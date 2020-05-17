package tk.keyhoh.domain.account.name;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.exception.AlreadyExistsException;

import java.util.Optional;

public interface INameRepository {
    void save(Name name, Id id) throws AlreadyExistsException;
    Optional<Id> findId(Name name);
}
