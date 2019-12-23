package java.homework3.db_patterns;

import java.homework3.client.Client;
import java.homework3.client.ClientImpl;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class IdettityMap {

    private static volatile IdettityMap thisInstance;
    private Map<UUID, Client> clientMap = new ConcurrentHashMap<>();

    private IdettityMap(){}

    public static synchronized IdettityMap getInstance() {
        if (thisInstance == null){
            synchronized (IdettityMap.class){
                if (thisInstance == null)
                    thisInstance = new IdettityMap();
            }
        }
        return thisInstance;
    }

    public static void addClient(Client client){
        ClientImpl clientImpl = (ClientImpl) client;
        thisInstance.clientMap.put(clientImpl.getClientId(), client);
    }

    public static Client getClient(UUID key){
        return thisInstance.clientMap.get(key);
    }

    public static Client loadClient(UUID key, Connection connection){
        if (!thisInstance.clientMap.containsKey(key)){
            ClientImpl clientImpl = (ClientImpl) ClientDataMapper.getInstance().findById(connection, key);
            if (clientImpl != null)
                thisInstance.clientMap.put(clientImpl.getClientId(), clientImpl);
        }
        return thisInstance.clientMap.get(key);
    }

    public static void removeClient(UUID key){
        thisInstance.clientMap.remove(key);
    }

    public static void flushClientMap(Connection connection){
        for (Map.Entry<UUID, Client> entry : thisInstance.clientMap.entrySet())
            if (ClientDataMapper.getInstance().findById(connection, entry.getKey()) != null)
                ClientDataMapper.getInstance().update(connection, entry.getValue());
            else
                ClientDataMapper.getInstance().insert(connection, entry.getValue());
        thisInstance.clientMap.clear();
    }
}
