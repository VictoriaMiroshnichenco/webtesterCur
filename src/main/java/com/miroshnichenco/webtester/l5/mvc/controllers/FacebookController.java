package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miroshnichenco.webtester.l3.services.CommonService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;


@Controller
public class FacebookController extends AbstractController implements InitializingBean{

	@Value("${facebook.clientId}")
    private String facebookClientId;

    @Value("${facebook.secretKey}")
    private String facebookSecretKey;
    
    @Value("${application.host}")
    private String applicationHost;
    
    @Autowired
    private CommonService commonService;
    
    private String fbReferrer;

	@Override
	public void afterPropertiesSet() throws Exception {
		fbReferrer = "https://graph.facebook.com/oauth/authorize?client_id=" + facebookClientId + 
				"&redirect_uri=http://" + applicationHost + "/fromfb" + "&scope=email,user_location,user_birthday";
	}
    
	@RequestMapping(value={"/fbLogin", "/fbSignup"}, method={RequestMethod.GET})
    public String fbLogin() throws Exception {
        return "redirect:" + fbReferrer;
    }
	
	@RequestMapping(value="/fromfb", method={RequestMethod.GET})
    public String fromfb(HttpServletRequest request, HttpSession session, @RequestParam("code") String code) throws Exception {
		User user = getFacebookUser(code);
		com.miroshnichenco.webtester.l1.entities.User a = commonService.login(user);
		session.setAttribute("CURRENT_ACCOUNT", a);
		return "redirect:/home";
	}
	
	
	protected User getFacebookUser (String code) throws IOException{
    	String url = "https://graph.facebook.com/oauth/access_token?client_id="
                + facebookClientId + "&redirect_uri=http://" + applicationHost + "/fromfb?referrer="
                + fbReferrer + "&client_secret=" + facebookSecretKey + "&code=" + code;
        URLConnection connection = new URL(url).openConnection();
        InputStream in = null;
        try {
        	in = connection.getInputStream();
        	Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\Z");
            String out = scanner.next();
            String[] auth1 = out.split("=");
            String[] auth2 = auth1[1].split("&");
            FacebookClient facebookClient = new DefaultFacebookClient(auth2[0]);
            User user = facebookClient.fetchObject("me", User.class);
            return user;
        }finally {
        	IOUtils.closeQuietly(in);
        }
    }
}
