package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0926d extends A1.a {
    public static final Parcelable.Creator<C0926d> CREATOR = new A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9877b;

    public C0926d(int i4, String str) {
        this.f9876a = i4;
        this.f9877b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0926d)) {
            return false;
        }
        C0926d c0926d = (C0926d) obj;
        return c0926d.f9876a == this.f9876a && AbstractC0939q.b(c0926d.f9877b, this.f9877b);
    }

    public final int hashCode() {
        return this.f9876a;
    }

    public final String toString() {
        return this.f9876a + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f9877b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f9876a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.E(parcel, 2, this.f9877b, false);
        A1.c.b(parcel, iA);
    }
}
