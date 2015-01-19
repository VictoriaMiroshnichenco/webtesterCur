package com.miroshnichenco.webtester.l3.services;

import java.util.List;

import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;


public interface TestService {


	List<Test> listTests();

	Test getTestById(Long id);

	Question getQuestion(Long testId, int i);

	boolean processAnswer(String answerIds);

}
