package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends n5.a {
    public static final Parcelable.Creator<q0> CREATOR = new r0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f5781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m5.b f5782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5784e;

    public q0(int i10, IBinder iBinder, m5.b bVar, boolean z10, boolean z11) {
        this.f5780a = i10;
        this.f5781b = iBinder;
        this.f5782c = bVar;
        this.f5783d = z10;
        this.f5784e = z11;
    }

    public final k R() {
        IBinder iBinder = this.f5781b;
        if (iBinder == null) {
            return null;
        }
        return k.a.H(iBinder);
    }

    public final m5.b S() {
        return this.f5782c;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.f5782c.equals(q0Var.f5782c) && q.b(R(), q0Var.R());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f5780a);
        n5.c.s(parcel, 2, this.f5781b, false);
        n5.c.C(parcel, 3, this.f5782c, i10, false);
        n5.c.g(parcel, 4, this.f5783d);
        n5.c.g(parcel, 5, this.f5784e);
        n5.c.b(parcel, iA);
    }
}
