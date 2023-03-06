package com.itwillbs.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImp1;

@Controller
public class MemberController {
	// 주의 : 파일이 틀려도 같은 @Controller에 있는 가상주소는 모두 다르게 부여
	
//	서블릿이 동작하기 전에 웹 애플리케이션 서버에서 request, response 서버 내장객체 생성 => 서버 기억장소 할당
//	request 기억장소 안에 사용자가 입력한 파라미터 정보(태그 입력한 정보), 서버정보, 클라이언트정보, 세션정보, 쿠키정보 저장

	// 가상주소 http://localhost:8080/myweb/member/insert
	// 자동으로 가상주소 뽑아옴 /member/insert
	// 주소매핑 -> member/insertForm.jsp
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// 처리작업
		
		// 가상주소에서 주소변경없이 이동(member/insertForm.jsp)
//		RequestDispatcher dispatcher=
//				request.getReqestDispatcher(forward.getPath());
//				dispatcher.forward(request, response);
		
		// 주소변경없이 이동
		// /WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
		
		// 가상주소에서 주소변경 하면서 이동(가상주소 /member/login)
//		response.sendRedirect(forward.getPath());
//		return "redirect:/member/login";
	}
	
	
		// http://localhost:8080/myweb/member/insertPro
		// 자동으로 가상주소 뽑아옴 /member/insertPro
		@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
		public String insertPro(MemberDTO memberDTO) {
			// HttpServletRequest request
			// 사용자가 입력한 내용 => request에 저장 => request 가져오기
			// post방식 한글 깨지고 request.setCharacterEncoding("UTF-8")
			// web.xml에서 한글설정을 한번만하고 모든 곳에서 한글처리가 됨
			System.out.println("MemberController insertPro()");
			
			// 패키지 com.itwillbs.domain MemberDTO에 저장
//			MemberDTO memberDTO=new MemberDTO();
//			memberDTO.setId(request.getParameter("id"));
//			memberDTO.setPass(request.getParameter("pass"));
//			memberDTO.setName(request.getParameter("name"));
			// 스프링에서 insertForm.jsp id, pass, name 태그이름 입력된값이 서버에 전달되면
			// request에 저장되어짐 => MemberDTO 객체생성 => 멤버변수 id, pass, name 이름이 동일하면
			// 자동으로 setId(request.getParameter("id")) 메서드 호출되어지고 자동으로 동작해서 값 저장			
			System.out.println(memberDTO.getId());
			System.out.println(memberDTO.getPass());
			System.out.println(memberDTO.getName());
			
			
//			 가상주소에서 주소변경 하면서 이동(가상주소 /member/login)
//			response.sendRedirect(forward.getPath());
			
			// MemberFrontController 주소매핑
			// -> MemberInserPro.java execute() 호출 
			// -> MemberDAO insertMember()
			
			// 자바파일 메서드 호출 회원가입 처리 => MemberService 처리 => MemberDAO 디비
			// 주소매핑 MemberController
			// -> 처리 패키지 com.itwillbs.service
			// 	  MemberService 인터페이스 MemberServiceImp1 클래스 insertMember()
			// -> 디비 패키지 com.itwillbs.dao
			//	  MemberDAO 인터페이스 MemberDAOImp1 클래스 insertMember()
			
			// MemberService 부모 = MemberServiceImp1 자식 객체생성 
			MemberService memberService=new MemberServiceImp1();
			// 메서드 호출
			memberService.insertMember(memberDTO);
			
			
			// 주소 변경되면서 로그인 페이지로 이동
			// response.sendRedirect("/member/login");
			return "redirect:/member/login";
		}
		
	
	// 가상주소 http://localhost:8080/myweb/member/login
	// 주소매핑 -> member/loginForm.jsp
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/loginForm.jsp
		return "member/loginForm";
	}
	

			// http://localhost:8080/myweb/member/loginPro
			// 전송방식 POST
			@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
			public String loginPro(MemberDTO memberDTO) {
				System.out.println("MemberController loginPro()");
				// 디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
				System.out.println(memberDTO.getId());
				System.out.println(memberDTO.getPass());
				System.out.println(memberDTO.getName());
				
		//		 가상주소에서 주소변경 하면서 로그인 페이지로 이동(가상주소 /member/main)
		//		response.sendRedirect("/member/main");
				return "redirect:/member/main";
			}
			

	// 가상주소 http://localhost:8080/myweb/member/main
	// 주소매핑 -> member/main.jsp
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/main.jsp
		return "member/main";
	}
	
	// 가상주소 http://localhost:8080/myweb/member/logout
	// 자동으로 가상주소 뽑아옴 /member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout() {
		System.out.println("MemberController logout()");
		// 세션 초기화
		
	//	주소변경 하면서 로그인 페이지로 이동
	//	response.sendRedirect("/member/main");
		return "redirect:/member/main";
	}

	// 가상주소 http://localhost:8080/myweb/member/info
	// 주소매핑 -> member/info.jsp
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/info.jsp
		return "member/info";
	}

	// 가상주소 http://localhost:8080/myweb/member/update
	// 주소매핑 -> member/updateForm.jsp
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/loginForm.jsp
		return "member/updateForm";
	}

	// http://localhost:8080/myweb/member/updatePro
	// 자동으로 가상주소 뽑아옴 /member/updatePro
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		// 디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
//		주소변경 하면서 로그인 페이지로 이동
//		response.sendRedirect("/member/main");
		return "redirect:/member/main";
	}
	
	// 가상주소 http://localhost:8080/myweb/member/delete
	// 주소매핑 -> member/deleteForm.jsp
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/deleteForm.jsp
		return "member/deleteForm";
	}
	
	// http://localhost:8080/myweb/member/deletePro
		// 자동으로 가상주소 뽑아옴 /member/deletePro
		@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
		public String deletePro(MemberDTO memberDTO) {
			System.out.println("MemberController deletePro()");
			// 디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
			System.out.println(memberDTO.getId());
			System.out.println(memberDTO.getPass());
			System.out.println(memberDTO.getName());
			
//			주소변경 하면서 로그인 페이지로 이동
//			response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}
	
	// 가상주소 http://localhost:8080/myweb/member/list
	// 주소매핑 -> member/list.jsp
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/list.jsp
		return "member/list";
	}
}
