package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tk.keyhoh.domain.account.name.INameRepository;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.exception.AlreadyExistsException;

public class NameTest {
    private final AccountService accountService = new AccountService(new AccountRepository());
    private final INameRepository iNameRepository = new NameRepository();

    @Test
    void nameUniquenessTest(){
        var account = accountService.createAccount("name", "password");
        Assertions.assertDoesNotThrow(() -> iNameRepository.save(account.name, account.id));
        Assertions.assertThrows(AlreadyExistsException.class, () -> iNameRepository.save(account.name, account.id));
    }

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
