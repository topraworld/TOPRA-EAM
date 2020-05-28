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

/** Generated Interface for AM_Maintenance
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3
 */
public interface I_AM_Maintenance 
{

    /** TableName=AM_Maintenance */
    public static final String Table_Name = "AM_Maintenance";

    /** AD_Table_ID=54109 */
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

    /** Column name AD_Role_ID */
    public static final String COLUMNNAME_AD_Role_ID = "AD_Role_ID";

	/** Set Role.
	  * Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID);

	/** Get Role.
	  * Responsibility Role
	  */
	public int getAD_Role_ID();

	public org.compiere.model.I_AD_Role getAD_Role() throws RuntimeException;

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException;

    /** Column name AM_MaintenanceArea_ID */
    public static final String COLUMNNAME_AM_MaintenanceArea_ID = "AM_MaintenanceArea_ID";

	/** Set AM_MaintenanceArea ID	  */
	public void setAM_MaintenanceArea_ID (int AM_MaintenanceArea_ID);

	/** Get AM_MaintenanceArea ID	  */
	public int getAM_MaintenanceArea_ID();

	public org.eam.model.I_AM_MaintenanceArea getAM_MaintenanceArea() throws RuntimeException;

    /** Column name AM_MaintenanceParent_ID */
    public static final String COLUMNNAME_AM_MaintenanceParent_ID = "AM_MaintenanceParent_ID";

	/** Set AM Maintenance Parent	  */
	public void setAM_MaintenanceParent_ID (int AM_MaintenanceParent_ID);

	/** Get AM Maintenance Parent	  */
	public int getAM_MaintenanceParent_ID();

	public org.eam.model.I_AM_Maintenance getAM_MaintenanceParent() throws RuntimeException;

    /** Column name AM_MaintenancePatern_ID */
    public static final String COLUMNNAME_AM_MaintenancePatern_ID = "AM_MaintenancePatern_ID";

	/** Set AM_MaintenancePatern ID	  */
	public void setAM_MaintenancePatern_ID (int AM_MaintenancePatern_ID);

	/** Get AM_MaintenancePatern ID	  */
	public int getAM_MaintenancePatern_ID();

	public org.eam.model.I_AM_MaintenancePattern getAM_MaintenancePatern() throws RuntimeException;

    /** Column name AM_Maintenance_ID */
    public static final String COLUMNNAME_AM_Maintenance_ID = "AM_Maintenance_ID";

	/** Set AM Maintenance	  */
	public void setAM_Maintenance_ID (int AM_Maintenance_ID);

	/** Get AM Maintenance	  */
	public int getAM_Maintenance_ID();

    /** Column name AM_Meter_ID */
    public static final String COLUMNNAME_AM_Meter_ID = "AM_Meter_ID";

	/** Set Meter	  */
	public void setAM_Meter_ID (int AM_Meter_ID);

	/** Get Meter	  */
	public int getAM_Meter_ID();

	public org.eam.model.I_AM_Meter getAM_Meter() throws RuntimeException;

    /** Column name AM_PatternType_ID */
    public static final String COLUMNNAME_AM_PatternType_ID = "AM_PatternType_ID";

	/** Set AM_PatternType ID	  */
	public void setAM_PatternType_ID (int AM_PatternType_ID);

	/** Get AM_PatternType ID	  */
	public int getAM_PatternType_ID();

	public org.eam.model.I_AM_PatternType getAM_PatternType() throws RuntimeException;

    /** Column name A_Asset_Group_ID */
    public static final String COLUMNNAME_A_Asset_Group_ID = "A_Asset_Group_ID";

	/** Set Asset Group.
	  * Group of Assets
	  */
	public void setA_Asset_Group_ID (int A_Asset_Group_ID);

	/** Get Asset Group.
	  * Group of Assets
	  */
	public int getA_Asset_Group_ID();

	public org.compiere.model.I_A_Asset_Group getA_Asset_Group() throws RuntimeException;

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

    /** Column name CBInterval */
    public static final String COLUMNNAME_CBInterval = "CBInterval";

	/** Set Interval	  */
	public void setCBInterval (BigDecimal CBInterval);

	/** Get Interval	  */
	public BigDecimal getCBInterval();

    /** Column name CBTimeUnit */
    public static final String COLUMNNAME_CBTimeUnit = "CBTimeUnit";

	/** Set Time Unit.
	  * The unit of time for grouping chart data.
	  */
	public void setCBTimeUnit (String CBTimeUnit);

	/** Get Time Unit.
	  * The unit of time for grouping chart data.
	  */
	public String getCBTimeUnit();

    /** Column name C_DocType_ID */
    public static final String COLUMNNAME_C_DocType_ID = "C_DocType_ID";

	/** Set Document Type.
	  * Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID);

	/** Get Document Type.
	  * Document type or rules
	  */
	public int getC_DocType_ID();

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException;

    /** Column name CopyFrom */
    public static final String COLUMNNAME_CopyFrom = "CopyFrom";

	/** Set Copy From.
	  * Copy From Record
	  */
	public void setCopyFrom (String CopyFrom);

	/** Get Copy From.
	  * Copy From Record
	  */
	public String getCopyFrom();

    /** Column name CostAmt */
    public static final String COLUMNNAME_CostAmt = "CostAmt";

	/** Set Cost Value.
	  * Value with Cost
	  */
	public void setCostAmt (BigDecimal CostAmt);

	/** Get Cost Value.
	  * Value with Cost
	  */
	public BigDecimal getCostAmt();

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

    /** Column name CurrentAM */
    public static final String COLUMNNAME_CurrentAM = "CurrentAM";

	/** Set CurrentAM	  */
	public void setCurrentAM (BigDecimal CurrentAM);

	/** Get CurrentAM	  */
	public BigDecimal getCurrentAM();

    /** Column name DateDoc */
    public static final String COLUMNNAME_DateDoc = "DateDoc";

	/** Set Document Date.
	  * Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc);

	/** Get Document Date.
	  * Date of the Document
	  */
	public Timestamp getDateDoc();

    /** Column name DateLastRun */
    public static final String COLUMNNAME_DateLastRun = "DateLastRun";

	/** Set Date last run.
	  * Date the process was last run.
	  */
	public void setDateLastRun (Timestamp DateLastRun);

	/** Get Date last run.
	  * Date the process was last run.
	  */
	public Timestamp getDateLastRun();

    /** Column name DateLastRunAM */
    public static final String COLUMNNAME_DateLastRunAM = "DateLastRunAM";

	/** Set Date Last Run AM	  */
	public void setDateLastRunAM (Timestamp DateLastRunAM);

	/** Get Date Last Run AM	  */
	public Timestamp getDateLastRunAM();

    /** Column name DateLastSO */
    public static final String COLUMNNAME_DateLastSO = "DateLastSO";

	/** Set Date Last Service Order	  */
	public void setDateLastSO (Timestamp DateLastSO);

	/** Get Date Last Service Order	  */
	public Timestamp getDateLastSO();

    /** Column name DateNextRun */
    public static final String COLUMNNAME_DateNextRun = "DateNextRun";

	/** Set Date next run.
	  * Date the process will run next
	  */
	public void setDateNextRun (Timestamp DateNextRun);

	/** Get Date next run.
	  * Date the process will run next
	  */
	public Timestamp getDateNextRun();

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

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

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

    /** Column name IsApproved */
    public static final String COLUMNNAME_IsApproved = "IsApproved";

	/** Set Approved.
	  * Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved);

	/** Get Approved.
	  * Indicates if this document requires approval
	  */
	public boolean isApproved();

    /** Column name IsChild */
    public static final String COLUMNNAME_IsChild = "IsChild";

	/** Set Child	  */
	public void setIsChild (boolean IsChild);

	/** Get Child	  */
	public boolean isChild();

    /** Column name LastAM */
    public static final String COLUMNNAME_LastAM = "LastAM";

	/** Set Last AM	  */
	public void setLastAM (BigDecimal LastAM);

	/** Get Last AM	  */
	public BigDecimal getLastAM();

    /** Column name LastRead */
    public static final String COLUMNNAME_LastRead = "LastRead";

	/** Set Last Read	  */
	public void setLastRead (BigDecimal LastRead);

	/** Get Last Read	  */
	public BigDecimal getLastRead();

    /** Column name LeadTime */
    public static final String COLUMNNAME_LeadTime = "LeadTime";

	/** Set LeadTime (Days)	  */
	public void setLeadTime (int LeadTime);

	/** Get LeadTime (Days)	  */
	public int getLeadTime();

    /** Column name MBInterval */
    public static final String COLUMNNAME_MBInterval = "MBInterval";

	/** Set Interval	  */
	public void setMBInterval (BigDecimal MBInterval);

	/** Get Interval	  */
	public BigDecimal getMBInterval();

    /** Column name MBStartValue */
    public static final String COLUMNNAME_MBStartValue = "MBStartValue";

	/** Set Start Value	  */
	public void setMBStartValue (int MBStartValue);

	/** Get Start Value	  */
	public int getMBStartValue();

    /** Column name M_PriceList_ID */
    public static final String COLUMNNAME_M_PriceList_ID = "M_PriceList_ID";

	/** Set Price List.
	  * Unique identifier of a Price List
	  */
	public void setM_PriceList_ID (int M_PriceList_ID);

	/** Get Price List.
	  * Unique identifier of a Price List
	  */
	public int getM_PriceList_ID();

	public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException;

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name PerformDateBase */
    public static final String COLUMNNAME_PerformDateBase = "PerformDateBase";

	/** Set Perform Date Base	  */
	public void setPerformDateBase (boolean PerformDateBase);

	/** Get Perform Date Base	  */
	public boolean isPerformDateBase();

    /** Column name PerformValueBase */
    public static final String COLUMNNAME_PerformValueBase = "PerformValueBase";

	/** Set Perform Value Base	  */
	public void setPerformValueBase (boolean PerformValueBase);

	/** Get Perform Value Base	  */
	public boolean isPerformValueBase();

    /** Column name PriorityRule */
    public static final String COLUMNNAME_PriorityRule = "PriorityRule";

	/** Set Priority.
	  * Priority of a document
	  */
	public void setPriorityRule (String PriorityRule);

	/** Get Priority.
	  * Priority of a document
	  */
	public String getPriorityRule();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

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

    /** Column name ValidFrom */
    public static final String COLUMNNAME_ValidFrom = "ValidFrom";

	/** Set Valid from.
	  * Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom);

	/** Get Valid from.
	  * Valid from including this date (first day)
	  */
	public Timestamp getValidFrom();

    /** Column name ValidTo */
    public static final String COLUMNNAME_ValidTo = "ValidTo";

	/** Set Valid to.
	  * Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo);

	/** Get Valid to.
	  * Valid to including this date (last day)
	  */
	public Timestamp getValidTo();
}
