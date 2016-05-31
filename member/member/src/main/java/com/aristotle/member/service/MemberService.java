package com.aristotle.member.service;

import com.aristotle.core.exception.AppException;
import com.aristotle.core.persistance.User;

public interface MemberService {
	public User login(String userName, String password) throws AppException;

}
