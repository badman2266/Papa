package com.cecj03.papago.controller.crud;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/xxx/gogo.action")
public class PapaShopImageServlet extends HttpServlet{
	private static final long serialVersionUID = 2827297299439162553L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//使用同一種處理方法
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		File tempFile = new File("C:/uploadtemp");
		//保存路徑
		String savePath = getServletContext().getRealPath("/upload");
		File saveDir = new File(savePath);
		System.out.print(savePath);
		// 如果目錄不存在，就創建目錄
		if(!saveDir.exists()){
			saveDir.mkdir();
		}
		if(!tempFile.exists()) {
		    tempFile.mkdir();
		}
		// 創建文件上傳核心類
		DiskFileItemFactory dff = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dff);
		dff.setSizeThreshold(1024*10);
		dff.setRepository(tempFile);
		
		
		try{
			// 處理表單請求
			List<FileItem> itemList = sfu.parseRequest(request);
			for (FileItem fileItem : itemList) {
				// 對應表單中的控件的name
				String fieldName = fileItem.getFieldName();
				System.out.println("控件名稱：" + fieldName);
				// 如果是普通表單控件
				if(fileItem.isFormField()){
					String value = fileItem.getString();
					//重新編碼,解决亂碼
					value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
					System.out.println("普通內容：" + fieldName + "=" + value);
				// 上傳文件
				}else{
					// 獲得文件大小
					Long size = fileItem.getSize();
					// 獲得文件名
					String fileName = fileItem.getName();
					System.out.println("文件名："+fileName+"\t大小：" + size + "byte");
					
					//設置不允許上傳的文件格式
					if(fileName.endsWith(".exe")){
						request.setAttribute("msg", "不允許上傳的類型！");
					}else{
						//將文件保存到指定的路徑
						File file = new File(savePath,fileName);
						fileItem.write(file);
						System.out.println(savePath);
						request.setAttribute("msg", "上傳成功！");
					}
				}
			}
		}catch(FileSizeLimitExceededException e){
			request.setAttribute("msg", "文件太大");
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		//上傳完畢後  轉發到首頁
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
}
