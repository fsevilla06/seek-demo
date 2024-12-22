package git.fsevilla.seek.jobApplication.domain.repository;


import git.fsevilla.seek.jobApplication.domain.model.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "candidate")
public interface CandidateRepository {
    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable("id") Long id) throws Exception;
}
