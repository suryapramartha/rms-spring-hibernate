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
import com.mitrais.rms.model.Skill;
import com.mitrais.rms.service.SkillService;

@Controller
@RequestMapping("/skill")
public class SkillController 
{
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/list")
	public String getListAllSkill(Model model)
	{
		List<Skill> skillList = skillService.getAllSkill();
		model.addAttribute("skillAttribute", skillList);
		return "skill/list";	
	}
	
	@PostMapping("/save")
	public String saveAndGetAllSkill(@ModelAttribute("skillAttribute") Skill skill,Model model)
	{
		boolean isSaved = skillService.createSkill(skill);
		if(isSaved) {
			return "redirect:list";	
		}else {
			return null;	
		}
	}
	
	@RequestMapping("/new")
	public String newSkill(Model model)
	{
		Skill skill = new Skill();
		model.addAttribute("skillAttribute", skill);
		return "skill/new";	
	}
	
	@GetMapping("/edit")
	public String updateSkill(@RequestParam("skillId") String id,Model model) 
	{
		List<Skill> skillList = skillService.getSelectedSkillById(id);
		model.addAttribute("skillSelectedAttribute", skillList);
		return "skill/update";
	}
	
	@GetMapping("/delete")
	public String deleteSkillById(@RequestParam("skillId") String id) 
	{
		boolean isDeleted = skillService.deleteById(id);
		if(isDeleted) 
		{
			return "redirect:list";	
		}else
		{
			return null;
		}
		
	}
	
	@PostMapping("/update")
	public String updateSkill(@ModelAttribute("skillSelectedAttribute") Skill skill,Model model)
	{
		boolean isSaved = skillService.updateSkill(skill);
		if(isSaved) {
			return "redirect:list";	
		}else {
			return null;	
		}
	}
}
