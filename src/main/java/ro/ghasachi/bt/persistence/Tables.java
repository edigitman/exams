/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence;


import javax.annotation.Generated;

import ro.ghasachi.bt.persistence.tables.Egroup;
import ro.ghasachi.bt.persistence.tables.Egroupuser;
import ro.ghasachi.bt.persistence.tables.Exam;
import ro.ghasachi.bt.persistence.tables.Examinstance;
import ro.ghasachi.bt.persistence.tables.Examitem;
import ro.ghasachi.bt.persistence.tables.Examitemanswer;
import ro.ghasachi.bt.persistence.tables.Studexamanswer;
import ro.ghasachi.bt.persistence.tables.Studexaminstance;
import ro.ghasachi.bt.persistence.tables.User;
import ro.ghasachi.bt.persistence.tables.Verificationtoken;


/**
 * Convenience access to all tables in mydb
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table mydb.egroup
	 */
	public static final Egroup EGROUP = ro.ghasachi.bt.persistence.tables.Egroup.EGROUP;

	/**
	 * The table mydb.egroupuser
	 */
	public static final Egroupuser EGROUPUSER = ro.ghasachi.bt.persistence.tables.Egroupuser.EGROUPUSER;

	/**
	 * The table mydb.exam
	 */
	public static final Exam EXAM = ro.ghasachi.bt.persistence.tables.Exam.EXAM;

	/**
	 * The table mydb.examinstance
	 */
	public static final Examinstance EXAMINSTANCE = ro.ghasachi.bt.persistence.tables.Examinstance.EXAMINSTANCE;

	/**
	 * The table mydb.examitem
	 */
	public static final Examitem EXAMITEM = ro.ghasachi.bt.persistence.tables.Examitem.EXAMITEM;

	/**
	 * The table mydb.examitemanswer
	 */
	public static final Examitemanswer EXAMITEMANSWER = ro.ghasachi.bt.persistence.tables.Examitemanswer.EXAMITEMANSWER;

	/**
	 * The table mydb.studexamanswer
	 */
	public static final Studexamanswer STUDEXAMANSWER = ro.ghasachi.bt.persistence.tables.Studexamanswer.STUDEXAMANSWER;

	/**
	 * The table mydb.studexaminstance
	 */
	public static final Studexaminstance STUDEXAMINSTANCE = ro.ghasachi.bt.persistence.tables.Studexaminstance.STUDEXAMINSTANCE;

	/**
	 * The table mydb.user
	 */
	public static final User USER = ro.ghasachi.bt.persistence.tables.User.USER;

	/**
	 * The table mydb.verificationtoken
	 */
	public static final Verificationtoken VERIFICATIONTOKEN = ro.ghasachi.bt.persistence.tables.Verificationtoken.VERIFICATIONTOKEN;
}
