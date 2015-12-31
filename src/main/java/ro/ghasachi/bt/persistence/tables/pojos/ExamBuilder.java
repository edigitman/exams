package ro.ghasachi.bt.persistence.tables.pojos;

import java.sql.Timestamp;

public class ExamBuilder {
    private Exam value;
    private Integer id;
    private String name;
    private Integer userid;
    private String dificulty;
    private Timestamp datecreated;

    public ExamBuilder setValue(Exam value) {
        this.value = value;
        return this;
    }

    public ExamBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ExamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ExamBuilder setUserid(Integer userid) {
        this.userid = userid;
        return this;
    }

    public ExamBuilder setDificulty(String dificulty) {
        this.dificulty = dificulty;
        return this;
    }

    public ExamBuilder setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
        return this;
    }

    public Exam createExam() {
        return new Exam(value);
    }
}