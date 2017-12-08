package in.ravikalla.cloudBank.controller;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.ravikalla.cloudBank.domain.PrimaryAccount;
import in.ravikalla.cloudBank.domain.PrimaryTransaction;
import in.ravikalla.cloudBank.domain.SavingsAccount;
import in.ravikalla.cloudBank.domain.SavingsTransaction;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.service.AccountService;
import in.ravikalla.cloudBank.service.TransactionService;
import in.ravikalla.cloudBank.service.UserService;
import in.ravikalla.cloudBank.util.AppConstants;

@Controller
@RequestMapping(AppConstants.URI_ACC)
public class AccountController {
	private static final Logger L = LogManager.getLogger(AccountController.class);
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(AppConstants.URI_ACC_PRIMARY)
	public String primaryAccount(Model model, Principal principal) {
		L.debug("40 : Start : AccountController.primaryAccount(...)");

		List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
		
		User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionList);
        L.debug("49 : End : AccountController.primaryAccount(...)");
		return "primaryAccount";
	}

	@RequestMapping(AppConstants.URI_ACC_SAVINGS)
    public String savingsAccount(Model model, Principal principal) {
		L.debug("55 : Start : AccountController.savingsAccount(...)");
		List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);
        L.debug("62 : End : AccountController.savingsAccount(...)");
        return "savingsAccount";
    }

	@RequestMapping(value = AppConstants.URI_DEPOSIT, method = RequestMethod.GET)
    public String deposit(Model model) {
		L.debug("68 : Start : AccountController.deposit(...)");

        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        L.debug("73 : End : AccountController.deposit(...)");
        return "deposit";
    }

    @RequestMapping(value = AppConstants.URI_DEPOSIT, method = RequestMethod.POST)
    public String depositPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
  		L.debug("79 : Start : AccountController.depositPOST(...)");
        accountService.deposit(accountType, Double.parseDouble(amount), principal);
        L.debug("82 : End : AccountController.depositPOST(...)");

        return "redirect:/userFront";
    }
    
    @RequestMapping(value = AppConstants.URI_WITHDRAW, method = RequestMethod.GET)
    public String withdraw(Model model) {

    		L.debug("89 : Start : AccountController.withdraw(...)");
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");
        L.debug("93 : End : AccountController.withdraw(...)");

        return "withdraw";
    }

    @RequestMapping(value = AppConstants.URI_WITHDRAW, method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
    		L.debug("100 : Start : AccountController.withdrawPOST(...)");
        accountService.withdraw(accountType, Double.parseDouble(amount), principal);
        L.debug("102 : End : AccountController.withdrawPOST(...)");

        return "redirect:/userFront";
    }
}
