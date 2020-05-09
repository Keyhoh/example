package tk.keyhoh.domain.account;

import java.util.HashMap;
import java.util.Map;

public class PasswordRepository implements IPassword {
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
