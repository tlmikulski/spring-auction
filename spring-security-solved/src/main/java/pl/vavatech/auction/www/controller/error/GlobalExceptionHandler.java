package pl.vavatech.auction.www.controller.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

	Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ServerError> missingParamterHandler(
			final MethodArgumentNotValidException exception, final HttpServletRequest request) {
		logger.error(exception.getMessage(), exception);
		FieldError fieldError = exception.getBindingResult().getFieldError();
		String result = null;
		if (fieldError != null) {
			result = formatErrorMsg(fieldError);
		}

		if (result == null) {
			result = exception.toString();
		}
		return new ResponseEntity(new ServerError(result), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BindException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ServerError> handleException(final BindException exception) {
		logger.error(exception.getMessage(), exception);
		FieldError fieldError = exception.getFieldError();
		String result = formatErrorMsg(fieldError);
		if (result == null) {
			result = exception.toString();
		}
		return new ResponseEntity(new ServerError(result), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ServerError> handleException(final Exception exception) {
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.TEXT_PLAIN);

		logger.error(exception.getMessage(), exception);
		return new ResponseEntity(new ServerError(exception.toString()), headers,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String formatErrorMsg(final FieldError fieldError) {
		String result = "Field error in object '" + fieldError.getObjectName() + "' on field '"
				+ fieldError.getField() + "': rejected value [" + fieldError.getRejectedValue()
				+ "] ";
		return result;
	}

}
