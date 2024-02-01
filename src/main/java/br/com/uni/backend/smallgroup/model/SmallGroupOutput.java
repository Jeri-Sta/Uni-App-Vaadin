package br.com.uni.backend.smallgroup.model;

import br.com.uni.backend.common.enums.Sex;
import br.com.uni.backend.common.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallGroupOutput {

    private long Id;
    private String name;
    private WeekDays weekDay;
    private LocalTime time;
    private Sex sex;
}
