/**
 * 
 */
package com.htc.bean;

import java.sql.Date;

/**  
* @ClassName:Owners
* @Description:
* @author:htc  
* @date:2019年7月2日 上午1:04:29
*/
public class Owners {
	private Long id;			//编号
	private String name;		//业主名称
	private Long addressid;		//地址编号
	private String housenumber;	//门牌号
	private String watermeter;	//水表编号
	private Date adddate;		//登记日期
	private Long ownertypeid;	//业主类型ID
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the addressid
	 */
	public Long getAddressid() {
		return addressid;
	}
	/**
	 * @param addressid the addressid to set
	 */
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	/**
	 * @return the housenumber
	 */
	public String getHousenumber() {
		return housenumber;
	}
	/**
	 * @param housenumber the housenumber to set
	 */
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	/**
	 * @return the watermeter
	 */
	public String getWatermeter() {
		return watermeter;
	}
	/**
	 * @param watermeter the watermeter to set
	 */
	public void setWatermeter(String watermeter) {
		this.watermeter = watermeter;
	}
	/**
	 * @return the adddate
	 */
	public Date getAdddate() {
		return adddate;
	}
	/**
	 * @param adddate the adddate to set
	 */
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	/**
	 * @return the ownertypeid
	 */
	public Long getOwnertypeid() {
		return ownertypeid;
	}
	/**
	 * @param ownertypeid the ownertypeid to set
	 */
	public void setOwnertypeid(Long ownertypeid) {
		this.ownertypeid = ownertypeid;
	}
	
}
