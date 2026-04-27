package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends A1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9651b;

    public Scope(int i4, String str) {
        AbstractC0940s.f(str, "scopeUri must not be null or empty");
        this.f9650a = i4;
        this.f9651b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f9651b.equals(((Scope) obj).f9651b);
        }
        return false;
    }

    public int hashCode() {
        return this.f9651b.hashCode();
    }

    public String i() {
        return this.f9651b;
    }

    public String toString() {
        return this.f9651b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f9650a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.E(parcel, 2, i(), false);
        A1.c.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
