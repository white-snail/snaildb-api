package com.kasokuz.snaildb.controller.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.kasokuz.snaildb.controller.auth.response.LogResponse;
import com.kasokuz.snaildb.domain.User;
import com.kasokuz.snaildb.service.AccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping(value = "register")
	public void postRegister(@RequestParam String username, @RequestParam String password) throws NoSuchAlgorithmException {
		User user = new User();
		user.setUsername(username);
		user.setPassword(MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8)));
		this.service.saveUser(user);
	}

	@PostMapping(value = "login")
	public LogResponse postLogin(@RequestParam String username, @RequestParam String password) throws NoSuchAlgorithmException {
		User user = this.service.getUser(username);
		if(user != null && Arrays.equals(user.getPassword(), MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8)))) {
			SecurityContextHolder.getContext().setAuthentication(new Authentication() {
				
				private static final long serialVersionUID = -8665199376728947764L;
	
				@Override
				public String getName() {
					return user.getUsername();
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
					ret.add(() -> "USER");
					if(user.getAdmin()) ret.add(() -> "ADMIN");
					return ret;
				}
			});
			return new LogResponse(true);
		} else {
			return new LogResponse(false);
		}
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
