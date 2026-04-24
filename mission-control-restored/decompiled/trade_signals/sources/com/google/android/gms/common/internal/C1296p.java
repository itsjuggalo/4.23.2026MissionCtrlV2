package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1296p extends T1.a {
    public static final Parcelable.Creator<C1296p> CREATOR = new V();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15050e;

    public C1296p(int i8, boolean z7, boolean z8, int i9, int i10) {
        this.f15046a = i8;
        this.f15047b = z7;
        this.f15048c = z8;
        this.f15049d = i9;
        this.f15050e = i10;
    }

    public int a() {
        return this.f15049d;
    }

    public int d() {
        return this.f15050e;
    }

    public boolean e() {
        return this.f15047b;
    }

    public boolean f() {
        return this.f15048c;
    }

    public int h() {
        return this.f15046a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, h());
        T1.c.c(parcel, 2, e());
        T1.c.c(parcel, 3, f());
        T1.c.j(parcel, 4, a());
        T1.c.j(parcel, 5, d());
        T1.c.b(parcel, iA);
    }
}
