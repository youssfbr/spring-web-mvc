package br.com.alissondev.springwebmvc.rest;

import br.com.alissondev.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;
}
