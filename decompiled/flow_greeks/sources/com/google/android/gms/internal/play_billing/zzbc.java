package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbc {
    private final String zza;
    private final zzbb zzb;
    private zzbb zzc;

    public /* synthetic */ zzbc(String str, zzbd zzbdVar) {
        zzbb zzbbVar = new zzbb();
        this.zzb = zzbbVar;
        this.zzc = zzbbVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzbb zzbbVar = this.zzb.zzb;
        String str = "";
        while (zzbbVar != null) {
            Object obj = zzbbVar.zza;
            sb2.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                sb2.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzbbVar = zzbbVar.zzb;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzbc zza(Object obj) {
        zzbb zzbbVar = new zzbb();
        this.zzc.zzb = zzbbVar;
        this.zzc = zzbbVar;
        zzbbVar.zza = obj;
        return this;
    }
}
