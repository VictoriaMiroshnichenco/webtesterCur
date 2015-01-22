package com.miroshnichenco.webtester.l3.services;

import java.io.Serializable;
import java.util.List;

import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l5.mvc.forms.QuestionForm;
import com.miroshnichenco.webtester.l5.mvc.forms.TestForm;


public interface TestService {


	List<Test> listTests();

	Test getTestById(Long id);

	Question getQuestion(Long testId, int i);

	boolean processAnswer(String answerIds);

	List<Test> listTests(Long userId);

	Long createTest(TestForm testForm);

	Long createQuestion(QuestionForm questionForm);

	Question getQuestion(Long id);

}
