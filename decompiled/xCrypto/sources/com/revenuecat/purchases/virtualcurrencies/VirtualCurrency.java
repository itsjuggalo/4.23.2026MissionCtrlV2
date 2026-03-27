package com.revenuecat.purchases.virtualcurrencies;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import J3.o0;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualCurrency implements Parcelable {
    private final int balance;
    private final String code;
    private final String name;
    private final String serverDescription;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<VirtualCurrency> CREATOR = new Creator();

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return VirtualCurrency$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class Creator implements Parcelable.Creator<VirtualCurrency> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrency createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new VirtualCurrency(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrency[] newArray(int i4) {
            return new VirtualCurrency[i4];
        }
    }

    public /* synthetic */ VirtualCurrency(int i4, int i5, String str, String str2, String str3, k0 k0Var) {
        if (7 != (i4 & 7)) {
            AbstractC0325a0.a(i4, 7, VirtualCurrency$$serializer.INSTANCE.getDescriptor());
        }
        this.balance = i5;
        this.name = str;
        this.code = str2;
        if ((i4 & 8) == 0) {
            this.serverDescription = null;
        } else {
            this.serverDescription = str3;
        }
    }

    public static /* synthetic */ void getServerDescription$annotations() {
    }

    public static final /* synthetic */ void write$Self(VirtualCurrency virtualCurrency, d dVar, e eVar) {
        dVar.k(eVar, 0, virtualCurrency.balance);
        dVar.o(eVar, 1, virtualCurrency.name);
        dVar.o(eVar, 2, virtualCurrency.code);
        if (!dVar.j(eVar, 3) && virtualCurrency.serverDescription == null) {
            return;
        }
        dVar.E(eVar, 3, o0.f952a, virtualCurrency.serverDescription);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VirtualCurrency)) {
            return false;
        }
        VirtualCurrency virtualCurrency = (VirtualCurrency) obj;
        return this.balance == virtualCurrency.balance && r.b(this.name, virtualCurrency.name) && r.b(this.code, virtualCurrency.code) && r.b(this.serverDescription, virtualCurrency.serverDescription);
    }

    public final int getBalance() {
        return this.balance;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.balance) * 31) + this.name.hashCode()) * 31) + this.code.hashCode()) * 31;
        String str = this.serverDescription;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "VirtualCurrency(balance=" + this.balance + ", name=" + this.name + ", code=" + this.code + ", serverDescription=" + this.serverDescription + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        out.writeInt(this.balance);
        out.writeString(this.name);
        out.writeString(this.code);
        out.writeString(this.serverDescription);
    }

    @InternalRevenueCatAPI
    public VirtualCurrency(int i4, String name, String code, String str) {
        r.f(name, "name");
        r.f(code, "code");
        this.balance = i4;
        this.name = name;
        this.code = code;
        this.serverDescription = str;
    }

    public /* synthetic */ VirtualCurrency(int i4, String str, String str2, String str3, int i5, AbstractC1585j abstractC1585j) {
        this(i4, str, str2, (i5 & 8) != 0 ? null : str3);
    }
}
