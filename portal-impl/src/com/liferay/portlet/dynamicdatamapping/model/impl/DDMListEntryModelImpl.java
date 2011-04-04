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

package com.liferay.portlet.dynamicdatamapping.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.dynamicdatamapping.model.DDMListEntry;
import com.liferay.portlet.dynamicdatamapping.model.DDMListEntryModel;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the DDMListEntry service. Represents a row in the &quot;DDMListEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.dynamicdatamapping.model.DDMListEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMListEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMListEntryImpl
 * @see com.liferay.portlet.dynamicdatamapping.model.DDMListEntry
 * @see com.liferay.portlet.dynamicdatamapping.model.DDMListEntryModel
 * @generated
 */
public class DDMListEntryModelImpl extends BaseModelImpl<DDMListEntry>
	implements DDMListEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a d d m list entry model instance should use the {@link com.liferay.portlet.dynamicdatamapping.model.DDMListEntry} interface instead.
	 */
	public static final String TABLE_NAME = "DDMListEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "listEntryId", Types.BIGINT },
			{ "listId", Types.BIGINT },
			{ "classPK", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table DDMListEntry (uuid_ VARCHAR(75) null,listEntryId LONG not null primary key,listId LONG,classPK LONG)";
	public static final String TABLE_SQL_DROP = "drop table DDMListEntry";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMListEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMListEntry"),
			true);

	public Class<?> getModelClass() {
		return DDMListEntry.class;
	}

	public String getModelClassName() {
		return DDMListEntry.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.dynamicdatamapping.model.DDMListEntry"));

	public DDMListEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _listEntryId;
	}

	public void setPrimaryKey(long pk) {
		setListEntryId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_listEntryId);
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getListEntryId() {
		return _listEntryId;
	}

	public void setListEntryId(long listEntryId) {
		_listEntryId = listEntryId;
	}

	public long getListId() {
		return _listId;
	}

	public void setListId(long listId) {
		_listId = listId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public DDMListEntry toEscapedModel() {
		if (isEscapedModel()) {
			return (DDMListEntry)this;
		}
		else {
			return (DDMListEntry)Proxy.newProxyInstance(DDMListEntry.class.getClassLoader(),
				new Class[] { DDMListEntry.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DDMListEntry.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		DDMListEntryImpl ddmListEntryImpl = new DDMListEntryImpl();

		ddmListEntryImpl.setUuid(getUuid());
		ddmListEntryImpl.setListEntryId(getListEntryId());
		ddmListEntryImpl.setListId(getListId());
		ddmListEntryImpl.setClassPK(getClassPK());

		ddmListEntryImpl.resetOriginalValues();

		return ddmListEntryImpl;
	}

	public int compareTo(DDMListEntry ddmListEntry) {
		long pk = ddmListEntry.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DDMListEntry ddmListEntry = null;

		try {
			ddmListEntry = (DDMListEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = ddmListEntry.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public void resetOriginalValues() {
	}

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", listEntryId=");
		sb.append(getListEntryId());
		sb.append(", listId=");
		sb.append(getListId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.dynamicdatamapping.model.DDMListEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listEntryId</column-name><column-value><![CDATA[");
		sb.append(getListEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listId</column-name><column-value><![CDATA[");
		sb.append(getListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _listEntryId;
	private long _listId;
	private long _classPK;
	private transient ExpandoBridge _expandoBridge;
}