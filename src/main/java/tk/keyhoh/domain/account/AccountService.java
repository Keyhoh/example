package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.INameRepository;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.Password;
import tk.keyhoh.exception.AlreadyExistsException;

public class AccountService {
    private final IAccountRepository iAccountRepository;
    private final INameRepository iNameRepository;

    AccountService(IAccountRepository iAccountRepository, INameRepository iNameRepository) {
        this.iNameRepository = iNameRepository;
        this.iAccountRepository = iAccountRepository;
    }

    public boolean authenticate(Id id, Password password) {
        return iAccountRepository.exists(id, password);
    }

    public boolean authenticate(Name name, Password password) {
        return iAccountRepository.exists(name, password);
    }

    public Account createAccount(String name, String password) throws AlreadyExistsException {
        var account = new Account();

        // nameの目的はユーザビリティの向上。
        // nameにはemail addressが用いられることも考えられるので、システム内では別のIDを利用する。
        // そのためnameにaccount.idが紐づく関係性になるので、nameを先に保存する。
        iNameRepository.save(new Name(name), account.id);
        iAccountRepository.save(account, new Password(password));
        return account;
    }
}
