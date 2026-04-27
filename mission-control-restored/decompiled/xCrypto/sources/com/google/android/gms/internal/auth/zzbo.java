package com.google.android.gms.internal.auth;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import p1.AbstractC1687b;
import p1.C1688c;
import t1.b;
import t1.c;

/* JADX INFO: loaded from: classes.dex */
public final class zzbo extends e {
    public zzbo(Activity activity, C1688c c1688c) {
        super(activity, AbstractC1687b.f13983a, (a.d) (c1688c == null ? C1688c.f13987b : c1688c), e.a.f9668c);
    }

    public final Task<String> getSpatulaHeader() {
        return doRead(AbstractC0920y.a().b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzbk
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1520).a());
    }

    public final Task<c> performProxyRequest(final b bVar) {
        return doWrite(AbstractC0920y.a().b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzbl
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                zzbo zzboVar = this.zza;
                b bVar2 = bVar;
                ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), bVar2);
            }
        }).e(1518).a());
    }

    public zzbo(Context context, C1688c c1688c) {
        super(context, AbstractC1687b.f13983a, c1688c == null ? C1688c.f13987b : c1688c, e.a.f9668c);
    }
}
