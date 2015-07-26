package sharesumer.domain.mailgun_share;

import org.hibernate.validator.constraints.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sharesumer.domain.reading.By;
import sharesumer.domain.reading.Reading;
import sharesumer.domain.reading.ReadingRepository;
import sharesumer.infrastructure.gravatar.GravatarUri;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/mailgun/hook")
class MailgunWebHookController {

    @Autowired
    ReadingRepository readingRepository;

    @RequestMapping(method = RequestMethod.POST)
    void onEmailReceived(
            @Valid @URL @RequestParam(value = "subject") String uri,
            @RequestParam(value = "sender") String sender,
            @RequestParam(value = "timestamp") long timestamp) throws Exception {

        String title = fetchWebPageTitle(uri);

        Reading reading = new Reading(title, uri, anonymous(sender));
        readingRepository.insert(reading);
    }

    private String fetchWebPageTitle(String subject) throws IOException {
        Document doc = Jsoup.connect(subject).get();
        return doc.select("html title").text();
    }

    private By anonymous(String email) {
        return new By(email, GravatarUri.fromEmail(email).toString());
    }

}
