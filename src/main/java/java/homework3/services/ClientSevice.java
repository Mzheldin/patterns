package java.homework3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.homework3.client.ClientImpl;
import java.homework3.repository.ClientRepository;
import java.util.List;

@Service
public class ClientSevice {

    private ClientRepository clientRepository;

    @Autowired
    public ClientSevice(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientImpl> findAll(){
        return clientRepository.findAll();
    }
}
