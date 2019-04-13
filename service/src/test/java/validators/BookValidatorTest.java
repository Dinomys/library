package validators;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookValidatorTest{

    @org.junit.Test
    public void isbnValidatorWhenNumberHas13DigitsShouldReturnTrue() {
        //given
        String test = "000111-222-3334";
        BookValidator validator = new BookValidator();
        //when
        boolean result = validator.isbnValidator(test);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void isbnValidatorWhenNumberHas10DigitsShouldReturnTrue(){
        //given
        String test = "1112223334";
        BookValidator validator = new BookValidator();

        //when
        boolean result = validator.isbnValidator(test);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void isbnValidatorWhenNumberHas11DigitsShouldReturnFalse(){
        //given
        String test = "00011133344";
        BookValidator validator = new BookValidator();

        //when
        boolean result = validator.isbnValidator(test);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }

}
