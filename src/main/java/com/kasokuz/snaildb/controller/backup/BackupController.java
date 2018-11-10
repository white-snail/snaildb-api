package com.kasokuz.snaildb.controller.backup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.backup.response.Backup;
import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.domain.Subspecies;
import com.kasokuz.snaildb.domain.Superfamily;
import com.kasokuz.snaildb.domain.Taxonomer;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@RequestMapping(value = "backup", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BackupController {

	@Autowired
	private SnailService service;
	
	@GetMapping(value = "export")
	public Backup getExport() {
		Backup backup = new Backup();
		for(Taxonomer taxonomer : service.getTaxonomers()) backup.taxonomers.add(new Backup.Taxonomer(taxonomer));
		for(Superfamily superfamily : service.getSuperfamilies()) backup.superfamilies.add(new Backup.Superfamily(superfamily));
		for(Family family : service.getFamilies()) backup.families.add(new Backup.Family(family));
		for(Genus genus : service.getGenuses()) backup.genera.add(new Backup.Genus(genus));
		for(Species species : service.getSpecies()) backup.species.add(new Backup.Species(species));
		for(Subspecies subspecies : service.getSubspecies()) backup.subspecies.add(new Backup.Subspecies(subspecies));
		return backup;
	}
	
	@PostMapping(value = "import", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public void postImport(@RequestBody Backup backup) {
		//TODO
	}
	
}
