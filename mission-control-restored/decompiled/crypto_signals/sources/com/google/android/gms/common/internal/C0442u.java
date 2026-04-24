package com.google.android.gms.common.internal;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0442u extends AbstractC1255a {
    public static final Parcelable.Creator<C0442u> CREATOR = new X1(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5285d;
    public final int e;

    public C0442u(int i, boolean z6, boolean z7, int i6, int i7) {
        this.f5282a = i;
        this.f5283b = z6;
        this.f5284c = z7;
        this.f5285d = i6;
        this.e = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f5282a);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f5283b ? 1 : 0);
        u0.b0(parcel, 3, 4);
        parcel.writeInt(this.f5284c ? 1 : 0);
        u0.b0(parcel, 4, 4);
        parcel.writeInt(this.f5285d);
        u0.b0(parcel, 5, 4);
        parcel.writeInt(this.e);
        u0.a0(iX, parcel);
    }
}
