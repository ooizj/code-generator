package me.ooi.codegenerator.template

import groovy.transform.Field
import static me.ooi.codegenerator.TemplateUtil.*

// 需要生成的项目所在工作空间
@Field String root = 'D:\\workspace\\generated'

// 模板所在目录
@Field String template_dir = 'D:\\workspace\\github\\code-generator\\src\\main\\resources\\ftl\\mytest_v1\\project'

// 根项目名称
@Field String root_project_name = 'demo1'

// 子模块名称前缀
@Field String project_prefix = 'demo1'

// 包名（e.g. xxx/xxx/xxx）
@Field String base_package = 'me/ooi/demo1'

// 应用名称
@Field String app_name = 'demo1'

// 应用端口
def @Field app_port = 8080

// 请求context-path
@Field String context_path = 'demo1'

// 请求context-path
@Field String maven_group_id = 'me.ooi'

// 模板参数
@Field Map templateBinding = [
        "APP_NAME":app_name,
        "CONTEXT_PATH": context_path,
        "APP_NAME_CAP":app_name.capitalize(),
        "APP_PORT":app_port,

        "GROUP_ID":maven_group_id,
        "BASE_PACKAGE":base_package.replace("/", "."),
        "VERSION":"1.0",
        "ROOT_PROJECT_NAME":"${root_project_name}",
        "API_PROJECT_NAME":"${project_prefix}-api",
        "RESOURCE_PROJECT_NAME":"${project_prefix}-resource",
        "SERVICE_PROJECT_NAME":"${project_prefix}-service",
        "MAPPER_PACKAGE_PATH":base_package+"/mapper",
        "MAPPER_PACKAGE":base_package.replace("/", ".")+".mapper",

        "DS_URL":"jdbc:mysql://127.0.0.1:3306/mytest?useUnicode=true&characterEncoding=utf8&autoReconnect=true&pinGlobalTxToPhysicalConnection=true&useSSL=false&autoCommit=false",
        "DS_USERNAME":"root",
        "DS_PASSWORD":"root",
]


def copyT(String template){
    return copyT(template_dir, template, templateBinding)
}

// create project file
def project_dir = new File(root, root_project_name)
project_dir.mkdirs()
copyT 'pom.xml' to "${project_dir}/pom.xml"

// create "api" project dir
def sub_project_dir = new File(project_dir, "${project_prefix}-api")
mkProjectDirs(sub_project_dir)
mkDirs "${sub_project_dir}",
        "src/main/java/${base_package}/api/vo",
            "src/main/java/${base_package}/api/dto",
            "src/main/java/${base_package}/api/query",
            "src/main/java/${base_package}/api/constraints"
copyT 'api/pom.xml' to "${sub_project_dir}/pom.xml"
copyT 'api/constraints/' to "${sub_project_dir}/src/main/java/${base_package}/api/constraints/"
copyT 'api/query/BaseQuery.java' to "${sub_project_dir}/src/main/java/${base_package}/api/query/BaseQuery.java"
copyT 'api/BaseCode.java' to "${sub_project_dir}/src/main/java/${base_package}/api/BaseCode.java"
copyT 'api/IBaseCode.java' to "${sub_project_dir}/src/main/java/${base_package}/api/IBaseCode.java"
copyT 'api/StdResult.java' to "${sub_project_dir}/src/main/java/${base_package}/api/StdResult.java"
copyT 'api/PageData.java' to "${sub_project_dir}/src/main/java/${base_package}/api/PageData.java"

// create "resource" project dir
sub_project_dir = new File(project_dir, "${project_prefix}-resource")
mkProjectDirs(sub_project_dir)
copyT "resource/pom.xml" to "${sub_project_dir}/pom.xml"
copyT "resource/resources/" to "${sub_project_dir}/src/main/resources/"
copyT "resource/java/config/" to "${sub_project_dir}/src/main/java/${base_package}/config/"
copyT "resource/java/Application.java" to "${sub_project_dir}/src/main/java/${base_package}/Application.java"

// create "service" project dir
sub_project_dir = new File(project_dir, "${project_prefix}-service")
mkProjectDirs(sub_project_dir)
mkDirs "${sub_project_dir}",
        "src/main/java/${base_package}/po",
        "src/main/java/${base_package}/mapper",
        "src/main/java/${base_package}/service",
        "src/main/resources/${base_package}/mapper"
copyT "service/pom.xml" to "${sub_project_dir}/pom.xml"
copyT "service/java/BaseEntity.java" to "${sub_project_dir}/src/main/java/${base_package}/po/BaseEntity.java"
