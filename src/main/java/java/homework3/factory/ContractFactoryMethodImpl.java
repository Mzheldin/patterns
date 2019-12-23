package java.homework3.factory;

import java.homework3.Manager;
import java.homework3.client.Client;
import java.homework3.client.ConsumerClient;
import java.homework3.client.ProviderClient;
import java.homework3.contract.ConsumerContract;
import java.homework3.contract.Contract;
import java.homework3.contract.ContractImpl;
import java.homework3.contract.ProviderContract;

public class ContractFactoryMethodImpl implements ContractFactoryMethod {
    @Override
    public Contract createContract(Manager manager, Client client) {
        if (client.getClass().getName().equals(ConsumerClient.class.getName()))
            return createConsumerContract(manager, (ConsumerClient) client);
        if (client.getClass().getName().equals(ProviderClient.class.getName()))
            return createProviderContract(manager, (ProviderClient) client);
        return null;
    }

    private ConsumerContract createConsumerContract(Manager manager, ConsumerClient client){
        ContractImpl contract = new ContractImpl();
        contract.setManager(manager);
        contract.setClient(client);
        return contract;
    }

    private ProviderContract createProviderContract(Manager manager, ProviderClient client){
        ContractImpl contract = new ContractImpl();
        contract.setManager(manager);
        contract.setClient(client);
        return contract;
    }
}
