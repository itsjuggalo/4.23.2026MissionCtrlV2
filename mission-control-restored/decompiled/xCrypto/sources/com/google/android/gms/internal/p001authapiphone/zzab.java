package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import s1.AbstractC1766b;

/* JADX INFO: loaded from: classes.dex */
public final class zzab extends AbstractC1766b {
    public zzab(Activity activity) {
        super(activity);
    }

    @Override // s1.AbstractC1766b
    public final Task<Void> startSmsRetriever() {
        return doWrite(AbstractC0920y.a().b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api-phone.zzx
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzg(new zzz(this.zza, (TaskCompletionSource) obj2));
            }
        }).d(zzac.zzc).e(1567).a());
    }

    public final Task<Void> startSmsUserConsent(final String str) {
        return doWrite(AbstractC0920y.a().b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api-phone.zzy
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzh(str, new zzaa(this.zza, (TaskCompletionSource) obj2));
            }
        }).d(zzac.zzd).e(1568).a());
    }

    public zzab(Context context) {
        super(context);
    }
}
