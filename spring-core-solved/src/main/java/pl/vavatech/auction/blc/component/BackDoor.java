package pl.vavatech.auction.blc.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class BackDoor implements ApplicationContextAware {

	private ApplicationContext context;

	public Object execute(String expression) {
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
		standardEvaluationContext.setBeanResolver(new BeanFactoryResolver(
				context));

		Object value = parser.parseExpression(expression).getValue(
				standardEvaluationContext);

		return value;

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}

}
