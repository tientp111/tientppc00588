package miniproject.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.Entity.Product;
import miniproject.Services.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService proService;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid,
			@RequestParam("page") Optional<Integer> page) {
		int paging = page.orElse(0);
		if (paging < 0) {
			paging = 0;
		}
		Pageable pageable = PageRequest.of(paging, 6);
		
		if (cid.isPresent()) {
			Page<Product> list = proService.findByCategoryId(cid.get(), pageable);
			model.addAttribute("list", list);
		} else {
			Page<Product> list = proService.findAll(pageable);
			model.addAttribute("list", list);
		}
		return "product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = proService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}

}
