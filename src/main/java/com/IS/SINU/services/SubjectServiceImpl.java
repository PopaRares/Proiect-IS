package com.IS.SINU.services;

import com.IS.SINU.entities.dao.Subject;
import com.IS.SINU.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository repository;

    @Override
    public List<Subject> listAll() {
        return repository.findAll();
    }
}
