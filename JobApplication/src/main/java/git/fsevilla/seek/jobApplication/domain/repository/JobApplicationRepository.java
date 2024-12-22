package git.fsevilla.seek.jobApplication.domain.repository;

import git.fsevilla.seek.jobApplication.domain.model.ApplicationStatus;
import git.fsevilla.seek.jobApplication.domain.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    public List<JobApplication> findAllByVacancyId(Long vacancyId);

    public List<JobApplication> findAllByCandidateId(Long candidateId);

    public List<JobApplication> findAllByStatus(ApplicationStatus status);
}
