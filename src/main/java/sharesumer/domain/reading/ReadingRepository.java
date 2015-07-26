package sharesumer.domain.reading;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReadingRepository extends MongoRepository<Reading, String> {
}
