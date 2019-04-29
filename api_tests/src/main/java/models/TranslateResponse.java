package models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Generated("com.robohorse.robopojogenerator")
public class TranslateResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("text")
	private List<String> text;

	@SerializedName("lang")
	private String lang;
}