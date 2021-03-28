package tw.waterball.judgegirl.springboot.exam.repositories.jpa;

import lombok.*;
import tw.waterball.judgegirl.entities.Exam;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static tw.waterball.judgegirl.commons.utils.StreamUtils.mapToList;

@Table(name = "exams")
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExamData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date startTime;
    private Date endTime;
    private String description;

    @OneToMany(mappedBy = "id.examId", cascade = {CascadeType.ALL})
    private List<QuestionData> questions = new ArrayList<>();


    public void addQuestion(QuestionData questionData) {
        questions.add(questionData);
    }

    public void removeQuestion(QuestionData questionData) {
        questions.remove(questionData);
    }

    public Exam toEntity() {
        return new Exam(id, name, startTime, endTime, description,
                mapToList(questions, QuestionData::toEntity));
    }

    public static ExamData toData(Exam exam) {
        return ExamData.builder()
                .id(exam.getId())
                .name(exam.getName())
                .startTime(exam.getStartTime())
                .endTime(exam.getEndTime())
                .description(exam.getDescription())
                .questions(mapToList(exam.getQuestions(), QuestionData::toData))
                .build();
    }
}
