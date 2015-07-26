package sharesumer.domain.reading;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "readings")
public class Reading {

    @Id
    private final String id = UUID.randomUUID().toString();
    private final String title;
    private final String uri;
    private final By by;

    public Reading(String title, String uri, By by) {
        this.title = title;
        this.uri = uri;
        this.by = by;
    }

    public String title() {
        return title;
    }

    public String uri() {
        return uri;
    }

    public By by() {
        return by;
    }

    public String id() {
        return id;
    }
}


