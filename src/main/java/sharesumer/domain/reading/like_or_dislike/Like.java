package sharesumer.domain.reading.like_or_dislike;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "reading_likes")
public class Like {

    @Id
    private final String id = UUID.randomUUID().toString();

    private final String readingId;

    public Like(String readingId) {
        this.readingId = readingId;
    }


}


