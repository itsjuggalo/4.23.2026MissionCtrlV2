package com.google.android.gms.internal.auth;

import G1.b;
import G1.c;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzbo extends e {
    public zzbo(Activity activity, c cVar) {
        super(activity, b.f2412a, (a.d) (cVar == null ? c.f2416b : cVar), e.a.f10853c);
    }

    public final Task<String> getSpatulaHeader() {
        return doRead(AbstractC1186x.a().b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth.zzbk
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1520).a());
    }

    public final Task<K1.c> performProxyRequest(final K1.b bVar) {
        return doWrite(AbstractC1186x.a().b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth.zzbl
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                zzbo zzboVar = this.zza;
                K1.b bVar2 = bVar;
                ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), bVar2);
            }
        }).e(1518).a());
    }

    public zzbo(Context context, c cVar) {
        super(context, b.f2412a, cVar == null ? c.f2416b : cVar, e.a.f10853c);
    }
}
