package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends Q1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10836b;

    public Scope(int i7, String str) {
        AbstractC1207s.f(str, "scopeUri must not be null or empty");
        this.f10835a = i7;
        this.f10836b = str;
    }

    public String A() {
        return this.f10836b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f10836b.equals(((Scope) obj).f10836b);
        }
        return false;
    }

    public int hashCode() {
        return this.f10836b.hashCode();
    }

    public String toString() {
        return this.f10836b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f10835a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.E(parcel, 2, A(), false);
        Q1.c.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
