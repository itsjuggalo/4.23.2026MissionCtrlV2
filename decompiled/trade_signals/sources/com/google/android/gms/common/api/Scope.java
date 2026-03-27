package com.google.android.gms.common.api;

import R1.j;
import T1.a;
import T1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14906b;

    public Scope(int i8, String str) {
        AbstractC1294n.e(str, "scopeUri must not be null or empty");
        this.f14905a = i8;
        this.f14906b = str;
    }

    public String a() {
        return this.f14906b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f14906b.equals(((Scope) obj).f14906b);
        }
        return false;
    }

    public int hashCode() {
        return this.f14906b.hashCode();
    }

    public String toString() {
        return this.f14906b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        int i9 = this.f14905a;
        int iA = c.a(parcel);
        c.j(parcel, 1, i9);
        c.p(parcel, 2, a(), false);
        c.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
