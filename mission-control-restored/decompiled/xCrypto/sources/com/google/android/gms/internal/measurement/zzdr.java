package com.google.android.gms.internal.measurement;

import J1.b;
import S1.AbstractC0562e3;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;

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
            AbstractC0940s.k(context);
            String strA = AbstractC0562e3.a(context);
            AbstractC0940s.k(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(strA)) {
                strA = AbstractC0562e3.a(context);
            }
            Boolean boolC = AbstractC0562e3.c("google_analytics_force_disable_updates", resources, strA);
            zzfb zzfbVar = this.zzc;
            zzfbVar.zzR(zzfbVar.zzc(context, boolC == null || !boolC.booleanValue()));
            if (zzfbVar.zzQ() == null) {
                Log.w(zzfbVar.zzO(), "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
            ((zzcr) AbstractC0940s.k(zzfbVar.zzQ())).initialize(b.f(context), new zzdd(130000L, Math.max(iA, r0), Boolean.TRUE.equals(boolC) || DynamiteModule.c(context, ModuleDescriptor.MODULE_ID) < iA, this.zzb, AbstractC0562e3.a(context)), this.zzh);
        } catch (Exception e4) {
            this.zzc.zzN(e4, true, false);
        }
    }
}
