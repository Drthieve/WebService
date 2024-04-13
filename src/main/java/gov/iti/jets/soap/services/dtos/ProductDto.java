package gov.iti.jets.soap.services.dtos;

import gov.iti.jets.domain.models.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.rest.resources.category.CategoryResponse;
import gov.iti.jets.rest.utils.LinkJsonbAdapter;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@XmlRootElement(name = "product")
@XmlType(propOrder = {"identifier", "productName", "productDescription", "productQuantity", "productPrice", "productCategories"})
public class ProductDto implements Serializable {
    private Integer identifier;
    private String productName;
    private String productDescription;
    private Integer productQuantity;
    private BigDecimal productPrice;
    private Set<CategoryDto> productCategories;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.identifier = product.getId();
        this.productName = product.getName();
        this.productDescription = product.getDescription();
        this.productQuantity = product.getQuantity();
        this.productPrice = product.getPrice();
        this.productCategories = product.getCategories().stream()
                .map(CategoryDto::new)
                .collect(toSet());
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "category")
    public Set<CategoryDto> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<CategoryDto> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + identifier + ", " +
                "name = " + productName + ", " +
                "description = " + productDescription + ", " +
                "quantity = " + productQuantity + ", " +
                "price = " + productPrice + ", " +
                "categories = " + productCategories.size() + ")";
    }
}
