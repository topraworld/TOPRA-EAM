/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/
package org.eam.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for AM_AssetMeterLogDocLine
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3
 */
public interface I_AM_AssetMeterLogDocLine 
{

    /** TableName=AM_AssetMeterLogDocLine */
    public static final String Table_Name = "AM_AssetMeterLogDocLine";

    /** AD_Table_ID=1000024 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name A_Asset_ID */
    public static final String COLUMNNAME_A_Asset_ID = "A_Asset_ID";

	/** Set Fixed Asset.
	  * Fixed Asset used internally or by customers
	  */
	public void setA_Asset_ID (int A_Asset_ID);

	/** Get Fixed Asset.
	  * Fixed Asset used internally or by customers
	  */
	public int getA_Asset_ID();

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException;

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AM_AssetMeter_ID */
    public static final String COLUMNNAME_AM_AssetMeter_ID = "AM_AssetMeter_ID";

	/** Set AM Asset Meter	  */
	public void setAM_AssetMeter_ID (int AM_AssetMeter_ID);

	/** Get AM Asset Meter	  */
	public int getAM_AssetMeter_ID();

	public org.eam.model.I_AM_AssetMeter getAM_AssetMeter() throws RuntimeException;

    /** Column name AM_AssetMeter_Log_ID */
    public static final String COLUMNNAME_AM_AssetMeter_Log_ID = "AM_AssetMeter_Log_ID";

	/** Set AM Asset Meter Log	  */
	public void setAM_AssetMeter_Log_ID (int AM_AssetMeter_Log_ID);

	/** Get AM Asset Meter Log	  */
	public int getAM_AssetMeter_Log_ID();

    /** Column name AM_AssetMeterLogDoc_ID */
    public static final String COLUMNNAME_AM_AssetMeterLogDoc_ID = "AM_AssetMeterLogDoc_ID";

	/** Set AM_AssetMeterLogDoc ID	  */
	public void setAM_AssetMeterLogDoc_ID (int AM_AssetMeterLogDoc_ID);

	/** Get AM_AssetMeterLogDoc ID	  */
	public int getAM_AssetMeterLogDoc_ID();

    /** Column name AM_AssetMeterLogDocLine_ID */
    public static final String COLUMNNAME_AM_AssetMeterLogDocLine_ID = "AM_AssetMeterLogDocLine_ID";

	/** Set AM_AssetMeterLogDocLine ID	  */
	public void setAM_AssetMeterLogDocLine_ID (int AM_AssetMeterLogDocLine_ID);

	/** Get AM_AssetMeterLogDocLine ID	  */
	public int getAM_AssetMeterLogDocLine_ID();

    /** Column name AM_Meter_ID */
    public static final String COLUMNNAME_AM_Meter_ID = "AM_Meter_ID";

	/** Set AM Meter	  */
	public void setAM_Meter_ID (int AM_Meter_ID);

	/** Get AM Meter	  */
	public int getAM_Meter_ID();

	public org.eam.model.I_AM_Meter getAM_Meter() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Line */
    public static final String COLUMNNAME_Line = "Line";

	/** Set Line No.
	  * Unique line for this document
	  */
	public void setLine (int Line);

	/** Get Line No.
	  * Unique line for this document
	  */
	public int getLine();

    /** Column name Reading */
    public static final String COLUMNNAME_Reading = "Reading";

	/** Set Reading	  */
	public void setReading (BigDecimal Reading);

	/** Get Reading	  */
	public BigDecimal getReading();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name UUID */
    public static final String COLUMNNAME_UUID = "UUID";

	/** Set Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID);

	/** Get Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public String getUUID();
}
