package pl.vavatech.auction.www.controller.error;

public class ServerError {
	private String result = "error :-(";
	private String error;

	public ServerError(String error) {
		this.setError(error);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getResult() {
		return result;
	}

}
