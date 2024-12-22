package git.fsevilla.seek.jobApplication.application;

import git.fsevilla.seek.jobApplication.domain.service.CreateJobApplicationUseCase;
import git.fsevilla.seek.jobApplication.domain.service.FindJobApplicationUseCase;
import git.fsevilla.seek.jobApplication.domain.service.UpdateJobApplicationUseCase;

public interface JobApplicationService extends FindJobApplicationUseCase, CreateJobApplicationUseCase, UpdateJobApplicationUseCase {
}
