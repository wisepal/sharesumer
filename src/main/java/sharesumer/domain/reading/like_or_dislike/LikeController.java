package sharesumer.domain.reading.like_or_dislike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sharesumer.domain.reading.ReadingResourceAssembler;

@RestController
@RequestMapping("/reading-likes/{readingId}")
public class LikeController {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    ReadingResourceAssembler readingResourceAssembler;

    @RequestMapping(method = RequestMethod.POST)
    void postLike(@PathVariable String readingId) {
        Like like = new Like(readingId);
        likeRepository.insert(like);
    }


}

