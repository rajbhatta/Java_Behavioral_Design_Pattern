## Introduction ##
- When we need to eliminate conditional statement then we need to use strategy pattern
- If it is difficult to add new strategies or cases inside the application then we need to use strategy design pattern
- When it is used, client is aware about strategies or cases


## Example ##
```java
java.util.Comparator
```

## Design consideration ##
- Can be implemented using interfaces but abstract base class is preferred.
- All the concrete classes are implemented per strategy or case.
- We want to minimize or eliminate if/else condition
- Strategies doesn't know about each other

## UML ##
- The context receives the request and decides which strategy to used based on the situation or case
<img src="strategy.png" />

## Example ##
### Example 1 ###
