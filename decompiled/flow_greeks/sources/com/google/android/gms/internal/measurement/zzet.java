package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.s;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzet extends zzeq {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ Activity zzb;
    final /* synthetic */ zzfa zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzet(zzfa zzfaVar, Bundle bundle, Activity activity) {
        super(zzfaVar.zza, true);
        this.zza = bundle;
        this.zzb = activity;
        Objects.requireNonNull(zzfaVar);
        this.zzc = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        Bundle bundle;
        Bundle bundle2 = this.zza;
        if (bundle2 != null) {
            bundle = new Bundle();
            if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = bundle2.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        zzcr zzcrVar = (zzcr) s.k(this.zzc.zza.zzQ());
        Activity activity = this.zzb;
        zzcrVar.onActivityCreatedByScionActivityInfo(zzdf.zza(activity), bundle, this.zzi);
    }
}
