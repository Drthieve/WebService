package gov.iti.jets.soap.services.dtos;

import gov.iti.jets.domain.models.CartLineItem;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

@XmlRootElement(name = "cartLineItem")
@XmlType(propOrder = {"id", "productId", "quantity"})
public class CartLineItemDto implements Serializable {
    private int quantity;
    private int id;
    private int productId;

    public CartLineItemDto() {
    }

    public CartLineItemDto(CartLineItem cartLineItem) {
        this.id = cartLineItem.getId();
        this.productId = cartLineItem.getProduct().getId();
        this.quantity = cartLineItem.getQuantity();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "productIdId = " + productId + ", " +
                "quantity = " + quantity + ")";
    }
}
