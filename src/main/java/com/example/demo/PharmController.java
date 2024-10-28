package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PharmController {

	@Autowired
	PharmRepo pharmrepo;
	
	@Autowired
	StoreRepo storerepo;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("pharmEntity", new PharmEntity());
		return "home";
	}
	
	//@RequestMapping(value="/signup", method=RequestMethod.POST)    
	//public ModelAndView save(@ModelAttribute PharmEntity pharmEntity)  
	//{  
	//	pharmrepo.save(pharmEntity);
	//ModelAndView modelAndView = new ModelAndView();    
	//modelAndView.setViewName("pharm-data");        
	//modelAndView.addObject("pharmEntity", pharmEntity); 
	//return modelAndView ;
	//}
	
	 // Display signup page
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("pharmEntity", new PharmEntity());
        return "signup";
    }

    // Handle signup form submission
    @PostMapping("/signup")
    public ModelAndView save(@ModelAttribute PharmEntity pharmEntity) {
        pharmrepo.save(pharmEntity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pharm-data");
        modelAndView.addObject("pharmEntity", pharmEntity);
        return modelAndView;
    }
	
 // Display login page
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("pharmEntity", new PharmEntity());
        return "login";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam(value = "storeName", required = false) String storeName,
    					@RequestParam(value = "address", required = false) String address,
    					@RequestParam(value = "city", required = false) String storeCity,
                         @RequestParam(value = "medicine", required = false) String medicineName,
                         Model model) {
        List<StoreEntity> pharmacies;

        pharmacies = storerepo.findByCriteria(
                StringUtils.hasText(storeCity) ? storeCity : null,
                StringUtils.hasText(storeName) ? storeName : null,
                StringUtils.hasText(address) ? address : null,
                StringUtils.hasText(medicineName) ? medicineName : null
            );

        model.addAttribute("pharmacies", pharmacies);
        return "search";
    }


	
	
}
