package sharesumer.domain.reading.like_or_dislike;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "reading_dislikes")
public class Dislike {

    @Id
    private final String id = UUID.randomUUID().toString();
    private final String readingId;

    public Dislike(String readingId) {
        this.readingId = readingId;
    }

    
    
}


