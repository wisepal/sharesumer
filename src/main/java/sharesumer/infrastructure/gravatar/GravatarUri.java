package sharesumer.infrastructure.gravatar;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class GravatarUri {

    private final String value;

    private GravatarUri(String value) {
        this.value = value;
    }

    public static final GravatarUri fromEmail(String email) {

        String sanitizedEmail = email.trim().toLowerCase();
        String hashCode = Hashing.md5().hashString(sanitizedEmail, Charsets.UTF_8).toString();

        return new GravatarUri("http://www.gravatar.com/avatar/" + hashCode);
    }

    @Override
    public String toString() {
        return value;
    }
}
