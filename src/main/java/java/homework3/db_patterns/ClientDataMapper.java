package java.homework3.db_patterns;

import java.homework3.client.Client;
import java.homework3.client.ClientImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ClientDataMapper {

    private static volatile ClientDataMapper thisInstance;

    private ClientDataMapper() {
    }

    public static synchronized ClientDataMapper getInstance() {
        if (thisInstance == null){
            synchronized (ClientDataMapper.class){
                if (thisInstance == null)
                    thisInstance = new ClientDataMapper();
            }
        }
        return thisInstance;
    }

    public Client findById(Connection connection, UUID clientId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT idClient, name, lastName, phone, email, address FROM clients WHERE idClient = ?;"); ResultSet resultSet = preparedStatement.executeQuery()){
            preparedStatement.setObject(1, clientId);
            while (resultSet.next()){
                ClientImpl client = new ClientImpl((UUID) resultSet.getObject(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6));
                return client;
            }
            throw new IdNotFoundException(clientId);
        } catch (SQLException | IdNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public void insert(Connection connection, Client client) {
        ClientImpl clientImpl = (ClientImpl) client;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO clients VALUES (?, ?, ?, ?, ?, ?);")) {
            preparedStatement.setObject(1, clientImpl.getClientId());
            preparedStatement.setString(2, clientImpl.getName());
            preparedStatement.setString(3, clientImpl.getLastName());
            preparedStatement.setString(4, clientImpl.getPhone());
            preparedStatement.setString(5, clientImpl.getEmail());
            preparedStatement.setString(6, clientImpl.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Connection connection, Client client) {
        ClientImpl clientImpl = (ClientImpl) client;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE clients SET name = ?, lastName = ?, phone = ?, email = ?, address = ? WHERE idClient = ?;")) {
            preparedStatement.setObject(6, clientImpl.getClientId());
            preparedStatement.setString(1, clientImpl.getName());
            preparedStatement.setString(2, clientImpl.getLastName());
            preparedStatement.setString(3, clientImpl.getPhone());
            preparedStatement.setString(4, clientImpl.getEmail());
            preparedStatement.setString(5, clientImpl.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Connection connection, Client client) {
        ClientImpl clientImpl = (ClientImpl) client;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM clients WHERE idClient = ?;")) {
            preparedStatement.setObject(1, clientImpl.getClientId());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
