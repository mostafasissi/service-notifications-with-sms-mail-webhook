package ehtp.mostafa.servicesmsvonage.config;

import com.vonage.client.VonageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class VonageConfig {
    @Value(value = "${vonage.api_key}")
    private String API_KEY  ;
    @Value(value = "${vonage.secret_key}")
    private String API_SECRET  ;
    @Bean
    public VonageClient client(){
        return VonageClient
                .builder()
                .apiKey(API_KEY)
                .apiSecret(API_SECRET)
                .build();
    }
}
