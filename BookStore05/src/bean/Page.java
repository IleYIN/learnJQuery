package bean;

import java.util.List;

public class Page<T> {
	//��ǰ�ǵڼ�ҳ �������Ĳ���
	private int pageNo;
	//��ҳ��		����õ���
	private int totalPage;
	//�ܼ�¼��	��ѯ�õ����ý���
	private int totalCount;
	//ÿҳ��ʾ���������������ݿ�һ�β�4����¼
	private int pageSize = 2;
	//�������ݿ���ĸ�������ʼ��	����õ���
	private int index;
	//�Ƿ�����һҳ	�жϵõ�
	private boolean hasNext;
	//�Ƿ�����һҳ	�жϵõ�
	private boolean hasPrev;
	//��װ�˲�ѯ������ҳ������	��ѯ�������ý���
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
		//����ʵ�ʵ�totalPage
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
		//ÿҳ��ʾ4����������Ϊ��
		//ҳ�� ��ʼ���� ��������
		// 1     0      3
		// 2     4      7
		// 3     8      11
		if(getPageNo()>=1) {
			return (getPageNo()-1)*getPageSize();
		}
		return 0;
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
