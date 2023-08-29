package ehtp.mostafa.kafkaproducer.config;


import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class kafkaTopicConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String , Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG ,bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    @Bean
    public NewTopic smsTopic() {
        return new NewTopic("sms", 2, (short) 2);
    }
    @Bean
    public NewTopic mailTopic() {
        return new NewTopic("mail", 2, (short) 2);
    }
    @Bean
    public NewTopic webhookTopic() {
        return new NewTopic("webhook", 2, (short) 2);
    }

}
