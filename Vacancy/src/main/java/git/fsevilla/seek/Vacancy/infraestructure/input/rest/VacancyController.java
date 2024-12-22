package git.fsevilla.seek.Vacancy.infraestructure.input.rest;

import git.fsevilla.seek.Vacancy.application.VacancyService;
import git.fsevilla.seek.Vacancy.domain.exception.InvalidDataException;
import git.fsevilla.seek.Vacancy.domain.exception.VacancyNotFoundException;
import git.fsevilla.seek.Vacancy.domain.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(vacancyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id) throws VacancyNotFoundException {
        return ResponseEntity.ok(vacancyService.find(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Vacancy vacancy) throws InvalidDataException {
        return ResponseEntity.ok(vacancyService.save(vacancy));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Vacancy vacancy) throws InvalidDataException, VacancyNotFoundException {
        return ResponseEntity.ok(vacancyService.update(vacancy));
    }
}
