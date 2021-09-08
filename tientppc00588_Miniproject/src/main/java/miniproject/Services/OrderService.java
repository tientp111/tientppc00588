package miniproject.Services;

import com.fasterxml.jackson.databind.JsonNode;

import miniproject.Entity.Order;

public interface OrderService {

	Order create(JsonNode order);

	Object findByUsername(String username);

	Object findById(Long id);
}
