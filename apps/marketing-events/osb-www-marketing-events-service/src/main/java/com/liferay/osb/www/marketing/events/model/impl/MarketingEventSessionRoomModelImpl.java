/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.osb.www.marketing.events.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoomModel;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoomSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MarketingEventSessionRoom service. Represents a row in the &quot;OSB_MarketingEventSessionRoom&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link MarketingEventSessionRoomModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MarketingEventSessionRoomImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoomImpl
 * @see MarketingEventSessionRoom
 * @see MarketingEventSessionRoomModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class MarketingEventSessionRoomModelImpl extends BaseModelImpl<MarketingEventSessionRoom>
	implements MarketingEventSessionRoomModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a marketing event session room model instance should use the {@link MarketingEventSessionRoom} interface instead.
	 */
	public static final String TABLE_NAME = "OSB_MarketingEventSessionRoom";
	public static final Object[][] TABLE_COLUMNS = {
			{ "marketingEventSessionRoomId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "marketingEventId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "imageFileEntryId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("marketingEventSessionRoomId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("marketingEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("imageFileEntryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table OSB_MarketingEventSessionRoom (marketingEventSessionRoomId LONG not null primary key,createDate DATE null,modifiedDate DATE null,marketingEventId LONG,name VARCHAR(75) null,imageFileEntryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table OSB_MarketingEventSessionRoom";
	public static final String ORDER_BY_JPQL = " ORDER BY marketingEventSessionRoom.marketingEventSessionRoomId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY OSB_MarketingEventSessionRoom.marketingEventSessionRoomId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.osb.www.marketing.events.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.osb.www.marketing.events.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.osb.www.marketing.events.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom"),
			true);
	public static final long MARKETINGEVENTID_COLUMN_BITMASK = 1L;
	public static final long MARKETINGEVENTSESSIONROOMID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MarketingEventSessionRoom toModel(
		MarketingEventSessionRoomSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MarketingEventSessionRoom model = new MarketingEventSessionRoomImpl();

		model.setMarketingEventSessionRoomId(soapModel.getMarketingEventSessionRoomId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setMarketingEventId(soapModel.getMarketingEventId());
		model.setName(soapModel.getName());
		model.setImageFileEntryId(soapModel.getImageFileEntryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MarketingEventSessionRoom> toModels(
		MarketingEventSessionRoomSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MarketingEventSessionRoom> models = new ArrayList<MarketingEventSessionRoom>(soapModels.length);

		for (MarketingEventSessionRoomSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.osb.www.marketing.events.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom"));

	public MarketingEventSessionRoomModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _marketingEventSessionRoomId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarketingEventSessionRoomId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marketingEventSessionRoomId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MarketingEventSessionRoom.class;
	}

	@Override
	public String getModelClassName() {
		return MarketingEventSessionRoom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marketingEventSessionRoomId",
			getMarketingEventSessionRoomId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("marketingEventId", getMarketingEventId());
		attributes.put("name", getName());
		attributes.put("imageFileEntryId", getImageFileEntryId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long marketingEventSessionRoomId = (Long)attributes.get(
				"marketingEventSessionRoomId");

		if (marketingEventSessionRoomId != null) {
			setMarketingEventSessionRoomId(marketingEventSessionRoomId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long marketingEventId = (Long)attributes.get("marketingEventId");

		if (marketingEventId != null) {
			setMarketingEventId(marketingEventId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}
	}

	@JSON
	@Override
	public long getMarketingEventSessionRoomId() {
		return _marketingEventSessionRoomId;
	}

	@Override
	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId) {
		_marketingEventSessionRoomId = marketingEventSessionRoomId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getMarketingEventId() {
		return _marketingEventId;
	}

	@Override
	public void setMarketingEventId(long marketingEventId) {
		_columnBitmask |= MARKETINGEVENTID_COLUMN_BITMASK;

		if (!_setOriginalMarketingEventId) {
			_setOriginalMarketingEventId = true;

			_originalMarketingEventId = _marketingEventId;
		}

		_marketingEventId = marketingEventId;
	}

	public long getOriginalMarketingEventId() {
		return _originalMarketingEventId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	@Override
	public void setImageFileEntryId(long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MarketingEventSessionRoom.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MarketingEventSessionRoom toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MarketingEventSessionRoom)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MarketingEventSessionRoomImpl marketingEventSessionRoomImpl = new MarketingEventSessionRoomImpl();

		marketingEventSessionRoomImpl.setMarketingEventSessionRoomId(getMarketingEventSessionRoomId());
		marketingEventSessionRoomImpl.setCreateDate(getCreateDate());
		marketingEventSessionRoomImpl.setModifiedDate(getModifiedDate());
		marketingEventSessionRoomImpl.setMarketingEventId(getMarketingEventId());
		marketingEventSessionRoomImpl.setName(getName());
		marketingEventSessionRoomImpl.setImageFileEntryId(getImageFileEntryId());

		marketingEventSessionRoomImpl.resetOriginalValues();

		return marketingEventSessionRoomImpl;
	}

	@Override
	public int compareTo(MarketingEventSessionRoom marketingEventSessionRoom) {
		long primaryKey = marketingEventSessionRoom.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSessionRoom)) {
			return false;
		}

		MarketingEventSessionRoom marketingEventSessionRoom = (MarketingEventSessionRoom)obj;

		long primaryKey = marketingEventSessionRoom.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		MarketingEventSessionRoomModelImpl marketingEventSessionRoomModelImpl = this;

		marketingEventSessionRoomModelImpl._setModifiedDate = false;

		marketingEventSessionRoomModelImpl._originalMarketingEventId = marketingEventSessionRoomModelImpl._marketingEventId;

		marketingEventSessionRoomModelImpl._setOriginalMarketingEventId = false;

		marketingEventSessionRoomModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MarketingEventSessionRoom> toCacheModel() {
		MarketingEventSessionRoomCacheModel marketingEventSessionRoomCacheModel = new MarketingEventSessionRoomCacheModel();

		marketingEventSessionRoomCacheModel.marketingEventSessionRoomId = getMarketingEventSessionRoomId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			marketingEventSessionRoomCacheModel.createDate = createDate.getTime();
		}
		else {
			marketingEventSessionRoomCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			marketingEventSessionRoomCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			marketingEventSessionRoomCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		marketingEventSessionRoomCacheModel.marketingEventId = getMarketingEventId();

		marketingEventSessionRoomCacheModel.name = getName();

		String name = marketingEventSessionRoomCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			marketingEventSessionRoomCacheModel.name = null;
		}

		marketingEventSessionRoomCacheModel.imageFileEntryId = getImageFileEntryId();

		return marketingEventSessionRoomCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{marketingEventSessionRoomId=");
		sb.append(getMarketingEventSessionRoomId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", marketingEventId=");
		sb.append(getMarketingEventId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", imageFileEntryId=");
		sb.append(getImageFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>marketingEventSessionRoomId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventSessionRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>marketingEventId</column-name><column-value><![CDATA[");
		sb.append(getMarketingEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getImageFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = MarketingEventSessionRoom.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			MarketingEventSessionRoom.class
		};
	private long _marketingEventSessionRoomId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _marketingEventId;
	private long _originalMarketingEventId;
	private boolean _setOriginalMarketingEventId;
	private String _name;
	private long _imageFileEntryId;
	private long _columnBitmask;
	private MarketingEventSessionRoom _escapedModel;
}