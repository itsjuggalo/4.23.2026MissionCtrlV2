package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends e {
    private static final a.g zza;
    private static final a.AbstractC0145a zzb;
    private static final a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzc = new a("SmsCodeAutofill.API", zznVar, gVar);
    }

    public zzr(Activity activity) {
        super(activity, zzc, (a.d) a.d.f9667K, e.a.f9668c);
    }

    public final Task<Integer> checkPermissionState() {
        return doRead(AbstractC0920y.a().d(zzac.zza).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api-phone.zzk
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzc(new zzp(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1564).a());
    }

    public final Task<Boolean> hasOngoingSmsRequest(final String str) {
        AbstractC0940s.k(str);
        AbstractC0940s.b(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(AbstractC0920y.a().d(zzac.zza).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api-phone.zzl
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzd(str, new zzq(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1565).a());
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(AbstractC0920y.a().d(zzac.zza).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api-phone.zzm
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zze(new zzo(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1563).a());
    }

    public zzr(Context context) {
        super(context, zzc, a.d.f9667K, e.a.f9668c);
    }
}
