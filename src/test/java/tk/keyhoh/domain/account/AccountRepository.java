package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.IPasswordRepository;
import tk.keyhoh.domain.account.password.Password;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepository implements IAccountRepository {
    private final IPasswordRepository iPasswordRepository = new PasswordRepository();
    private final Map<Id, Account> store = new HashMap<>();

    @Override
    public void save(Account account, Password password) {
        store.put(account.id, account);
        iPasswordRepository.save(account.id, password);
    }

    @Override
    public Optional<Account> find(Id id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public boolean exists(Id id, Password password) {
        return store.containsKey(id) && iPasswordRepository.exists(id, password);
    }

    @Override
    public boolean exists(Name name, Password password) {
        return store.entrySet().parallelStream()
                .anyMatch(e -> e.getValue().name.equals(name) && iPasswordRepository.exists(e.getKey(), password));
    }
}
