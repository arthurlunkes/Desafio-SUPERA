package dev.arthurlunkes.CRUDClients.services;

import dev.arthurlunkes.CRUDClients.dtos.RequestClientDTO;
import dev.arthurlunkes.CRUDClients.models.ClientModel;
import dev.arthurlunkes.CRUDClients.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientModel> findAllClients() {
        return clientRepository.findAll();
    }

    public ClientModel findClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    public ClientModel saveClient(RequestClientDTO requestClientModel) {
        ClientModel newClient = new ClientModel();

        BeanUtils.copyProperties(requestClientModel, newClient);

        return clientRepository.save(newClient);
    }

    public List<ClientModel> saveAllClients(List<RequestClientDTO> requestClientModels) {
        List<ClientModel> newClients = new ArrayList<>();

        for (RequestClientDTO requestClientModel : requestClientModels) {
            ClientModel newClient = new ClientModel();

            BeanUtils.copyProperties(requestClientModel, newClient);

            newClients.add(clientRepository.save(newClient));
        }

        return newClients;

    }

    public ClientModel updateClient(ClientModel clientOld) {
        ClientModel ClientUpdate = clientRepository.save(clientOld);
        return ClientUpdate;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
