package java.homework3.observer;

public interface OperationSubject {
    void attach(OperationObserver operationObserver);
    void detach(OperationObserver operationObserver);
    void notifyObservers();
}
