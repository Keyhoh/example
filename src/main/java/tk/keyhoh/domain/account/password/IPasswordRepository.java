package tk.keyhoh.domain.account.password;

import tk.keyhoh.domain.account.id.Id;

public interface IPasswordRepository {
    void save(Id id, Password password);
    boolean exists(Id id, Password password);
}
