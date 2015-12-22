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

import ro.ghasachi.bt.web.middleware.ProfService;
import ro.ghasachi.bt.web.vo.ExamGroupVO;
import ro.ghasachi.bt.web.vo.ExamInstanceVO;
import ro.ghasachi.bt.web.vo.ExamItemAnswerVO;
import ro.ghasachi.bt.web.vo.ExamItemVO;
import ro.ghasachi.bt.web.vo.ExamVO;

@Controller
@RequestMapping(value = "/prof")
public class ProfController {

	private final static Logger log = LoggerFactory.getLogger(ProfController.class);
	
	@Autowired
	private ProfService service ;

	// EXAM resources

	/**
	 * Create a new exam associated to a prof, only if current user is prof
	 * 
	 * @param examVO
	 */
	@RequestMapping(value = "exam", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createExam(@RequestBody ExamVO examVO) {
		log.debug("create exam: " + examVO );
	}

	/**
	 * Update the exam only is the exam was created by this user.
	 * 
	 * @param examVO
	 */
	@RequestMapping(value = "exam", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public ExamVO updateExam(@RequestBody ExamVO examVO) {
		log.debug("update Exam: " + examVO );
		return null;
	}
	
	/**
	 * Get one exam by id. Only if current user is prof and has created is or
	 * current user is stud and is in a group from one of the exam instances.
	 * 
	 * @return
	 */
	@RequestMapping(value = "exam/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExamVO getExam(@PathVariable("id") Long id) {
		log.debug("get Exam: " + id );
		return null;
	}
	
	@RequestMapping(value = "exam", method = RequestMethod.GET)
	@ResponseBody
	public List<ExamVO> getAllExam() {
		log.debug("get All Exam");
		return null;
	}

	// EXAM INSTANCE resources
	
	@RequestMapping(value = "examInstance", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createExamInstance(@RequestBody ExamInstanceVO examInstanceVO){	
		log.debug("createExamInstance :" + examInstanceVO);
	}
	
	@RequestMapping(value = "examInstance", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public ExamInstanceVO updateExamInstance(@RequestBody ExamInstanceVO examInstanceVO){
		log.debug("updateExamInstance :" + examInstanceVO);
		return examInstanceVO;
	}
	
	@RequestMapping(value = "examInstance/{id}/{state}", method = RequestMethod.PUT)
	@ResponseBody
	public ExamInstanceVO startExamInstance(@PathVariable("id") Long id, @PathVariable("state") String state){
		log.debug("startExamInstance :" + id + ", state:" + state);
		return new ExamInstanceVO();
	}
	
	@RequestMapping(value = "examInstance/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExamInstanceVO getExamInstance(@PathVariable("id") Long id){
		log.debug("getExamInstance :" + id);
		return new ExamInstanceVO();
	}
	
	@RequestMapping(value = "examInstance", method = RequestMethod.GET)
	@ResponseBody
	public List<ExamInstanceVO> getAllExamInstance(){
		log.debug("getAllExamInstance");
		return null;
	}
	
	
	// EXAM ITEM resources

	/**
	 * Create one exam item for one exam
	 * 
	 * @param examItemVO
	 */
	@RequestMapping(value = "examItem", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createExamItem(@RequestBody ExamItemVO examItemVO) {
		log.debug("createExamItem: " + examItemVO);
	}

	/**
	 * Update and examItem
	 * 
	 * @param examItemVO
	 * @return
	 */
	@RequestMapping(value = "examItem", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public ExamItemVO updateExamItem(@RequestBody ExamItemVO examItemVO) {
		log.debug("updateExamItem: " + examItemVO);
		return examItemVO;
	}

	/**
	 * Get one exam item
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "examItem/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExamItemVO getExamItem(@PathVariable("id") Long id) {
		log.debug("getExamItem: " + id);
		return new ExamItemVO();
	}

	/**
	 * Delete one exam item
	 * 
	 * @param id
	 */
	@RequestMapping(value = "examItem/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteOneExamItem(@PathVariable("id") Long id) {
		log.debug("deleteOneExamItem: " + id);
	}

	// EXAM GROUP resources
	
	@RequestMapping(value = "examGroup", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createExamGroup(@RequestBody ExamGroupVO examGroupVO) {
		log.debug("createExamGroup: " + examGroupVO);
	}
	
	@RequestMapping(value = "examGroup", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public ExamGroupVO updateExamGroup(@RequestBody ExamGroupVO examGroupVO) {
		log.debug("updateExamGroup: " + examGroupVO);
		return examGroupVO;
	}
	
	@RequestMapping(value = "examGroup/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExamGroupVO getExamGroup(@PathVariable("id") Long id) {
		log.debug("getExamGroup: " + id);
		return new ExamGroupVO();
	}
	
	@RequestMapping(value = "examGroup", method = RequestMethod.GET)
	@ResponseBody
	public List<ExamGroupVO> getAllExamGroup() {
		log.debug("getAllExamGroup: ");
		return null;
	}
	
	@RequestMapping(value = "examGroup/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteExamGroup(@PathVariable("id") Long id) {		
		log.debug("deleteExamGroup: " + id);
	}
	
	// EXAM ITEM ANSWER resources

	/**
	 * Create one answer for one item
	 * 
	 * @param examItemVO
	 */
	@RequestMapping(value = "examItemAnswer", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createExamItemAnswer(@RequestBody ExamItemAnswerVO examItemVO) {
		log.debug("createExamItemAnswer: " + examItemVO);
	}

	@RequestMapping(value = "examItemAnswer", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public ExamItemAnswerVO updateExamItemAnswer(@RequestBody ExamItemAnswerVO examItemVO) {
		log.debug("updateExamItemAnswer: " + examItemVO);
		return null;
	}

	@RequestMapping(value = "examItemAnswer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ExamItemAnswerVO getExamItemAnswer(@PathVariable("id") Long id) {
		log.debug("getExamItemAnswer: " + id);
		return null;
	}

	@RequestMapping(value = "examItemAnswer/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public ExamItemAnswerVO deleteExamItemAnswer(@PathVariable("id") Long id) {
		log.debug("deleteExamItemAnswer: " + id);
		return null;
	}	
}
