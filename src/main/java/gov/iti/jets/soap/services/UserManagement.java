package gov.iti.jets.soap.services;

import gov.iti.jets.domain.enums.OrderStatus;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.OrderService;
import gov.iti.jets.domain.services.UserService;
import gov.iti.jets.rest.exceptions.ApiException;
import gov.iti.jets.rest.resources.cart.CartResponse;
import gov.iti.jets.soap.exceptions.SOAPApiException;
import gov.iti.jets.soap.services.dtos.*;
import jakarta.jws.*;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@SuppressWarnings("NonJaxWsWebServices")
@WebService(targetNamespace = "http://www.jets.gov.iti.eg/ecommerce",
        name = "UserManagement",
        portName = "UserManagementPort",
        serviceName = "UserManagementService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class UserManagement {

    // Method to echo a string
    @WebMethod
    @WebResult(name = "echoedString", partName = "echoedStringPartName")
    public String echo(@WebParam(name = "stringToEcho", partName = "stringToEchoPartName") String s) {
        return s;
    }

    // Method to get all users
    @WebMethod
    @WebResult(name = "users")
    public List<UserDto> getAllUsers() {
        return UserService.getAllUsers()
                .stream()
                .map(UserDto::new)
                .collect(toList());
    }

    // Method to create or update a user
    @WebMethod
    @WebResult(name = "user")
    public UserDto createOrUpdateUser(@WebParam(name = "user") UserRequestDto userRequestDto) {
        System.out.println(userRequestDto);
        User user = new User(userRequestDto.getFirstName(),
                userRequestDto.getLastName(),
                userRequestDto.getEmail(),
                userRequestDto.getRole());
        if (userRequestDto.getId() != null) {
            user.setId(userRequestDto.getId());
        }
        UserService.updateUser(user);
        return new UserDto(user);
    }

    // Method to find a user by ID
    @WebMethod
    @WebResult(name = "user")
    public UserDto findUserById(@WebParam(name = "userId") int userId) {
        return UserService.findUserById(userId).map(UserDto::new).orElseThrow(() -> new SOAPApiException("No user exists with the id " + userId));
    }

    // Method to delete a user
    @WebMethod
    @Oneway
    public void deleteUser(@WebParam(name = "userId") int userId) {
        UserService.deleteUser(userId);
    }

    // Method to get a cart by user ID
    @WebMethod
    @WebResult(name = "cart")
    public CartDto getCartByUserId(@WebParam(name = "userId") int userId) {
        return UserService.findCartByUserId(userId).map(CartDto::new).orElseThrow(() ->
                new SOAPApiException(String.format("No user exists with the id (%s)", userId)));
    }

    // Method to add an item to a user's cart
    @WebMethod
    @WebResult(name = "cart")
    public CartDto addItemToUserCart(@WebParam(name = "userId") int userId, @WebParam(name = "cartLineItem") CartLineItemRequestDto dto) {
        var cart = UserService.addItemToUserCart(userId, dto.getProductId(), dto.getQuantity());
        return new CartDto(cart);
    }

    // Method to clear a user's cart
    @WebMethod
    @Oneway
    public void clearUserCart(@WebParam(name = "userId") int userId) {
        UserService.clearUserCart(userId);
    }

    // Method to get orders by user ID
    @WebMethod
    @WebResult(name = "order")
    public List<OrderDto> getOrdersByUserId(@WebParam(name = "userId") int userId) {
        return UserService.getOrdersByUserId(userId).stream()
                .map(OrderDto::new)
                .collect(toList());
    }

    // Method to create an order from a user's cart
    @WebMethod
    @WebResult(name = "order")
    public OrderDto createOrderFromUserCart(@WebParam(name = "userId") int userId) {
        Order order = UserService.createOrderFromUserCart(userId);
        return new OrderDto(order);
    }

    // Method to update an order status
    @WebMethod
    @WebResult(name = "order")
    public OrderDto updateOrderStatus(@WebParam(name = "orderId") int orderId,
                                      @WebParam(name = "newStatus") OrderStatus newStatus) {
        var order = OrderService.updateOrderStatus(orderId, newStatus);
        return new OrderDto(order);
    }
}
