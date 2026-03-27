package com.google.android.gms.internal.location;

import A1.a;
import A1.c;
import P1.AbstractBinderC0512x;
import P1.B;
import P1.C;
import P1.InterfaceC0514z;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends a {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    final int zza;
    final zzba zzb;
    final C zzc;
    final PendingIntent zzd;
    final InterfaceC0514z zze;
    final zzai zzf;

    public zzbc(int i4, zzba zzbaVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.zza = i4;
        this.zzb = zzbaVar;
        zzai zzagVar = null;
        this.zzc = iBinder == null ? null : B.zzb(iBinder);
        this.zzd = pendingIntent;
        this.zze = iBinder2 == null ? null : AbstractBinderC0512x.zzb(iBinder2);
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzagVar = iInterfaceQueryLocalInterface instanceof zzai ? (zzai) iInterfaceQueryLocalInterface : new zzag(iBinder3);
        }
        this.zzf = zzagVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r7v0, types: [P1.C, android.os.IBinder] */
    public static zzbc zza(C c4, zzai zzaiVar) {
        if (zzaiVar == null) {
            zzaiVar = null;
        }
        return new zzbc(2, null, c4, null, null, zzaiVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzbc zzb(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) {
        return new zzbc(1, zzbaVar, null, pendingIntent, null, zzaiVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r7v0, types: [P1.z, android.os.IBinder] */
    public static zzbc zzc(InterfaceC0514z interfaceC0514z, zzai zzaiVar) {
        if (zzaiVar == null) {
            zzaiVar = null;
        }
        return new zzbc(2, null, null, null, interfaceC0514z, zzaiVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.C(parcel, 2, this.zzb, i4, false);
        C c4 = this.zzc;
        c.s(parcel, 3, c4 == null ? null : c4.asBinder(), false);
        c.C(parcel, 4, this.zzd, i4, false);
        InterfaceC0514z interfaceC0514z = this.zze;
        c.s(parcel, 5, interfaceC0514z == null ? null : interfaceC0514z.asBinder(), false);
        zzai zzaiVar = this.zzf;
        c.s(parcel, 6, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        c.b(parcel, iA);
    }
}
