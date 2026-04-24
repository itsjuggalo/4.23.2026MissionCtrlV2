package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0928f extends A1.a {
    public static final Parcelable.Creator<C0928f> CREATOR = new o0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0942u f9894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f9897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f9899f;

    public C0928f(C0942u c0942u, boolean z4, boolean z5, int[] iArr, int i4, int[] iArr2) {
        this.f9894a = c0942u;
        this.f9895b = z4;
        this.f9896c = z5;
        this.f9897d = iArr;
        this.f9898e = i4;
        this.f9899f = iArr2;
    }

    public int i() {
        return this.f9898e;
    }

    public int[] k() {
        return this.f9897d;
    }

    public int[] l() {
        return this.f9899f;
    }

    public boolean m() {
        return this.f9895b;
    }

    public boolean n() {
        return this.f9896c;
    }

    public final C0942u o() {
        return this.f9894a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, this.f9894a, i4, false);
        A1.c.g(parcel, 2, m());
        A1.c.g(parcel, 3, n());
        A1.c.u(parcel, 4, k(), false);
        A1.c.t(parcel, 5, i());
        A1.c.u(parcel, 6, l(), false);
        A1.c.b(parcel, iA);
    }
}
