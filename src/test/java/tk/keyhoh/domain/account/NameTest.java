package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tk.keyhoh.domain.account.name.INameRepository;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.exception.AlreadyExistsException;

import java.util.UUID;

public class NameTest {
    private final AccountService accountService = new AccountService(new AccountRepository(), new NameRepository());
    private final INameRepository iNameRepository = new NameRepository();

    @Test
    void nameUniquenessTest() throws AlreadyExistsException {
        var uniqueName = UUID.randomUUID().toString();
        var account = accountService.createAccount(uniqueName, "password");
        var name = new Name(uniqueName);
        Assertions.assertThrows(AlreadyExistsException.class, () -> iNameRepository.save(name, account.id));
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
