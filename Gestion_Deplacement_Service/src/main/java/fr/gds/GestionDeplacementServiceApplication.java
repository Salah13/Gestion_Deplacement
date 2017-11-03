package fr.gds;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.gds.dao.ProduitRepository;
import fr.gds.entities.Produit;

@SpringBootApplication
public class GestionDeplacementServiceApplication implements CommandLineRunner{
	@Autowired
	private ProduitRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(GestionDeplacementServiceApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		//ProduitRepository pr = ctx.getBean(ProduitRepository.class);
		/*pr.save(new Produit("LX 64",900,23));
		pr.save(new Produit("HT 45",100,10));
		pr.save(new Produit("DS 124",50,45));*/
		
		List<Produit> prods = pr.findAll();
		prods.forEach(p->System.out.println(p.getDesignation()));
		
	}
}
