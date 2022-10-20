package util;

public class PageRequest {
	
	private int page = 1; // 현재 페이지
	private int size = 20; // 페이지 요소 수
	private int width = 10; // 표시 페이지 개수
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
