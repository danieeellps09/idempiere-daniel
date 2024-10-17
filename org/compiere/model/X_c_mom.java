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
/** Generated Model - DO NOT CHANGE */
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.util.Env;

/** Generated Model for c_mom
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="c_mom")
public class X_c_mom extends PO implements I_c_mom, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241011L;

    /** Standard Constructor */
    public X_c_mom (Properties ctx, int c_mom_ID, String trxName)
    {
      super (ctx, c_mom_ID, trxName);
      /** if (c_mom_ID == 0)
        {
			setName (null);
			setValue (null);
			setc_mom_ID (0);
			setend_time (new Timestamp( System.currentTimeMillis() ));
			setstart_date (new Timestamp( System.currentTimeMillis() ));
			setstart_time (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Standard Constructor */
    public X_c_mom (Properties ctx, int c_mom_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, c_mom_ID, trxName, virtualColumns);
      /** if (c_mom_ID == 0)
        {
			setName (null);
			setValue (null);
			setc_mom_ID (0);
			setend_time (new Timestamp( System.currentTimeMillis() ));
			setstart_date (new Timestamp( System.currentTimeMillis() ));
			setstart_time (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Standard Constructor */
    public X_c_mom (Properties ctx, String c_mom_UU, String trxName)
    {
      super (ctx, c_mom_UU, trxName);
      /** if (c_mom_UU == null)
        {
			setName (null);
			setValue (null);
			setc_mom_ID (0);
			setend_time (new Timestamp( System.currentTimeMillis() ));
			setstart_date (new Timestamp( System.currentTimeMillis() ));
			setstart_time (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Standard Constructor */
    public X_c_mom (Properties ctx, String c_mom_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, c_mom_UU, trxName, virtualColumns);
      /** if (c_mom_UU == null)
        {
			setName (null);
			setValue (null);
			setc_mom_ID (0);
			setend_time (new Timestamp( System.currentTimeMillis() ));
			setstart_date (new Timestamp( System.currentTimeMillis() ));
			setstart_time (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_c_mom (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_c_mom[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Duration.
		@param Duration Normal Duration in Duration Unit
	*/
	public void setDuration (BigDecimal Duration)
	{
		set_Value (COLUMNNAME_Duration, Duration);
	}

	/** Get Duration.
		@return Normal Duration in Duration Unit
	  */
	public BigDecimal getDuration()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Duration);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	/** Set agenda.
		@param agenda agenda
	*/
	public void setagenda (String agenda)
	{
		set_Value (COLUMNNAME_agenda, agenda);
	}

	/** Get agenda.
		@return agenda	  */
	public String getagenda()
	{
		return (String)get_Value(COLUMNNAME_agenda);
	}

	/** Set  minutes of meeting detail.
		@param c_mom_ID  minutes of meeting detail
	*/
	public void setc_mom_ID (int c_mom_ID)
	{
		if (c_mom_ID < 1)
			set_ValueNoCheck (COLUMNNAME_c_mom_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_c_mom_ID, Integer.valueOf(c_mom_ID));
	}

	/** Get  minutes of meeting detail.
		@return  minutes of meeting detail	  */
	public int getc_mom_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_c_mom_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set chairperson.
		@param chairperson chairperson
	*/
	public void setchairperson (String chairperson)
	{
		set_Value (COLUMNNAME_chairperson, chairperson);
	}

	/** Get chairperson.
		@return chairperson	  */
	public String getchairperson()
	{
		return (String)get_Value(COLUMNNAME_chairperson);
	}

	/** Set discussion_detail.
		@param discussion_detail discussion_detail
	*/
	public void setdiscussion_detail (String discussion_detail)
	{
		set_Value (COLUMNNAME_discussion_detail, discussion_detail);
	}

	/** Get discussion_detail.
		@return discussion_detail	  */
	public String getdiscussion_detail()
	{
		return (String)get_Value(COLUMNNAME_discussion_detail);
	}

	/** Set end_time.
		@param end_time end_time
	*/
	public void setend_time (Timestamp end_time)
	{
		set_Value (COLUMNNAME_end_time, end_time);
	}

	/** Get end_time.
		@return end_time	  */
	public Timestamp getend_time()
	{
		return (Timestamp)get_Value(COLUMNNAME_end_time);
	}

	/** Set participants.
		@param participants participants
	*/
	public void setparticipants (String participants)
	{
		set_Value (COLUMNNAME_participants, participants);
	}

	/** Get participants.
		@return participants	  */
	public String getparticipants()
	{
		return (String)get_Value(COLUMNNAME_participants);
	}

	/** Set start_date.
		@param start_date start_date
	*/
	public void setstart_date (Timestamp start_date)
	{
		set_Value (COLUMNNAME_start_date, start_date);
	}

	/** Get start_date.
		@return start_date	  */
	public Timestamp getstart_date()
	{
		return (Timestamp)get_Value(COLUMNNAME_start_date);
	}

	/** Set start_time.
		@param start_time start_time
	*/
	public void setstart_time (Timestamp start_time)
	{
		set_Value (COLUMNNAME_start_time, start_time);
	}

	/** Get start_time.
		@return start_time	  */
	public Timestamp getstart_time()
	{
		return (Timestamp)get_Value(COLUMNNAME_start_time);
	}
}