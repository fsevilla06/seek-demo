package git.fsevilla.seek.Candidate.application;

import git.fsevilla.seek.Candidate.CandidateApplication;
import git.fsevilla.seek.Candidate.domain.exception.CandidateNotFoundException;
import git.fsevilla.seek.Candidate.domain.model.Candidate;
import git.fsevilla.seek.Candidate.domain.repository.CandidateRepository;
import git.fsevilla.seek.Candidate.domain.service.CreateCandidateUseCase;
import git.fsevilla.seek.Candidate.domain.service.FindCandidateUseCase;
import git.fsevilla.seek.Candidate.domain.service.UpdateCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CandidateService implements FindCandidateUseCase, CreateCandidateUseCase, UpdateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate findById(Long id) throws CandidateNotFoundException {
        return candidateRepository.findById(id).orElseThrow(() -> new CandidateNotFoundException("No candidate with id " + id + "found "));
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate update(Candidate candidate) throws CandidateNotFoundException {
        Candidate oldCandidate = findById(candidate.getId());
        if (StringUtils.hasText(candidate.getName())) {
            oldCandidate.setName(candidate.getName());
        }
        if (StringUtils.hasText(candidate.getEmail())){
            oldCandidate.setEmail(candidate.getEmail());
        }

        return candidateRepository.save(oldCandidate);
    }
}
