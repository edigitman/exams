package ro.ghasachi.bt.web.vo;

import ro.ghasachi.bt.persistence.tables.pojos.Examitemanswer;

public class ExamItemAnswerVO {

    private int id;
    private int itemId;
    private int examInstanceId;
    private String value;
    private Boolean correct;

    public ExamItemAnswerVO() {
    }

    public ExamItemAnswerVO(Examitemanswer examitemanswer) {
        this.id = examitemanswer.getId() == null ? 0 : examitemanswer.getId();
        this.itemId = examitemanswer.getItemid();
        this.value = examitemanswer.getValue();
        this.correct = examitemanswer.getCorrect() == 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public ExamItemAnswerVO(String value) {
        this.value = value;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getExamInstanceId() {
        return examInstanceId;
    }

    public void setExamInstanceId(int examInstanceId) {
        this.examInstanceId = examInstanceId;
    }
}
