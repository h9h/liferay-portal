/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.documentlibrary.util;

import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * <a href="HookFactory.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class HookFactory {

	public static Hook getInstance() {
		if (_hook == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Instantiate " + PropsValues.DL_HOOK_IMPL);
			}

			_hook = (Hook)InstancePool.get(PropsValues.DL_HOOK_IMPL);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Return " + _hook.getClass().getName());
		}

		return _hook;
	}

	public static void setInstance(Hook hook) {
		if (_log.isDebugEnabled()) {
			_log.debug("Set " + hook.getClass().getName());
		}

		_hook = hook;
	}

	private static Log _log = LogFactoryUtil.getLog(HookFactory.class);

	private static Hook _hook = null;

}