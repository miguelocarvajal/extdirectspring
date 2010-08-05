/**
 * Copyright 2010 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.ralscha.extdirectspring.bean;

import org.codehaus.jackson.annotate.JsonWriteNullProperties;

/**
 * Class representing the response of a poll request
 * 
 * @author Ralph Schaer
 */
public class ExtDirectPollResponse {

  private String type;
  private String name;
  private Object data;
  private String message;
  private String where;

  public ExtDirectPollResponse() {
    type = "event";
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Object getData() {
    return data;
  }

  public void setData(final Object data) {
    this.data = data;
  }

  @JsonWriteNullProperties(false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @JsonWriteNullProperties(false)
  public String getWhere() {
    return where;
  }

  public void setWhere(String where) {
    this.where = where;
  }

  @Override
  public String toString() {
    return "ExtDirectPollResponse [type=" + type + ", name=" + name + ", data=" + data + ", message=" + message
        + ", where=" + where + "]";
  }

}