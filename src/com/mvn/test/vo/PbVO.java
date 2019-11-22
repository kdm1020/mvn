package com.mvn.test.vo;

import org.apache.commons.fileupload.FileItem;

import lombok.Data;

@Data
public class PbVO {
	private Integer pbNum;
	private String pbTitle;
	private String pbContent;
	private String pbImg1;
	private String pbImg2;
	private FileItem pbImgFile1;
	private FileItem pbImgFile2;
	private Integer creusr;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private Integer modusr;
	private Integer pbCnt;
}
