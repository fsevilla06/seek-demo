package git.fsevilla.seek.Candidate.domain.service;

import git.fsevilla.seek.Candidate.domain.exception.CandidateNotFoundException;
import git.fsevilla.seek.Candidate.domain.model.Candidate;

public interface UpdateCandidateUseCase {
    public Candidate update(Candidate candidate) throws CandidateNotFoundException;
}
