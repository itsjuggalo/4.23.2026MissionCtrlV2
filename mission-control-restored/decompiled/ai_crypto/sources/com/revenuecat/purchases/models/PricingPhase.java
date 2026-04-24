package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.utils.PriceExtensionsKt;
import java.util.Locale;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PricingPhase implements Parcelable {
    public static final Parcelable.Creator<PricingPhase> CREATOR = new Creator();
    private final Integer billingCycleCount;
    private final Period billingPeriod;
    private final Price price;
    private final RecurrenceMode recurrenceMode;

    public static final class Creator implements Parcelable.Creator<PricingPhase> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PricingPhase createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new PricingPhase(Period.CREATOR.createFromParcel(parcel), RecurrenceMode.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), Price.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PricingPhase[] newArray(int i7) {
            return new PricingPhase[i7];
        }
    }

    public PricingPhase(Period billingPeriod, RecurrenceMode recurrenceMode, Integer num, Price price) {
        r.f(billingPeriod, "billingPeriod");
        r.f(recurrenceMode, "recurrenceMode");
        r.f(price, "price");
        this.billingPeriod = billingPeriod;
        this.recurrenceMode = recurrenceMode;
        this.billingCycleCount = num;
        this.price = price;
    }

    public static /* synthetic */ PricingPhase copy$default(PricingPhase pricingPhase, Period period, RecurrenceMode recurrenceMode, Integer num, Price price, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            period = pricingPhase.billingPeriod;
        }
        if ((i7 & 2) != 0) {
            recurrenceMode = pricingPhase.recurrenceMode;
        }
        if ((i7 & 4) != 0) {
            num = pricingPhase.billingCycleCount;
        }
        if ((i7 & 8) != 0) {
            price = pricingPhase.price;
        }
        return pricingPhase.copy(period, recurrenceMode, num, price);
    }

    public static /* synthetic */ String formattedPriceInMonths$default(PricingPhase pricingPhase, Locale locale, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }

    public static /* synthetic */ Price pricePerDay$default(PricingPhase pricingPhase, Locale locale, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        return pricingPhase.pricePerDay(locale);
    }

    public static /* synthetic */ Price pricePerMonth$default(PricingPhase pricingPhase, Locale locale, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        return pricingPhase.pricePerMonth(locale);
    }

    public static /* synthetic */ Price pricePerWeek$default(PricingPhase pricingPhase, Locale locale, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        return pricingPhase.pricePerWeek(locale);
    }

    public static /* synthetic */ Price pricePerYear$default(PricingPhase pricingPhase, Locale locale, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        return pricingPhase.pricePerYear(locale);
    }

    public final Period component1() {
        return this.billingPeriod;
    }

    public final RecurrenceMode component2() {
        return this.recurrenceMode;
    }

    public final Integer component3() {
        return this.billingCycleCount;
    }

    public final Price component4() {
        return this.price;
    }

    public final PricingPhase copy(Period billingPeriod, RecurrenceMode recurrenceMode, Integer num, Price price) {
        r.f(billingPeriod, "billingPeriod");
        r.f(recurrenceMode, "recurrenceMode");
        r.f(price, "price");
        return new PricingPhase(billingPeriod, recurrenceMode, num, price);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PricingPhase)) {
            return false;
        }
        PricingPhase pricingPhase = (PricingPhase) obj;
        return r.b(this.billingPeriod, pricingPhase.billingPeriod) && this.recurrenceMode == pricingPhase.recurrenceMode && r.b(this.billingCycleCount, pricingPhase.billingCycleCount) && r.b(this.price, pricingPhase.price);
    }

    public final String formattedPriceInMonths() {
        return formattedPriceInMonths$default(this, null, 1, null);
    }

    public final Integer getBillingCycleCount() {
        return this.billingCycleCount;
    }

    public final Period getBillingPeriod() {
        return this.billingPeriod;
    }

    public final OfferPaymentMode getOfferPaymentMode() {
        if (this.recurrenceMode != RecurrenceMode.FINITE_RECURRING) {
            return null;
        }
        if (this.price.getAmountMicros() == 0) {
            return OfferPaymentMode.FREE_TRIAL;
        }
        Integer num = this.billingCycleCount;
        if (num != null && num.intValue() == 1) {
            return OfferPaymentMode.SINGLE_PAYMENT;
        }
        Integer num2 = this.billingCycleCount;
        if (num2 == null || num2.intValue() <= 1) {
            return null;
        }
        return OfferPaymentMode.DISCOUNTED_RECURRING_PAYMENT;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final RecurrenceMode getRecurrenceMode() {
        return this.recurrenceMode;
    }

    public int hashCode() {
        int iHashCode = ((this.billingPeriod.hashCode() * 31) + this.recurrenceMode.hashCode()) * 31;
        Integer num = this.billingCycleCount;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.price.hashCode();
    }

    public final Price pricePerDay() {
        return pricePerDay$default(this, null, 1, null);
    }

    public final Price pricePerMonth() {
        return pricePerMonth$default(this, null, 1, null);
    }

    public final Price pricePerWeek() {
        return pricePerWeek$default(this, null, 1, null);
    }

    public final Price pricePerYear() {
        return pricePerYear$default(this, null, 1, null);
    }

    public String toString() {
        return "PricingPhase(billingPeriod=" + this.billingPeriod + ", recurrenceMode=" + this.recurrenceMode + ", billingCycleCount=" + this.billingCycleCount + ", price=" + this.price + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i7) {
        int iIntValue;
        r.f(out, "out");
        this.billingPeriod.writeToParcel(out, i7);
        out.writeString(this.recurrenceMode.name());
        Integer num = this.billingCycleCount;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        this.price.writeToParcel(out, i7);
    }

    public final String formattedPriceInMonths(Locale locale) {
        r.f(locale, "locale");
        return pricePerMonth(locale).getFormatted();
    }

    public final Price pricePerDay(Locale locale) {
        r.f(locale, "locale");
        return PriceExtensionsKt.pricePerDay(this.price, this.billingPeriod, locale);
    }

    public final Price pricePerMonth(Locale locale) {
        r.f(locale, "locale");
        return PriceExtensionsKt.pricePerMonth(this.price, this.billingPeriod, locale);
    }

    public final Price pricePerWeek(Locale locale) {
        r.f(locale, "locale");
        return PriceExtensionsKt.pricePerWeek(this.price, this.billingPeriod, locale);
    }

    public final Price pricePerYear(Locale locale) {
        r.f(locale, "locale");
        return PriceExtensionsKt.pricePerYear(this.price, this.billingPeriod, locale);
    }
}
