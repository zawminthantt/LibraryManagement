
package com.ictti.library.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts.upload.FormFile;

public class UploadFileUtil {
    
    private static final String IMGDIR ="public/upload";    
    
    private ServletContext context;
    
    /*public UploadFileUtil(ServletContext ctx){
        context = ctx;
    }*/
    
    /**
     * get file directory + file name under the application path
     * 
     * @param baseName
     * @return
     */
    public String getFilePath(String baseName) {
        //Directory to be uploaded
        String filePath = IMGDIR + "/" + baseName;
        return filePath;
    }

    /**
     * write updated data to the specified directory + filename
     * 
     * @param filePath	directory + file name
     * @param fForm		Struts form which contains uploaded data
     * @throws IOException
     */
    public static void write(String filePath, FormFile fForm) throws IOException { 
        
        //1)Get absolute path from ServletContext
        //String realPath = context.getRealPath(filePath);
        OutputStream out = new FileOutputStream(filePath);
        
        //2)Write uploaded file using FormFile
        out.write(fForm.getFileData(), 0, fForm.getFileSize());
        out.close();
    }
    
}
