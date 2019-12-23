package java.homework3.proxy;

import java.homework3.Manager;
import java.homework3.client.Client;
import java.homework3.contract.Contract;
import java.homework3.factory.ContractFactoryMethod;
import java.homework3.factory.SingletonContractFactoryMethod;
import java.homework3.notification.Notification;
import java.homework3.notification.NotificationManager;
import java.util.Date;

public class ProxyContractFactoryMethod implements ContractFactoryMethod {

    private static volatile ProxyContractFactoryMethod thisInstance;

    private ProxyContractFactoryMethod() {}

    public static synchronized ProxyContractFactoryMethod getInstance() {
        if (thisInstance == null){
            synchronized (ProxyContractFactoryMethod.class){
                if (thisInstance == null)
                    thisInstance = new ProxyContractFactoryMethod();
            }
        }
        return thisInstance;
    }

    @Override
    public Contract createContract(Manager manager, Client client) {
        NotificationManager notificationManager = NotificationManager.getInstance();
        Contract contract = SingletonContractFactoryMethod.getInstance().getContactFactoryMethod().createContract(manager, client);
        notificationManager.addManager(manager);
        notificationManager.addNotification(new Notification(manager, new Date(), contract, true));
        return contract;
    }
}
