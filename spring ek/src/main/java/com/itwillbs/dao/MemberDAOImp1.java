package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImp1 implements MemberDAO{

	@Override
	public void insertMember(MemberDTO memberDTO) {
		// 디비작업 
		System.out.println("MemberDAOImp1 insertMember()");
		
	}

}
