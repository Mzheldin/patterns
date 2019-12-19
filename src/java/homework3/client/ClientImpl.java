package java.homework3.client;

import java.util.Objects;
import java.util.UUID;

public class ClientImpl implements ConsumerClient, ProviderClient {
    private UUID clientId;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;

    public ClientImpl(UUID clientId, String name, String lastName, String phone, String email, String address) {
        this.clientId = clientId;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public ClientImpl() {
        this.clientId = UUID.randomUUID();
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientImpl)) return false;
        ClientImpl client = (ClientImpl) o;
        return getClientId().equals(client.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId());
    }
}
