package com.rs.game.item;

import java.io.Serializable;

import com.rs.cache.loaders.ItemDefinitions;

/**
 * Represents a single item.
 * <p/>
 * 
 * @author Graham / edited by Dragonkk(Alex)
 */
public class Item implements Serializable {

	private static final long serialVersionUID = -6485003878697568087L;

	@Deprecated
	private short id;
	private int newId;
	protected int amount;

	public int getId() {
		return newId != 0 ? newId : id;
	}

	@Override
	public Item clone() {
		return new Item(newId, amount);
	}

	public Item(int id) {
		this(id, 1);
	}

	public Item(int id, int amount) {
		this(id, amount, false);
	}

	public Item(int id, int amount, boolean amt0) {
		this.newId = id;
		this.amount = amount;
		if (this.amount <= 0 && !amt0) {
				this.amount = 1;
		}
	}

	public ItemDefinitions getDefinitions() {
		return ItemDefinitions.getItemDefinitions(newId);
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setId(int id) {
		this.newId = id;
	}

	public int getAmount() {
		return amount;
	}

	public String getName() {
		return getDefinitions().getName();
	}

}
