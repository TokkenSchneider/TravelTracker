package cmput301w15t07.TravelTracker.model;

import java.util.Date;
import java.util.UUID;

import cmput301w15t07.TravelTracker.serverinterface.Constants.Type;

/*
 *   Copyright 2015 Kirby Banman,
 *                  Stuart Bildfell,
 *                  Elliot Colp,
 *                  Christian Ellinger,
 *                  Braedy Kuzma,
 *                  Ryan Thornhill
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * Model object for individual expense Items made by Users acting as Claimants.
 * Expense Items belong to a Claim.
 * 
 * @author kdbanman,
 *         braedy,
 *         therabidsquirel
 *
 */
public class Item extends Document {
	private UUID claim;
	private String description;
	private ItemCategory category;
	private Date date;
	private Float amount;
	private ItemCurrency currency;
	private Receipt receipt;
	private Geolocation geolocation;
	private boolean isComplete;

	/**
	 * Package protected constructor, intended for use only by DataSource.
	 * 
	 * @param docID UUID document identifier
	 * @param claimID UUID parent claim identifier
	 */
	Item(UUID docID, UUID claimID) {
		super(docID);
		
		claim = claimID;
		
		// Empty description
		description = "";
		
		category = ItemCategory.NO_CATEGORY;
		
		date = new Date();
		
		// Start at 0 of unknown currency
		amount = 0.f;
		currency = ItemCurrency.CAD;
		
		receipt = new Receipt();
		
		isComplete = true;
		
		setType(Type.ITEM);
		
	}
	
	/**
	 * Get the claim to which this belongs.
	 * @return The claim's UUID.
	 */
	public UUID getClaim() {
		return this.claim;
	}
	
	/**
	 * Set the claim to which this belongs.
	 * @param claim The claim's UUID.
	 */
	public void setClaim(UUID claim) {
		this.claim = claim;
		this.<Item>hasChanged(this);
	}
	
	/**
	 * Get the item description.
	 * @return The description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set the item description.
	 * @param description The description.
	 */
	public void setDescription(String description) {
		this.description = description;
		this.<Item>hasChanged(this);
	}
	
	/**
	 * Get the item's category.
	 * @return The category.
	 */
	public ItemCategory getCategory() {
		return category;
	}
	
	/**
	 * Set the item's category.
	 * @param category The category.
	 */
	public void setCategory(ItemCategory category) {
		this.category = category;
		this.<Item>hasChanged(this);
	}
	
	/**
	 * Get the date on which the expense item occurred.
	 * @return The date.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Set the date on which the expense item occurred.
	 * @param date The date.
	 */
	public void setDate(Date date) {
		this.date = date;
		this.<Item>hasChanged(this);
	}
	
	/**
	 * Get the expense amount.
	 * @return The amount.
	 */
	public Float getAmount() {
		return amount;
	}
	
	/**
	 * Set the expense amount.
	 * @param amount The amount.
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
		this.<Item>hasChanged(this);
	}
	
	/**
	 * Get the currency type of the expense.
	 * @return The currency.
	 */
	public ItemCurrency getCurrency() {
		return currency;
	}
	
	/**
	 * Set the currency type of the expense.
	 * @param currency The currency.
	 */
	public void setCurrency(ItemCurrency currency) {
		this.currency = currency;
		this.<Item>hasChanged(this);
	}
	
	/**
	 * Get the attached Receipt.
	 * @return The receipt.
	 */
	public Receipt getReceipt() {
		return receipt;
	}
	
	/**
	 * Set the attached Receipt.
	 * @param receipt The receipt.
	 */
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
		this.<Item>hasChanged(this);
	}
	
    /**
     * Get the attached Geolocation.
     * @return The geolocation.
     */
    public Geolocation getGeolocation() {
        return geolocation;
    }
    
    /**
     * Set the attached Geolocation.
     * @param geolocation The geolocation.
     */
    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
        this.<Item>hasChanged(this);
    }
    
	/**
	 * Get the status of the expense item.
	 * @return The status.
	 */
	public boolean isComplete() {
		return isComplete;
	}
	
	/**
	 * Set the status of the expense item.
	 * @param isComplete The status.
	 */
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
		this.<Item>hasChanged(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((claim == null) ? 0 : claim.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
		        + ((geolocation == null) ? 0 : geolocation.hashCode());
		result = prime * result + (isComplete ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (category != other.category)
			return false;
		if (claim == null) {
			if (other.claim != null)
				return false;
		} else if (!claim.equals(other.claim))
			return false;
		if (currency != other.currency)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (geolocation == null) {
		    if (other.geolocation != null)
		        return false;
		} else if (!geolocation.equals(other.geolocation))
		    return false;
		if (isComplete != other.isComplete)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		}
		return true;
	}
}
