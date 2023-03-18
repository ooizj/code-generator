package #BASE_PACKAGE#.api;

import lombok.Data;

import java.util.List;

@Data
public class PageData<T> {

//	/** 分页大小 */
//	private int pageSize;
//	/** 总页数 */
//	private int pageNo;
	/** 总记录数 */
	private long total;
	/** 数据 */
	private List<T> data;

	public PageData(List<T> data, long total) {
		this.data = data;
		this.total = total;
	}

//	public PageData(List<T> data, int pageNo, int pageSize, long total) {
//		this.data = data;
//		this.pageNo = pageNo;
//		this.pageSize = pageSize;
//		this.total = total;
//	}

}

