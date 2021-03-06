package org.mixit.cesar.security.service.account;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.mixit.cesar.site.model.member.Member;
import org.mixit.cesar.security.model.Account;
import org.mixit.cesar.security.repository.AccountRepository;
import org.mixit.cesar.site.repository.MemberRepository;
import org.mixit.cesar.security.service.exception.EmailExistException;
import org.mixit.cesar.security.service.exception.ExpiredTokenException;
import org.mixit.cesar.security.service.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TokenService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Generate a new token
     */
    public void generateNewToken(Account account) {
        Objects.requireNonNull(account);
        Objects.requireNonNull(account.getOauthId());
        account.setToken(UUID.randomUUID().toString());
        reinitTokenValidity(account);
    }


    /**
     * Reinit token validity
     */
    public void reinitTokenValidity(Account account) {
        Objects.requireNonNull(account);
        account.setTokenExpiration(LocalDateTime.now().plus(Duration.ofHours(3)));
    }

    /**
     * Chek user with token
     */
    public Account checkToken(String token) {
        Account account = accountRepository.findByToken(token);

        //Step1: we check the token and its validity
        if (account == null) {
            throw new InvalidTokenException();
        }
        //Step2: the token is only valid during 3 hours
        if (account.getTokenExpiration() == null || LocalDateTime.now().minus(Duration.ofHours(3)).compareTo(account.getTokenExpiration()) > 0) {
            throw new ExpiredTokenException();
        }

        return account;
    }


    /**
     * Check user and return credentials
     */
    public Account getCredentialsForToken(String token) {
        Account account = checkToken(token);
        account.setValid(true);
        return account;
    }

    /**
     * We had'nt be able to keep the old accounts when we migrated to the new website. When a user sign in for the
     * first time on the new website, we try to link his old member infos
     */
    public Member tryToLinkWithActualMember(Account account){
        List<Account> accounts = accountRepository.findByEmail(account.getEmail());

        if(!accounts.isEmpty() && !accounts.get(0).getOauthId().equals(account.getOauthId())){
            //We can't have to account with the same email
            throw new EmailExistException();
        }

        Optional<Member> member = memberRepository.findByEmail(account.getEmail()).stream().findFirst();

        if(member.isPresent()){
            Account acc = accountRepository.findByMember(member.get().getId());
            if(acc!=null) {
                //We can't have a member linked with 2 accounts
                throw new EmailExistException();
            }
            return member.get();
        }
        else{
            return null;
        }
    }
}
