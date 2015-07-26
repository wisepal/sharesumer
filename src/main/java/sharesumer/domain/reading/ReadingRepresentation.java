package sharesumer.domain.reading;

import org.springframework.hateoas.ResourceSupport;

public class ReadingRepresentation extends ResourceSupport {

    public final String title;
    public final String uri;
    public final String contributorHeadshot;
    public final String contributorName;
    public final Long likeCount;

    public ReadingRepresentation(String title, String uri, String contributorHeadshot, String contributorName, Long likeCount) {
        this.title = title;
        this.uri = uri;
        this.contributorHeadshot = contributorHeadshot;
        this.contributorName = contributorName;
        this.likeCount = likeCount;
    }
}
