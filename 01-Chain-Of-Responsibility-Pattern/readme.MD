## Introduction ##
This pattern lets us pass requests along a chain of handlers. 
Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

## Design consideration ##
- Chain of receiver objects 
- Each handle is based on the main interface which defines the contract between each chain links
- ConcreteHandler for each receiver or implementation that will interpret the request.
- Each handler has a reference ot the next

## UML design consideration ##
### UML design 1 ###
<img src="chain1.png"/>


## Example ##
### Example 1 ###
```java
package example.one;

public  abstract class AbstractLogger {
public static int INFO = 1;
public static int DEBUG = 2;
public static int ERROR = 3;

protected int level;

//next element in chain or responsibility
protected AbstractLogger nextLogger;

public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
        }

public void logMessage(int level, String message){
        if(this.level <= level){
        write(message);
        }
        if(nextLogger !=null){
        nextLogger.logMessage(level, message);
        }
        }

abstract protected void write(String message);
}

```
```java
package example.one;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

```

```java
package example.one;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

```

```java
package example.one;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

```

```java
package example.one;

public class ChainResponsibilityDemo {
    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        //file logger is passed to errorLogger
        errorLogger.setNextLogger(fileLogger);
        
        //consoleLogger is passed to fileLogger
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}

```

### Example 2 ###
```java
package example.two;

public interface RequestHandler {
    void setNextRequestHandler(RequestHandler requestHandler);
    boolean process(RequestData requestData);
}

```

```java
package example.two;

public class CloudDataHandler implements RequestHandler {
    private RequestHandler requestHandler;
    @Override
    public void setNextRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
    @Override
    public boolean process(RequestData requestData) {
        requestData.setMetaCloudData("Meta Data from Cloud is populated");
        return requestHandler == null ? true : requestHandler.process(requestData);
    }
}

```

```java
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

```

```java
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

```

```java
package example.two;

public class RequestData {

    private String metaDBData;
    private String metaFileData;
    private String metaCloudData;

    public String getMetaDBData() {
        return metaDBData;
    }

    public void setMetaDBData(String metaDBData) {
        this.metaDBData = metaDBData;
    }

    public String getMetaFileData() {
        return metaFileData;
    }

    public void setMetaFileData(String metaFileData) {
        this.metaFileData = metaFileData;
    }

    public String getMetaCloudData() {
        return metaCloudData;
    }

    public void setMetaCloudData(String metaCloudData) {
        this.metaCloudData = metaCloudData;
    }
}

```

```js
package example.two;

import java.util.ArrayList;
import java.util.List;

public class NexusRunner {
    public static void main(String [] args){
        RequestData requestData = new RequestData();
        List< RequestHandler > requestHandlers = new ArrayList<>();
        requestHandlers.add(new DBDataHandler());
        requestHandlers.add(new FileDataHandler());
        requestHandlers.add(new CloudDataHandler());

        // create the chain of Handler
        for (int i = 0; i < requestHandlers.size() - 1; i++) {
            requestHandlers.get(i).setNextRequestHandler(requestHandlers.get(i + 1));
        }
        requestHandlers.get(0).process(requestData);
        System.out.println(requestData);
    }
}
```