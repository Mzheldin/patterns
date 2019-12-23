package java.homework3.factory;

import java.homework3.Manager;
import java.homework3.client.Client;
import java.homework3.contract.Contract;

public interface ContractFactoryMethod {
    Contract createContract(Manager manager, Client client);
}
