package bean;

import java.util.List;

public class Page<T> {
	//当前是第几页 传进来的参数
	private int pageNo;
	//总页数		计算得到的
	private int totalPage;
	//总记录数	查询得到设置进入
	private int totalCount;
	//每页显示的条数，告诉数据库一次查4条记录
	private int pageSize = 2;
	//告诉数据库从哪个索引开始查	计算得到的
	private int index;
	//是否有下一页	判断得到
	private boolean hasNext;
	//是否有上一页	判断得到
	private boolean hasPrev;
	//封装了查询出来分页的数据	查询出来设置进入
	private List<T> pageData;
	
	public String getUrl() {
		return url;
	}
	private String url;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPageNo(int pageNo) {
		pageNo = pageNo>0?pageNo:1;
		pageNo = pageNo>getTotalPage()?getTotalPage():pageNo;
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		//计算实际的totalPage
		//10  4-->3
		//20  6-->4
		int t = getTotalCount()/getPageSize();
		if(!(getTotalCount()%getPageSize()==0)) {
			t+=1;
		}
		return t;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getIndex() {
		//每页显示4条，则索引为：
		//页码 开始索引 结束索引
		// 1     0      3
		// 2     4      7
		// 3     8      11
		return (getPageNo()-1)*getPageSize();
	}
	public boolean isHasNext() {
		return getPageNo()<getTotalPage();
	}
	public boolean isHasPrev() {
		return getPageNo()>1;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public Page() {
	}
	public Page(int pageNo, int totalPage, int totalCount, int pageSize, int index, boolean hasNext, boolean hasPrev,
			List<T> pageData) {
		super();
		this.pageNo = pageNo;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.index = index;
		this.hasNext = hasNext;
		this.hasPrev = hasPrev;
		this.pageData = pageData;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", pageSize="
				+ pageSize + ", index=" + index + ", hasNext=" + hasNext + ", hasPrev=" + hasPrev + ", pageData="
				+ pageData + "]";
	}
}
