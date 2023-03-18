//${table.entityName}Resource.java
package ${apiPackage};

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "${table.comment}")
@RequestMapping("/v1/${table.entityName?uncap_first}")
public interface ${table.entityName}Resource {

}