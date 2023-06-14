package ir.behi.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class Application {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/test")
    public ResponseEntity receiveMessage(String message) {
        for (int i = 1; i < 10; i++) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    kafkaTemplate.send("behrooz", message);
                }
            });
            th.start();
        }
        return ResponseEntity.ok("send all");
    }


    @KafkaListener(topics = "behrooz", groupId = "id")
    public void
    publish(String message) {
        logger.info("You have a new message: " + message);
    }
}
