package com.miroshnichenco.webtester.l2.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l2.dao.QuestionDao;

@Repository("questionDao")
public class QuestionDaoImpl extends AbstractEntityDao<Question> implements
		QuestionDao {

	@Override
	protected Class getEntityClass() {
		return Question.class;
	}

}
