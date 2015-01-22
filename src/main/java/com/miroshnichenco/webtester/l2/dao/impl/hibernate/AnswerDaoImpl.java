package com.miroshnichenco.webtester.l2.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.miroshnichenco.webtester.l1.entities.Answer;
import com.miroshnichenco.webtester.l2.dao.AnswerDao;

@Repository("answerDao")
public class AnswerDaoImpl extends AbstractEntityDao<Answer> implements AnswerDao {

	@Override
	protected Class getEntityClass() {
		return Answer.class;
	}

}
