package ethp.mostafa.serviceemailspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Message {
    private String from ;
    private String to;
    private String msgBody;
    private String subject;
    private String attachment;
}
