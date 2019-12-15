package java.homework3.contract;

import java.homework3.client.Client;
import java.homework3.Manager;
import java.homework3.observer.OperationObserver;
import java.util.List;

public class ContractImpl implements ConsumerContract, ProviderContract, OperationObserver {
    private Manager manager;
    private Client client;
    private List<Operation> operations;
    private int amount;

    public ContractImpl(Manager manager, Client client) {
        this.manager = manager;
        this.client = client;
    }

    public ContractImpl() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void update(int amount) {
        this.amount =+ amount;
    }
}
