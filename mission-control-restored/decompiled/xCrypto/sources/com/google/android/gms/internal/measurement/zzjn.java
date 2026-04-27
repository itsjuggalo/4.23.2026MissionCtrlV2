package com.google.android.gms.internal.measurement;

import Z1.r;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzjn extends zzkg {
    private final Context zza;
    private final r zzb;

    public zzjn(Context context, r rVar) {
        this.zza = context;
        this.zzb = rVar;
    }

    public final boolean equals(Object obj) {
        r rVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkg) {
            zzkg zzkgVar = (zzkg) obj;
            if (this.zza.equals(zzkgVar.zza()) && ((rVar = this.zzb) != null ? rVar.equals(zzkgVar.zzb()) : zzkgVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        r rVar = this.zzb;
        return (iHashCode * 1000003) ^ (rVar == null ? 0 : rVar.hashCode());
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(length + 45 + strValueOf.length() + 1);
        sb.append("FlagsContext{context=");
        sb.append(string);
        sb.append(", hermeticFileOverrides=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final r zzb() {
        return this.zzb;
    }
}
