package git.fsevilla.seek.Vacancy.application;

import git.fsevilla.seek.Vacancy.domain.exception.InvalidDataException;
import git.fsevilla.seek.Vacancy.domain.exception.VacancyNotFoundException;
import git.fsevilla.seek.Vacancy.domain.model.Vacancy;
import git.fsevilla.seek.Vacancy.domain.repository.VacancyRepository;
import git.fsevilla.seek.Vacancy.domain.service.CreateVacancyUseCase;
import git.fsevilla.seek.Vacancy.domain.service.FindVacancyUseCase;
import git.fsevilla.seek.Vacancy.domain.service.UpdateVacancyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class VacancyService implements FindVacancyUseCase, CreateVacancyUseCase, UpdateVacancyUseCase {
    @Autowired
    private VacancyRepository vacancyRepository;
    @Override
    public Vacancy save(Vacancy vacancy) throws InvalidDataException {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy find(Long id) throws VacancyNotFoundException {
        return vacancyRepository.findById(id).orElseThrow(() -> new VacancyNotFoundException("No vacancy found with id " + id));
    }

    @Override
    public Vacancy update(Vacancy vacancy) throws VacancyNotFoundException, InvalidDataException {
        Vacancy oldVacancy = find(vacancy.getId());
        if (StringUtils.hasText(vacancy.getName())) {
            oldVacancy.setName(vacancy.getName());
        }
        if (StringUtils.hasText(vacancy.getCompany())) {
            oldVacancy.setCompany(vacancy.getCompany());
        }
        if (StringUtils.hasText(vacancy.getDescription())) {
            oldVacancy.setDescription(vacancy.getDescription());
        }
        if (StringUtils.hasText(vacancy.getEmail())) {
            oldVacancy.setEmail(vacancy.getEmail());
        }
        if (StringUtils.hasText(vacancy.getMinSalaryOffer())) {
            oldVacancy.setMinSalaryOffer(vacancy.getMinSalaryOffer());
        }
        if (StringUtils.hasText(vacancy.getMaxSalaryOffer())) {
            oldVacancy.setMaxSalaryOffer(vacancy.getMaxSalaryOffer());
        }
        oldVacancy.setStatus(vacancy.getStatus());
        return vacancyRepository.save(oldVacancy);
    }
}
