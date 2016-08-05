package pl.vavatech.auction.www.component;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

import org.springframework.expression.ParseException;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import com.google.common.collect.Sets;

public class CurrencyFormatter implements AnnotationFormatterFactory<CurrencyFormat> {

	private class PLNFormatter implements Formatter<BigDecimal> {
		@Override
		public String print(BigDecimal object, Locale locale) {
			return object.toString() + " PLN";
		}

		@Override
		public BigDecimal parse(String text, Locale locale) throws ParseException {
			return new BigDecimal(text.split(" ")[0]);
		}
	}

	@Override
	public Set<Class<?>> getFieldTypes() {
		return Sets.newHashSet(BigDecimal.class);
	}

	@Override
	public Printer<?> getPrinter(CurrencyFormat annotation, Class<?> fieldType) {
		return new PLNFormatter();
	}

	@Override
	public Parser<?> getParser(CurrencyFormat annotation, Class<?> fieldType) {
		return new PLNFormatter();
	}

}
