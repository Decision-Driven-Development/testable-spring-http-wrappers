package ewc.utilities.testableio.wrappers.spring.resttemplate;

import ewc.utilities.testableio.core.QueryId;
import ewc.utilities.testableio.core.SourceId;
import ewc.utilities.testableio.core.StubFacade;
import org.springframework.http.RequestEntity;

public class StubRestTemplate implements RestTemplateThinWrapper {
    private final SourceId clientId;
    private final QueryId queryId;
    private final StubFacade stubs;

    public StubRestTemplate(SourceId clientId, QueryId queryId, StubFacade stubs) {
        this.clientId = clientId;
        this.queryId = queryId;
        this.stubs = stubs;
    }

    @Override
    public <T> ResponseEntityWrapper<T> exchange(RequestEntity<?> entity, Class<T> responseType) {
        return new StubResponseEntity<>(this.stubs.next(this.clientId, this.queryId, responseType));
    }
}
