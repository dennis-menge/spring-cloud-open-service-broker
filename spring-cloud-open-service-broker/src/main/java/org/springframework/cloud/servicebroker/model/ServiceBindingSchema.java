/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.servicebroker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Service binding JSON Schemas.
 *
 * @author sgunaratne@pivotal.io
 * @author Sam Gunaratne
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceBindingSchema {

	/**
	 * The JSON schema for configuration parameters when creating a service binding.
	 */
	@JsonProperty("create")
	private final MethodSchema createMethodSchema;

	private ServiceBindingSchema() {
		createMethodSchema = null;
	}

	private ServiceBindingSchema(MethodSchema createMethodSchema) {
		this.createMethodSchema = createMethodSchema;
	}

	public static ServiceBindingSchemaBuilder builder() {
		return new ServiceBindingSchemaBuilder();
	}

	public MethodSchema getCreateMethodSchema() {
		return this.createMethodSchema;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ServiceBindingSchema)) return false;
		ServiceBindingSchema that = (ServiceBindingSchema) o;
		return Objects.equals(createMethodSchema, that.createMethodSchema);
	}

	@Override
	public int hashCode() {
		return Objects.hash(createMethodSchema);
	}

	@Override
	public String toString() {
		return "ServiceBindingSchema{" +
				"createMethodSchema=" + createMethodSchema +
				'}';
	}

	public static class ServiceBindingSchemaBuilder {
		private MethodSchema createMethodSchema;

		ServiceBindingSchemaBuilder() {
		}

		public ServiceBindingSchema.ServiceBindingSchemaBuilder createMethodSchema(MethodSchema createMethodSchema) {
			this.createMethodSchema = createMethodSchema;
			return this;
		}

		public ServiceBindingSchema build() {
			return new ServiceBindingSchema(createMethodSchema);
		}
	}
}