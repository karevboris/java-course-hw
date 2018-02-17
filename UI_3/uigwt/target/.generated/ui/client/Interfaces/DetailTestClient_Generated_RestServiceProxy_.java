package ui.client.Interfaces;

public class DetailTestClient_Generated_RestServiceProxy_ implements ui.client.Interfaces.DetailTestClient, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("/api/detailTest");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void add(ui.shared.DetailTestGWT detailTestGWT, org.fusesource.restygwt.client.MethodCallback<ui.shared.DetailTestGWT> callback) {
    final ui.shared.DetailTestGWT final_detailTestGWT = detailTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(detailTestGWT));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.DetailTestGWT>(__method, callback) {
        protected ui.shared.DetailTestGWT parseResult() throws Exception {
          try {
            return ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void delete(ui.shared.DetailTestGWT detailTestGWT, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final ui.shared.DetailTestGWT final_detailTestGWT = detailTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(detailTestGWT));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Integer>(__method, callback) {
        protected java.lang.Integer parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void deleteById(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Integer>(__method, callback) {
        protected java.lang.Integer parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void get(int id, org.fusesource.restygwt.client.MethodCallback<ui.shared.DetailTestGWT> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.DetailTestGWT>(__method, callback) {
        protected ui.shared.DetailTestGWT parseResult() throws Exception {
          try {
            return ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getAll(org.fusesource.restygwt.client.MethodCallback<java.util.List<ui.shared.DetailTestGWT>> callback) {
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<ui.shared.DetailTestGWT>>(__method, callback) {
        protected java.util.List<ui.shared.DetailTestGWT> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void update(ui.shared.DetailTestGWT detailTestGWT, org.fusesource.restygwt.client.MethodCallback<ui.shared.DetailTestGWT> callback) {
    final ui.shared.DetailTestGWT final_detailTestGWT = detailTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/update")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(detailTestGWT));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.DetailTestGWT>(__method, callback) {
        protected ui.shared.DetailTestGWT parseResult() throws Exception {
          try {
            return ui.shared.DetailTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}
