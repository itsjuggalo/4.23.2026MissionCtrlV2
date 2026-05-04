package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.Objects;
import m7.o0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzabm implements zzafv<zzajj> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzafv zzb;
    private final /* synthetic */ zzabj zzc;

    public zzabm(zzabj zzabjVar, zzael zzaelVar, zzafv zzafvVar) {
        this.zza = zzaelVar;
        this.zzb = zzafvVar;
        Objects.requireNonNull(zzabjVar);
        this.zzc = zzabjVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzajj zzajjVar) {
        zzajj zzajjVar2 = zzajjVar;
        if (TextUtils.isEmpty(zzajjVar2.zze())) {
            this.zzc.zza.zza(new zzahv(zzajjVar2.zzd(), zzajjVar2.zzb(), Long.valueOf(zzajjVar2.zza()), "Bearer"), null, Constants.SIGN_IN_METHOD_PHONE, Boolean.valueOf(zzajjVar2.zzf()), null, this.zza, this.zzb);
        } else {
            this.zza.zza(new Status(17025), o0.Y(zzajjVar2.zzc(), zzajjVar2.zze()));
        }
    }
}
