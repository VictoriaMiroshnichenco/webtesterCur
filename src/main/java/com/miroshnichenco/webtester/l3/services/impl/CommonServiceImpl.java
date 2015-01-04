package com.miroshnichenco.webtester.l3.services.impl;

import java.util.List;



import java.util.UUID;






import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;








import com.miroshnichenco.webtester.l0.utils.ReflectionUtils;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.UserRole;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l2.dao.AccountRoleDao;
import com.miroshnichenco.webtester.l2.dao.RoleDao;
import com.miroshnichenco.webtester.l2.dao.impl.hibernate.AccountDaoImpl;
import com.miroshnichenco.webtester.l3.components.EntityBuilder;
import com.miroshnichenco.webtester.l3.services.CommonService;
import com.miroshnichenco.webtester.l3.services.EmailService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;

@Service("commonService")

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommonServiceImpl implements CommonService {
	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDaoImpl accountDao;
	
	@Autowired
	@Qualifier("hibernateAccountRoleDao")
	private AccountRoleDao accountRoleDao;
	
	@Autowired
	@Qualifier("hibernateRoleDao")
	private RoleDao roleDao;

	@Autowired
	@Qualifier("entityBuilder")
	private EntityBuilder entityBuilder;
	
	@Autowired
	@Qualifier("emailService")
	private EmailService emailService;
	
	@Override
	@Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public User login(String email, String password, int role)
			throws InvalidUserInputException {
		User a = null;

		a = accountDao.findByEmail(email);
		if(a == null) {
			throw new InvalidUserInputException("Bad credentials");
		}
		if(!StringUtils.equals(password, a.getPassword())) {
			throw new InvalidUserInputException("Bad credentials");
		}
		if(!a.getActive()) {
			throw new InvalidUserInputException("Account is not active");
		}

		if(!hasRole(a , role)) {
			throw new InvalidUserInputException("Current account does not have selected role");
		}
		return a;
	}
	
	@Override
	@Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public User login(com.restfb.types.User user) throws InvalidUserInputException {
		User a = accountDao.findByEmail(user.getEmail());
		if(a != null) {
			return a;
		}
		else{
			SignUpForm form = new SignUpForm ();
			form.setEmail(user.getEmail());
			
			form.setName(user.getFirstName());

			form.setLogin(user.getEmail());
			
			UUID pwd = UUID.randomUUID();//generate temp password
			form.setPassword(pwd.toString());
			//form.setPassword2(pwd.toString());??
			
			return signUp(form, false, true);
		}
	}
	protected User signUp(SignUpForm form, boolean sendVerificationEmail, boolean sendPasswordToEmail) throws InvalidUserInputException {
		User u = entityBuilder.buildAccount();
		ReflectionUtils.copyByFields(u, form);
		accountDao.save(u);
		
		Role r = roleDao.getStudentRole();
		UserRole ar = entityBuilder.buildAccountRole(u, r);
		accountRoleDao.save(ar);
		
		if(sendVerificationEmail) {
			emailService.sendVerificationEmail();
		}
		if(sendPasswordToEmail) {
			emailService.sendGeneratedPasswordToEmail();
		}
		return u;
	}
	
	@Override
	@Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public User signUp(SignUpForm form) throws InvalidUserInputException {
		return signUp(form, true, false);
	}
	
	private boolean hasRole(User a , int role) {
		for(UserRole ar : a.getAccountRoles()) {
			if(ar.getRole().getIdRole().intValue() == role) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Role> listAllRoles() {
		return roleDao.finfAll();
		
	}

	@Override
	public String getSupportEmailAddress() {
		return null;
	}

}
