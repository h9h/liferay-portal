/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsValues;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayResourceLoader extends ResourceLoader {

	public static void setListeners(String[] listeners) {
		_listeners = new VelocityResourceListener[listeners.length];

		for (int i = 0; i < listeners.length; i++) {
			try {
				_listeners[i] = (VelocityResourceListener)Class.forName(
					listeners[i]).newInstance();
			}
			catch (Exception ex) {
				_log.error(ex);

				_listeners[i] = null;
			}
		}
	}

	public long getLastModified(Resource resource) {
		if (_log.isDebugEnabled()) {
			_log.debug("Get last modified for " + resource.getName());
		}

		return 0;
	}

	public InputStream getResourceStream(String source)
		throws ResourceNotFoundException {

		if (_log.isDebugEnabled()) {
			_log.debug("Get resource for " + source);
		}

		InputStream is = null;

		for (int i = 0; (is == null) && (i < _listeners.length); i++) {
			if (_listeners[i] != null) {
				is = _listeners[i].getResourceStream(source);
			}
		}

		if (is == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Could not find " + source);
			}

			throw new ResourceNotFoundException(source);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Successfully got " + source);
		}

		return is;
	}

	public void init(ExtendedProperties props) {
		setCachingOn(
			PropsValues.VELOCITY_ENGINE_RESOURCE_MANAGER_CACHE_ENABLED);
		setModificationCheckInterval(
			PropsValues.
				VELOCITY_ENGINE_RESOURCE_MANAGER_MODIFICATION_CHECK_INTERVAL);
	}

	public boolean isSourceModified(Resource resource) {
		if (_log.isDebugEnabled()) {
			_log.debug("Check modified status for " + resource.getName());
		}

		return false;
	}

	public boolean resourceExists(String resourceName) {
        InputStream is = null;

        try {
            is = getResourceStream(resourceName);
        }
        catch (ResourceNotFoundException e) {
            if(_log.isDebugEnabled()) {
                _log.debug(
					"Could not load resource '" + resourceName +
					"' from ResourceLoader " + getClass().getName() + ": ", e);
			}
        }
		finally {
            try {
                if (is != null) {
                    is.close();
				}
            }
            catch (IOException e) {
			}
        }

		if (is != null) {
			return true;
		}
        else {
			return false;
		}
    }

	private static Log _log = LogFactoryUtil.getLog(
		LiferayResourceLoader.class);

	private static VelocityResourceListener[] _listeners =
		new VelocityResourceListener[0];

}