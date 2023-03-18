package me.ooi.codegenerator

class TemplateUtil {

    // read template
    static def readT(File templateFile, Map templateBinding){
        def str = templateFile.getText('UTF-8')
        str = str.replaceAll(~/#([a-z|A-Z][a-z|A-Z|0-9|_]*)#/, {{
            def val = templateBinding.get(it[1])
            if( val == null ){
                return it[0]
            }else {
                return val
            }
        }})
        return str
    }

    // create project dir
    static def mkProjectDirs(File sub_project_dir){
        new File(sub_project_dir, "src/main/java/").mkdirs()
        new File(sub_project_dir, 'src/main/resources').mkdirs()
    }

    static def copyT(String templateDir, String template, Map templateBinding){
        return [to: {String dst->
            def target = new File(dst)
            if( !target.getParentFile().exists() ){
                target.getParentFile().mkdirs()
            }

            def templateFile = new File(templateDir, template)
            if( templateFile.isDirectory() ){
                target.mkdirs()
                templateFile.eachFile {
                    new File(target, it.getName()).write(readT(it, templateBinding), 'UTF-8')
                }
            }else {
                target.write(readT(templateFile, templateBinding), 'UTF-8')
            }
        }]
    }

    static def mkDirs(String parentDir, String ...dirs){
        dirs.collect{
            new File(parentDir, it).mkdirs()
        }
    }

}
