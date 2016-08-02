package pl.vavatech.auction.blc.lab2_done;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	@Inject
	private NumerationService numerationService;
	private CustomerService customerService;
	private CouponsService couponsService;

	@Inject
	public InvoiceService(CustomerService customerService) {
		this.customerService = customerService;

	}

	@Inject
	public void setCouponsService(CouponsService couponsService) {
		this.couponsService = couponsService;
	}

}
