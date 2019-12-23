package java.homework3.contract;

import java.homework3.observer.OperationObserver;
import java.homework3.observer.OperationSubject;
import java.util.Set;

public class Operation implements OperationSubject {
    private ContractImpl contract;
    private int amount;
    private Set<OperationObserver> operationObservers;

    public Operation(ContractImpl contract) {
        this.contract = contract;
        operationObservers.add(contract);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        notifyObservers();
    }

    @Override
    public void attach(OperationObserver operationObserver) {
        operationObservers.add(operationObserver);
    }

    @Override
    public void detach(OperationObserver operationObserver) {
        operationObservers.remove(operationObserver);
    }

    @Override
    public void notifyObservers() {
        for (OperationObserver operationObserver : operationObservers)
            operationObserver.update(amount);
    }
}
