package miniproject.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Username", "Roleid"})
})
@ApiModel(value = "Authority model")
public class Authority  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@ApiModelProperty(notes = "The database generated Authority ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne @JoinColumn(name = "Username")
	private Account account;
	
	@ManyToOne  @JoinColumn(name = "Roleid")
	private Role role;
}