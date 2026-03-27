package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.InterfaceC1289i;

/* JADX INFO: loaded from: classes.dex */
public final class I extends T1.a {
    public static final Parcelable.Creator<I> CREATOR = new J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f14930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0790b f14931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14933e;

    public I(int i8, IBinder iBinder, C0790b c0790b, boolean z7, boolean z8) {
        this.f14929a = i8;
        this.f14930b = iBinder;
        this.f14931c = c0790b;
        this.f14932d = z7;
        this.f14933e = z8;
    }

    public final C0790b a() {
        return this.f14931c;
    }

    public final InterfaceC1289i d() {
        IBinder iBinder = this.f14930b;
        if (iBinder == null) {
            return null;
        }
        return InterfaceC1289i.a.E(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return false;
        }
        I i8 = (I) obj;
        return this.f14931c.equals(i8.f14931c) && AbstractC1293m.a(d(), i8.d());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, this.f14929a);
        T1.c.i(parcel, 2, this.f14930b, false);
        T1.c.o(parcel, 3, this.f14931c, i8, false);
        T1.c.c(parcel, 4, this.f14932d);
        T1.c.c(parcel, 5, this.f14933e);
        T1.c.b(parcel, iA);
    }
}
