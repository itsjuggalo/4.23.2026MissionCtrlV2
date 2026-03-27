package com.revenuecat.purchases.virtualcurrencies;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import io.flutter.plugins.firebase.database.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o7.AbstractC2504f0;
import o7.M;
import o7.t0;
import o7.x0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002&%B\u001d\b\u0007\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR,\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "Landroid/os/Parcelable;", "", "", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "all", "<init>", "(Ljava/util/Map;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/util/Map;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;Ln7/d;Lm7/e;)V", "write$Self", Constants.ERROR_CODE, b.au, "(Ljava/lang/String;)Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/Map;", "getAll", "()Ljava/util/Map;", "getAll$annotations", "()V", "Companion", "$serializer", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class VirtualCurrencies implements Parcelable {
    private final Map<String, VirtualCurrency> all;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<VirtualCurrencies> CREATOR = new Creator();
    private static final k7.b[] $childSerializers = {new M(x0.f22227a, VirtualCurrency$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public final k7.b serializer() {
            return VirtualCurrencies$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VirtualCurrencies> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrencies createFromParcel(Parcel parcel) {
            AbstractC2304t.f(parcel, "parcel");
            int i8 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i8);
            for (int i9 = 0; i9 != i8; i9++) {
                linkedHashMap.put(parcel.readString(), VirtualCurrency.CREATOR.createFromParcel(parcel));
            }
            return new VirtualCurrencies(linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VirtualCurrencies[] newArray(int i8) {
            return new VirtualCurrencies[i8];
        }
    }

    public /* synthetic */ VirtualCurrencies(int i8, Map map, t0 t0Var) {
        if (1 != (i8 & 1)) {
            AbstractC2504f0.a(i8, 1, VirtualCurrencies$$serializer.INSTANCE.getDescriptor());
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
        return (obj instanceof VirtualCurrencies) && AbstractC2304t.b(this.all, ((VirtualCurrencies) obj).all);
    }

    public final VirtualCurrency get(String code) {
        AbstractC2304t.f(code, "code");
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
    public void writeToParcel(Parcel parcel, int flags) {
        AbstractC2304t.f(parcel, "out");
        Map<String, VirtualCurrency> map = this.all;
        parcel.writeInt(map.size());
        for (Map.Entry<String, VirtualCurrency> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            entry.getValue().writeToParcel(parcel, flags);
        }
    }

    @InternalRevenueCatAPI
    public VirtualCurrencies(Map<String, VirtualCurrency> all) {
        AbstractC2304t.f(all, "all");
        this.all = all;
    }
}
