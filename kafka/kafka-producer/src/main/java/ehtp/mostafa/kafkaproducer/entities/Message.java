package ehtp.mostafa.kafkaproducer.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Message implements Serializable {
    String from ;
    String to ;
    String msgBody ;

    String subject ;
    String attachment;
}
