package example.two;

public class DBDataHandler implements RequestHandler {

    private RequestHandler requestHandler;

    @Override
    public void setNextRequestHandler(RequestHandler requestHandler) {
        this.requestHandler=requestHandler;
    }

    @Override
    public boolean process(RequestData requestData) {
        requestData.setMetaDBData("Calling from DB");
        return requestHandler==null?true: requestHandler.process(requestData);
    }
}
