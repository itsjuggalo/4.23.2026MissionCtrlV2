package com.google.android.gms.internal.measurement;

import U1.l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzjn extends zzkh {
    private final Context zza;
    private final l zzb;

    public zzjn(Context context, l lVar) {
        this.zza = context;
        this.zzb = lVar;
    }

    public final boolean equals(Object obj) {
        l lVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkh) {
            zzkh zzkhVar = (zzkh) obj;
            if (this.zza.equals(zzkhVar.zza()) && ((lVar = this.zzb) != null ? lVar.equals(zzkhVar.zzb()) : zzkhVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        l lVar = this.zzb;
        return (iHashCode * 1000003) ^ (lVar == null ? 0 : lVar.hashCode());
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

    @Override // com.google.android.gms.internal.measurement.zzkh
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkh
    public final l zzb() {
        return this.zzb;
    }
}
