package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1209u extends Q1.a {
    public static final Parcelable.Creator<C1209u> CREATOR = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11158e;

    public C1209u(int i7, boolean z7, boolean z8, int i8, int i9) {
        this.f11154a = i7;
        this.f11155b = z7;
        this.f11156c = z8;
        this.f11157d = i8;
        this.f11158e = i9;
    }

    public int A() {
        return this.f11157d;
    }

    public int B() {
        return this.f11158e;
    }

    public boolean C() {
        return this.f11155b;
    }

    public boolean D() {
        return this.f11156c;
    }

    public int E() {
        return this.f11154a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, E());
        Q1.c.g(parcel, 2, C());
        Q1.c.g(parcel, 3, D());
        Q1.c.t(parcel, 4, A());
        Q1.c.t(parcel, 5, B());
        Q1.c.b(parcel, iA);
    }
}
