package sharesumer.infrastructure.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(basePackages = "sharesumer.domain")
class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.uri}")
    String uri;

    @Override
    protected String getDatabaseName() {
        return "wisepal";
    }

    @Override
    public Mongo mongo() throws UnknownHostException {
        return new MongoClient(new MongoClientURI(uri));
    }

}