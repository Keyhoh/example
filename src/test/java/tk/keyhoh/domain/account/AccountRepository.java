package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.IPassword;
import tk.keyhoh.domain.account.password.Password;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository implements IAccountRepository {
    private final IPassword iPasswordRepository = new PasswordRepository();
    private final Map<Id, Account> store = new HashMap<>();

    @Override
    public void save(Account account, Password password) {
        store.put(account.id, account);
        iPasswordRepository.save(account.id, password);
    }

    @Override
    public Account find(Id id) {
        return store.get(id);
    }

    @Override
    public boolean exists(Id id, Password password) {
        return store.containsKey(id) && iPasswordRepository.exists(id, password);
    }

    @Override
    public boolean exists(Name name, Password password) {
        return false;
    }
}
