package com.google.android.gms.measurement.internal;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzot {
    private final String zza;
    private final Map zzb;
    private final zzls zzc;
    private final com.google.android.gms.internal.measurement.zzis zzd;

    public zzot(String str, Map map, zzls zzlsVar, com.google.android.gms.internal.measurement.zzis zzisVar) {
        this.zza = str;
        this.zzb = map;
        this.zzc = zzlsVar;
        this.zzd = zzisVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        Map map = this.zzb;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public final zzls zzc() {
        return this.zzc;
    }

    public final com.google.android.gms.internal.measurement.zzis zzd() {
        return this.zzd;
    }
}
