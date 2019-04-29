package models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@Generated("com.robohorse.robopojogenerator")
public class DetectResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("lang")
	private String lang;
	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	@Override
	public String toString(){
		return
				"DetectResponse{" +
						"code = '" + code + '\'' +
						",lang = '" + lang + '\'' +
						"}";
	}
}