package pl.altkom.spring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomeHealth implements HealthIndicator {

	@Override
	public Health health() {
		return new Health.Builder().up()
				.withDetail("mirek", 12).build();
	}
}
