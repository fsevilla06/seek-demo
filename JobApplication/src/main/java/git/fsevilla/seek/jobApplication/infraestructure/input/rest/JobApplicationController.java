package git.fsevilla.seek.jobApplication.infraestructure.input.rest;

import git.fsevilla.seek.jobApplication.application.JobApplicationService;
import git.fsevilla.seek.jobApplication.domain.exception.InvalidDataException;
import git.fsevilla.seek.jobApplication.domain.exception.JobApplicationNotFoundException;
import git.fsevilla.seek.jobApplication.domain.model.ApplicationStatus;
import git.fsevilla.seek.jobApplication.domain.model.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(jobApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id) throws JobApplicationNotFoundException {
        return ResponseEntity.ok(jobApplicationService.findById(id));
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity findByVacancyId(@PathVariable Long vacancyId) {
        return ResponseEntity.ok(jobApplicationService.findByVacancyId(vacancyId));
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity findByCandidateId(@PathVariable Long candidateId) {
        return ResponseEntity.ok(jobApplicationService.findByCandidateId(candidateId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity findByStatus(@PathVariable ApplicationStatus status) {
        return ResponseEntity.ok(jobApplicationService.findByStatus(status));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody JobApplication jobApplication) throws InvalidDataException {
        return ResponseEntity.ok(jobApplicationService.save(jobApplication));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody JobApplication jobApplication) throws JobApplicationNotFoundException, InvalidDataException {
        return ResponseEntity.ok(jobApplicationService.update(jobApplication));
    }
}
