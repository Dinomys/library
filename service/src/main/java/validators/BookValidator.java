package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookValidator {

    private static final Pattern REGEXPATTERN = Pattern.compile("^(([0-9]-?){13})$");

    protected boolean isbnValidator(String isbn) {
        Matcher matcher = REGEXPATTERN.matcher(isbn);
        return matcher.matches();
    }
}

