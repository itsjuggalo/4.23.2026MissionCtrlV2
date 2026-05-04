package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzeu extends zzei {
    private static final Set zza;
    private static final zzea zzb;
    private static final zzer zzc;
    private final String zzd;
    private final zzdn zze;
    private final Level zzf;
    private final Set zzg;
    private final zzea zzh;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzdh.zza, zzdm.zza)));
        zza = setUnmodifiableSet;
        zzb = zzed.zza(setUnmodifiableSet).zzd();
        zzc = new zzer();
    }

    public /* synthetic */ zzeu(String str, String str2, boolean z10, zzdn zzdnVar, Level level, Set set, zzea zzeaVar, zzet zzetVar) {
        super(str2);
        if (str2.length() > 23) {
            int i10 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char cCharAt = str2.charAt(length);
                if (cCharAt == '.' || cCharAt == '$') {
                    i10 = length;
                    break;
                }
            }
            str2 = str2.substring(i10 + 1);
        }
        String strConcat = "".concat(String.valueOf(str2));
        this.zzd = strConcat.substring(0, Math.min(strConcat.length(), 23));
        this.zze = zzdnVar;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzeaVar;
    }

    public static zzer zzc() {
        return zzc;
    }
}
