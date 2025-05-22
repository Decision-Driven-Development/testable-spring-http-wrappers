package ewc.utilities.testableio.wrappers.spring.resttemplate;

import java.util.Map;

public record TrackableRestTemplateRequest(String httpMethod, String url, Map<String,String> values, Object body) {
}
