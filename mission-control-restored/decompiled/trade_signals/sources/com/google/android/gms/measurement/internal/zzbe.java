package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends T1.a implements Iterable<String> {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();
    private final Bundle zza;

    public zzbe(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbd(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.e(parcel, 2, zzf(), false);
        T1.c.b(parcel, iA);
    }

    public final Object zza(String str) {
        return this.zza.get(str);
    }

    public final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    public final Double zzc(String str) {
        return Double.valueOf(this.zza.getDouble("value"));
    }

    public final String zzd(String str) {
        return this.zza.getString(str);
    }

    public final int zze() {
        return this.zza.size();
    }

    public final Bundle zzf() {
        return new Bundle(this.zza);
    }

    public final /* synthetic */ Bundle zzg() {
        return this.zza;
    }
}
