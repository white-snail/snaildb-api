package com.kasokuz.snaildb.module.snail.web.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminGUIController {
	
	@GetMapping(value = "util.js", produces = "application/javascript")
	public ResponseEntity<byte[]> getAdminJs() throws IOException {
		return read("util.js");
	}
	
	@GetMapping(value = "login", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<byte[]> getLogin() throws IOException {
		return read("login.html");
	}
	
	@GetMapping(value = "admin", produces = MediaType.TEXT_HTML_VALUE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<byte[]> getAdmin() throws IOException {
		return read("admin.html");
	}
	
	private ResponseEntity<byte[]> read(String file) throws IOException {
		return ResponseEntity.ok().body(Files.readAllBytes(Paths.get("src/main/resources/gui/" + file)));
	}

}
