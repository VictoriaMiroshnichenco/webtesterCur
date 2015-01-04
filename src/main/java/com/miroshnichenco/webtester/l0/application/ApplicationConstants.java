package com.miroshnichenco.webtester.l0.application;

import java.util.Arrays;
import java.util.List;

public interface ApplicationConstants {
	int ADMIN_ROLE 			= 4;
	int ADVANCED_TUTOR_ROLE = 2;
	int TUTOR_ROLE 			= 3;
	int STUDENT_ROLE 		= 1;
	List<Integer> ROLES = Arrays.asList(new Integer[]{ADMIN_ROLE, ADVANCED_TUTOR_ROLE, TUTOR_ROLE, STUDENT_ROLE});
}
