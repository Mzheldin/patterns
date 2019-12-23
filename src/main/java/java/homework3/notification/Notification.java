package java.homework3.notification;

import java.homework3.Manager;
import java.homework3.contract.Contract;
import java.util.Date;

public class Notification {

    private Long id;
    private Manager manager;
    private Date date;
    private Contract contract;
    private boolean actual;

    public Notification(Manager manager, Date date, Contract contract, boolean actual) {
        this.manager = manager;
        this.date = date;
        this.contract = contract;
        this.actual = actual;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
