package git.fsevilla.seek.Candidate.domain.service;

import git.fsevilla.seek.Candidate.domain.exception.CandidateNotFoundException;
import git.fsevilla.seek.Candidate.domain.model.Candidate;

import java.util.List;

public interface FindCandidateUseCase {

    public Candidate findById(Long id) throws CandidateNotFoundException;
    public List<Candidate> findAll();

}
