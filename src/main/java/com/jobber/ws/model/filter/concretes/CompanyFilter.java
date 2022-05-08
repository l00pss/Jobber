package com.jobber.ws.model.filter.concretes;
import com.jobber.ws.model.filter.abstracts.Filter;
import com.jobber.ws.model.entity.company.Company;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@NoArgsConstructor
@Setter
public class CompanyFilter extends Filter {
    private String name;
    private Integer vacancyFromCount;
    private Integer vacancyToCount;

    @Override
    public boolean name(String name) {
        if (Objects.isNull(name) || name.trim().equals("")) return true;
        return this.name.trim().equals(name);
    }

    @Override
    public boolean fromVacancyCount(Integer vacancyCount) {
        if (Objects.isNull(vacancyCount)) return true;
        int result = this.vacancyFromCount.compareTo(vacancyCount);
        return result < 0 || result == 0;
    }

    @Override
    public boolean toVacancyCount(Integer vacancyCount) {
        if (Objects.isNull(vacancyCount)) return true;
        int result = this.vacancyToCount.compareTo(vacancyCount);
        return result > 0;
    }

    public boolean filter(Company company){
        Integer vacancyCount = company.getVacancies().size();
        return this.name(company.getName())
                && this.fromVacancyCount(vacancyCount)
                && this.toVacancyCount(vacancyCount);
    }
}
