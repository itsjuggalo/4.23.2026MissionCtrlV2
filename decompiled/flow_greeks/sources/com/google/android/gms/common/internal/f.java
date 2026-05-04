package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends n5.a {
    public static final Parcelable.Creator<f> CREATOR = new j1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f5696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f5699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f5701f;

    public f(u uVar, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.f5696a = uVar;
        this.f5697b = z10;
        this.f5698c = z11;
        this.f5699d = iArr;
        this.f5700e = i10;
        this.f5701f = iArr2;
    }

    public int R() {
        return this.f5700e;
    }

    public int[] S() {
        return this.f5699d;
    }

    public int[] T() {
        return this.f5701f;
    }

    public boolean U() {
        return this.f5697b;
    }

    public boolean V() {
        return this.f5698c;
    }

    public final u W() {
        return this.f5696a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, this.f5696a, i10, false);
        n5.c.g(parcel, 2, U());
        n5.c.g(parcel, 3, V());
        n5.c.u(parcel, 4, S(), false);
        n5.c.t(parcel, 5, R());
        n5.c.u(parcel, 6, T(), false);
        n5.c.b(parcel, iA);
    }
}
