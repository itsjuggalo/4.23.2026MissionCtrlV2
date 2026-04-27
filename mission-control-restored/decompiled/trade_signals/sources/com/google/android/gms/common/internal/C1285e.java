package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1285e extends T1.a {
    public static final Parcelable.Creator<C1285e> CREATOR = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1296p f14974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f14977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f14979f;

    public C1285e(C1296p c1296p, boolean z7, boolean z8, int[] iArr, int i8, int[] iArr2) {
        this.f14974a = c1296p;
        this.f14975b = z7;
        this.f14976c = z8;
        this.f14977d = iArr;
        this.f14978e = i8;
        this.f14979f = iArr2;
    }

    public int a() {
        return this.f14978e;
    }

    public int[] d() {
        return this.f14977d;
    }

    public int[] e() {
        return this.f14979f;
    }

    public boolean f() {
        return this.f14975b;
    }

    public boolean h() {
        return this.f14976c;
    }

    public final C1296p n() {
        return this.f14974a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.o(parcel, 1, this.f14974a, i8, false);
        T1.c.c(parcel, 2, f());
        T1.c.c(parcel, 3, h());
        T1.c.k(parcel, 4, d(), false);
        T1.c.j(parcel, 5, a());
        T1.c.k(parcel, 6, e(), false);
        T1.c.b(parcel, iA);
    }
}
