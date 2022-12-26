package ru.sbt.store.core.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parameters", schema = "online_store")
@Getter
@Setter
public class Parameter extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "parameters_id_seq")
    private Long id;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parameter_type_id")
    private ParameterType parameterType;

    public Long getProductId() {
        return product == null ? null : product.getId();
    }

    public Long getParameterTypeId() {
        return parameterType == null ? null : parameterType.getId();
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", productId=" + getProductId()+
                ", parameterTypeId=" + getParameterTypeId() +
                ", value='" + value + '\'' +
                '}';
    }

}
