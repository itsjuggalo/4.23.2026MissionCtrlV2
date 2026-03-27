package com.google.android.gms.internal.location;

import Q1.a;
import Q1.c;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import f2.AbstractBinderC1551B;
import f2.AbstractBinderC1598x;
import f2.InterfaceC1552C;
import f2.InterfaceC1600z;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends a {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    final int zza;
    final zzba zzb;
    final InterfaceC1552C zzc;
    final PendingIntent zzd;
    final InterfaceC1600z zze;
    final zzai zzf;

    public zzbc(int i7, zzba zzbaVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.zza = i7;
        this.zzb = zzbaVar;
        zzai zzagVar = null;
        this.zzc = iBinder == null ? null : AbstractBinderC1551B.zzb(iBinder);
        this.zzd = pendingIntent;
        this.zze = iBinder2 == null ? null : AbstractBinderC1598x.zzb(iBinder2);
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzagVar = iInterfaceQueryLocalInterface instanceof zzai ? (zzai) iInterfaceQueryLocalInterface : new zzag(iBinder3);
        }
        this.zzf = zzagVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, f2.C] */
    public static zzbc zza(InterfaceC1552C interfaceC1552C, zzai zzaiVar) {
        if (zzaiVar == null) {
            zzaiVar = null;
        }
        return new zzbc(2, null, interfaceC1552C, null, null, zzaiVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzbc zzb(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) {
        return new zzbc(1, zzbaVar, null, pendingIntent, null, zzaiVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, f2.z] */
    public static zzbc zzc(InterfaceC1600z interfaceC1600z, zzai zzaiVar) {
        if (zzaiVar == null) {
            zzaiVar = null;
        }
        return new zzbc(2, null, null, null, interfaceC1600z, zzaiVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.C(parcel, 2, this.zzb, i7, false);
        InterfaceC1552C interfaceC1552C = this.zzc;
        c.s(parcel, 3, interfaceC1552C == null ? null : interfaceC1552C.asBinder(), false);
        c.C(parcel, 4, this.zzd, i7, false);
        InterfaceC1600z interfaceC1600z = this.zze;
        c.s(parcel, 5, interfaceC1600z == null ? null : interfaceC1600z.asBinder(), false);
        zzai zzaiVar = this.zzf;
        c.s(parcel, 6, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        c.b(parcel, iA);
    }
}
