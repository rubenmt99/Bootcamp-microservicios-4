package nttdata.bootcamp.nttdata_kafka_taller7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "mi-topic";

    private final List<String> mensajes = new ArrayList<>();

    @Autowired
    public TestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Enviamos mensaje por Kafka.
     *
     * @param mensaje El mensaje a enviar a Kafka.
     * @return Un mensaje indicando que el mensaje fue enviado a Kafka.
     */
    @PostMapping("/enviar-mensaje")
    public String enviarMensaje(@RequestParam String mensaje) {
        kafkaTemplate.send(TOPIC, mensaje);
        return "Mensaje enviado a Kafka: " + mensaje;
    }

    
    /**
     * Maneja las solicitudes GET en la ruta "/recibir-mensajes".
     * Devuelve la lista de mensajes recibidos desde Kafka.
     *
     * @return La lista de mensajes recibidos desde Kafka.
     */
    @GetMapping("/recibir-mensajes")
    public List<String> obtenerMensajes() {
        return mensajes;
    }

    
    /**
     * Método anotado con @KafkaListener para recibir mensajes desde el topic "mi-topic" en el grupo "my-group".
     * Agrega el mensaje recibido a la lista de mensajes.
     *
     * @param mensaje El mensaje recibido desde Kafka.
     */
    @KafkaListener(topics = "mi-topic", groupId = "my-group")
    public void recibirMensaje(String mensaje) {
        mensajes.add(mensaje);
        System.out.println("Mensaje recibido de Kafka: " + mensaje);
    }
    
    
    
}