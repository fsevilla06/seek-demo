package git.fsevilla.seek.Candidate.domain.service;

import git.fsevilla.seek.Candidate.domain.model.Candidate;

public interface CreateCandidateUseCase {
    public Candidate save(Candidate candidate);
}
