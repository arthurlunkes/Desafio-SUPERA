package dev.arthurlunkes.CRUDClients.controllers;

import dev.arthurlunkes.CRUDClients.dtos.RequestClientDTO;
import dev.arthurlunkes.CRUDClients.models.ClientModel;
import dev.arthurlunkes.CRUDClients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity findAllClients() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllClients());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findClientById(@PathVariable Long id) {
        ClientModel client;

        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.findClientById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
    }

    @PostMapping
    public ResponseEntity saveClient(@RequestBody RequestClientDTO client) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.saveClient(client));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar cliente: "
                    + e.getMessage());
        }
    }

    @PostMapping("/all")
    public ResponseEntity saveAllClients(@RequestBody List<RequestClientDTO> clients) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.saveAllClients(clients));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar clientes: "
                    + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateClient(@RequestBody ClientModel client) {

        try {
            clientService.findClientById(client.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(client));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar cliente: "
                    + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {

        try {
            clientService.findClientById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        clientService.deleteClient(id);

        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado!");
    }

}