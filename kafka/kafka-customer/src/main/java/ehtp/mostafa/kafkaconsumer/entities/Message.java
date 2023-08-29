package ehtp.mostafa.kafkaconsumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message implements Serializable {
    String from ;
    String to ;
    String msgBody ;
    String subject ;
    String attachment;

}