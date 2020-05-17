package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.password.IPasswordRepository;
import tk.keyhoh.domain.account.password.Password;

import java.util.HashMap;
import java.util.Map;

public class PasswordRepository implements IPasswordRepository {
    private final Map<Id, Password> store = new HashMap<>();

    @Override
    public void save(Id id, Password password) {
        store.put(id, password);
    }

    @Override
    public boolean exists(Id id, Password password) {
        return store.containsKey(id) && store.get(id).equals(password);
    }
}
