package java.homework3.contract;

import java.homework3.client.Client;
import java.homework3.Manager;

public class ContractImpl implements ConsumerContract, ProviderContract {
    private Manager manager;
    private Client client;

    public ContractImpl(Manager manager, Client client) {
        this.manager = manager;
        this.client = client;
    }

    public ContractImpl() {
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
}
