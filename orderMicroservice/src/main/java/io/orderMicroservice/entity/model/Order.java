package io.orderMicroservice.entity.model;

import io.orderMicroservice.entity.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    private String customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_pedido",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products;

    private String payment_method;
    private String card_number;
    private String expiration_date;
    private String cvv;
    private String status;


    public Order(OrderDTO dto) {
        this.customer_id = dto.customer().getCustomer_id();
        this.first_name = dto.customer().getFirst_name();
        this.last_name = dto.customer().getLast_name();
        this.email = dto.customer().getEmail();
        this.address = dto.customer().getAddress();

        List<Products> productList = new ArrayList<>();
        List<Products> productsDto = dto.products();
        for (Products productDto : productsDto) {
            Products product = new Products();
            product.setProduct_id(productDto.getProduct_id());
            product.setQuantity(productDto.getQuantity());
            productList.add(product);
        }
        this.products = productList;

        this.payment_method = dto.payment().getPayment_method();
        this.card_number = dto.payment().getCard_number();
        this.expiration_date = dto.payment().getExpiration_date();
        this.cvv = dto.payment().getCvv();
    }


}
