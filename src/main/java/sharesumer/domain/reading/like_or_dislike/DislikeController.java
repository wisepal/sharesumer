package sharesumer.domain.reading.like_or_dislike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sharesumer.domain.reading.ReadingResourceAssembler;

@RestController
@RequestMapping("/reading-dislikes/{readingId}")
public class DislikeController {

    @Autowired
    DislikeRepository dislikeRepository;

    @Autowired
    ReadingResourceAssembler readingResourceAssembler;

    @RequestMapping(method = RequestMethod.POST)
    void postDislike(@PathVariable String readingId) {
        Dislike like = new Dislike(readingId);
        dislikeRepository.insert(like);
        
        
    }


}

