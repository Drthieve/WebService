package gov.iti.jets.soap.services.dtos;

import gov.iti.jets.domain.models.CartLineItem;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

@XmlRootElement(name = "cartLineItem")
@XmlType(propOrder = {"productIdentifier", "amount"})
public class CartLineItemRequestDto implements Serializable {

    private int productIdentifier; // Identifier of the product
    private int amount; // Amount of the product

    // Default constructor
    public CartLineItemRequestDto() {
    }

    // Getter for productIdentifier
    public int getProductIdentifier() {
        return productIdentifier;
    }

    // Setter for productIdentifier
    public void setProductIdentifier(int productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    // Getter for amount
    public int getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(int amount) {
        this.amount = amount;
    }

    // String representation of the object
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "productIdentifier = " + productIdentifier + ", " +
                "amount = " + amount + ")";
    }
}
