package ru.sbt.store.core.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_items", schema = "online_store")
@Getter
@Setter
public class OrderItem extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_items_id_seq")
    private Long id;

    private Integer quantity = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getOrderId() {
        return order == null ? null : order.getId();
    }

    public Long getProductId() {
        return product == null ? null: product.getId();
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + getOrderId() +
                ", productId=" + getProductId() +
                ", quantity=" + quantity +
                '}';
    }
}
