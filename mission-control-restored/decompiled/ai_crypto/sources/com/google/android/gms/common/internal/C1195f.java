package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1195f extends Q1.a {
    public static final Parcelable.Creator<C1195f> CREATOR = new o0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1209u f11077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f11080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f11082f;

    public C1195f(C1209u c1209u, boolean z7, boolean z8, int[] iArr, int i7, int[] iArr2) {
        this.f11077a = c1209u;
        this.f11078b = z7;
        this.f11079c = z8;
        this.f11080d = iArr;
        this.f11081e = i7;
        this.f11082f = iArr2;
    }

    public int A() {
        return this.f11081e;
    }

    public int[] B() {
        return this.f11080d;
    }

    public int[] C() {
        return this.f11082f;
    }

    public boolean D() {
        return this.f11078b;
    }

    public boolean E() {
        return this.f11079c;
    }

    public final C1209u F() {
        return this.f11077a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, this.f11077a, i7, false);
        Q1.c.g(parcel, 2, D());
        Q1.c.g(parcel, 3, E());
        Q1.c.u(parcel, 4, B(), false);
        Q1.c.t(parcel, 5, A());
        Q1.c.u(parcel, 6, C(), false);
        Q1.c.b(parcel, iA);
    }
}
