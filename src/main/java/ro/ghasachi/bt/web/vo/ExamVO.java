package ro.ghasachi.bt.web.vo;

import ro.ghasachi.bt.persistence.tables.pojos.Exam;

import java.util.ArrayList;
import java.util.List;

public class ExamVO {

    private int id;
    private String name;
    private String difficulty;
    private List<ExamItemVO> itemList = new ArrayList<>();

    public ExamVO() {
    }

    public ExamVO(String name, String dificulty) {
        this.name = name;
        this.difficulty = dificulty;
    }

    public ExamVO(Integer id, String name, String dificulty) {
        this.id = id;
        this.name = name;
        this.difficulty = dificulty;
    }

    public ExamVO(Exam exam) {
        this.id = exam.getId();
        this.name = exam.getName();
        this.difficulty = exam.getDificulty();
    }

    public void addItem(ExamItemVO itemVO){
        itemList.add(itemVO);
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String dificulty) {
        this.difficulty = dificulty;
    }

    public List<ExamItemVO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ExamItemVO> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "ExamVO{" +
                "name='" + name + '\'' +
                ", dificulty='" + difficulty + '\'' +
                '}';
    }
}
