package com.spring.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.spring.dto.ProjectEmployee;
import com.spring.dto.SkillsEmployee;

@Configuration
public class RestTempleteImpl {

	@Autowired
	RestTemplate rest;

	public List<SkillsEmployee> getAllSkill() {

		SkillsEmployee[] result = rest.getForObject("http://localhost:8099/skill/getAllSkills", SkillsEmployee[].class);

		List<SkillsEmployee> emp = Arrays.asList(result);

		return emp;
	}

	public List<SkillsEmployee> getSkillByName(String sName) {

		SkillsEmployee result = rest.getForObject("http://localhost:8099/skill/getSkillbyName/" + sName,
				SkillsEmployee.class);
		List<SkillsEmployee> emp = Arrays.asList(result);
		return emp;
	}
	
	
	public ProjectEmployee getProjectByName(String pName)
	{
		return rest.getForObject("http://localhost:8109/project/getProjectbyName/" +pName, ProjectEmployee.class);
	}

}
