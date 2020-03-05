package org.com.hrq.req;

/**
 *  分页请求公共类
 */
public class PageReq {
    protected int	pageNo		= 1;
    protected int	pageSize	= 10;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    
    
}
