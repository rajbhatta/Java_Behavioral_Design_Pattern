package example.two;

public interface RequestHandler {
    void setNextRequestHandler(RequestHandler requestHandler);
    boolean process(RequestData requestData);
}
