//${table.entityName}ResourceImpl.java
package ${resourcePackage};

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import ${apiPackage}.${table.entityName}Resource;
import ${servicePackage}.${table.entityName}Service;

@RequiredArgsConstructor
@RestController
public class ${table.entityName}ResourceImpl implements ${table.entityName}Resource {

    private final ${table.entityName}Service ${table.entityName?uncap_first}Service;

}