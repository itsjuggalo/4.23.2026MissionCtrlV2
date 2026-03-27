package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends e {
    private static final a.g zza;
    private static final a.AbstractC0178a zzb;
    private static final a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzc = new a("SmsCodeAutofill.API", zznVar, gVar);
    }

    public zzr(Activity activity) {
        super(activity, zzc, (a.d) a.d.f10852M, e.a.f10853c);
    }

    public final Task<Integer> checkPermissionState() {
        return doRead(AbstractC1186x.a().d(zzac.zza).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api-phone.zzk
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzc(new zzp(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1564).a());
    }

    public final Task<Boolean> hasOngoingSmsRequest(final String str) {
        AbstractC1207s.k(str);
        AbstractC1207s.b(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(AbstractC1186x.a().d(zzac.zza).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api-phone.zzl
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzd(str, new zzq(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1565).a());
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(AbstractC1186x.a().d(zzac.zza).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api-phone.zzm
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zze(new zzo(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1563).a());
    }

    public zzr(Context context) {
        super(context, zzc, a.d.f10852M, e.a.f10853c);
    }
}
