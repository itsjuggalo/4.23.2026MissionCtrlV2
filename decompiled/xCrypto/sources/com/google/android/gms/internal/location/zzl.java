package com.google.android.gms.internal.location;

import A1.a;
import A1.c;
import P1.AbstractBinderC0509u;
import P1.InterfaceC0510v;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends a {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    final int zza;
    final zzj zzb;
    final InterfaceC0510v zzc;
    final zzai zzd;

    public zzl(int i4, zzj zzjVar, IBinder iBinder, IBinder iBinder2) {
        this.zza = i4;
        this.zzb = zzjVar;
        zzai zzagVar = null;
        this.zzc = iBinder == null ? null : AbstractBinderC0509u.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzagVar = iInterfaceQueryLocalInterface instanceof zzai ? (zzai) iInterfaceQueryLocalInterface : new zzag(iBinder2);
        }
        this.zzd = zzagVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.C(parcel, 2, this.zzb, i4, false);
        InterfaceC0510v interfaceC0510v = this.zzc;
        c.s(parcel, 3, interfaceC0510v == null ? null : interfaceC0510v.asBinder(), false);
        zzai zzaiVar = this.zzd;
        c.s(parcel, 4, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        c.b(parcel, iA);
    }
}
