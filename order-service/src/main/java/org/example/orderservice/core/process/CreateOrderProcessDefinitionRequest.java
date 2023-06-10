package org.example.orderservice.core.process;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderProcessDefinitionRequest {
    private String name;
    private List<String> validationDefinitions;
    private String shippingPreparationDefinition;
}
