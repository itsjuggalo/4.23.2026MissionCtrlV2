package com.google.android.gms.internal.auth_blockstore;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import w1.C1902c;
import w1.C1903d;
import w1.f;

/* JADX INFO: loaded from: classes.dex */
public final class zzg extends zza implements IInterface {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.blockstore.internal.IBlockstoreService");
    }

    public final void zza(zzi zziVar, C1902c c1902c) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zziVar);
        zzc.zzb(parcelObtainAndWriteInterfaceToken, c1902c);
        transactAndReadExceptionReturnVoid(13, parcelObtainAndWriteInterfaceToken);
    }

    public final void zzb(zzk zzkVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zzkVar);
        transactAndReadExceptionReturnVoid(11, parcelObtainAndWriteInterfaceToken);
    }

    public final void zzc(zzm zzmVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zzmVar);
        transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
    }

    public final void zzd(zzm zzmVar, C1903d c1903d) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zzmVar);
        zzc.zzb(parcelObtainAndWriteInterfaceToken, c1903d);
        transactAndReadExceptionReturnVoid(12, parcelObtainAndWriteInterfaceToken);
    }

    public final void zze(zzo zzoVar, f fVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zzoVar);
        zzc.zzb(parcelObtainAndWriteInterfaceToken, fVar);
        transactAndReadExceptionReturnVoid(10, parcelObtainAndWriteInterfaceToken);
    }
}
