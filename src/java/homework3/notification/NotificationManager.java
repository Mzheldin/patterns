package java.homework3.notification;

import java.homework3.Manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager {

    private static volatile NotificationManager thisInstance;
    private volatile Map<Manager, List<Notification>> tasks;

    private NotificationManager() {
        tasks = new HashMap<>();
    }

    public static synchronized NotificationManager getInstance() {
        if (thisInstance == null){
            synchronized (NotificationManager.class){
                if (thisInstance == null)
                    thisInstance = new NotificationManager();
            }
        }
        return thisInstance;
    }

    public boolean addNotification(Notification notification){
        for (Manager manager : tasks.keySet())
            if (notification.getManager().equals(manager)){
                tasks.get(manager).add(notification);
                return true;
            }
        return false;
    }

    public void addManager(Manager manager){
        if (!tasks.containsKey(manager))
            tasks.put(manager, new ArrayList<>());
    }
}
