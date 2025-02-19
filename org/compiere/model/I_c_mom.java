/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.util.KeyNamePair;

/** Generated Interface for c_mom
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
public interface I_c_mom 
{

    /** TableName=c_mom */
    public static final String Table_Name = "c_mom";

    /** AD_Table_ID=1000000 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(7);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

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

    /** Column name Duration */
    public static final String COLUMNNAME_Duration = "Duration";

	/** Set Duration.
	  * Normal Duration in Duration Unit
	  */
	public void setDuration (BigDecimal Duration);

	/** Get Duration.
	  * Normal Duration in Duration Unit
	  */
	public BigDecimal getDuration();

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

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();

    /** Column name agenda */
    public static final String COLUMNNAME_agenda = "agenda";

	/** Set agenda	  */
	public void setagenda (String agenda);

	/** Get agenda	  */
	public String getagenda();

    /** Column name c_mom_ID */
    public static final String COLUMNNAME_c_mom_ID = "c_mom_ID";

	/** Set  minutes of meeting detail	  */
	public void setc_mom_ID (int c_mom_ID);

	/** Get  minutes of meeting detail	  */
	public int getc_mom_ID();

    /** Column name chairperson */
    public static final String COLUMNNAME_chairperson = "chairperson";

	/** Set chairperson	  */
	public void setchairperson (String chairperson);

	/** Get chairperson	  */
	public String getchairperson();

    /** Column name discussion_detail */
    public static final String COLUMNNAME_discussion_detail = "discussion_detail";

	/** Set discussion_detail	  */
	public void setdiscussion_detail (String discussion_detail);

	/** Get discussion_detail	  */
	public String getdiscussion_detail();

    /** Column name end_time */
    public static final String COLUMNNAME_end_time = "end_time";

	/** Set end_time	  */
	public void setend_time (Timestamp end_time);

	/** Get end_time	  */
	public Timestamp getend_time();

    /** Column name participants */
    public static final String COLUMNNAME_participants = "participants";

	/** Set participants	  */
	public void setparticipants (String participants);

	/** Get participants	  */
	public String getparticipants();

    /** Column name start_date */
    public static final String COLUMNNAME_start_date = "start_date";

	/** Set start_date	  */
	public void setstart_date (Timestamp start_date);

	/** Get start_date	  */
	public Timestamp getstart_date();

    /** Column name start_time */
    public static final String COLUMNNAME_start_time = "start_time";

	/** Set start_time	  */
	public void setstart_time (Timestamp start_time);

	/** Get start_time	  */
	public Timestamp getstart_time();
}
