package ewc.utilities.testableio.wrappers.spring.resttemplate;

public class StubResponseEntity<T> implements ResponseEntityWrapper<T> {
    private final T response;

    public StubResponseEntity(T response) {
        this.response = response;
    }

    @Override
    public T getBody() {
        return response;
    }
}
