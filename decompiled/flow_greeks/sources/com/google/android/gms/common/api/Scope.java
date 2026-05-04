package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5453b;

    public Scope(int i10, String str) {
        com.google.android.gms.common.internal.s.f(str, "scopeUri must not be null or empty");
        this.f5452a = i10;
        this.f5453b = str;
    }

    public String R() {
        return this.f5453b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f5453b.equals(((Scope) obj).f5453b);
        }
        return false;
    }

    public int hashCode() {
        return this.f5453b.hashCode();
    }

    public String toString() {
        return this.f5453b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f5452a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.E(parcel, 2, R(), false);
        n5.c.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
