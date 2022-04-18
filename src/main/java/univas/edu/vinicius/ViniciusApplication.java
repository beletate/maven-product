package univas.edu.vinicius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import univas.edu.vinicius.DAO.ProductDAO;
import univas.edu.vinicius.model.Product;
import univas.edu.vinicius.model.support.ProductCategory;

@SpringBootApplication
public class ViniciusApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ViniciusApplication.class, args);
	}

	@Autowired
	private ProductDAO product;

	@Override
	public void run(String... args) throws Exception {
		Product product_1 = new Product("SSD", "Armazenador de Arquivos", 400, ProductCategory.MEDIUM);
		product.save(product_1);

		Product product_2 = new Product("HD", "Armazenador de Arquivos", 100, ProductCategory.MEDIUM);
		product.save(product_2);
	}
}
