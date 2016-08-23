package pl.vavatech.auction.www.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RenderingTimeInterceptor extends HandlerInterceptorAdapter {

	Logger log = Logger.getLogger(RenderingTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("start", System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long stop = System.currentTimeMillis() - (Long) request.getAttribute("start");
		log.info("Porcessing time " + request.getRequestURI() + " " + stop);
		super.postHandle(request, response, handler, modelAndView);
	}
}
