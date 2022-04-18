package univas.edu.vinicius.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import univas.edu.vinicius.model.support.ProductCategory;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String name;
    private float price;
    private String description;
    private ProductCategory category;
    
    public Product() {}

    public Product(String name, String description, float price, ProductCategory category) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
    
}
