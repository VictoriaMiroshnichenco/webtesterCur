package com.miroshnichenco.webtester.l2.dao.impl.hibernate;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l2.dao.TestDao;

@Repository("testDao")
public class TestDaoImpl extends AbstractEntityDao<Test> implements TestDao{

	@Override
	protected Class getEntityClass() {
		return Test.class;
	}

	@Override
	public List<Test> listTestsForUser(User user) {
		return (List<Test>) getSession().createCriteria(getEntityClass())
				.add(Restrictions.eq("user", user)).list();
	}

	@Override
	public List<Question> getQuestionForTest(Test test) {
		return (List<Question>) getSession().createCriteria(Question.class)
				.add(Restrictions.eq("test", test)).list();
	}
	
/*	@Override
	public List<Question> getQuestionForTest(Test test) {
		return (List<Question>) getSession().createCriteria(Question.class)
				.add(Restrictions.eq("test", test)).list();
	}
*/
}
