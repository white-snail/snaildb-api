package com.kasokuz.snaildb.module.snail.web.docs;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kasokuz.snaildb.module.snail.utils.GUI;

@Controller
public class DocsGUIController {

	@GetMapping(value = "docs", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<byte[]> getDocs() throws IOException {
		return GUI.read("docs.html");
	}
	
}
