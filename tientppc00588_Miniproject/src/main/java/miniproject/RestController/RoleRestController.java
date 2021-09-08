package miniproject.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import miniproject.Entity.Role;
import miniproject.Services.RoleService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
@RequiredArgsConstructor
@Api(value = "Roles APIs")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;
	
	@ApiOperation(value = "Find All Roles", response = Role.class)
	@ApiResponses (value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorizes"),
			@ApiResponse(code = 403, message = "Forbident"),
			@ApiResponse(code = 404, message = "Not Fount")
	})
	@GetMapping
	public List<Role> findAll(){
		return roleService.findAll();
	}
}
