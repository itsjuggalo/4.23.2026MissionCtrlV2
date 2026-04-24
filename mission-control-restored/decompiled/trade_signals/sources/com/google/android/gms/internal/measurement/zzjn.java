package com.google.android.gms.internal.measurement;

import android.content.Context;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes.dex */
final class zzjn extends zzkh {
    private final Context zza;
    private final InterfaceC2853s zzb;

    public zzjn(Context context, InterfaceC2853s interfaceC2853s) {
        this.zza = context;
        this.zzb = interfaceC2853s;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkh) {
            zzkh zzkhVar = (zzkh) obj;
            if (this.zza.equals(zzkhVar.zza())) {
                InterfaceC2853s interfaceC2853s = this.zzb;
                InterfaceC2853s interfaceC2853sZzb = zzkhVar.zzb();
                if (interfaceC2853s != null ? interfaceC2853s.equals(interfaceC2853sZzb) : interfaceC2853sZzb == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        InterfaceC2853s interfaceC2853s = this.zzb;
        return (iHashCode * 1000003) ^ (interfaceC2853s == null ? 0 : interfaceC2853s.hashCode());
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
    public final InterfaceC2853s zzb() {
        return this.zzb;
    }
}
