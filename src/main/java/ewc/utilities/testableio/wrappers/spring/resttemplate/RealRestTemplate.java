package ewc.utilities.testableio.wrappers.spring.resttemplate;

import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

public class RealRestTemplate implements RestTemplateThinWrapper {
    private final RestTemplate restTemplate;

    public RealRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> ResponseEntityWrapper<T> exchange(RequestEntity<?> entity, Class<T> responseType) {
        return new RealResponseEntity<>(restTemplate.exchange(entity, responseType));
    }
}
