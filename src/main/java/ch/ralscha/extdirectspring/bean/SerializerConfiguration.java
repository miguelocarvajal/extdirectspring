/**
 * Copyright 2010-2016 Ralph Schaer <ralphschaer@gmail.com>
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

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;

public class SerializerConfiguration {
	@JsonIgnore
	private Class<?> jsonView;

	private FilterProvider filterProvider;

	public Class<?> getJsonView() {
		return this.jsonView;
	}

	public void setJsonView(Class<?> jsonView) {
		this.jsonView = jsonView;
	}

	public FilterProvider getFilterProvider() {
		return this.filterProvider;
	}

	public void setFilterProvider(FilterProvider filterProvider) {
		this.filterProvider = filterProvider;
	}

	public void write(ObjectMapper objectMapper, List<Object> directResponses, ExtDirectResponse directResponse) throws JsonProcessingException {
		if (jsonView != null) {
			String jsonResult = objectMapper.writerWithView(jsonView)
					.writeValueAsString(directResponse.getResult());
			directResponses.add(new ExtDirectResponseRaw(directResponse, jsonResult));
		}
		else if (filterProvider != null) {
			String jsonResult = objectMapper.writer(filterProvider)
					.writeValueAsString(directResponse.getResult());
			directResponses.add(new ExtDirectResponseRaw(directResponse, jsonResult));
		}
		else {
			directResponses.add(directResponse);
		}
	}

	public Object write(ObjectMapper objectMapper, ExtDirectResponse directResponse) throws JsonProcessingException {
		if (jsonView != null) {
			String jsonResult = objectMapper.writerWithView(jsonView)
					.writeValueAsString(directResponse.getResult());
			return Collections
					.singleton(new ExtDirectResponseRaw(directResponse, jsonResult));
		}
		else if (filterProvider != null) {
			String jsonResult = objectMapper.writer(filterProvider)
					.writeValueAsString(directResponse.getResult());
			return Collections
					.singleton(new ExtDirectResponseRaw(directResponse, jsonResult));
		}
		else {
			return Collections.singleton(directResponse);
		}
	}
}
