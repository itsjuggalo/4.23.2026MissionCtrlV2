package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaj extends zzb implements zzak {
    public zzaj() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            zzb(parcel.readInt(), parcel.createStringArray());
        } else if (i4 == 2) {
            zzc(parcel.readInt(), parcel.createStringArray());
        } else {
            if (i4 != 3) {
                return false;
            }
            zzd(parcel.readInt(), (PendingIntent) zzc.zzb(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
