package com.spring.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.dto.ProjectEmployee;
import com.spring.dto.SkillsEmployee;

@Configuration
public class RestTempleteImpl {

	@Autowired
	RestTemplate rest;

	public List<SkillsEmployee> getAllSkill() throws JsonMappingException, JsonProcessingException {

		SkillsEmployee[] result = rest.getForObject("http://localhost:8099/skill/getAllSkills", SkillsEmployee[].class);

		List<SkillsEmployee> emp = Arrays.asList(result);

		return emp;
	}

	public List<SkillsEmployee> getSkillByName(String sName) throws JsonMappingException, JsonProcessingException {

		SkillsEmployee result = rest.getForObject("http://localhost:8099/skill/getSkillbyName/" + sName,
				SkillsEmployee.class);
		List<SkillsEmployee> emp = Arrays.asList(result);
		return emp;
	}
	
	
	public ProjectEmployee getProjectByName(String pName)
	{
		ProjectEmployee project=rest.getForObject("http://localhost:8109/project/getProjectbyName/" +pName, ProjectEmployee.class);
		return project;
		
	}

}
