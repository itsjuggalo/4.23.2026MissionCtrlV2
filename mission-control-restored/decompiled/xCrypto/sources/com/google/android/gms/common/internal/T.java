package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.InterfaceC0933k;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class T extends A1.a {
    public static final Parcelable.Creator<T> CREATOR = new U();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f9863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1984b f9864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9866e;

    public T(int i4, IBinder iBinder, C1984b c1984b, boolean z4, boolean z5) {
        this.f9862a = i4;
        this.f9863b = iBinder;
        this.f9864c = c1984b;
        this.f9865d = z4;
        this.f9866e = z5;
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
        T t4 = (T) obj;
        return this.f9864c.equals(t4.f9864c) && AbstractC0939q.b(k(), t4.k());
    }

    public final C1984b i() {
        return this.f9864c;
    }

    public final InterfaceC0933k k() {
        IBinder iBinder = this.f9863b;
        if (iBinder == null) {
            return null;
        }
        return InterfaceC0933k.a.b(iBinder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f9862a);
        A1.c.s(parcel, 2, this.f9863b, false);
        A1.c.C(parcel, 3, this.f9864c, i4, false);
        A1.c.g(parcel, 4, this.f9865d);
        A1.c.g(parcel, 5, this.f9866e);
        A1.c.b(parcel, iA);
    }
}
