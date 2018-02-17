package ui.client.Interfaces;

public class UserTestClient_Generated_RestServiceProxy_ implements ui.client.Interfaces.UserTestClient, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("/api/userTest");
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
  public void add(ui.shared.UserTestGWT userTestGWT, org.fusesource.restygwt.client.MethodCallback<ui.shared.UserTestGWT> callback) {
    final ui.shared.UserTestGWT final_userTestGWT = userTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(userTestGWT));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.UserTestGWT>(__method, callback) {
        protected ui.shared.UserTestGWT parseResult() throws Exception {
          try {
            return ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void delete(ui.shared.UserTestGWT userTestGWT, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final ui.shared.UserTestGWT final_userTestGWT = userTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(userTestGWT));
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
  public void deleteAllTestByTestId(int id, org.fusesource.restygwt.client.MethodCallback callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/testDelete/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Object>(__method, callback) {
        protected java.lang.Object parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.ObjectEncoderDecoder.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void deleteAllUserByUserId(int id, org.fusesource.restygwt.client.MethodCallback callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/userDelete/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Object>(__method, callback) {
        protected java.lang.Object parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.ObjectEncoderDecoder.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
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
  public void deleteDetailTestByTestId(int id, org.fusesource.restygwt.client.MethodCallback callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/detailDelete/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Object>(__method, callback) {
        protected java.lang.Object parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.ObjectEncoderDecoder.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void deleteDetailTestByUserId(int id, org.fusesource.restygwt.client.MethodCallback callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/detailDeleteByUser/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Object>(__method, callback) {
        protected java.lang.Object parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.ObjectEncoderDecoder.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void get(int id, org.fusesource.restygwt.client.MethodCallback<ui.shared.UserTestGWT> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.UserTestGWT>(__method, callback) {
        protected ui.shared.UserTestGWT parseResult() throws Exception {
          try {
            return ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getAll(org.fusesource.restygwt.client.MethodCallback<java.util.List<ui.shared.UserTestGWT>> callback) {
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<ui.shared.UserTestGWT>>(__method, callback) {
        protected java.util.List<ui.shared.UserTestGWT> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getCountPassedTests(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/countPassedTest/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
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
  public void getCountPassedUsers(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/countPassedUser/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
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
  public void getCountTests(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/countTests/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
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
  public void getCountUsers(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Integer> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/countUsers/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
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
  public void getDetailTest(ui.shared.UserTestGWT userTestGWT, org.fusesource.restygwt.client.MethodCallback<ui.shared.DetailTestGWT> callback) {
    final ui.shared.UserTestGWT final_userTestGWT = userTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/detail")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(userTestGWT));
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
  public void getPercentPassedTests(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Double> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/percentPassedTest/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Double>(__method, callback) {
        protected java.lang.Double parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.DOUBLE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getPercentPassedUsers(int id, org.fusesource.restygwt.client.MethodCallback<java.lang.Double> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/percentPassedUser/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Double>(__method, callback) {
        protected java.lang.Double parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.DOUBLE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getTests(int id, org.fusesource.restygwt.client.MethodCallback<java.util.List<ui.shared.TestGWT>> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/test/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<ui.shared.TestGWT>>(__method, callback) {
        protected java.util.List<ui.shared.TestGWT> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), ui.shared.TestGWT_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getUserTest(int userId, int testId, org.fusesource.restygwt.client.MethodCallback<ui.shared.UserTestGWT> callback) {
    final int final_userId = userId;
    final int final_testId = testId;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/read/"+(""+userId== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+userId))+"/"+(""+testId== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+testId))+"/")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.UserTestGWT>(__method, callback) {
        protected ui.shared.UserTestGWT parseResult() throws Exception {
          try {
            return ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getUsers(int id, org.fusesource.restygwt.client.MethodCallback<java.util.List<ui.shared.UserGWT>> callback) {
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/user/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<ui.shared.UserGWT>>(__method, callback) {
        protected java.util.List<ui.shared.UserGWT> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), ui.shared.UserGWT_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void update(ui.shared.UserTestGWT userTestGWT, org.fusesource.restygwt.client.MethodCallback<ui.shared.UserTestGWT> callback) {
    final ui.shared.UserTestGWT final_userTestGWT = userTestGWT;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/update")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.encode(userTestGWT));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<ui.shared.UserTestGWT>(__method, callback) {
        protected ui.shared.UserTestGWT parseResult() throws Exception {
          try {
            return ui.shared.UserTestGWT_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
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
