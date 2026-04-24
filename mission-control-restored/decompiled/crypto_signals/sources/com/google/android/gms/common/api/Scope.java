package com.google.android.gms.common.api;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.ReflectedParcelable;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends AbstractC1255a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new X1(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5057b;

    public Scope(int i, String str) {
        I.e(str, "scopeUri must not be null or empty");
        this.f5056a = i;
        this.f5057b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f5057b.equals(((Scope) obj).f5057b);
    }

    public final int hashCode() {
        return this.f5057b.hashCode();
    }

    public final String toString() {
        return this.f5057b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f5056a);
        u0.T(parcel, 2, this.f5057b, false);
        u0.a0(iX, parcel);
    }
}
