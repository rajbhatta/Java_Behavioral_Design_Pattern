## Introduction ##
- The observer pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically. 

## Example in Java ##
```java
java.util.Observer
java.util.EventListener
java.jms.Topic
```

## Design consideration ##
- Subject – interface or abstract class defining the operations for attaching and de-attaching observers to the subject.
- ConcreteSubject – concrete Subject class. It maintain the state of the object and when a change in the state occurs it notifies the attached Observers.
- Observer – interface or abstract class defining the operations to be used to notify this object.
- ConcreteObserver – concrete Observer implementations.

## UML ##
<img src="observer.png" />