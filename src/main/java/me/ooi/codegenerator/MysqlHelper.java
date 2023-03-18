package me.ooi.codegenerator;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MysqlHelper {

    private static Properties properties;
    static {
        properties = new Properties();
        try (InputStream input = MysqlHelper.class.getClassLoader().getResourceAsStream("ds.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("mysql driver not found!", e);
        }
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }

    private static Table getTable(ResultSet rs) throws SQLException {
        String tableName = rs.getString("TABLE_NAME");
        return Table.builder().name(tableName)
                .comment(rs.getString("REMARKS"))
                .columns(getTableColumns(tableName)).build();
    }

    private static Column getTableColumn(ColumnContext columnCtx, int index, ResultSet rs) throws SQLException {
        String columnName = rs.getString("COLUMN_NAME");
        return Column.builder().name(columnName)
                .index(index)
                .type(Integer.parseInt(rs.getString("DATA_TYPE")))
                .size(rs.getInt("COLUMN_SIZE"))
                .scale(columnCtx.getOrCreateColumn(columnName).getScale())
                .comment(rs.getString("REMARKS")).build();
    }

    public static List<Table> getTables(String tableName) throws SQLException {
        List<Table> tables = new ArrayList<>();
        try(Connection conn = getConnection()){
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            try(ResultSet rs = databaseMetaData.getTables(null, null, tableName, new String[]{"TABLE"})){
                while(rs.next()) {
                    tables.add(getTable(rs));
                }
            }
        }
        return tables;
    }

    public static Table getTable(String tableName) throws SQLException {
        List<Table> tables = getTables(tableName);
        if( tables.isEmpty() ){
            return null;
        }

        return tables.get(0);
    }

    public static List<Column> getTableColumns(String tableName) throws SQLException {
        List<Column> columns = new ArrayList<>();
        try(Connection conn = getConnection()){

            ColumnContext columnCtx = new ColumnContext();
            setColumnScale(columnCtx, conn, tableName);

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            try(ResultSet rs = databaseMetaData.getColumns(conn.getCatalog(),null, tableName, null)){
                int idx = 0;
                while(rs.next()) {
                    columns.add(getTableColumn(columnCtx, idx++, rs));
                }
            }
        }
        return columns;
    }

    private static void setColumnScale(ColumnContext columnCtx, Connection conn, String tableName) throws SQLException {
        try(Statement stmt = conn.createStatement()){
            try(ResultSet rs = stmt.executeQuery("select * from "+tableName)){
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    columnCtx.addColumn(Column.builder()
                            .name(rsmd.getColumnName(i))
                            .scale(rsmd.getScale(i)).build());
                }
            }
        }
    }

    public static List<Column> getColumns(String query) throws SQLException {
        try(Connection conn = getConnection()){
            List<Column> columns = new ArrayList<Column>();
            try(Statement stmt = conn.createStatement()){
                try(ResultSet rs = stmt.executeQuery(query)){
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    int colCount = rsMetaData.getColumnCount();
                    for (int i = 1; i <= colCount; i++) {
                        Column c = new Column();
                        c.setIndex(i);
                        c.setName(rsMetaData.getColumnName(i));
                        c.setType(rsMetaData.getColumnType(i));
                        columns.add(c);
                    }
                }
            }
            return columns;
        }
    }

}
