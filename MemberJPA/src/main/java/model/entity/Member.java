package model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DialectOverride;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "member")
public class Member {
    @Id
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberAddr;
    private LocalDate memberRegdate = LocalDate.now();;
    private String memberPasswd;
    //등급 조인
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grade_no")
    private Grade grade;

    public void setGradeNo(int gradeNo) {
        this.grade = new Grade();
        this.grade.setGradeNo(gradeNo);
    }
}
