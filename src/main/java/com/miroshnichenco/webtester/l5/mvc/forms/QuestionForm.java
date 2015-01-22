package com.miroshnichenco.webtester.l5.mvc.forms;


import java.util.List;

import com.miroshnichenco.webtester.l1.entities.Answer;
import com.miroshnichenco.webtester.l1.entities.Test;


public class QuestionForm extends AbstractForm implements IForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
	private List<Answer> answers;
	private Long testId;
	private Long questionId;
	
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
}
