package org.example.orderservice.persistence.process;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name = "order_process_definition")
public class OrderProcessDefinitionEntity implements Serializable {
    @Id
    private String id;
    @Column(unique = true)
    private String name;
    private List<String> validationDefinitions;
    private String shippingPreparationDefinition;
}
