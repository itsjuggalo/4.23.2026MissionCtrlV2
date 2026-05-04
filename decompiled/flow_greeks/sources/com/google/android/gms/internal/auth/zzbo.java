package com.google.android.gms.internal.auth;

import a5.b;
import a5.c;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbo extends f {
    public zzbo(Activity activity, c cVar) {
        super(activity, b.f77a, (a.d) (cVar == null ? c.f81b : cVar), f.a.f5486c);
    }

    public final Task<String> getSpatulaHeader() {
        return doRead(v.a().b(new q() { // from class: com.google.android.gms.internal.auth.zzbk
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1520).a());
    }

    public final Task<e5.c> performProxyRequest(final e5.b bVar) {
        return doWrite(v.a().b(new q() { // from class: com.google.android.gms.internal.auth.zzbl
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                zzbo zzboVar = this.zza;
                e5.b bVar2 = bVar;
                ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), bVar2);
            }
        }).e(1518).a());
    }

    public zzbo(Context context, c cVar) {
        super(context, b.f77a, cVar == null ? c.f81b : cVar, f.a.f5486c);
    }
}
