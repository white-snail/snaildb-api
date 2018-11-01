package com.kasokuz.snaildb.module.account.web.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.account.dto.User;
import com.kasokuz.snaildb.module.account.service.AccountService;
import com.kasokuz.snaildb.module.account.web.auth.response.LogResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {
	
	@Autowired
	private AccountService service;

	@PostMapping(value = "login")
	public LogResponse postLogin(@RequestParam String username, @RequestParam String password) {
		User user = this.service.getUser(username);
		//TODO check password
		SecurityContextHolder.getContext().setAuthentication(new Authentication() {
			
			@Override
			public String getName() {
				return username;
			}
			
			@Override
			public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
				
			}
			
			@Override
			public boolean isAuthenticated() {
				return true;
			}
			
			@Override
			public Object getPrincipal() {
				return null;
			}
			
			@Override
			public Object getDetails() {
				return null;
			}
			
			@Override
			public Object getCredentials() {
				return null;
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> ret = new ArrayList<>();
				ret.add(() -> "ADMIN");
				return ret;
			}
		});
		return new LogResponse(true);
	}
	
	@PostMapping(value = "logout")
	public LogResponse logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){    
			request.logout();
			new SecurityContextLogoutHandler().logout(request, response, auth);
			return new LogResponse(true);
		} else {
			return new LogResponse(false);
		}
	}
	
}
