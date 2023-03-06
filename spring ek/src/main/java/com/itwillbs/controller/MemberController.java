package com.itwillbs.controller;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	// 주의 : 파일이 틀려도 같은 @Controller에 있는 가상주소는 모두 다르게 부여

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
		// 전송방식 POST
		@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
		public String insertPro() {
			System.out.println("MemberController insertPro()");
			// 처리작업
			
//			 가상주소에서 주소변경 하면서 이동(가상주소 /member/login)
//			response.sendRedirect(forward.getPath());
			// 자바파일 메서드 호출 회원가입 처리 => 처리 => 디비
			// 로그인 페이지로 이동
			// 주소변경 없이 이동
			// /WEB-INF/views/loginForm.jsp
			return "member/loginForm";
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
			public String loginPro() {
				System.out.println("MemberController loginPro()");
				// 처리작업
				
		//		 가상주소에서 주소변경 하면서 이동(가상주소 /member/main)
		//		response.sendRedirect(forward.getPath());
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

	// 가상주소 http://localhost:8080/myweb/member/delete
	// 주소매핑 -> member/deleteForm.jsp
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		// 처리작업
		
		// 주소변경 없이 이동
		// /WEB-INF/views/deleteForm.jsp
		return "member/deleteForm";
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
