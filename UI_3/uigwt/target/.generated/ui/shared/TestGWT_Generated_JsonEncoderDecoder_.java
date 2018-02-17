package ui.shared;

public class TestGWT_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ui.shared.TestGWT> {
  
  public static final TestGWT_Generated_JsonEncoderDecoder_ INSTANCE = new TestGWT_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ui.shared.TestGWT value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ui.shared.TestGWT parseValue = (ui.shared.TestGWT)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getUserId()), rc, "userId");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getCount()), rc, "count");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getPassed()), rc, "passed");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.DOUBLE.encode(parseValue.getPercent()), rc, "percent");
    return rc;
  }
  
  public ui.shared.TestGWT decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    // We found a creator so we use the annotated constructor
    ui.shared.TestGWT rc = new ui.shared.TestGWT(
      // The arguments are placed in the order they appear within the annotated constructor
      object.get("id") == null || object.get("id") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), 
      object.get("name") == null || object.get("name") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name")), 
      object.get("userId") == null || object.get("userId") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("userId"))
    );
    rc.setCount(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("count")), null));
    rc.setPassed(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("passed")), null));
    rc.setPercent(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.DOUBLE.decode(object.get("percent")), null));
    return rc;
  }
  
}
