package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class Price implements Parcelable {
    public static final Parcelable.Creator<Price> CREATOR = new Creator();
    private final long amountMicros;
    private final String currencyCode;
    private final String formatted;

    public static final class Creator implements Parcelable.Creator<Price> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Price createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new Price(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Price[] newArray(int i7) {
            return new Price[i7];
        }
    }

    public Price(String formatted, long j7, String currencyCode) {
        r.f(formatted, "formatted");
        r.f(currencyCode, "currencyCode");
        this.formatted = formatted;
        this.amountMicros = j7;
        this.currencyCode = currencyCode;
    }

    public static /* synthetic */ Price copy$default(Price price, String str, long j7, String str2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = price.formatted;
        }
        if ((i7 & 2) != 0) {
            j7 = price.amountMicros;
        }
        if ((i7 & 4) != 0) {
            str2 = price.currencyCode;
        }
        return price.copy(str, j7, str2);
    }

    public final String component1() {
        return this.formatted;
    }

    public final long component2() {
        return this.amountMicros;
    }

    public final String component3() {
        return this.currencyCode;
    }

    public final Price copy(String formatted, long j7, String currencyCode) {
        r.f(formatted, "formatted");
        r.f(currencyCode, "currencyCode");
        return new Price(formatted, j7, currencyCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Price)) {
            return false;
        }
        Price price = (Price) obj;
        return r.b(this.formatted, price.formatted) && this.amountMicros == price.amountMicros && r.b(this.currencyCode, price.currencyCode);
    }

    public final long getAmountMicros() {
        return this.amountMicros;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getFormatted() {
        return this.formatted;
    }

    public int hashCode() {
        return (((this.formatted.hashCode() * 31) + Long.hashCode(this.amountMicros)) * 31) + this.currencyCode.hashCode();
    }

    public String toString() {
        return "Price(formatted=" + this.formatted + ", amountMicros=" + this.amountMicros + ", currencyCode=" + this.currencyCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i7) {
        r.f(out, "out");
        out.writeString(this.formatted);
        out.writeLong(this.amountMicros);
        out.writeString(this.currencyCode);
    }
}
