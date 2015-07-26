package sharesumer.domain.reading.like_or_dislike;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, String> {

    Long countByReadingId(String readingId);
    
}
