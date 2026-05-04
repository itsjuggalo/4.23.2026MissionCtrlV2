package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import java.util.List;
import java.util.Objects;
import m7.z1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzaaz implements zzafv<zzahl> {
    private final /* synthetic */ zzafs zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ z1 zze;
    private final /* synthetic */ zzael zzf;
    private final /* synthetic */ zzahv zzg;

    public zzaaz(zzaar zzaarVar, zzafs zzafsVar, String str, String str2, Boolean bool, z1 z1Var, zzael zzaelVar, zzahv zzahvVar) {
        this.zza = zzafsVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = z1Var;
        this.zzf = zzaelVar;
        this.zzg = zzahvVar;
        Objects.requireNonNull(zzaarVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahl zzahlVar) {
        List<zzahk> listZza = zzahlVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzahk zzahkVar = listZza.get(0);
        zzaia zzaiaVarZzf = zzahkVar.zzf();
        List<zzaib> listZza2 = zzaiaVarZzf != null ? zzaiaVarZzf.zza() : null;
        if (listZza2 != null && !listZza2.isEmpty()) {
            if (TextUtils.isEmpty(this.zzb)) {
                listZza2.get(0).zza(this.zzc);
            } else {
                int i10 = 0;
                while (true) {
                    if (i10 >= listZza2.size()) {
                        break;
                    }
                    if (listZza2.get(i10).zzf().equals(this.zzb)) {
                        listZza2.get(i10).zza(this.zzc);
                        break;
                    }
                    i10++;
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzahkVar.zza(bool.booleanValue());
        } else {
            zzahkVar.zza(zzahkVar.zzb() - zzahkVar.zza() < 1000);
        }
        zzahkVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzahkVar);
    }
}
