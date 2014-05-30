package com.cecj03.papago.controller.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.crud.services.PapaMemCrudService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaMemAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.request = request;
	}

	// 型別
	private PapaMem entity;
	private int type;
	private int status;

	private String crudAction;

	// injection setter on Spring
	private PapaMemCrudService service;

	public void setService(PapaMemCrudService service) {
		this.service = service;
	}

	// set attributes for image file
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	@Override
	public String execute() throws Exception {

		// 檢查是否有上傳圖檔 有的話把圖檔轉成byte[] 並放入entity
		if (userImage != null && userImage.length() != 0) {
			byte[] temp = IOUtils.toByteArray(new FileInputStream(userImage
					.getPath()));
			entity.setMemPic(temp);
			System.out.println("we've set the dm file");
		} else {
			entity.setMemPic(null);
			System.out.println("there's no file uploaded");
		}
		if (crudAction != null && crudAction.equals("Insert")) {
			// set update time before create;
			entity.setMemDate(new Timestamp(new java.util.Date().getTime()));
			PapaMem result = service.createMem(entity, type, status);
			if (result != null) {
				request.setAttribute("insert",
						service.readById(result.getMemId()));
				return Action.SUCCESS;
			} else {
				System.out.println("失敗");
				this.addFieldError("action",
						this.getText("crud.form.insert.failed"));
			}
		}
		return Action.INPUT;
	}

	private File getImageFile(String imageId) {
		String filePath = request.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + "/Image/", imageId);
		System.out.println(file.toString());
		return file;
	}

	
	public PapaMem getEntity() {
		return entity;
	}

	public void setEntity(PapaMem entity) {
		this.entity = entity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public String getCrudAction() {
		return crudAction;
	}

	public void setCrudAction(String crudAction) {
		this.crudAction = crudAction;
	}

}
