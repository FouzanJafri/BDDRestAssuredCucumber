package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pojo.Support;

@Data
public class User {

	private pojo.Data data;
	private Support support;
	
	
	public pojo.Data getData() {
		return data;
	}
	
	public void setData(pojo.Data data) {
		this.data = data;
	}
	public Support getSupport() {
		return support;
	}
	public void setSupport(Support support) {
		this.support = support;
	}
	
	
	

}
