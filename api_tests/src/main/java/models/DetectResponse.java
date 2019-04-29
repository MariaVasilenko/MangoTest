package models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Generated("com.robohorse.robopojogenerator")
public class DetectResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("lang")
	private String lang;
}