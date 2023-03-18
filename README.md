# code-generator
code-generator是一个生成工程和api、service、resource层代码的工具

## 生成工程
打开create_project_mytest_v1.groovy，修改以下的“工作空间”、“模板所在目录（就是code-generator此工程下面的ftl\\mytest_v1\\project目录）”、应用名等。  

```groovy

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

```
然后执行此groovy脚本，如图
![image](https://user-images.githubusercontent.com/9606965/226081420-a93cbcc7-e26e-4bc4-a7ef-7fd0a6abee28.png)

## 生成api、service、resource层代码
执行test下面的方法即可根据数据库表生成api、service、resource层代码，生成之前需修改projectDir、moduleNamePrefix和包名
![image](https://user-images.githubusercontent.com/9606965/226081525-8917314b-7512-4e68-a5b7-801b01bebbb2.png)




