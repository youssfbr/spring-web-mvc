package br.com.alissondev.springwebmvc.service;
import br.com.alissondev.springwebmvc.exception.JediNotFoundException;
import br.com.alissondev.springwebmvc.model.Jedi;
import br.com.alissondev.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(final Long id) {
        Optional<Jedi> jedi = repository.findById(id);

        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(final Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(final Long id, final Jedi jedi) {

        findById(id);

        jedi.setId(id);

        return repository.save(jedi);
    }

    public void delete(Long id) {
        final Jedi jedi = findById(id);

        repository.delete(jedi);
    }
}
