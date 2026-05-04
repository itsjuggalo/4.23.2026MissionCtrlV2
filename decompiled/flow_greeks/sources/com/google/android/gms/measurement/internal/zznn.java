package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import x4.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zznn extends zzos {
    public final zzhe zza;
    public final zzhe zzb;
    public final zzhe zzc;
    public final zzhe zzd;
    public final zzhe zze;
    public final zzhe zzf;
    private final Map zzh;

    public zznn(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzh = new HashMap();
        zzhh zzhhVarZzd = this.zzu.zzd();
        Objects.requireNonNull(zzhhVarZzd);
        this.zza = new zzhe(zzhhVarZzd, "last_delete_stale", 0L);
        zzhh zzhhVarZzd2 = this.zzu.zzd();
        Objects.requireNonNull(zzhhVarZzd2);
        this.zzb = new zzhe(zzhhVarZzd2, "last_delete_stale_batch", 0L);
        zzhh zzhhVarZzd3 = this.zzu.zzd();
        Objects.requireNonNull(zzhhVarZzd3);
        this.zzc = new zzhe(zzhhVarZzd3, "backoff", 0L);
        zzhh zzhhVarZzd4 = this.zzu.zzd();
        Objects.requireNonNull(zzhhVarZzd4);
        this.zzd = new zzhe(zzhhVarZzd4, "last_upload", 0L);
        zzhh zzhhVarZzd5 = this.zzu.zzd();
        Objects.requireNonNull(zzhhVarZzd5);
        this.zze = new zzhe(zzhhVarZzd5, "last_upload_attempt", 0L);
        zzhh zzhhVarZzd6 = this.zzu.zzd();
        Objects.requireNonNull(zzhhVarZzd6);
        this.zzf = new zzhe(zzhhVarZzd6, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    public final boolean zzbb() {
        return false;
    }

    public final Pair zzc(String str, zzjl zzjlVar) {
        return zzjlVar.zzo(zzjk.AD_STORAGE) ? zzd(str) : new Pair("", Boolean.FALSE);
    }

    @Deprecated
    public final Pair zzd(String str) {
        zznm zznmVar;
        a.C0423a c0423aA;
        zzg();
        zzic zzicVar = this.zzu;
        long jB = zzicVar.zzaZ().b();
        zznm zznmVar2 = (zznm) this.zzh.get(str);
        if (zznmVar2 != null && jB < zznmVar2.zzc) {
            return new Pair(zznmVar2.zza, Boolean.valueOf(zznmVar2.zzb));
        }
        x4.a.b(true);
        long jZzl = zzicVar.zzc().zzl(str, zzfy.zza) + jB;
        try {
            try {
                c0423aA = x4.a.a(zzicVar.zzaY());
            } catch (PackageManager.NameNotFoundException unused) {
                c0423aA = null;
                if (zznmVar2 != null && jB < zznmVar2.zzc + this.zzu.zzc().zzl(str, zzfy.zzb)) {
                    return new Pair(zznmVar2.zza, Boolean.valueOf(zznmVar2.zzb));
                }
            }
        } catch (Exception e10) {
            this.zzu.zzaV().zzj().zzb("Unable to get advertising id", e10);
            zznmVar = new zznm("", false, jZzl);
        }
        if (c0423aA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String strA = c0423aA.a();
        zznmVar = strA != null ? new zznm(strA, c0423aA.b(), jZzl) : new zznm("", c0423aA.b(), jZzl);
        this.zzh.put(str, zznmVar);
        x4.a.b(false);
        return new Pair(zznmVar.zza, Boolean.valueOf(zznmVar.zzb));
    }

    @Deprecated
    public final String zzf(String str, boolean z10) {
        zzg();
        String str2 = z10 ? (String) zzd(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestZzO = zzpp.zzO();
        if (messageDigestZzO == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzO.digest(str2.getBytes())));
    }
}
