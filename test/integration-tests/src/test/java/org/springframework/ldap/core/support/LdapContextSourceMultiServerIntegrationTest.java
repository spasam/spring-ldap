/*
 * Copyright 2005-2010 the original author or authors.
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
package org.springframework.ldap.core.support;

import static junit.framework.Assert.assertEquals;

import javax.naming.NamingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Advanced integration tests for LdapContextSource.
 * 
 * @author Mattias Hellborg Arthursson
 */
@ContextConfiguration(locations = { "/conf/ldapContextSourceTestContext.xml" })
public class LdapContextSourceMultiServerIntegrationTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private LdapContextSource tested;

	@Test
	public void testUrls() throws NamingException {
		String[] urls = tested.getUrls();
		String string = tested.assembleProviderUrlString(urls);

		assertEquals("ldap://127.0.0.1:389 ldap://127.0.0.2:389", string);
	}
}
