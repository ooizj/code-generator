package #BASE_PACKAGE#.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StdResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code = BaseCode.SUCCESS.getCode();
	private String message = BaseCode.SUCCESS.getMessage();
	private T data;

	public StdResult(IBaseCode code, T data){
		this.code = code.getCode();
		this.message = code.getMessage();
		this.data = data;
	}

	public static <T> StdResult<T> success(T data){
		return new StdResult<>(BaseCode.SUCCESS, data);
	}
}