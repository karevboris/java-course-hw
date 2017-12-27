package ui.shared;

public class Hello_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ui.shared.Hello> {
  
  public static final Hello_Generated_JsonEncoderDecoder_ INSTANCE = new Hello_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ui.shared.Hello value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ui.shared.Hello parseValue = (ui.shared.Hello)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    return rc;
  }
  
  public ui.shared.Hello decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    // We found a creator so we use the annotated constructor
    ui.shared.Hello rc = new ui.shared.Hello(
      // The arguments are placed in the order they appear within the annotated constructor
      object.get("id") == null || object.get("id") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("id")), 
      object.get("name") == null || object.get("name") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name"))
    );
    return rc;
  }
  
}
