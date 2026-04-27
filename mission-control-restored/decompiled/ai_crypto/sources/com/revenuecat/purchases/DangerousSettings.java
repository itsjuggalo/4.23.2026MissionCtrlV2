package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class DangerousSettings implements Parcelable {
    public static final Parcelable.Creator<DangerousSettings> CREATOR = new Creator();
    private final boolean autoSyncPurchases;
    private final boolean customEntitlementComputation;

    public static final class Creator implements Parcelable.Creator<DangerousSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DangerousSettings createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new DangerousSettings(parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DangerousSettings[] newArray(int i7) {
            return new DangerousSettings[i7];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DangerousSettings() {
        boolean z7 = false;
        this(z7, z7, 3, null);
    }

    public static /* synthetic */ DangerousSettings copy$default(DangerousSettings dangerousSettings, boolean z7, boolean z8, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = dangerousSettings.autoSyncPurchases;
        }
        if ((i7 & 2) != 0) {
            z8 = dangerousSettings.customEntitlementComputation;
        }
        return dangerousSettings.copy(z7, z8);
    }

    public final boolean component1() {
        return this.autoSyncPurchases;
    }

    public final boolean component2$purchases_defaultsRelease() {
        return this.customEntitlementComputation;
    }

    public final DangerousSettings copy(boolean z7, boolean z8) {
        return new DangerousSettings(z7, z8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DangerousSettings)) {
            return false;
        }
        DangerousSettings dangerousSettings = (DangerousSettings) obj;
        return this.autoSyncPurchases == dangerousSettings.autoSyncPurchases && this.customEntitlementComputation == dangerousSettings.customEntitlementComputation;
    }

    public final boolean getAutoSyncPurchases() {
        return this.autoSyncPurchases;
    }

    public final boolean getCustomEntitlementComputation$purchases_defaultsRelease() {
        return this.customEntitlementComputation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z7 = this.autoSyncPurchases;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i7 = r02 * 31;
        boolean z8 = this.customEntitlementComputation;
        return i7 + (z8 ? 1 : z8);
    }

    public String toString() {
        return "DangerousSettings(autoSyncPurchases=" + this.autoSyncPurchases + ", customEntitlementComputation=" + this.customEntitlementComputation + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i7) {
        r.f(out, "out");
        out.writeInt(this.autoSyncPurchases ? 1 : 0);
        out.writeInt(this.customEntitlementComputation ? 1 : 0);
    }

    public DangerousSettings(boolean z7, boolean z8) {
        this.autoSyncPurchases = z7;
        this.customEntitlementComputation = z8;
    }

    public /* synthetic */ DangerousSettings(boolean z7, boolean z8, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? true : z7, (i7 & 2) != 0 ? false : z8);
    }

    public DangerousSettings(boolean z7) {
        this(z7, false);
    }

    public /* synthetic */ DangerousSettings(boolean z7, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? true : z7);
    }
}
