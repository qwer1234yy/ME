package common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ControlResponse <T> implements Serializable{
	private int status;
	private String msg;
	private T data;
	
	private ControlResponse(int status){
		this.status = status;
		}
		private ControlResponse(int status,T data){
		this.status = status;
		this.data = data;
		}
		private ControlResponse(int status,T data,String msg){
		this.status = status;
		this.data = data;
		this.msg = msg;
		}
		private ControlResponse(int status,String msg){
		this.status = status;
		this.msg = msg;
		}
		@JsonIgnore
		//使之不在json序列化之内
		public boolean isSuccess(){
		return this.status == ResponseCode.SUCCESS.getCode();
		}
		public int getStatus(){
		return status;
		}
		public T getData(){
		return data;
		}
		public String getMsg(){
		return msg;
		}

		public static <T> ControlResponse<T> createBySuccess(){
		return new ControlResponse<T>(ResponseCode.SUCCESS.getCode());
		}
		public static <T> ControlResponse<T> createBySuccessMessage(String msg){
		return new ControlResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
		}
		public static <T> ControlResponse<T> createBySuccess(T data){
		return new ControlResponse<T>(ResponseCode.SUCCESS.getCode(),data);
		}
		public static <T> ControlResponse<T> createBySuccess(String msg,T data){
		return new ControlResponse<T>(ResponseCode.SUCCESS.getCode(),data,msg);
		}
		public static <T> ControlResponse<T> createByError(){
		return new ControlResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
		}
		public static <T> ControlResponse<T> createByErrorMessage(String errorMessage){
		return new ControlResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
		}
		public static <T> ControlResponse<T> createByErrorCodeMessage(int erroeCode,String errorMessage){
		return new ControlResponse<T>(erroeCode,errorMessage);
		}
}
