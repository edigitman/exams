package ro.ghasachi.bt.web.vo;

import ro.ghasachi.bt.persistence.tables.pojos.Examitem;

import java.util.ArrayList;
import java.util.List;

public class ExamItemVO {

    private int id;
    private String assertion;
    private int type;
    private int examId;
    private long points;
    private int difficulty;
    private List<ExamItemAnswerVO> answers = new ArrayList<>();


    public ExamItemVO() {
    }

    public ExamItemVO(Examitem examitem) {
        this.id = examitem.getId();
        this.assertion = examitem.getAssertion();
        this.type = examitem.getType();
        this.points = examitem.getPoints();
        this.difficulty = examitem.getDifficulty() == null ? 0 : examitem.getDifficulty();
    }

    public void addAnswer(ExamItemAnswerVO answerVO) {
        answers.add(answerVO);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssertion() {
        return assertion;
    }

    public void setAssertion(String assertion) {
        this.assertion = assertion;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ExamItemAnswerVO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ExamItemAnswerVO> answers) {
        this.answers = answers;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
