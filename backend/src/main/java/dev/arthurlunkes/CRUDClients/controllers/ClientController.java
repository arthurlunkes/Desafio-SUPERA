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
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllClients());
    }

    @PostMapping
    public ResponseEntity saveClient(@RequestBody RequestClientDTO client) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.saveClient(client));
    }

    @PostMapping("/all")
    public ResponseEntity saveAllClients(@RequestBody List<RequestClientDTO> clients) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.saveAllClients(clients));
    }

    @PutMapping
    public ResponseEntity updateClient(@RequestBody ClientModel client) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);

        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }

}
