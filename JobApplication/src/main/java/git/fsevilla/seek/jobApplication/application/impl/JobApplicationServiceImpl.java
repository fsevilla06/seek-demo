package git.fsevilla.seek.jobApplication.application.impl;

import git.fsevilla.seek.jobApplication.application.CandidateService;
import git.fsevilla.seek.jobApplication.application.JobApplicationService;
import git.fsevilla.seek.jobApplication.application.VacancyService;
import git.fsevilla.seek.jobApplication.domain.exception.InvalidDataException;
import git.fsevilla.seek.jobApplication.domain.exception.JobApplicationNotFoundException;
import git.fsevilla.seek.jobApplication.domain.model.ApplicationStatus;
import git.fsevilla.seek.jobApplication.domain.model.JobApplication;
import git.fsevilla.seek.jobApplication.domain.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private CandidateService candidateService;


    @Override
    public JobApplication save(JobApplication jobApplication) throws InvalidDataException {
        if (jobApplication.getVacancyId() == null || !vacancyService.existsVacancy(jobApplication.getVacancyId())) {
            throw new InvalidDataException("Invalid vacancy id");
        }
        if (jobApplication.getCandidateId() == null || !candidateService.exists(jobApplication.getCandidateId())) {
            throw new InvalidDataException("Invalid candidate id");
        }
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public JobApplication findById(Long id) throws JobApplicationNotFoundException {
        return jobApplicationRepository.findById(id).orElseThrow(() -> new JobApplicationNotFoundException("No job application found with id " + id));
    }

    @Override
    public List<JobApplication> findAll() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public List<JobApplication> findByVacancyId(Long vacancyId) {
        return jobApplicationRepository.findAllByVacancyId(vacancyId);
    }

    @Override
    public List<JobApplication> findByCandidateId(Long candidateId) {
        return jobApplicationRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public List<JobApplication> findByStatus(ApplicationStatus status) {
        return jobApplicationRepository.findAllByStatus(status);
    }

    @Override
    public JobApplication update(JobApplication jobApplication) throws JobApplicationNotFoundException, InvalidDataException {
        JobApplication oldJobApplication = findById(jobApplication.getId());
        if (jobApplication.getVacancyId() != null) {
            if (!vacancyService.existsVacancy(jobApplication.getVacancyId())) {
                throw new InvalidDataException("Invalid vacancy id");
            }
            oldJobApplication.setVacancyId(jobApplication.getVacancyId());
        }
        if (jobApplication.getCandidateId() != null) {
            if (!candidateService.exists(jobApplication.getCandidateId())) {
                throw new InvalidDataException("Invalid candidate id");
            }
            oldJobApplication.setCandidateId(jobApplication.getCandidateId());
        }
        if (jobApplication.getApplicationDate() != null) {
            oldJobApplication.setApplicationDate(jobApplication.getApplicationDate());
        }
        if (jobApplication.getStatus() != null) {
            oldJobApplication.setStatus(jobApplication.getStatus());
        }
        return jobApplicationRepository.save(oldJobApplication);
    }
}
