package com.kasokuz.snaildb.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;

public class GUI {
	
	public static ResponseEntity<byte[]> read(String file) throws IOException {
		return ResponseEntity.ok().body(Files.readAllBytes(Paths.get("src/main/resources/gui/" + file)));
	}
	
}
