package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0942u extends A1.a {
    public static final Parcelable.Creator<C0942u> CREATOR = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9975e;

    public C0942u(int i4, boolean z4, boolean z5, int i5, int i6) {
        this.f9971a = i4;
        this.f9972b = z4;
        this.f9973c = z5;
        this.f9974d = i5;
        this.f9975e = i6;
    }

    public int i() {
        return this.f9974d;
    }

    public int k() {
        return this.f9975e;
    }

    public boolean l() {
        return this.f9972b;
    }

    public boolean m() {
        return this.f9973c;
    }

    public int n() {
        return this.f9971a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, n());
        A1.c.g(parcel, 2, l());
        A1.c.g(parcel, 3, m());
        A1.c.t(parcel, 4, i());
        A1.c.t(parcel, 5, k());
        A1.c.b(parcel, iA);
    }
}
