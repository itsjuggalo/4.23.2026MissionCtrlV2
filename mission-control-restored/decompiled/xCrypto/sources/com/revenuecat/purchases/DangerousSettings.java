package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.AbstractC1585j;
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
        public final DangerousSettings[] newArray(int i4) {
            return new DangerousSettings[i4];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DangerousSettings() {
        boolean z4 = false;
        this(z4, z4, 3, null);
    }

    public static /* synthetic */ DangerousSettings copy$default(DangerousSettings dangerousSettings, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = dangerousSettings.autoSyncPurchases;
        }
        if ((i4 & 2) != 0) {
            z5 = dangerousSettings.customEntitlementComputation;
        }
        return dangerousSettings.copy(z4, z5);
    }

    public final boolean component1() {
        return this.autoSyncPurchases;
    }

    public final boolean component2$purchases_defaultsRelease() {
        return this.customEntitlementComputation;
    }

    public final DangerousSettings copy(boolean z4, boolean z5) {
        return new DangerousSettings(z4, z5);
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
        boolean z4 = this.autoSyncPurchases;
        ?? r02 = z4;
        if (z4) {
            r02 = 1;
        }
        int i4 = r02 * 31;
        boolean z5 = this.customEntitlementComputation;
        return i4 + (z5 ? 1 : z5);
    }

    public String toString() {
        return "DangerousSettings(autoSyncPurchases=" + this.autoSyncPurchases + ", customEntitlementComputation=" + this.customEntitlementComputation + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        out.writeInt(this.autoSyncPurchases ? 1 : 0);
        out.writeInt(this.customEntitlementComputation ? 1 : 0);
    }

    public DangerousSettings(boolean z4, boolean z5) {
        this.autoSyncPurchases = z4;
        this.customEntitlementComputation = z5;
    }

    public /* synthetic */ DangerousSettings(boolean z4, boolean z5, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? true : z4, (i4 & 2) != 0 ? false : z5);
    }

    public DangerousSettings(boolean z4) {
        this(z4, false);
    }

    public /* synthetic */ DangerousSettings(boolean z4, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? true : z4);
    }
}
