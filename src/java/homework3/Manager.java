package java.homework3;

import java.homework3.client.Client;
import java.homework3.contract.Contract;
import java.homework3.factory.ContractFactoryMethod;
import java.homework3.factory.SingletonContractFactoryMethod;
import java.homework3.proxy.ProxyContractFactoryMethod;

public class Manager {
    public Contract createContract(Client client){
        return ProxyContractFactoryMethod.getInstance().createContract(this, client);
    }
}
