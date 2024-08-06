package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "grade")
public class Grade {
    //등급번호
    @Id
    private int gradeNo;
    //등급명
    private String gradeName;
}
