package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u extends n5.a {
    public static final Parcelable.Creator<u> CREATOR = new z0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5800e;

    public u(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f5796a = i10;
        this.f5797b = z10;
        this.f5798c = z11;
        this.f5799d = i11;
        this.f5800e = i12;
    }

    public int R() {
        return this.f5799d;
    }

    public int S() {
        return this.f5800e;
    }

    public boolean T() {
        return this.f5797b;
    }

    public boolean U() {
        return this.f5798c;
    }

    public int V() {
        return this.f5796a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, V());
        n5.c.g(parcel, 2, T());
        n5.c.g(parcel, 3, U());
        n5.c.t(parcel, 4, R());
        n5.c.t(parcel, 5, S());
        n5.c.b(parcel, iA);
    }
}
