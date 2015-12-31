package ro.ghasachi.bt.middleware;

import ro.ghasachi.bt.web.vo.*;

import java.util.List;

public interface ProfService {

    // EXAM
    Integer createExam(ExamVO examVO);

    ExamVO updateExam(ExamVO examVO);

    ExamVO getOneExam(Long id);

    List<ExamVO> getExams();

    // EXAM ITEM
    void createExamItem(ExamItemVO examItemVO);

    ExamItemVO getOneExamItem(int id);

    ExamItemVO updateExamItem(ExamItemVO examItemVO);

    void removeExamItem(Long id);

    // EXAM GROUP
    void createExamGroup(ExamGroupVO examGroupVO);

    List<ExamGroupVO> getExamGroups();

    ExamGroupVO getOneExamGroup(Integer id);

    void removeExamGroup(Long id);

    ExamGroupVO updateExamGroup(ExamGroupVO examGroupVO);

    void addStudFromGroup(ExamGroupStudVO examGroupStudVO);

    void removeStudFromGroup(ExamGroupStudVO examGroupStudVO);

    // EXAM ITEM ANSWER
    void createExamItemAnswer(ExamItemAnswerVO examItemAnswerVO);

    ExamItemAnswerVO updateExamItemAnswer(ExamItemAnswerVO examItemAnswerVO);

    ExamItemAnswerVO getOneExamItemAnswer(Long id);

    void removeExamItemAnswer(int id);

    // EXAM INSTANCES
    void createExamInstance(ExamInstanceVO examInstanceVO);

    ExamInstanceVO updateExamInstance(ExamInstanceVO examInstanceVO);

    ExamInstanceVO setStateOnExamInstance(int id, String state);

    ExamInstanceVO getOneExamInstance(int id);

    List<ExamInstanceVO> getExamInstances();
}
