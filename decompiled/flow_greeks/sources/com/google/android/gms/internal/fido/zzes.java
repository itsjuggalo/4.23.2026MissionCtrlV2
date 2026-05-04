package com.google.android.gms.internal.fido;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzes extends zzei {
    private final zzdn zza;
    private final Level zzb;
    private final Set zzc;
    private final zzea zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzes(String str, @NullableDecl String str2, boolean z10, zzdn zzdnVar, boolean z11, boolean z12) {
        super(str2);
        Level level = Level.ALL;
        Set set = zzeu.zza;
        zzea zzeaVar = zzeu.zzb;
        this.zza = zzdnVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzeaVar;
    }
}
