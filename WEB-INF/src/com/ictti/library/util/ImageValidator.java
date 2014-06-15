package com.ictti.library.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ImageValidator{
   private Pattern pattern;
   private Matcher matcher;
   
   private static final String IMAGE_PATTERN = 
                "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|jpeg))$)";

   public ImageValidator(){
	  pattern = Pattern.compile(IMAGE_PATTERN);
	 
   }
 
   /**
   * Validate image with regular expression
   * @param image image for validation
   * @return true valid image, false invalid image
   */
   public boolean validate(final String image){
	  matcher = pattern.matcher(image);
	  boolean flag= matcher.matches();
	  return flag;
 
   }


}
