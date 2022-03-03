package registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import registration.entities.hosp_regis;

@Controller
public class registcont {
	@Autowired
	private JdbcTemplate jdt;
	public JdbcTemplate getJdt() {
		return jdt;
	}
	public void setJdt(JdbcTemplate jdt) {
		this.jdt = jdt;
	}
	
	@RequestMapping("/regist")
	public String regist_view(Model model)
	{
		model.addAttribute("msg"," ");
			return "hosp_regis";
	}
	@RequestMapping("/ind")
	public String ind(Model model)
	{
		model.addAttribute("msg","Wrong Credentials ");
			return "index";
	}

	@RequestMapping(path = "/register" , method = RequestMethod.POST) 
	public String contactsub(@RequestParam("email") String email , @RequestParam("name") String name , @RequestParam("age") String age ,@RequestParam("dod") String dod , Model model) {
		hosp_regis hp=new hosp_regis();
		
		hp.setEmail(email);
		hp.setName(name);
		hp.setAge(age);
		hp.setDistyp(dod);
		
		 String query="insert into hos_regis(email,name,age,distyp) values(?,?,?,?)";
		int result= jdt.update(query, hp.getEmail(),hp.getName(),hp.getAge(),hp.getDistyp());
		
		/*
		 * model.addAttribute("name",name); model.addAttribute("email",email);
		 * model.addAttribute("pass",pass);
		 */
		model.addAttribute("msg","Registered Succesfully");
	  
	  return "hosp_regis"; 
	  
	  }
	
	@RequestMapping(path = "/vdata" , method = RequestMethod.GET) 
	public String vdata(Model model) {
		String qu="select * from hos_regis";
		List<hosp_regis> ll=jdt.query(qu, new Rowmapper());
		model.addAttribute("ldata",ll);
		model.addAttribute("msg"," ");
		return("vdata_view");
	}
	
	@RequestMapping(path = "/edit" , method = RequestMethod.POST) 
	public String edit(@RequestParam("edem") String email  ,Model model) {
		String qu="select * from hos_regis where email=?";
		hosp_regis hsp=jdt.queryForObject(qu,new Rowmapper(),email);
		

		model.addAttribute("email",hsp.getEmail());
		model.addAttribute("name",hsp.getName());
		model.addAttribute("age",hsp.getAge());
		model.addAttribute("distyp",hsp.getDistyp());
		
		return("edit_form");
	}
	
	@RequestMapping(path = "/edit_sub" , method = RequestMethod.POST) 
	public String edsub(@RequestParam("hid_email") String hid_email,@RequestParam("email") String email , @RequestParam("name") String name , @RequestParam("age") String age ,@RequestParam("dod") String dod , Model model) {
		hosp_regis hp=new hosp_regis();
		
		hp.setEmail(email);
		hp.setName(name);
		hp.setAge(age);
		hp.setDistyp(dod);
		
		 String query="update hos_regis set email=?,name=?, age=?,distyp=? where email=? ";
		int result= jdt.update(query, hp.getEmail(),hp.getName(),hp.getAge(),hp.getDistyp(),hid_email);
		
		model.addAttribute("msg","Updated Succesfully");
	  
		String qu="select * from hos_regis";
		List<hosp_regis> ll=jdt.query(qu, new Rowmapper());
		model.addAttribute("ldata",ll);
		
		return("vdata_view");
	  
	  }
	
	@RequestMapping(path = "/delete" , method = RequestMethod.POST) 
	public String delete(@RequestParam("delem") String del_email  ,Model model) {
		String query="delete from hos_regis where email=?";
	jdt.update(query, del_email);
		
		model.addAttribute("msg","Deleted Succesfully");
		  
		String qu="select * from hos_regis";
		List<hosp_regis> ll=jdt.query(qu, new Rowmapper());
		model.addAttribute("ldata",ll);
		
		return("vdata_view");
	  
	}
	@RequestMapping(path = "/login" , method = RequestMethod.POST) 
	public String log(@RequestParam("uid") int uid,@RequestParam("pass") int pass  ,Model model) {
	
			if(uid==123 && pass==123) {
				
				return "redirect:/regist";
			}
			else 
			{
				return "redirect:/ind";
			}
			
		
	  
	}
	
}
