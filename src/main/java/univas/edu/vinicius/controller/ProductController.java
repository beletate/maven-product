package univas.edu.vinicius.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.List;
import univas.edu.vinicius.DAO.AuditingDAO;
import univas.edu.vinicius.dto.ProductDTO;
import univas.edu.vinicius.model.Auditing;
import univas.edu.vinicius.model.Product;
import univas.edu.vinicius.service.AuditingService;
import univas.edu.vinicius.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
    private ProductService service;
	private AuditingDAO auditingDAO;

    @GetMapping()
    public List<ProductDTO> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{code}")
    public ProductDTO getProductById(@PathVariable Long code) {
        Product product = service.getProductById(code);
        return new ProductDTO(product);
    }

    @PutMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody @Valid ProductDTO dto, @PathVariable Long code) {
        service.updateProduct(dto, code);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid ProductDTO dto) {
        service.createProduct(dto);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long code) {
        service.deleteProduct(code);
    }
}
