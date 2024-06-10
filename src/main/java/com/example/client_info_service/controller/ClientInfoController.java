package com.example.client_info_service.controller;

import com.example.client_info_service.model.ClientInfo;
import com.example.client_info_service.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para manejar las solicitudes relacionadas con la información del cliente.
 */
@RestController
@RequestMapping("/api/clients")
public class ClientInfoController {

    // Servicio para manejar la lógica de negocio relacionada con los clientes
    @Autowired
    private ClientInfoService clientInfoService;

    /**
     * Obtiene la información del cliente basada en el tipo de documento y el número de documento proporcionados.
     * 
     * @param documentType el tipo de documento del cliente
     * @param documentNumber el número de documento del cliente
     * @return un ResponseEntity con la información del cliente o un mensaje de error si no se encuentra
     */
    @GetMapping
    public ResponseEntity<?> getClientInfo(@RequestParam String documentType, @RequestParam String documentNumber) {
        // Verificación de la validez de los parámetros de entrada
        if (documentType == null || documentNumber == null || 
            (!"C".equalsIgnoreCase(documentType) && !"P".equalsIgnoreCase(documentType))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de documento inválido o número de documento faltante");
        }

        // Recuperar la información del cliente desde el servicio
        ClientInfo clientInfo = clientInfoService.getClientInfo(documentType, documentNumber);
        if (clientInfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }

        // Retornar la información del cliente encontrada
        return ResponseEntity.status(HttpStatus.OK).body(clientInfo);
    }
}
