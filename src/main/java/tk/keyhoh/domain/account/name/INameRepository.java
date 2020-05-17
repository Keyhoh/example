package tk.keyhoh.domain.account.name;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.exception.AlreadyExistsException;

public interface INameRepository {
    void save(Name name, Id id) throws AlreadyExistsException;
}
