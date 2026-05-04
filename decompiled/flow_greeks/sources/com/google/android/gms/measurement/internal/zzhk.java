package com.google.android.gms.measurement.internal;

import v5.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhk {
    final zzic zza;

    public zzhk(zzpg zzpgVar) {
        this.zza = zzpgVar.zzag();
    }

    public final boolean zza() {
        try {
            zzic zzicVar = this.zza;
            v5.c cVarA = d.a(zzicVar.zzaY());
            if (cVarA != null) {
                return cVarA.e("com.android.vending", 128).versionCode >= 80837300;
            }
            zzicVar.zzaV().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.zza.zzaV().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
