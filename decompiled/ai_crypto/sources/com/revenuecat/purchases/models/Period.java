package com.revenuecat.purchases.models;

import E5.m;
import E5.o;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class Period implements Parcelable {
    private final String iso8601;
    private final Unit unit;
    private final int value;
    public static final Factory Factory = new Factory(null);
    public static final Parcelable.Creator<Period> CREATOR = new Creator();

    public static final class Creator implements Parcelable.Creator<Period> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new Period(parcel.readInt(), Unit.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period[] newArray(int i7) {
            return new Period[i7];
        }
    }

    public static final class Factory {
        public /* synthetic */ Factory(AbstractC2148j abstractC2148j) {
            this();
        }

        public final Period create(String iso8601) {
            r.f(iso8601, "iso8601");
            o period = PeriodKt.toPeriod(iso8601);
            return new Period(((Number) period.c()).intValue(), (Unit) period.d(), iso8601);
        }

        private Factory() {
        }
    }

    public enum Unit {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        UNKNOWN
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Unit.values().length];
            try {
                iArr[Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Period(int i7, Unit unit, String iso8601) {
        r.f(unit, "unit");
        r.f(iso8601, "iso8601");
        this.value = i7;
        this.unit = unit;
        this.iso8601 = iso8601;
    }

    public static /* synthetic */ Period copy$default(Period period, int i7, Unit unit, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = period.value;
        }
        if ((i8 & 2) != 0) {
            unit = period.unit;
        }
        if ((i8 & 4) != 0) {
            str = period.iso8601;
        }
        return period.copy(i7, unit, str);
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getValueInDays$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getValueInWeeks$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getValueInYears$annotations() {
    }

    public final int component1() {
        return this.value;
    }

    public final Unit component2() {
        return this.unit;
    }

    public final String component3() {
        return this.iso8601;
    }

    public final Period copy(int i7, Unit unit, String iso8601) {
        r.f(unit, "unit");
        r.f(iso8601, "iso8601");
        return new Period(i7, unit, iso8601);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.value == period.value && this.unit == period.unit && r.b(this.iso8601, period.iso8601);
    }

    public final String getIso8601() {
        return this.iso8601;
    }

    public final Unit getUnit() {
        return this.unit;
    }

    public final int getValue() {
        return this.value;
    }

    public final double getValueInDays() {
        double d7;
        double d8;
        int i7 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i7 == 1) {
            return this.value;
        }
        if (i7 == 2) {
            d7 = this.value;
            d8 = 7.0d;
        } else if (i7 == 3) {
            d7 = this.value;
            d8 = 30.0d;
        } else {
            if (i7 != 4) {
                if (i7 != 5) {
                    throw new m();
                }
                LogUtilsKt.errorLog$default("Unknown period unit trying to get value in days: " + this.unit, null, 2, null);
                return 0.0d;
            }
            d7 = this.value;
            d8 = 365.0d;
        }
        return d7 * d8;
    }

    public final double getValueInMonths() {
        double d7;
        double d8;
        int i7 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i7 == 1) {
            d7 = this.value;
            d8 = 30.0d;
        } else {
            if (i7 != 2) {
                if (i7 == 3) {
                    return this.value;
                }
                if (i7 == 4) {
                    return ((double) this.value) * 12.0d;
                }
                if (i7 != 5) {
                    throw new m();
                }
                LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, null, 2, null);
                return 0.0d;
            }
            d7 = this.value;
            d8 = 4.345238095238096d;
        }
        return d7 / d8;
    }

    public final double getValueInWeeks() {
        double d7;
        double d8;
        int i7 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i7 == 1) {
            return ((double) this.value) / 7.0d;
        }
        if (i7 == 2) {
            return this.value;
        }
        if (i7 == 3) {
            d7 = this.value;
            d8 = 4.345238095238096d;
        } else {
            if (i7 != 4) {
                if (i7 != 5) {
                    throw new m();
                }
                LogUtilsKt.errorLog$default("Unknown period unit trying to get value in weeks: " + this.unit, null, 2, null);
                return 0.0d;
            }
            d7 = this.value;
            d8 = 52.142857142857146d;
        }
        return d7 * d8;
    }

    public final double getValueInYears() {
        double d7;
        double d8;
        int i7 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i7 == 1) {
            d7 = this.value;
            d8 = 365.0d;
        } else if (i7 == 2) {
            d7 = this.value;
            d8 = 52.142857142857146d;
        } else {
            if (i7 != 3) {
                if (i7 == 4) {
                    return this.value;
                }
                if (i7 != 5) {
                    throw new m();
                }
                LogUtilsKt.errorLog$default("Unknown period unit trying to get value in years: " + this.unit, null, 2, null);
                return 0.0d;
            }
            d7 = this.value;
            d8 = 12.0d;
        }
        return d7 / d8;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.value) * 31) + this.unit.hashCode()) * 31) + this.iso8601.hashCode();
    }

    public String toString() {
        return "Period(value=" + this.value + ", unit=" + this.unit + ", iso8601=" + this.iso8601 + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i7) {
        r.f(out, "out");
        out.writeInt(this.value);
        out.writeString(this.unit.name());
        out.writeString(this.iso8601);
    }
}
