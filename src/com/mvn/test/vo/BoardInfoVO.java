package com.mvn.test.vo;

import lombok.Data;

@Data
public class BoardInfoVO {
	private Integer biNum;
	private String biTitle;
	private String biContent;
	private Integer uiNwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
}
