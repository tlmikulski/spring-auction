package pl.vavatech.auction.blc.repo;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CounterRepo {
	Long c();
}
