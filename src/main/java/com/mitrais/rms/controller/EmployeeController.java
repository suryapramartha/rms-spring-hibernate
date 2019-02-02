package com.mitrais.rms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitrais.rms.model.Employee;
import com.mitrais.rms.model.EmployeeCompetency;
import com.mitrais.rms.model.Skill;
import com.mitrais.rms.service.EmployeeService;
import com.mitrais.rms.service.SkillService;

@Controller
@RequestMapping("/employee")
public class EmployeeController 
{	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/list")
	public String getListAllEmployee(Model model)
	{
		List<Employee> emplList = employeeService.getAllEmployee();
		model.addAttribute("employeeAttribute",emplList);
		return "employee/list";	
	}
	
	@PostMapping("/save")
	public String saveAndGetAllEmployee(@ModelAttribute("employeeAttribute") Employee employee,Model model)
	{
		boolean isSaved = employeeService.createEmployee(employee);
		if(isSaved) {
			return "redirect:list";	
		}else {
			return null;	
		}
	}
	
	@RequestMapping("/new")
	public String newEmployee(Model model)
	{
		Employee empl = new Employee();
		model.addAttribute("employeeAttribute", empl);
		return "employee/new";	
	}
	
	@GetMapping("/edit")
	public String updateEmployee(@RequestParam("employeeId") String id,Model model) 
	{
		List<Employee> emplList = employeeService.getSelectedEmployeeById(id);
		model.addAttribute("employeeSelectedAttribute", emplList);
		return "employee/update";
	}
	
	@GetMapping("/new-competency")
	public String newCompetency(@RequestParam("employeeId") String id, Model model) 
	{
		List<Employee> emplList = employeeService.getSelectedEmployeeById(id);
		model.addAttribute("employeeSelectedAttribute", emplList);
		List<Skill> skillList = skillService.getNotAssignedSkill(id);
		model.addAttribute("listSkillAttribute", skillList);
		return "employee/newCompetency";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployeeById(@RequestParam("employeeId") String id) 
	{
		boolean isDeleted = employeeService.deleteById(id);
		if(isDeleted) 
		{
			return "redirect:list";	
		}else
		{
			return null;
		}
		
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("employeeSelectedAttribute") Employee employee,Model model)
	{
		boolean isSaved = employeeService.updateEmployee(employee);
		if(isSaved) {
			return "redirect:list";	
		}else {
			return null;	
		}
	}
	
	@GetMapping("/view-competency")
	public String viewCompetencyEmployee(@RequestParam("employeeId") String id,Model model)
	{
		List<Employee> emplList = employeeService.getSelectedEmployeeById(id);
		model.addAttribute("employeeSelectedAttribute", emplList);
		
		List<Skill> skillList = skillService.getAssignedSkill(id);
		model.addAttribute("assignedSkillAttribute",skillList);
		return "employee/viewCompetency";	
	}
	
	@PostMapping("/save-competency")
	public String saveCompetencyEmployee(@RequestParam("emplId") int emplId,@RequestParam("ListSkill") int skillId,Model model,RedirectAttributes rd)
	{
		EmployeeCompetency cp = new EmployeeCompetency(emplId, skillId);
		boolean isSaved = employeeService.insertNewCompetency(cp);
		if(isSaved) {
			rd.addAttribute("employeeId",emplId);
			return "redirect:view-competency";	
		}else {
			return null;	
		}
	}
	
	@GetMapping("/delete-competency")
	public String deleteEmployeeCompetencyById(@RequestParam("skillId") String skillId, @RequestParam("employeeId") String emplId,RedirectAttributes rd) 
	{
		boolean isDeleted = employeeService.deleteEmployeeCompetency(skillId, emplId);
		if(isDeleted) 
		{
			rd.addAttribute("employeeId",emplId);
			return "redirect:view-competency";	
		}else
		{
			return null;
		}
		
	}
}
