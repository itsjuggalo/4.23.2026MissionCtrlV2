package com.google.android.gms.internal.measurement;

import Q1.c;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzdf extends Q1.a {
    public static final Parcelable.Creator<zzdf> CREATOR = new zzdg();
    public final int zza;
    public final String zzb;
    public final Intent zzc;

    public zzdf(int i7, String str, Intent intent) {
        this.zza = i7;
        this.zzb = str;
        this.zzc = intent;
    }

    public static zzdf zza(Activity activity) {
        return new zzdf(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdf)) {
            return false;
        }
        zzdf zzdfVar = (zzdf) obj;
        return this.zza == zzdfVar.zza && Objects.equals(this.zzb, zzdfVar.zzb) && Objects.equals(this.zzc, zzdfVar.zzc);
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.zza;
        int iA = c.a(parcel);
        c.t(parcel, 1, i8);
        c.E(parcel, 2, this.zzb, false);
        c.C(parcel, 3, this.zzc, i7, false);
        c.b(parcel, iA);
    }
}
