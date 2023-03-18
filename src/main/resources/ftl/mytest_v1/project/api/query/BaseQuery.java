package #BASE_PACKAGE#.api.query;

import lombok.Data;

@Data
public class BaseQuery implements java.io.Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private Integer pageNo;
  
  private Integer pageSize;
  
}