package pl.vavatech.auction.blc.repo;

public class FindCriteria {
	private OrderBy orderBy;
	private OrderDir orderDir = OrderDir.DESC;
	private String query;
	private int page = 0;
	private int pageSize = 10;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public OrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public OrderDir getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(OrderDir orderDir) {
		this.orderDir = orderDir;
	}
}
