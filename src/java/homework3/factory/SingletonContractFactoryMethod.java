package java.homework3.factory;

public class SingletonContractFactoryMethod {
    private static volatile SingletonContractFactoryMethod thisInstance;
    private final ContractFactoryMethod CONTRACT_FACTORY_METHOD = new ContractFactoryMethodImpl();

    private SingletonContractFactoryMethod() {}

    public static synchronized SingletonContractFactoryMethod getInstance() {
        if (thisInstance == null){
            synchronized (SingletonContractFactoryMethod.class){
                if (thisInstance == null)
                    thisInstance = new SingletonContractFactoryMethod();
            }
        }
        return thisInstance;
    }

    public ContractFactoryMethod getContactFactoryMethod(){
        return CONTRACT_FACTORY_METHOD;
    }
}
