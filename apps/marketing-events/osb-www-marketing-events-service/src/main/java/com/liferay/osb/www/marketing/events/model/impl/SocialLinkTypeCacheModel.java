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

import com.liferay.osb.www.marketing.events.model.SocialLinkType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialLinkType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkType
 * @generated
 */
@ProviderType
public class SocialLinkTypeCacheModel implements CacheModel<SocialLinkType>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialLinkTypeCacheModel)) {
			return false;
		}

		SocialLinkTypeCacheModel socialLinkTypeCacheModel = (SocialLinkTypeCacheModel)obj;

		if (socialLinkTypeId == socialLinkTypeCacheModel.socialLinkTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, socialLinkTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{socialLinkTypeId=");
		sb.append(socialLinkTypeId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialLinkType toEntityModel() {
		SocialLinkTypeImpl socialLinkTypeImpl = new SocialLinkTypeImpl();

		socialLinkTypeImpl.setSocialLinkTypeId(socialLinkTypeId);
		socialLinkTypeImpl.setUserId(userId);

		if (userName == null) {
			socialLinkTypeImpl.setUserName("");
		}
		else {
			socialLinkTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			socialLinkTypeImpl.setCreateDate(null);
		}
		else {
			socialLinkTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialLinkTypeImpl.setModifiedDate(null);
		}
		else {
			socialLinkTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			socialLinkTypeImpl.setName("");
		}
		else {
			socialLinkTypeImpl.setName(name);
		}

		socialLinkTypeImpl.setImageFileEntryId(imageFileEntryId);

		socialLinkTypeImpl.resetOriginalValues();

		return socialLinkTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		socialLinkTypeId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(socialLinkTypeId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(imageFileEntryId);
	}

	public long socialLinkTypeId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long imageFileEntryId;
}