package com.miroshnichenco.webtester.l6.security;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.miroshnichenco.webtester.l1.entities.User;


public class SecurityUtils{
	
	public static long getCurrentIdAccount () {
		CurrentAccount a = getCurrentAccount();
		return a != null ? a.getIdAccount() : -1;
	}
	
	public static CurrentAccount getCurrentAccount () {
		Object principal;
		try {
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
		if (principal instanceof CurrentAccount) {
			return (CurrentAccount)principal;
		}
		return null;
	}
	
	public static void authentificate(User account) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(
                new CurrentAccount(account),
                account.getPassword(),
                AuthentificationService.convert(account.getAccountRoles()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
