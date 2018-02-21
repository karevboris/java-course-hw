package ui.shared;

public class DetailTestGWT_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ui.shared.DetailTestGWT> {
  
  public static final DetailTestGWT_Generated_JsonEncoderDecoder_ INSTANCE = new DetailTestGWT_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ui.shared.DetailTestGWT value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ui.shared.DetailTestGWT parseValue = (ui.shared.DetailTestGWT)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getCountPassed()), rc, "countPassed");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getCountFailed()), rc, "countFailed");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.DOUBLE.encode(parseValue.getResult()), rc, "result");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getAttempts()), rc, "attempts");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getDate()), rc, "date");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.BOOLEAN.encode(parseValue.getPassed()), rc, "passed");
    return rc;
  }
  
  public ui.shared.DetailTestGWT decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    // We found a creator so we use the annotated constructor
    ui.shared.DetailTestGWT rc = new ui.shared.DetailTestGWT(
      // The arguments are placed in the order they appear within the annotated constructor
      object.get("id") == null || object.get("id") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), 
      object.get("countPassed") == null || object.get("countPassed") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("countPassed")), 
      object.get("countFailed") == null || object.get("countFailed") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("countFailed")), 
      object.get("result") == null || object.get("result") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.DOUBLE.decode(object.get("result")), 
      object.get("attempts") == null || object.get("attempts") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("attempts")), 
      object.get("date") == null || object.get("date") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("date"))
    );
    rc.setName(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name")), null));
    rc.setPassed(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.BOOLEAN.decode(object.get("passed")), null));
    return rc;
  }
  
}
