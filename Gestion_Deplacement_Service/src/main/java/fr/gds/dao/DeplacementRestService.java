package fr.gds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gds.entities.Deplacement;


@RestController
public class DeplacementRestService {
	
	@Autowired
	private DeplacementRepository pr;

	@RequestMapping(value = "/afficherDeplacement", method = RequestMethod.GET)
	public Page<Deplacement> listDeplacement(@RequestParam(name="page", defaultValue="0")int page, @RequestParam(name="page", defaultValue="3")int size) {

		return pr.findAll(new PageRequest(page, size));
	}

	@RequestMapping(value = "/ajouterDeplacement", method = RequestMethod.POST)
	public Deplacement addDeplacement(@RequestBody Deplacement p) {

		return pr.save(p);
	}

	@RequestMapping(value = "/majDeplacement/{id}", method = RequestMethod.PUT)
	public Deplacement updateDeplacement(@RequestBody Deplacement p, @PathVariable("id") Long id) {
		p.setId(id);
		return pr.saveAndFlush(p);
	}

	@RequestMapping(value = "/supprimerDeplacement/{id}", method = RequestMethod.DELETE)
	public void deleteDeplacementById(@PathVariable("id") Long id) {

		pr.delete(id);
	}

	@RequestMapping(value = "/chercherDeplacement", method = RequestMethod.GET)
	public Page<Deplacement> chercher(
			String mc, 
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="3")int size) {

		return pr.chercherDeplacementByClient("%"+mc+"%", new PageRequest(page, size));
	}

	


}
