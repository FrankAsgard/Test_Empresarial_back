# client-info-service API

El servicio `client-info-service` proporciona una API para consultar información sobre clientes. Esta aplicación está desarrollada con Spring Boot.

## Endpoints Disponibles

### 1. Obtener Información del Cliente

- **URL:** `/api/clients`
- **Método:** `GET`
- **Descripción:** Recupera la información del cliente según el tipo de documento y el número de documento especificados.
- **Parámetros de Consulta:**
  - `documentType` (Requerido): El tipo de documento del cliente (por ejemplo, 'C' para cédula, 'P' para pasaporte).
  - `documentNumber` (Requerido): El número de documento del cliente.
- **Respuesta Exitosa:**
  - **Código de Estado:** 200 OK
  - **Contenido:**
    ```json
    {
      "firstName": "Juan",
      "secondName": "Carlos",
      "firstSurname": "Pérez",
      "secondSurname": "Gómez",
      "phone": "123456789",
      "address": "Groove street 123",
      "city": "Bogotá"
    }
    ```
- **Errores Comunes:**
  - **Código de Estado:** 400 Bad Request
    - **Descripción:** Tipo de documento inválido o número de documento faltante.
    - **Contenido:**
      ```json
      {
        "error": "Tipo de documento inválido o número de documento faltante"
      }
      ```
  - **Código de Estado:** 404 Not Found
    - **Descripción:** No se encontró el cliente solicitado.
    - **Contenido:**
      ```json
      {
        "error": "Cliente no encontrado"
      }
      ```

## Configuración del Entorno

Para probar la API localmente, asegúrese de tener configurada la base de datos y las dependencias necesarias en el archivo `pom.xml`. La configuración específica para pruebas y el manejo de excepciones están implementados en Spring Boot y se gestionan a través de la configuración de seguridad y manejo de excepciones del framework.

## Consideraciones de Seguridad

La API maneja datos sensibles, por lo que es importante implementar medidas de seguridad adecuadas:
- Autenticación y autorización utilizando Spring Security.
- Cifrado de datos sensibles en la base de datos.
- Validación y saneamiento de entradas para evitar inyecciones SQL y otros ataques comunes.

## Ejemplo de Solicitud

Para obtener la información de un cliente, puedes realizar una solicitud GET a la siguiente URL:

http://localhost:8080/api/clients?documentType=C&documentNumber=123456789

## Resumen de Errores

- **400 Bad Request:** Indica un problema con los parámetros de entrada.
- **404 Not Found:** No se encontró el cliente solicitado.

Esta documentación proporciona una guía básica para interactuar con el servicio `client-info-service`.
