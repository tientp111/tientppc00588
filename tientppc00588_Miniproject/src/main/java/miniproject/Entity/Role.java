package miniproject.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "roles")
@ApiModel(value = "Roles model")
public class Role  implements Serializable{
	
	@Id
	@ApiModelProperty(notes = "The database generated Roles ID")
	private String id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
}