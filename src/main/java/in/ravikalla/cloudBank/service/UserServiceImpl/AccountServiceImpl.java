package in.ravikalla.cloudBank.service.UserServiceImpl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import in.ravikalla.cloudBank.dao.PrimaryAccountDao;
import in.ravikalla.cloudBank.dao.SavingsAccountDao;
import in.ravikalla.cloudBank.domain.PrimaryAccount;
import in.ravikalla.cloudBank.domain.PrimaryTransaction;
import in.ravikalla.cloudBank.domain.SavingsAccount;
import in.ravikalla.cloudBank.domain.SavingsTransaction;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.service.AccountService;
import in.ravikalla.cloudBank.service.TransactionService;
import in.ravikalla.cloudBank.service.UserService;

@Service
public class AccountServiceImpl implements AccountService {
    
    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

	private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionService transactionService;

    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }
    
    public void deposit(String accountType, double amount, Principal principal) {
        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = user.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryDepositTransaction(primaryTransaction);
            
            callBofaDeposit();
            
        } else if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();
            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
            transactionService.saveSavingsDepositTransaction(savingsTransaction);
            
            callBofaDeposit();
        }
    }
    
    private void callBofaDeposit(){
      try {
        RestTemplate rest = new RestTemplate();
        String quote = rest.getForObject("http://localhost:7001/bofa/deposit", String.class);
        LOG.info("bofa online deposit response: " + quote);
      } catch (RestClientException e) {
        LOG.error("Rest call to Bofa-online deposit service failed.");
      }
    }
    
    public void withdraw(String accountType, double amount, Principal principal) {
        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = user.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryWithdrawTransaction(primaryTransaction);
		
            callBofaWithdraw();
            
        } else if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();
            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Withdraw from savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
            transactionService.saveSavingsWithdrawTransaction(savingsTransaction);
            
            callBofaWithdraw();
        }
    }

    private void callBofaWithdraw(){
      
      try{
        RestTemplate rest = new RestTemplate();
        String str = rest.getForObject("http://localhost:7001/bofa/withdraw", String.class);
        LOG.info("Bofa online response: "+str);
      } catch(RestClientException e){
        LOG.error("Rest call to Bofa-online withdraw service failed.");
      }
    }
    
    private int accountGen() {
        return ++nextAccountNumber;
    }

	

}
