package br.com.uni.backend.person.model;

import br.com.uni.backend.common.enums.FrequentChurch;
import br.com.uni.backend.common.enums.Sex;
import br.com.uni.backend.common.enums.SmallGroupRole;
import br.com.uni.backend.common.enums.WeekDays;
import br.com.uni.backend.smallgroup.model.SmallGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private FrequentChurch frequentChurch;

    @Enumerated(EnumType.STRING)
    private WeekDays avaliableWeekDay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "small_group_id")
    private SmallGroup smallGroup;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SmallGroupRole smallGroupRole;
}
