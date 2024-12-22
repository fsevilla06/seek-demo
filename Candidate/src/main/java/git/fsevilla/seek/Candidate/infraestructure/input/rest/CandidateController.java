package git.fsevilla.seek.Candidate.infraestructure.input.rest;

import git.fsevilla.seek.Candidate.application.CandidateService;
import git.fsevilla.seek.Candidate.domain.exception.CandidateNotFoundException;
import git.fsevilla.seek.Candidate.domain.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id) throws CandidateNotFoundException {
        return ResponseEntity.ok(candidateService.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Candidate candidate) {
        return ResponseEntity.ok(candidateService.save(candidate));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Candidate candidate) throws CandidateNotFoundException {
        return ResponseEntity.ok(candidateService.update(candidate));
    }
}
