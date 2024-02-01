package br.com.uni.backend.person.model;

import br.com.uni.backend.common.enums.FrequentChurch;
import br.com.uni.backend.common.enums.Sex;
import br.com.uni.backend.common.enums.SmallGroupRole;
import br.com.uni.backend.common.enums.WeekDays;
import br.com.uni.backend.smallgroup.model.SmallGroupOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInput {

    private Long id;
    private String name;
    private String phone;
    private Sex sex;
    private FrequentChurch frequentChurch;
    private WeekDays avaliableWeekDay;
    private SmallGroupOutput smallGroup;
    private SmallGroupRole smallGroupRole;
}