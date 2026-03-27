package com.google.android.gms.common.internal;

import P1.C0648b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.InterfaceC1200k;

/* JADX INFO: loaded from: classes.dex */
public final class T extends Q1.a {
    public static final Parcelable.Creator<T> CREATOR = new U();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f11046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0648b f11047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11049e;

    public T(int i7, IBinder iBinder, C0648b c0648b, boolean z7, boolean z8) {
        this.f11045a = i7;
        this.f11046b = iBinder;
        this.f11047c = c0648b;
        this.f11048d = z7;
        this.f11049e = z8;
    }

    public final C0648b A() {
        return this.f11047c;
    }

    public final InterfaceC1200k B() {
        IBinder iBinder = this.f11046b;
        if (iBinder == null) {
            return null;
        }
        return InterfaceC1200k.a.b(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T)) {
            return false;
        }
        T t7 = (T) obj;
        return this.f11047c.equals(t7.f11047c) && AbstractC1206q.b(B(), t7.B());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f11045a);
        Q1.c.s(parcel, 2, this.f11046b, false);
        Q1.c.C(parcel, 3, this.f11047c, i7, false);
        Q1.c.g(parcel, 4, this.f11048d);
        Q1.c.g(parcel, 5, this.f11049e);
        Q1.c.b(parcel, iA);
    }
}
