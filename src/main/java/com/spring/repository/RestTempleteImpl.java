package com.spring.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.dto.Employee;
import com.spring.dto.Project;
import com.spring.dto.ProjectEmployee;
import com.spring.dto.SkillsEmployee;

@Configuration
public class RestTempleteImpl {

	@Autowired
	RestTemplate rest;

	HttpHeaders header = new HttpHeaders();
	ObjectMapper mapper = new ObjectMapper();

	public Project assignproject(Project project) {
		String jsonRequest = null;
		header.setContentType(MediaType.APPLICATION_JSON);

		try {
			jsonRequest = mapper.writeValueAsString(project);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, header);
		return rest.postForObject("http://localhost:8109/project/addProject", entity, Project.class);

	}

	public Project getProjectbyId(int pId) {
		Project result = null;
		result = rest.getForObject("http://localhost:8109/project/getProject/" + pId, Project.class);
		return result;
	}

	public ProjectEmployee assignprojectEmployee(ProjectEmployee project) {
		String jsonRequest = null;
		header.setContentType(MediaType.APPLICATION_JSON);

		try {
			jsonRequest = mapper.writeValueAsString(project);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, header);
		return rest.postForObject("http://localhost:8109/project/addProjectEmp", entity, ProjectEmployee.class);
	}

	public ProjectEmployee getProjectEmployeebyId(int eId) {
		ProjectEmployee result = null;
		result = rest.getForObject("http://localhost:8109/project/getProjectEmp/" + eId, ProjectEmployee.class);
		return result;
	}

	public SkillsEmployee getSkillsEmployeebyId(Employee emp) {
		SkillsEmployee result = null;

		result = rest.getForObject("http://localhost:8099/skill/getSkillEmployee/", SkillsEmployee.class);
		return result;
	}

	public List<SkillsEmployee> getAllSkill() throws JsonMappingException, JsonProcessingException {

		SkillsEmployee[] result = rest.getForObject("http://localhost:8099/skill/getAllSkills", SkillsEmployee[].class);

		List<SkillsEmployee> emp = Arrays.asList(result);

		return emp;
	}

}
