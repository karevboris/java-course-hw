package ui.shared;

public class AnswerGWT_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ui.shared.AnswerGWT> {
  
  public static final AnswerGWT_Generated_JsonEncoderDecoder_ INSTANCE = new AnswerGWT_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ui.shared.AnswerGWT value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ui.shared.AnswerGWT parseValue = (ui.shared.AnswerGWT)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getText()), rc, "text");
    return rc;
  }
  
  public ui.shared.AnswerGWT decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    // We found a creator so we use the annotated constructor
    ui.shared.AnswerGWT rc = new ui.shared.AnswerGWT(
      // The arguments are placed in the order they appear within the annotated constructor
      object.get("id") == null || object.get("id") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), 
      object.get("text") == null || object.get("text") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("text"))
    );
    return rc;
  }
  
}
