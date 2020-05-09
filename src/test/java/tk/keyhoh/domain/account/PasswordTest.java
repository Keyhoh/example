package tk.keyhoh.domain.account;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordTest {
    @ParameterizedTest
    @CsvSource({
        "Correct Password,   Correct Password,  true",
        "Correct Password, InCorrect Password, false",
    })
    void PasswordEquality(String expected, String actual, boolean result){
        var expectedPass = new Password(expected);
        var actualPass = new Password(actual);
        assertEquals(expectedPass.equals(actualPass), result);
    }
}
