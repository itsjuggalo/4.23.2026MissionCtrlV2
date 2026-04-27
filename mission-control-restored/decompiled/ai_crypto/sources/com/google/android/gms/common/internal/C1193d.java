package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1193d extends Q1.a {
    public static final Parcelable.Creator<C1193d> CREATOR = new A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11060b;

    public C1193d(int i7, String str) {
        this.f11059a = i7;
        this.f11060b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1193d)) {
            return false;
        }
        C1193d c1193d = (C1193d) obj;
        return c1193d.f11059a == this.f11059a && AbstractC1206q.b(c1193d.f11060b, this.f11060b);
    }

    public final int hashCode() {
        return this.f11059a;
    }

    public final String toString() {
        return this.f11059a + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f11060b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f11059a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.E(parcel, 2, this.f11060b, false);
        Q1.c.b(parcel, iA);
    }
}
