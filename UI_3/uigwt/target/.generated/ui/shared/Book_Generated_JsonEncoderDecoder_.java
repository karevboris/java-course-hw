package ui.shared;

public class Book_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ui.shared.Book> {
  
  public static final Book_Generated_JsonEncoderDecoder_ INSTANCE = new Book_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ui.shared.Book value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ui.shared.Book parseValue = (ui.shared.Book)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getNumPages()), rc, "numPages");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getAuthor()), rc, "author");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getDatePublhn()), rc, "datePublhn");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getDate()), rc, "date");
    return rc;
  }
  
  public ui.shared.Book decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    // We found a creator so we use the annotated constructor
    ui.shared.Book rc = new ui.shared.Book(
      // The arguments are placed in the order they appear within the annotated constructor
      object.get("id") == null || object.get("id") instanceof com.google.gwt.json.client.JSONNull ? 0 : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), 
      object.get("name") == null || object.get("name") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name")), 
      object.get("numPages") == null || object.get("numPages") instanceof com.google.gwt.json.client.JSONNull ? 0 : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("numPages")), 
      object.get("author") == null || object.get("author") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("author")), 
      object.get("datePublhn") == null || object.get("datePublhn") instanceof com.google.gwt.json.client.JSONNull ? 0 : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("datePublhn")), 
      object.get("date") == null || object.get("date") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("date"))
    );
    return rc;
  }
  
}
