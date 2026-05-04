package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;
import w5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzdr extends zzeq {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdr(zzfb zzfbVar, Context context, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        try {
            Context context = this.zza;
            s.k(context);
            String strZza = com.google.android.gms.measurement.internal.zzhu.zza(context);
            s.k(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(strZza)) {
                strZza = com.google.android.gms.measurement.internal.zzhu.zza(context);
            }
            Boolean boolZzc = com.google.android.gms.measurement.internal.zzhu.zzc("google_analytics_force_disable_updates", resources, strZza);
            zzfb zzfbVar = this.zzc;
            zzfbVar.zzR(zzfbVar.zzc(context, boolZzc == null || !boolZzc.booleanValue()));
            if (zzfbVar.zzQ() == null) {
                Log.w(zzfbVar.zzO(), "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
            ((zzcr) s.k(zzfbVar.zzQ())).initialize(b.J(context), new zzdd(133005L, Math.max(iA, r0), Boolean.TRUE.equals(boolZzc) || DynamiteModule.c(context, ModuleDescriptor.MODULE_ID) < iA, this.zzb, com.google.android.gms.measurement.internal.zzhu.zza(context)), this.zzh);
        } catch (Exception e10) {
            this.zzc.zzN(e10, true, false);
        }
    }
}
