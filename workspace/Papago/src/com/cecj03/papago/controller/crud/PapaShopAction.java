package com.cecj03.papago.controller.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.PriceType;
import com.cecj03.papago.model.ShopStatusType;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.crud.services.PapaShopService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaShopAction extends ActionSupport implements
		ServletRequestAware {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.request = request;
	}

	private PapaShop bean;
	private ShopType st;
	private ShopStatusType sst;
	private PriceType pt;
	private String papaAction;
	PapaShopService service;

	public void setService(PapaShopService service) {
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
			bean.setShopPic(temp);
			System.out.println("we've set the dm file");
		} else {
			bean.setShopPic(null);
			System.out.println("there's no file uploaded");
		}
		
		//商家的Crud 
		if (papaAction != null && papaAction.equals("Select")) {
			List<PapaShop> result = service.select(bean);
			request.setAttribute("select", result);
			return Action.SUCCESS;

		} else if (papaAction != null && papaAction.equals("Insert")) {

			bean.setShopDate(new Timestamp(new java.util.Date().getTime()));
			bean.setPriceType(pt);
			bean.setShopStatusType(sst);
			bean.setShopType(st);
			PapaShop result = service.insertShop(bean);

			if (result != null) {
				request.setAttribute("insert", result);
				return Action.INPUT;
			} else {
				this.addFieldError("action",
						this.getText("papashopForm.insert.fail"));
				return Action.INPUT;
			}
		} else if (papaAction != null && papaAction.equals("Update")){
			bean.setShopDate(new Timestamp(new java.util.Date().getTime()));
			bean.setPriceType(pt);
			bean.setShopStatusType(sst);
			bean.setShopType(st);
			PapaShop result = service.updateShop(bean);
			
			if (result != null) {
				request.setAttribute("update", result);
				return "RUDsuccess";
			} else {
				this.addFieldError("action",
						this.getText("papashopForm.update.fail"));
				return "RUDfaill";
			}
		}else if(papaAction!=null && papaAction.equals("Delete")) {
			System.out.println(bean.getShopId());
			boolean result = service.deleteShop(bean.getShopId());
			if(result) {
				request.setAttribute("delete", result);
				this.addFieldError("action",
						this.getText("productForm.delete.success"));
				return "RUDsuccess";
			} else {
				this.addFieldError("action",
						this.getText("productForm.delete.fail"));
			}
			return "RUDfaill";	
		}
			this.addFieldError("action",
					this.getText("papashopForm.action.unknown"));
		
		return Action.INPUT;
	}

	public PapaShop getBean() {
		return bean;
	}

	public void setBean(PapaShop bean) {
		this.bean = bean;
	}

	public String getPapaAction() {
		return papaAction;
	}

	public void setPapaAction(String papaAction) {
		this.papaAction = papaAction;
	}

	public ShopType getSt() {
		return st;
	}

	public void setSt(ShopType st) {
		this.st = st;
	}

	public ShopStatusType getSst() {
		return sst;
	}

	public void setSst(ShopStatusType sst) {
		this.sst = sst;
	}

	public PriceType getPt() {
		return pt;
	}

	public void setPt(PriceType pt) {
		this.pt = pt;
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
	
}
