package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import models.User;

@Controller
public class ExchangesController {

    @GetMapping("/exchanges")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
//        User user = new User();
//        user.setName("billgates");
//        
//        System.out.println(user.data());
        
        try {         
	    	Class.forName("com.mysql.jdbc.Driver");  
	    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/viewfinquanttrading?useSSL=false","root","1");  
	
	    	Statement stmt=conn.createStatement();  
	    	ResultSet rs=stmt.executeQuery("show tables");
	    	String link = "";
	    	
	    	while(rs.next()) {		
	    		link = "<a href='index.jsp?table="+rs.getString(1)+"'>"+rs.getString(1)+"</a><br> ";
	    		System.out.println(link); 
	    	}	       
	        
	        System.out.println("test");
        } catch(Exception e) { 
        	System.out.println(e);
        }        
        return "greeting";
    }

    
    @GetMapping("/exchanges/one")
    public String greetingOne(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
