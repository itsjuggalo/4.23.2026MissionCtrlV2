package com.google.android.gms.internal.auth_blockstore;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import h5.c;
import h5.d;
import h5.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzg extends zza implements IInterface {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.blockstore.internal.IBlockstoreService");
    }

    public final void zza(zzi zziVar, c cVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zziVar);
        zzc.zzb(parcelObtainAndWriteInterfaceToken, cVar);
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

    public final void zzd(zzm zzmVar, d dVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zzmVar);
        zzc.zzb(parcelObtainAndWriteInterfaceToken, dVar);
        transactAndReadExceptionReturnVoid(12, parcelObtainAndWriteInterfaceToken);
    }

    public final void zze(zzo zzoVar, f fVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zzc(parcelObtainAndWriteInterfaceToken, zzoVar);
        zzc.zzb(parcelObtainAndWriteInterfaceToken, fVar);
        transactAndReadExceptionReturnVoid(10, parcelObtainAndWriteInterfaceToken);
    }
}
