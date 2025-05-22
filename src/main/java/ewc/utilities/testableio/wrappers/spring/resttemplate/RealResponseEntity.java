package ewc.utilities.testableio.wrappers.spring.resttemplate;

import org.springframework.http.ResponseEntity;

public class RealResponseEntity<T> implements ResponseEntityWrapper<T> {
    private final ResponseEntity<T> entity;

    RealResponseEntity(ResponseEntity<T> entity) {
        this.entity = entity;
    }

    public T getBody() {
        return this.entity.getBody();
    }
}
