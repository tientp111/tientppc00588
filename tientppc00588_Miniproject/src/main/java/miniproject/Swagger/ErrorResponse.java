package miniproject.Swagger;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Error Model")
public class ErrorResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Error code", name ="code", value = "200")
	private int code;
	
	@ApiModelProperty(notes = "Status", name ="message", value = "SUCCESS")
	private String status;
	
	@ApiModelProperty(notes = "Message", name ="message", value = "Invalid field")
	private String message;
	
	
}
