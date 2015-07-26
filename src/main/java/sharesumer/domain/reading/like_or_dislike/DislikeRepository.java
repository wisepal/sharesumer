package sharesumer.domain.reading.like_or_dislike;

import org.springframework.data.mongodb.repository.MongoRepository;

interface DislikeRepository extends MongoRepository<Dislike, String> {
}
