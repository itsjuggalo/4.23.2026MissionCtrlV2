package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5671b;

    public d(int i10, String str) {
        this.f5670a = i10;
        this.f5671b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f5670a == this.f5670a && q.b(dVar.f5671b, this.f5671b);
    }

    public final int hashCode() {
        return this.f5670a;
    }

    public final String toString() {
        int i10 = this.f5670a;
        int length = String.valueOf(i10).length();
        String str = this.f5671b;
        StringBuilder sb2 = new StringBuilder(length + 1 + String.valueOf(str).length());
        sb2.append(i10);
        sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb2.append(str);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f5670a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.E(parcel, 2, this.f5671b, false);
        n5.c.b(parcel, iA);
    }
}
