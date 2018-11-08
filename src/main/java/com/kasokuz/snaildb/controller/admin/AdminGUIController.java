package com.kasokuz.snaildb.controller.admin;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kasokuz.snaildb.utils.GUI;

@Controller
public class AdminGUIController {
	
	@GetMapping(value = "util.js", produces = "application/javascript")
	public ResponseEntity<byte[]> getAdminJs() throws IOException {
		return GUI.read("util.js");
	}
	
	@GetMapping(value = "login", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<byte[]> getLogin() throws IOException {
		return GUI.read("login.html");
	}
	
	@GetMapping(value = "admin", produces = MediaType.TEXT_HTML_VALUE)
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<byte[]> getAdmin() throws IOException {
		return GUI.read("admin.html");
	}

}
