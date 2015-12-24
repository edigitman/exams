package ro.ghasachi.bt.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ro.ghasachi.bt.web.middleware.StudService;
import ro.ghasachi.bt.web.vo.ExamInstanceVO;
import ro.ghasachi.bt.web.vo.ExamItemVO;
import ro.ghasachi.bt.web.vo.StudExamInstanceVO;
import ro.ghasachi.bt.web.vo.StudInfoVO;

@Controller
@RequestMapping(value = "/stud")
public class StudController {

	private final static Logger log = LoggerFactory.getLogger(StudController.class);

	@Autowired
	private StudService service;
	
	@RequestMapping(value = "exam", method = RequestMethod.GET)
	@ResponseBody
	public List<ExamInstanceVO> getAllExam() {
		log.debug("getAllExam: " );
		return service.getMyExams();
	}

	@RequestMapping(value = "exam/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExamInstanceVO getExam(@PathVariable("id") Long id) {
		log.debug("getExam: " + id);
		return service.getOneExam(id);
	}

	@RequestMapping(value = "exam/{id}/{state}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public StudExamInstanceVO takeExam(@PathVariable("id") Long id, @PathVariable("state") String state) {
		log.debug("getExam: " + id + ", state: " + state);
		
		StudExamInstanceVO seiVO = service.changeExamInstance(id, state);
		
		return seiVO;
	}

	@RequestMapping(value = "item/{examId}/{itemId}", method = RequestMethod.GET)
	@ResponseBody
	public ExamItemVO getExamItem(@PathVariable("examId") Long examId, @PathVariable("itemId") Long itemId) {
		log.debug("getExamItem: exam: " + examId + ", itemId" + itemId);
		
		ExamItemVO eiVO = service.getExamItem(examId, itemId);
		
		return null;
	}

	@RequestMapping(value = "item", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveExamItem(@RequestBody ExamItemVO examItemVO) {
		log.debug("saveExamItem: " + examItemVO);
		
		service.saveExamItem(examItemVO);		
	}

	@RequestMapping(value = "acc", method = RequestMethod.GET)
	@ResponseBody
	public StudInfoVO getStudStats() {
		log.debug("getStudStats");
		
		//TODO what do we need to show here?
		
		return null;
	}

}
