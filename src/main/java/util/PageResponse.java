package util;

import java.util.Arrays;
import java.util.List;

import content.vo.ContentVO;

public class PageResponse<E> {
	private int currentPage; // 현재 페이지
	private int pageSize; // 한 페이지에 요소 개수
	private int width; // 페이지 선택지 개수
	private int totalContent; // 총 요소 개수
	private int startPage; // 페이징 시작 페이지
	private int endPage; // 페이징 종료 페이지
	private int totalPage; // 마지막 페이지
	private List<E> pageList; // 페이지 요소
	private boolean showPrev;
	private boolean showNext;
	
	public PageResponse(PageRequest pageRequest, List<E> list, int totalContent) {
		this.currentPage = pageRequest.getPage();
		this.pageSize = pageRequest.getSize();
		this.width = pageRequest.getWidth();
		this.totalContent = totalContent;
		this.totalPage = (int)(Math.ceil(this.totalContent / (double)this.pageSize));
		
		this.startPage = (this.currentPage - 1) / this.width * this.width + 1;
		this.endPage = Math.min(this.totalPage, this.startPage + (this.width - 1));
		this.pageList = list;
		
		this.showPrev = (this.startPage != 1);
		this.showNext = (this.totalPage > this.endPage);
	
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getWidth() {
		return width;
	}
	public int getTotalContent() {
		return totalContent;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public List<E> getPageList() {
		return pageList;
	}
	public boolean isShowPrev() {
		return showPrev;
	}
	public boolean isShowNext() {
		return showNext;
	}
	
    //사용법
//  PageResponseDTO<BoardDTO> pageResponseDTO = PageResponseDTO.<BoardDTO>withAll()
//          .pageRequestDTO(pageRequestDTO)
//          .total(boardDAO.getTotal(pageRequestDTO))
//          .dtoList(boardDTOList)
//          .build();
//      return pageResponseDTO;
	
	
}
