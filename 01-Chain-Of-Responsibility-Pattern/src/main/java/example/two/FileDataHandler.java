package example.two;

public class FileDataHandler implements RequestHandler {
    private RequestHandler requestHandler;

    @Override
    public void setNextRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public boolean process(RequestData requestData) {
        requestData.setMetaFileData("Meta Data from File is populated");
        return requestHandler == null ? true : requestHandler.process(requestData);
    }
}
