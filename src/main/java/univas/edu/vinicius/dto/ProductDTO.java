package univas.edu.vinicius.dto;

import univas.edu.vinicius.model.Product;
import univas.edu.vinicius.model.support.ProductCategory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProductDTO {

    private Long code;

    @NotNull(message = "O nome não pode ser nulo.")
    @NotEmpty(message = "o nome não pode ser vazio.")
    @Size(min = 1, max = 30, message = "Nome deve possuir entre 1 e 30 caracteres.")
    private String name;

    @NotNull(message = "O preço não pode ser null.")
    @Positive(message = "O preço deve ser um valor positivo.")
    private float price;

    @NotNull(message = "O fornecedor não pode ser nulo.")
    @NotEmpty(message = "O fornecedor não pode ser vazio.")
    private String description;

    private ProductCategory category;

    public ProductDTO() {}

    public ProductDTO(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}