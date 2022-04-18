package univas.edu.vinicius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import univas.edu.vinicius.DAO.ProductDAO;
import univas.edu.vinicius.Exceptions.InvalidDataException;
import univas.edu.vinicius.Exceptions.ObjectNotFoundException;
import univas.edu.vinicius.dto.ProductDTO;
import univas.edu.vinicius.model.Auditing;
import univas.edu.vinicius.model.Product;

@Service
public class ProductService {

	@Autowired
    private ProductDAO productDAO;

    public List<ProductDTO> getAllProducts() {
        List<Product> listProduct = productDAO.findAll();

        return listProduct.stream()
                .map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
    }

    public Product getProductById(@PathVariable Long code) {
        if(code == null) {
            throw new InvalidDataException("Identificador não pode ser null.");
        }
        Optional<Product> obj = productDAO.findById(code);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Product não encontrado: " + code));
    }

    public void createProduct(ProductDTO dto) {
        Product product = toProduct(dto);
        productDAO.save(product);
    }

    private Product toProduct(ProductDTO dto) {
        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        return product;
    }

    public void updateProduct(ProductDTO dto, Long code) {
        if(dto == null) {
            throw new InvalidDataException("Product não pode ser null.");
        }
        Product product = getProductById(code);
        updateProduct(dto, product);
        productDAO.save(product);
    }

    private void updateProduct(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
    }

    public void deleteProduct(Long code) {
        Product product = getProductById(code);
        productDAO.delete(product);
    }
}
