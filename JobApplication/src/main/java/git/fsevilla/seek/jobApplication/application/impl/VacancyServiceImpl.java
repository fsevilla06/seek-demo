package git.fsevilla.seek.jobApplication.application.impl;

import git.fsevilla.seek.jobApplication.application.VacancyService;
import git.fsevilla.seek.jobApplication.domain.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;
    @Override
    public boolean existsVacancy(Long vacancyId) {
        try {
            return vacancyRepository.getVacancy(vacancyId) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
