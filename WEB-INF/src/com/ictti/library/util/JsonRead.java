package com.ictti.library.util;

import com.ictti.library.presentation.form.AmazonBeanForm;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class JsonRead {
	public AmazonBeanForm getJsonElement(String xmlAmazon) {
		AmazonBeanForm bean = new AmazonBeanForm();
		// convert XML to JSON
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSONObject jsonObj = (JSONObject) xmlSerializer.read(xmlAmazon
				.toString());

		if (jsonObj.getJSONObject("Items").getJSONObject("Item").isNullObject()) {
			bean.setFrmFormControl("");
			bean.setFrmErrorMsg("The Book does not exist at AMAZON");
			return bean;
		}
		bean.setFrmFormControl("data");
		bean.setFrmErrorMsg(null);
		// get JsonObject until ItemAttributes
		JSONObject jsonObjItemAttributes = jsonObj.getJSONObject("Items")
				.getJSONObject("Item").getJSONObject("ItemAttributes");

		// set ISBN 10
		bean.setFrmRegISBN(jsonObjItemAttributes.getString("ISBN"));

		
		// set Book Author
		String strAuthor = "";
		if (jsonObjItemAttributes.has("Author")) {
			strAuthor = jsonObjItemAttributes.getString("Author");
			strAuthor = strAuthor.replace("\"", "").replace("[", "").replace(
					"]", "");
		} else {
			strAuthor = jsonObjItemAttributes.getString("Creator");
		}
		bean.setFrmRegAuthor1(strAuthor);

		// set Book Title
		bean.setFrmRegTitle(jsonObjItemAttributes.getString("Title"));

		// set Manufacturer
		bean.setFrmRegPublisher(jsonObjItemAttributes.getString("Publisher"));

		// set Publication Date
		bean.setFrmRegDate(jsonObjItemAttributes
				.getString("PublicationDate"));

		// set No of pages
		bean.setFrmRegPage(jsonObjItemAttributes.getString("NumberOfPages")
				);

		/*// set Price 
		bean.setFrmRegPrice(jsonObjItemAttributes.getJSONObject("ListPrice")
				.getString("FormattedPrice"));
*/
		//set Price 
		bean.setFrmRegPrice(jsonObjItemAttributes.getJSONObject("ListPrice")
				.getString("FormattedPrice"));
		// set size
		float h = Float
				.parseFloat(jsonObjItemAttributes.getJSONObject(
						"PackageDimensions").getJSONObject("Height").getString(
						"#text")) / 100;
		float l = Float
				.parseFloat(jsonObjItemAttributes.getJSONObject(
						"PackageDimensions").getJSONObject("Length").getString(
						"#text")) / 100;
		float w = Float.parseFloat(jsonObjItemAttributes.getJSONObject(
				"PackageDimensions").getJSONObject("Width").getString("#text")) / 100;
		bean.setFrmSize("" + l + " * " + w + " * " + h + " inches");

		// set photoPath
		bean.setFrmPhotoPath(jsonObj.getJSONObject("Items").getJSONObject(
				"Item").getJSONObject("MediumImage").getString("URL"));
		return bean;
	}

}