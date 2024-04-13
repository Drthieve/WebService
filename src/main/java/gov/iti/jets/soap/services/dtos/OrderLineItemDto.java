package gov.iti.jets.soap.services.dtos;

import gov.iti.jets.domain.models.OrderLineItem;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "orderLineItem")
@XmlType(propOrder = {"identifier", "productId", "quantity", "total"})
public class OrderLineItemDto implements Serializable {
    private int identifier;
    private int productId;
    private int quantity;
    private BigDecimal total;

    public OrderLineItemDto() {
    }

    public OrderLineItemDto(OrderLineItem orderLineItem) {
        this.identifier = orderLineItem.getId();
        this.productId = orderLineItem.getProduct().getId();
        this.quantity = orderLineItem.getQuantity();
        this.total = orderLineItem.getTotal();
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + identifier + ", " +
                "productId = " + productId + ", " +
                "quantity = " + quantity + ", " +
                "total = " + total + ")";
    }
}
