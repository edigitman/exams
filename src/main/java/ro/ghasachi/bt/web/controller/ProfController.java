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

import ro.ghasachi.bt.middleware.ProfService;
import ro.ghasachi.bt.web.util.ControllerInputValidator;
import ro.ghasachi.bt.web.vo.*;

@Controller
@RequestMapping(value = "/prof")
public class ProfController {

    private final static Logger log = LoggerFactory.getLogger(ProfController.class);

    @Autowired
    private ProfService service;

    // EXAM resources

    /**
     * Create a new exam associated to a prof, only if current user is prof
     *
     * @param examVO exam instance
     */
    @RequestMapping(value = "exam", consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createExam(@RequestBody ExamVO examVO) {
        log.debug("create exam: " + examVO);

        ControllerInputValidator.validateCreateExam(examVO);

        service.createExam(examVO);
    }

    /**
     * Update the exam only is the exam was created by this user.
     *
     * @param examVO exam instance
     */
    @RequestMapping(value = "exam", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public ExamVO updateExam(@RequestBody ExamVO examVO) {
        log.debug("update Exam: " + examVO);

        ControllerInputValidator.validateCreateExam(examVO);

        return service.updateExam(examVO);
    }

    /**
     * Get one exam by id. Only if current user is prof and has created is or
     * current user is stud and is in a group from one of the exam instances.
     *
     * @return exam instance
     */
    @RequestMapping(value = "exam/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExamVO getExam(@PathVariable("id") Long id) {
        log.debug("get Exam: " + id);

        return service.getOneExam(id);
    }

    @RequestMapping(value = "exam", method = RequestMethod.GET)
    @ResponseBody
    public List<ExamVO> getAllExam() {
        log.debug("get All Exam");
        return service.getExams();
    }

    // EXAM INSTANCE resources

    @RequestMapping(value = "examInstance", consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createExamInstance(@RequestBody ExamInstanceVO examInstanceVO) {
        log.debug("createExamInstance :" + examInstanceVO);

        service.createExamInstance(examInstanceVO);
    }

    @RequestMapping(value = "examInstance", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public ExamInstanceVO updateExamInstance(@RequestBody ExamInstanceVO examInstanceVO) {
        log.debug("updateExamInstance :" + examInstanceVO);

        return service.updateExamInstance(examInstanceVO);
    }

    @RequestMapping(value = "examInstance/{id}/{state}", method = RequestMethod.PUT)
    @ResponseBody
    public ExamInstanceVO startExamInstance(@PathVariable("id") int id, @PathVariable("state") String state) {
        log.debug("startExamInstance :" + id + ", state:" + state);
        return service.setStateOnExamInstance(id, state);
    }

    @RequestMapping(value = "examInstance/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExamInstanceVO getExamInstance(@PathVariable("id") int id) {
        log.debug("getExamInstance :" + id);

        return service.getOneExamInstance(id);
    }

    @RequestMapping(value = "examInstance", method = RequestMethod.GET)
    @ResponseBody
    public List<ExamInstanceVO> getAllExamInstance() {
        log.debug("getAllExamInstance");
        return service.getExamInstances();
    }


    // EXAM ITEM resources

    /**
     * Create one exam item for one exam
     *
     * @param examItemVO exam item
     */
    @RequestMapping(value = "examItem", consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createExamItem(@RequestBody ExamItemVO examItemVO) {
        log.debug("createExamItem: " + examItemVO);

        ControllerInputValidator.validateCreateExamItem(examItemVO);

        service.createExamItem(examItemVO);
    }

    /**
     * Update and examItem
     *
     * @param examItemVO changes exam item with id oof the old one
     * @return exam item
     */
    @RequestMapping(value = "examItem", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public ExamItemVO updateExamItem(@RequestBody ExamItemVO examItemVO) {
        log.debug("updateExamItem: " + examItemVO);

        ControllerInputValidator.validateCreateExamItem(examItemVO);

        return service.updateExamItem(examItemVO);
    }

    /**
     * Get one exam item
     *
     * @param id id of exam item
     * @return exam item instance
     */
    @RequestMapping(value = "examItem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExamItemVO getExamItem(@PathVariable("id") int id) {
        log.debug("getOneExamItem: " + id);

        return service.getOneExamItem(id);
    }

    /**
     * Delete one exam item
     *
     * @param id exam item id
     */
    @RequestMapping(value = "examItem/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOneExamItem(@PathVariable("id") Long id) {
        log.debug("deleteOneExamItem: " + id);
        service.removeExamItem(id);
    }

    // EXAM GROUP resources

    @RequestMapping(value = "examGroup", consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createExamGroup(@RequestBody ExamGroupVO examGroupVO) {
        log.debug("createExamGroup: " + examGroupVO);

        ControllerInputValidator.validateCreateexamGroup(examGroupVO);
        service.createExamGroup(examGroupVO);

    }

    @RequestMapping(value = "examGroup", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public ExamGroupVO updateExamGroup(@RequestBody ExamGroupVO examGroupVO) {
        log.debug("updateExamGroup: " + examGroupVO);
        ControllerInputValidator.validateCreateexamGroup(examGroupVO);
        return service.updateExamGroup(examGroupVO);
    }

    @RequestMapping(value = "examGroup/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExamGroupVO getExamGroup(@PathVariable("id") Integer id) {
        log.debug("getExamGroup: " + id);

        return service.getOneExamGroup(id);
    }

    @RequestMapping(value = "examGroup", method = RequestMethod.GET)
    @ResponseBody
    public List<ExamGroupVO> getAllExamGroup() {
        log.debug("getAllExamGroup: ");

        return service.getExamGroups();
    }

    @RequestMapping(value = "examGroup/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteExamGroup(@PathVariable("id") Long id) {
        log.debug("deleteExamGroup: " + id);

        service.removeExamGroup(id);
    }

    @RequestMapping(value = "examGroupStud", consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addStudToExamGroup(@RequestBody ExamGroupStudVO examGroupStudVO) {
        log.debug("addStudToExamGroup: " + examGroupStudVO);

        ControllerInputValidator.validateAddStudToGroup(examGroupStudVO);
        service.addStudFromGroup(examGroupStudVO);
    }

    @RequestMapping(value = "examGroupStud", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeStudToExamGroup(@RequestBody ExamGroupStudVO examGroupStudVO) {
        log.debug("removeStudToExamGroup: " + examGroupStudVO);
        ControllerInputValidator.validateAddStudToGroup(examGroupStudVO);
        service.removeStudFromGroup(examGroupStudVO);
    }

    // EXAM ITEM ANSWER resources

    /**
     * Create one answer for one item
     *
     * @param examItemAnswerVO answer representation
     */
    @RequestMapping(value = "examItemAnswer", consumes = "application/json", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createExamItemAnswer(@RequestBody ExamItemAnswerVO examItemAnswerVO) {
        log.debug("createExamItemAnswer: " + examItemAnswerVO);
        ControllerInputValidator.validateProfAnswer(examItemAnswerVO);
        service.createExamItemAnswer(examItemAnswerVO);
    }

    @RequestMapping(value = "examItemAnswer", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public ExamItemAnswerVO updateExamItemAnswer(@RequestBody ExamItemAnswerVO examItemAnswerVO) {
        log.debug("updateExamItemAnswer: " + examItemAnswerVO);
        ControllerInputValidator.validateProfAnswer(examItemAnswerVO);
        return service.updateExamItemAnswer(examItemAnswerVO);
    }

    @RequestMapping(value = "examItemAnswer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExamItemAnswerVO getExamItemAnswer(@PathVariable("id") Long id) {
        log.debug("getExamItemAnswer: " + id);
        return service.getOneExamItemAnswer(id);
    }

    @RequestMapping(value = "examItemAnswer/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteExamItemAnswer(@PathVariable("id") int id) {
        log.debug("deleteExamItemAnswer: " + id);
        service.removeExamItemAnswer(id);
    }
}
