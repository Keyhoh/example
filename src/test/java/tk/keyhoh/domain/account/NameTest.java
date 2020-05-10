package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NameTest {
    @ParameterizedTest()
    @CsvSource({
            "Alice, Alice,  true",
            "Alice,   Bob, false",
    })
    void nameEquality(String expected, String actual, boolean result) {
        var expectedName = new Name(expected);
        var actualName = new Name(actual);
        Assertions.assertEquals(expectedName.equals(actualName), result);
    }
}
