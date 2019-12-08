package java.homework3;

public class ContractFactoryMethodImpl implements ContractFactoryMethod {
    @Override
    public Contract createContract(Manager manager, Client client) {
        if (client.getClass().getName().equals(ConsumerClient.class.getName()))
            return createConsumerContract(manager, (ConsumerClient) client);
        if (client.getClass().getName().equals(ProviderClient.class.getName()))
            return createProviderContract(manager, (ProviderClient) client);
        return null;
    }

    private Contract createConsumerContract(Manager manager, ConsumerClient client){
        ContractImpl contract = new ContractImpl();
        contract.setManager(manager);
        contract.setClient(client);
        return contract;
    }

    private Contract createProviderContract(Manager manager, ProviderClient client){
        ContractImpl contract = new ContractImpl();
        contract.setManager(manager);
        contract.setClient(client);
        return contract;
    }
}
