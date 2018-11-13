package com.kasokuz.snaildb.controller.backup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// delete the current database
		for(Taxonomer taxonomer : service.getTaxonomers()) service.deleteTaxonomer(taxonomer.getTaxonomerId());
		for(Superfamily superfamily : service.getSuperfamilies()) service.deleteSuperfamily(superfamily.getSuperfamilyId());
		for(Family family : service.getFamilies()) service.deleteFamily(family.getFamilyId());
		for(Genus genus : service.getGenuses()) service.deleteGenus(genus.getGenusId());
		for(Species species : service.getSpecies()) service.deleteSpecies(species.getSpeciesId());
		for(Subspecies subspecies : service.getSubspecies()) service.deleteSubspecies(subspecies.getSubspeciesId());
		// save the new data
		Map<Integer, Taxonomer> taxonomers = new HashMap<>();
		Map<Integer, Superfamily> superfamilies = new HashMap<>();
		Map<Integer, Family> families = new HashMap<>();
		Map<Integer, Genus> genera = new HashMap<>();
		Map<Integer, Species> species_ = new HashMap<>();
		for(Backup.Taxonomer taxonomer : backup.taxonomers) {
			taxonomers.put(taxonomer.id, service.saveTaxonomer(new Taxonomer(taxonomer.n, taxonomer.s)));
		}
		for(Backup.Superfamily superfamily : backup.superfamilies) {
			superfamilies.put(superfamily.id, service.saveSuperfamily(new Superfamily(superfamily.n, getTaxonomers(superfamily.t, taxonomers), superfamily.y, superfamily.p, superfamily.a)));
		}
		for(Backup.Family family : backup.families) {
			families.put(family.id, service.saveFamily(new Family(superfamilies.get(family.s), family.n, getTaxonomers(family.t, taxonomers), family.y)));
		}
		for(Backup.Genus genus : backup.genera) {
			genera.put(genus.id, service.saveGenus(new Genus(families.get(genus.f), genus.n, getTaxonomers(genus.t, taxonomers), genus.y)));
		}
		for(Backup.Species species : backup.species) {
			species_.put(species.id, service.saveSpecies(new Species(genera.get(species.g), species.n, getTaxonomers(species.t, taxonomers), species.y, species.v, species.e)));
		}
		for(Backup.Subspecies subspecies : backup.subspecies) {
			service.saveSubspecies(new Subspecies(species_.get(subspecies.s), subspecies.n, getTaxonomers(subspecies.t, taxonomers), subspecies.y, subspecies.mnh, subspecies.mxh, subspecies.mnw, subspecies.mxw, subspecies.f, subspecies.l));
		}
	}
	
	private List<Taxonomer> getTaxonomers(List<Integer> ids, Map<Integer, Taxonomer> taxonomers) {
		List<Taxonomer> ret = new ArrayList<>();
		for(Integer id : ids) {
			ret.add(taxonomers.get(id));
		}
		return ret;
	}
	
}
