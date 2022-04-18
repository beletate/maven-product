package univas.edu.vinicius.model.support;

import java.util.stream.Stream;

import univas.edu.vinicius.Exceptions.InvalidDataException;

public enum ProductCategory {
	
	LOW(1), MEDIUM(2), HIGH(3);
	
	private int code;
	
	private ProductCategory(int code) {
		this.code = code;
	}
	
	public static ProductCategory getPriority(Integer code) {
		return Stream.of(ProductCategory.values())
				.filter(t -> t.getCode() == code)
				.findFirst()
				.orElseThrow(() -> new InvalidDataException("Prioridade inválida: " + code));
	}
	
	public int getCode() {
		return code;
	}
}
