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

/** Generated Interface for AM_CalenderSchedule
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3
 */
public interface I_AM_CalenderSchedule 
{

    /** TableName=AM_CalenderSchedule */
    public static final String Table_Name = "AM_CalenderSchedule";

    /** AD_Table_ID=1000021 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

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

    /** Column name AM_CalenderSchedule_ID */
    public static final String COLUMNNAME_AM_CalenderSchedule_ID = "AM_CalenderSchedule_ID";

	/** Set AM_CalenderSchedule ID	  */
	public void setAM_CalenderSchedule_ID (int AM_CalenderSchedule_ID);

	/** Get AM_CalenderSchedule ID	  */
	public int getAM_CalenderSchedule_ID();

    /** Column name AM_Maintenance_ID */
    public static final String COLUMNNAME_AM_Maintenance_ID = "AM_Maintenance_ID";

	/** Set AM Maintenance	  */
	public void setAM_Maintenance_ID (int AM_Maintenance_ID);

	/** Get AM Maintenance	  */
	public int getAM_Maintenance_ID();

	public org.eam.model.I_AM_Maintenance getAM_Maintenance() throws RuntimeException;

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

    /** Column name DateActualFinished */
    public static final String COLUMNNAME_DateActualFinished = "DateActualFinished";

	/** Set Actual Finish Date	  */
	public void setDateActualFinished (Timestamp DateActualFinished);

	/** Get Actual Finish Date	  */
	public Timestamp getDateActualFinished();

    /** Column name DateScheduled */
    public static final String COLUMNNAME_DateScheduled = "DateScheduled";

	/** Set Scheduled Date	  */
	public void setDateScheduled (Timestamp DateScheduled);

	/** Get Scheduled Date	  */
	public Timestamp getDateScheduled();

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

    /** Column name DuePercentage */
    public static final String COLUMNNAME_DuePercentage = "DuePercentage";

	/** Set Due Percentage %	  */
	public void setDuePercentage (BigDecimal DuePercentage);

	/** Get Due Percentage %	  */
	public BigDecimal getDuePercentage();

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

    /** Column name IsWOGeneratable */
    public static final String COLUMNNAME_IsWOGeneratable = "IsWOGeneratable";

	/** Set Generate Work Order	  */
	public void setIsWOGeneratable (boolean IsWOGeneratable);

	/** Get Generate Work Order	  */
	public boolean isWOGeneratable();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name Status */
    public static final String COLUMNNAME_Status = "Status";

	/** Set Status.
	  * Status of the currently running check
	  */
	public void setStatus (String Status);

	/** Get Status.
	  * Status of the currently running check
	  */
	public String getStatus();

    /** Column name Type */
    public static final String COLUMNNAME_Type = "Type";

	/** Set Type.
	  * Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type);

	/** Get Type.
	  * Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType();

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
