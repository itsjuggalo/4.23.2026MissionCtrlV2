package com.google.android.gms.internal.location;

import Q1.a;
import Q1.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import f2.AbstractBinderC1595u;
import f2.InterfaceC1596v;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends a {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    final int zza;
    final zzj zzb;
    final InterfaceC1596v zzc;
    final zzai zzd;

    public zzl(int i7, zzj zzjVar, IBinder iBinder, IBinder iBinder2) {
        this.zza = i7;
        this.zzb = zzjVar;
        zzai zzagVar = null;
        this.zzc = iBinder == null ? null : AbstractBinderC1595u.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzagVar = iInterfaceQueryLocalInterface instanceof zzai ? (zzai) iInterfaceQueryLocalInterface : new zzag(iBinder2);
        }
        this.zzd = zzagVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.C(parcel, 2, this.zzb, i7, false);
        InterfaceC1596v interfaceC1596v = this.zzc;
        c.s(parcel, 3, interfaceC1596v == null ? null : interfaceC1596v.asBinder(), false);
        zzai zzaiVar = this.zzd;
        c.s(parcel, 4, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        c.b(parcel, iA);
    }
}
