package miniproject.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import miniproject.Dao.OrderDAO;
import miniproject.Dao.OrderDetailDAO;
import miniproject.Entity.Order;
import miniproject.Entity.OrderDetail;
import miniproject.Services.OrderService;

import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO dao;

	@Autowired
	OrderDetailDAO odao;
	
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).stream()
				.peek(d -> d.setOrder(order)).collect(Collectors.toList());
		details.forEach(n -> System.out.println(n.getId() +"---" + n.getProduct().getName()));
		odao.saveAll(details);

		return order;
	}
	
	@Override
	public Order findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {		
		return dao.findByUsername(username);
	}

}
