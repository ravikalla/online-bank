package in.ravikalla.cloudBank.controller;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.ravikalla.cloudBank.domain.PrimaryAccount;
import in.ravikalla.cloudBank.domain.Recipient;
import in.ravikalla.cloudBank.domain.SavingsAccount;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.service.TransactionService;
import in.ravikalla.cloudBank.service.UserService;
import static in.ravikalla.cloudBank.util.AppConstants.*;

@Controller
@RequestMapping(URI_TRANSFER)
public class TransferController {
	private static final Logger L = LogManager.getLogger(TransferController.class);

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = URI_TRANSFER_BETWEEN_ACCOUNTS, method = RequestMethod.GET)
	public String betweenAccounts(Model model) {
		L.debug("37 : Start : TransferController.betweenAccounts(...)");

		model.addAttribute("transferFrom", "");
		model.addAttribute("transferTo", "");
		model.addAttribute("amount", "");

		L.debug("43 : End : TransferController.betweenAccounts(...)");
		return "betweenAccounts";
	}

	@RequestMapping(value = URI_TRANSFER_BETWEEN_ACCOUNTS, method = RequestMethod.POST)
	public String betweenAccountsPost(
			@ModelAttribute("transferFrom") String transferFrom,
			@ModelAttribute("transferTo") String transferTo,
			@ModelAttribute("amount") String amount,
			Principal principal
	) throws Exception {
		L.debug("54 : Start : TransferController.betweenAccountsPost(...)");

		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		SavingsAccount savingsAccount = user.getSavingsAccount();
		transactionService.betweenAccountsTransfer(transferFrom, transferTo, amount, primaryAccount, savingsAccount);

		L.debug("61 : End : TransferController.betweenAccountsPost(...)");
		return "redirect:/userFront";
	}
	
	@RequestMapping(value = URI_TRANSFER_RECEPIENT, method = RequestMethod.GET)
	public String recipient(Model model, Principal principal) {
		L.debug("67 : Start : TransferController.recipient(...)");

		List<Recipient> recipientList = transactionService.findRecipientList(principal);

		Recipient recipient = new Recipient();

		model.addAttribute("recipientList", recipientList);
		model.addAttribute("recipient", recipient);

		L.debug("76 : End : TransferController.recipient(...)");
		return "recipient";
	}

	@RequestMapping(value = URI_TRANSFER_RECEPIENT_SAVE, method = RequestMethod.POST)
	public String recipientPost(@ModelAttribute("recipient") Recipient recipient, Principal principal) {
		L.debug("82 : Start : TransferController.recipientPost(...)");

		User user = userService.findByUsername(principal.getName());
		recipient.setUser(user);
		transactionService.saveRecipient(recipient);

		L.debug("88 : End : TransferController.recipientPost(...)");
		return "redirect:/transfer/recipient";
	}

	@RequestMapping(value = URI_TRANSFER_RECEPIENT_SAVE, method = RequestMethod.GET)
	public String recipientEdit(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){
		L.debug("94 : Start : TransferController.recipientEdit(...)");

		Recipient recipient = transactionService.findRecipientByName(recipientName);
		List<Recipient> recipientList = transactionService.findRecipientList(principal);

		model.addAttribute("recipientList", recipientList);
		model.addAttribute("recipient", recipient);

		L.debug("102 : End : TransferController.recipientEdit(...)");
		return "recipient";
	}

	@RequestMapping(value = URI_TRANSFER_RECEPIENT_DELETE, method = RequestMethod.GET)
	@Transactional
	public String recipientDelete(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){
		L.debug("109 : Start : TransferController.recipientDelete(...)");

		transactionService.deleteRecipientByName(recipientName);

		List<Recipient> recipientList = transactionService.findRecipientList(principal);

		Recipient recipient = new Recipient();
		model.addAttribute("recipient", recipient);
		model.addAttribute("recipientList", recipientList);

		L.debug("119 : End : TransferController.recipientDelete(...)");
		return "recipient";
	}

	@RequestMapping(value = URI_TRANSFER_TO_SOMEONE,method = RequestMethod.GET)
	public String toSomeoneElse(Model model, Principal principal) {
		L.debug("125 : Start : TransferController.toSomeoneElse(...)");

		List<Recipient> recipientList = transactionService.findRecipientList(principal);

		model.addAttribute("recipientList", recipientList);
		model.addAttribute("accountType", "");

		L.debug("132 : End : TransferController.toSomeoneElse(...)");
		return "toSomeoneElse";
	}

	@RequestMapping(value =  URI_TRANSFER_TO_SOMEONE,method = RequestMethod.POST)
	public String toSomeoneElsePost(@ModelAttribute("recipientName") String recipientName, @ModelAttribute("accountType") String accountType, @ModelAttribute("amount") String amount, Principal principal) {
		L.debug("138 : Start : TransferController.toSomeoneElsePost(...)");

		User user = userService.findByUsername(principal.getName());
		Recipient recipient = transactionService.findRecipientByName(recipientName);
		transactionService.toSomeoneElseTransfer(recipient, accountType, amount, user.getPrimaryAccount(), user.getSavingsAccount());

		L.debug("144 : End : TransferController.toSomeoneElsePost(...)");
		return "redirect:/userFront";
	}
}
