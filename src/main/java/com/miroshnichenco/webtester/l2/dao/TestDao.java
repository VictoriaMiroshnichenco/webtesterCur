package com.miroshnichenco.webtester.l2.dao;

import java.util.List;

import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;

public interface TestDao extends IEntityDao<Test>{

	List<Test> listTestsForUser(User user);

	List<Question> getQuestionForTest(Test test);

	//List<Test> listTestsForUser(Long userId);


}
