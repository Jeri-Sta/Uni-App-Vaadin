package br.com.uni.backend.smallgroup.model;

import br.com.uni.backend.common.enums.Sex;
import br.com.uni.backend.common.enums.WeekDays;
import br.com.uni.backend.person.model.PersonOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallGroupInput {

    private long Id;
    private String name;
    private WeekDays weekDay;
    private LocalTime time;
    private Sex sex;
    private Collection<PersonOutput> members;
}
