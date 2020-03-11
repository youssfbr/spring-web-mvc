package br.com.alissondev.springwebmvc.rest;
import br.com.alissondev.springwebmvc.model.Jedi;
import br.com.alissondev.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jedi")
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping
    public List<Jedi> getAllJedi() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Jedi jedi = service.findById(id);

        return ResponseEntity.ok(jedi);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {

        return service.save(jedi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi jedi) {

        return ResponseEntity.ok(service.update(id, jedi));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id) {

        service.delete(id);
    }

}
