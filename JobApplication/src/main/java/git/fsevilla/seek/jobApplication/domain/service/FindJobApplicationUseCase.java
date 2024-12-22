package git.fsevilla.seek.jobApplication.domain.service;

import git.fsevilla.seek.jobApplication.domain.exception.JobApplicationNotFoundException;
import git.fsevilla.seek.jobApplication.domain.model.ApplicationStatus;
import git.fsevilla.seek.jobApplication.domain.model.JobApplication;

import java.util.List;

public interface FindJobApplicationUseCase {
    public JobApplication findById(Long id) throws JobApplicationNotFoundException;

    public List<JobApplication> findAll();

    public List<JobApplication> findByVacancyId(Long vacancyId);

    public List<JobApplication> findByCandidateId(Long candidateId);

    public List<JobApplication> findByStatus(ApplicationStatus status);
}
