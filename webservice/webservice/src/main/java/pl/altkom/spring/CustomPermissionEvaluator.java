package pl.altkom.spring;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class CustomPermissionEvaluator implements
		PermissionEvaluator {

	@Override
	public boolean hasPermission(
			Authentication authentication,
			Object targetDomainObject, Object permission) {
		return true;
	}

	@Override
	public boolean hasPermission(
			Authentication authentication,
			Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return true;
	}

}
