package com.google.android.gms.internal.measurement;

import T1.c;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzdf extends T1.a {
    public static final Parcelable.Creator<zzdf> CREATOR = new zzdg();
    public final int zza;
    public final String zzb;
    public final Intent zzc;

    public zzdf(int i8, String str, Intent intent) {
        this.zza = i8;
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
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = this.zza;
        int iA = c.a(parcel);
        c.j(parcel, 1, i9);
        c.p(parcel, 2, this.zzb, false);
        c.o(parcel, 3, this.zzc, i8, false);
        c.b(parcel, iA);
    }
}
