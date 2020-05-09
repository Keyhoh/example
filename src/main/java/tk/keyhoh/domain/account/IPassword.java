package tk.keyhoh.domain.account;

interface IPassword {
    void save(Id id, Password password);
    boolean exists(Id id, Password password);
}
