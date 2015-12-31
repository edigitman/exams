package ro.ghasachi.bt.middleware;

import java.util.List;

import ro.ghasachi.bt.web.vo.ExamInstanceVO;
import ro.ghasachi.bt.web.vo.ExamItemAnswerVO;
import ro.ghasachi.bt.web.vo.ExamItemVO;
import ro.ghasachi.bt.web.vo.StudExamInstanceVO;

public interface StudService {

	List<ExamInstanceVO> getMyExams();

	ExamInstanceVO getOneExam(long id);

	StudExamInstanceVO changeExamInstance(Long id, String state);

	ExamItemVO getExamItem(int examId, int itemId);

	void saveExamItem(ExamItemAnswerVO examItemAnswerVO);

}
