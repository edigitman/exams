package ro.ghasachi.bt.web.vo;

import ro.ghasachi.bt.persistence.tables.pojos.Egroup;

import java.util.ArrayList;
import java.util.List;

public class ExamGroupVO {

    private String name;
    private int id;
    private List<UserVO> students = new ArrayList<>();

    public ExamGroupVO() {
    }

    public ExamGroupVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void add(UserVO userVO){
        this.students.add(userVO);
    }

    public ExamGroupVO(Egroup egroup) {
        this.id = egroup.getId();
        this.name = egroup.getName();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserVO> getStudents() {
        return students;
    }

    public void setStudents(List<UserVO> students) {
        this.students = students;
    }
}
