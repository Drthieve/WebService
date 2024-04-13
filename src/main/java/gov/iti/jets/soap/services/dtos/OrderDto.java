package gov.iti.jets.soap.services.dtos;

import gov.iti.jets.domain.enums.OrderStatus;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.rest.utils.LinkJsonbAdapter;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@XmlRootElement(name = "order")
@XmlType(propOrder = {"identifier", "orderItems", "status", "total"})
public class OrderDto implements Serializable {
    private int identifier;
    private Set<OrderLineItemDto> orderItems;
    private OrderStatus status;
    private BigDecimal total;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.identifier = order.getId();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.orderItems = order.getOrderLineItems()
                .stream()
                .map(OrderLineItemDto::new)
                .collect(toSet());
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public Set<OrderLineItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderLineItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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
                "orderLineItems = " + orderItems + ", " +
                "status = " + status + ", " +
                "total = " + total + ")";
    }
}
