package java.homework3;

public class Manager {
    public Contract createContract(Client client){
        ContractFactoryMethod factoryMethod = SingletonContractFactoryMethod.getInstance().getContactFactoryMethod();
        return factoryMethod.createContract(this, client);
    }
}
