package ewc.utilities.testableio.wrappers.spring.resttemplate;

import org.springframework.http.RequestEntity;

public interface RestTemplateThinWrapper {
    <T> ResponseEntityWrapper<T> exchange(RequestEntity<?> entity, Class<T> responseType);
}
