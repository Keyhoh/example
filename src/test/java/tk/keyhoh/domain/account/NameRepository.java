package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.INameRepository;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.exception.AlreadyExistsException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NameRepository implements INameRepository {
    private static final Map<Name, Id> store = new HashMap<>();

    @Override
    public void save(Name name, Id id) throws AlreadyExistsException {
        if(store.containsKey(name)) throw new AlreadyExistsException(name);
        store.put(name, id);
    }

    @Override
    public Optional<Id> findId(Name name) {
        return Optional.ofNullable(store.get(name));
    }
}
