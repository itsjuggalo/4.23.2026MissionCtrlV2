package com.revenuecat.purchases.virtualcurrencies;

import F3.b;
import J3.AbstractC0325a0;
import J3.K;
import J3.k0;
import J3.o0;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualCurrencies implements Parcelable {
    private final Map<String, VirtualCurrency> all;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<VirtualCurrencies> CREATOR = new Creator();
    private static final b[] $childSerializers = {new K(o0.f952a, VirtualCurrency$$serializer.INSTANCE)};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return VirtualCurrencies$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class Creator implements Parcelable.Creator<VirtualCurrencies> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrencies createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            int i4 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i4);
            for (int i5 = 0; i5 != i4; i5++) {
                linkedHashMap.put(parcel.readString(), VirtualCurrency.CREATOR.createFromParcel(parcel));
            }
            return new VirtualCurrencies(linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrencies[] newArray(int i4) {
            return new VirtualCurrencies[i4];
        }
    }

    public /* synthetic */ VirtualCurrencies(int i4, Map map, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, VirtualCurrencies$$serializer.INSTANCE.getDescriptor());
        }
        this.all = map;
    }

    public static /* synthetic */ void getAll$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VirtualCurrencies) && r.b(this.all, ((VirtualCurrencies) obj).all);
    }

    public final VirtualCurrency get(String code) {
        r.f(code, "code");
        return this.all.get(code);
    }

    public final Map<String, VirtualCurrency> getAll() {
        return this.all;
    }

    public int hashCode() {
        return this.all.hashCode();
    }

    public String toString() {
        return "VirtualCurrencies(all=" + this.all + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        Map<String, VirtualCurrency> map = this.all;
        out.writeInt(map.size());
        for (Map.Entry<String, VirtualCurrency> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            entry.getValue().writeToParcel(out, i4);
        }
    }

    @InternalRevenueCatAPI
    public VirtualCurrencies(Map<String, VirtualCurrency> all) {
        r.f(all, "all");
        this.all = all;
    }
}
