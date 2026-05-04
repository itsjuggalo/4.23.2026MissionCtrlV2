package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import java.util.Objects;
import w.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzhm extends h {
    final /* synthetic */ zzht zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhm(zzht zzhtVar, int i10) {
        super(20);
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
    }

    @Override // w.h
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        s.e(str);
        return this.zza.zzC(str);
    }
}
