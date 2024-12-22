package git.fsevilla.seek.jobApplication.domain.service;

import git.fsevilla.seek.jobApplication.domain.exception.InvalidDataException;
import git.fsevilla.seek.jobApplication.domain.model.JobApplication;

public interface CreateJobApplicationUseCase {
    public JobApplication save(JobApplication jobApplication) throws InvalidDataException;
}
