package ui.shared;

public class TestQuestGWT_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<ui.shared.TestQuestGWT> {
  
  public static final TestQuestGWT_Generated_JsonEncoderDecoder_ INSTANCE = new TestQuestGWT_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(ui.shared.TestQuestGWT value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    ui.shared.TestQuestGWT parseValue = (ui.shared.TestQuestGWT)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getQuestId()), rc, "questId");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getTestId()), rc, "testId");
    return rc;
  }
  
  public ui.shared.TestQuestGWT decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    // We found a creator so we use the annotated constructor
    ui.shared.TestQuestGWT rc = new ui.shared.TestQuestGWT(
      // The arguments are placed in the order they appear within the annotated constructor
      object.get("questId") == null || object.get("questId") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("questId")), 
      object.get("testId") == null || object.get("testId") instanceof com.google.gwt.json.client.JSONNull ? null : org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("testId"))
    );
    return rc;
  }
  
}
