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

import fr.gds.entities.Produit;

@RestController
public class ProduiteRestService {

	@Autowired
	private ProduitRepository pr;

	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	public Page<Produit> listProduit(@RequestParam(name="page", defaultValue="0")int page, @RequestParam(name="page", defaultValue="3")int size) {

		return pr.findAll(new PageRequest(page, size));
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {

		return pr.findOne(id);
	}

	@RequestMapping(value = "/produits", method = RequestMethod.POST)
	public Produit addProduit(@RequestBody Produit p) {

		return pr.save(p);
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit p, @PathVariable("id") Long id) {
		p.setId(id);
		return pr.saveAndFlush(p);
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
	public void deleteProduitById(@PathVariable("id") Long id) {

		pr.delete(id);
	}

	@RequestMapping(value = "/chercherProduit", method = RequestMethod.GET)
	public Page<Produit> chercher(
			String mc, 
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="3")int size) {

		return pr.chercherProduit("%"+mc+"%", new PageRequest(page, size));
	}

}
