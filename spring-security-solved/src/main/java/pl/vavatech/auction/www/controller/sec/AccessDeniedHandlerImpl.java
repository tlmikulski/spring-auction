package pl.vavatech.auction.www.controller.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

	private static final RequestMatcher requestMatcher = new ELRequestMatcher(
			"hasHeader('X-Requested-With','XMLHttpRequest')");

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		if (requestMatcher.matches(request)) {
			response.sendError(HttpStatus.UNAUTHORIZED.value(),
					"Login required");
		} else {
			response.sendError(HttpStatus.FORBIDDEN.value());
		}
	}
}
