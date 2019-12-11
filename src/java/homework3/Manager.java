package java.homework3;

import java.homework3.client.Client;
import java.homework3.contract.Contract;
import java.homework3.factory.ContractFactoryMethod;
import java.homework3.factory.SingletonContractFactoryMethod;

public class Manager {
    public Contract createContract(Client client){
        ContractFactoryMethod factoryMethod = SingletonContractFactoryMethod.getInstance().getContactFactoryMethod();
        return factoryMethod.createContract(this, client);
    }
}
