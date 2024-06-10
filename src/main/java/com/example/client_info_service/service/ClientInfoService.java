package com.example.client_info_service.service;

import com.example.client_info_service.model.ClientInfo;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar la lógica de negocio relacionada con los clientes.
 */
@Service
public class ClientInfoService {

    /**
     * Recupera la información de un cliente basado en el tipo y número de documento.
     * 
     * @param documentType el tipo de documento del cliente
     * @param documentNumber el número de documento del cliente
     * @return la información del cliente si se encuentra, o null si no se encuentra
     */
    public ClientInfo getClientInfo(String documentType, String documentNumber) {
        // Ejemplo de datos estáticos para un cliente con tipo de documento "C" y número "23445322"
        if ("C".equalsIgnoreCase(documentType) && "23445322".equals(documentNumber)) {
            ClientInfo client = new ClientInfo();
            client.setFirstName("Juan");
            client.setSecondName("Carlos");
            client.setFirstSurname("Pérez");
            client.setSecondSurname("Gómez");
            client.setPhone("123456789");
            client.setAddress("Groove street 123");
            client.setCity("Bogotá");
            return client;
        }
        return null;
    }
}
