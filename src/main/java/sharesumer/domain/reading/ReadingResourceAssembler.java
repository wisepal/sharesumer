package sharesumer.domain.reading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import sharesumer.domain.reading.like_or_dislike.DislikeController;
import sharesumer.domain.reading.like_or_dislike.LikeController;
import sharesumer.domain.reading.like_or_dislike.LikeRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class ReadingResourceAssembler extends ResourceAssemblerSupport<Reading, ReadingRepresentation> {

    @Autowired
    LikeRepository likeRepository;

    public ReadingResourceAssembler() {
        super(ReadingController.class, ReadingRepresentation.class);
    }

    @Override
    public ReadingRepresentation toResource(Reading reading) {
        ReadingRepresentation representation = new ReadingRepresentation(
                reading.title(),
                reading.uri(),
                reading.by().headshot(),
                reading.by().name(),
                countLikes(reading));
        representation.add(
                linkTo(ReadingController.class).slash(reading.id()).withSelfRel(),
                linkTo(LikeController.class, reading.id()).withRel("like"),
                linkTo(DislikeController.class, reading.id()).withRel("dislike"));

        return representation;
    }

    private Long countLikes(Reading reading) {
        return likeRepository.countByReadingId(reading.id());
    }

}
