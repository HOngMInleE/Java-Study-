package com.Wait_Notify_Data;

public class DataBox {

	private String data; 
	
	public synchronized String getData() {
		if(this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		String returnValue = data;
		System.out.println("ConsumerTread가 읽은 데이터: " + returnValue);
		
		data = null; 
		notify();
		return returnValue;
	}
	
	
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		this.data = data;
		System.out.println("ProducerThread가 읽은 데이터: " + data);
		
		notify();
	}
	
	
}
