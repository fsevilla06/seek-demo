package git.fsevilla.seek.jobApplication.domain.service;

import git.fsevilla.seek.jobApplication.domain.exception.InvalidDataException;
import git.fsevilla.seek.jobApplication.domain.exception.JobApplicationNotFoundException;
import git.fsevilla.seek.jobApplication.domain.model.JobApplication;

public interface UpdateJobApplicationUseCase {
    public JobApplication update(JobApplication jobApplication) throws JobApplicationNotFoundException, InvalidDataException;
}
