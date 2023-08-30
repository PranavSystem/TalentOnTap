package com.ycp.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycp.Classes.Qualifications;
import com.ycp.Repository.QualiRepository;

@Service
@Transactional
public class QualificationService {

	@Autowired
	private QualiRepository repo;

	public Qualifications getqualiId(int id) {
		return repo.getById(id);
	}

}
