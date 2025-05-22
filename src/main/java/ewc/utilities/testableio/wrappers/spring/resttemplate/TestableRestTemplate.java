package ewc.utilities.testableio.wrappers.spring.resttemplate;

import ewc.utilities.testableio.tracking.OutputListener;
import org.springframework.http.RequestEntity;

public class TestableRestTemplate {
    private final RestTemplateThinWrapper restTemplate;
    private final OutputListener<TrackableRestTemplateRequest> outputListener;

    private TestableRestTemplate(RestTemplateThinWrapper restTemplate, OutputListener<TrackableRestTemplateRequest> listener) {
        this.restTemplate = restTemplate;
        this.outputListener = listener;
    }

    public static TestableRestTemplate create(RestTemplateThinWrapper restTemplate, OutputListener<TrackableRestTemplateRequest> listener) {
        return new TestableRestTemplate(restTemplate, listener);
    }

    public <R> R exchange(RequestEntity<?> entity, Class<R> responseType) {
        this.outputListener.track(new TrackableRestTemplateRequest(
            String.valueOf(entity.getMethod()),
            entity.getUrl().toString(),
            entity.getHeaders().toSingleValueMap(),
            entity.getBody()
        ));
        return restTemplate.exchange(entity, responseType).getBody();
    }
}
