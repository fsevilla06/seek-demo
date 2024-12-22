package git.fsevilla.seek.jobApplication.application.impl;

import git.fsevilla.seek.jobApplication.application.CandidateService;
import git.fsevilla.seek.jobApplication.domain.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public boolean exists(Long candidateId) {
        try {
            candidateRepository.getCandidate(candidateId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
