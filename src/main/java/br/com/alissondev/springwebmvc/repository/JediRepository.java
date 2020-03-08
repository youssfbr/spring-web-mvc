package br.com.alissondev.springwebmvc.repository;

import br.com.alissondev.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    public List<Jedi> getAllJedi() {

        List<Jedi> jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
        return jedi;
    }
}
