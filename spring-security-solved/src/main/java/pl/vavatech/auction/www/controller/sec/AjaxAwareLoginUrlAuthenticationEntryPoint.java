package pl.vavatech.auction.www.controller.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class AjaxAwareLoginUrlAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	private static final RequestMatcher requestMatcher = new ELRequestMatcher(
			"hasHeader('X-Requested-With','XMLHttpRequest')");

	public AjaxAwareLoginUrlAuthenticationEntryPoint() {
		setRealmName("Vavatech");
	}

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {
		if (isPreflight(request)) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else if (isRestRequest(request)) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		} else {
			super.commence(request, response, authException);
		}
	}

	/**
	 * Checks if this is a X-domain pre-flight request.
	 * 
	 * @param request
	 * @return
	 */
	private boolean isPreflight(HttpServletRequest request) {
		return "OPTIONS".equals(request.getMethod());
	}

	/**
	 * Checks if it is a rest request
	 * 
	 * @param request
	 * @return
	 */
	protected boolean isRestRequest(HttpServletRequest request) {
		return requestMatcher.matches(request);
	}
}
