package sharesumer.domain.reading;

public class By {

    private final String name;
    private final String headshot;

    public By(String name, String headshot) {
        this.name = name;
        this.headshot = headshot;
    }

    public String name() {
        return name;
    }

    public String headshot() {
        return headshot;
    }
}
