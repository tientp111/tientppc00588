package miniproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import miniproject.Entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}
