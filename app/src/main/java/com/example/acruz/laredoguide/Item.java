package com.example.acruz.laredoguide;

import android.os.Parcel;
import android.os.Parcelable;


public class Item implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    // Drawable ID
    private int mItemDrawableId;

    // Item name
    private String mItemName;

    // Item website
    private String mItemWebsite = NO_WEBSITE_PROVIDED;
    static final String NO_WEBSITE_PROVIDED = "no website";

    //Item Address
    private String mItemAddress;

    //Item Phone number
    private String mItemPhone;

    /**
     * Constructor 1
     * Create a new Item object.
     *
     * @param itemName       is the name of the item
     * @param itemDrawableId is the id of the corresponding drawable
     * @param itemAddress    is the address of the item
     * @param itemWebsite    is the item website
     * @param itemPhone      is the phone number
     */
    public Item(String itemName, int itemDrawableId, String itemWebsite,
                String itemAddress, String itemPhone) {
        mItemName = itemName;
        mItemDrawableId = itemDrawableId;
        mItemWebsite = itemWebsite;
        mItemAddress = itemAddress;
        mItemPhone = itemPhone;

    }

    /**
     * Constructor 2 - no website
     * Create a new Item object.
     *
     * @param itemName       is the name of the item
     * @param itemDrawableId is the id of the corresponding drawable
     * @param itemAddress    is the address of the item
     * @param itemPhone      is the phone number
     */
    public Item(String itemName, int itemDrawableId,
                String itemAddress, String itemPhone) {
        mItemName = itemName;
        mItemDrawableId = itemDrawableId;
        mItemAddress = itemAddress;
        mItemPhone = itemPhone;

    }

    // get the item's name
    public String getmItemName() {
        return mItemName;
    }

    // get the drawable id
    public int getmItemDrawableId() {
        return mItemDrawableId;
    }

    // get the item website
    public String getmItemWebsite() {
        return mItemWebsite;
    }

    // get the item address
    public String getmItemAddress() {
        return mItemAddress;
    }

    //get the item phone number
    public String getmItemPhone() {
        return mItemPhone;
    }

    //Parcelling
    public Item(Parcel in) {
        this.mItemName = in.readString();
        this.mItemDrawableId = in.readInt();
        this.mItemWebsite = in.readString();
        this.mItemAddress = in.readString();
        this.mItemPhone = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mItemName);
        dest.writeInt(this.mItemDrawableId);
        dest.writeString(this.mItemWebsite);
        dest.writeString(this.mItemAddress);
        dest.writeString(this.mItemPhone);
    }

}

