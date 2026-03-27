package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.AbstractC0921z;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import n1.AbstractC1624j;
import n1.AbstractC1625k;
import n1.C1616b;

/* JADX INFO: loaded from: classes.dex */
final class zzab extends e implements zzg {
    private static final a.g zza;
    private static final a.AbstractC0145a zzb;
    private static final a zzc;
    private static final C1.a zzd;
    private final Context zze;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzc = new a("GoogleAuthService.API", zzvVar, gVar);
        zzd = AbstractC1624j.a("GoogleAuthServiceClient");
    }

    public zzab(Context context) {
        super(context, zzc, a.d.f9667K, e.a.f9668c);
        this.zze = context;
    }

    public static /* bridge */ /* synthetic */ void zzf(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (AbstractC0921z.c(status, obj, taskCompletionSource)) {
            return;
        }
        zzd.h("The task is already complete.", new Object[0]);
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zza(final zzbw zzbwVar) {
        return doWrite(AbstractC0920y.a().d(AbstractC1625k.f13613l).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzt
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzd(new zzx(zzabVar, (TaskCompletionSource) obj2), zzbwVar);
            }
        }).e(1513).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzb(final C1616b c1616b) {
        AbstractC0940s.l(c1616b, "request cannot be null.");
        return doWrite(AbstractC0920y.a().d(AbstractC1625k.f13612k).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzu
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                C1616b c1616b2 = c1616b;
                ((zzp) ((zzi) obj).getService()).zze(new zzz(zzabVar, (TaskCompletionSource) obj2), c1616b2);
            }
        }).e(1515).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzc(final Account account, final String str, final Bundle bundle) {
        AbstractC0940s.l(account, "Account name cannot be null!");
        AbstractC0940s.f(str, "Scope cannot be null!");
        return doWrite(AbstractC0920y.a().d(AbstractC1625k.f13613l).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzs
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzf(new zzw(zzabVar, (TaskCompletionSource) obj2), account, str, bundle);
            }
        }).e(1512).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzd(final Account account) {
        AbstractC0940s.l(account, "account cannot be null.");
        return doWrite(AbstractC0920y.a().d(AbstractC1625k.f13612k).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzr
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzg(new zzaa(zzabVar, (TaskCompletionSource) obj2), account);
            }
        }).e(1517).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zze(final String str) {
        AbstractC0940s.l(str, "Client package name cannot be null!");
        return doWrite(AbstractC0920y.a().d(AbstractC1625k.f13612k).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth.zzq
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzh(new zzy(zzabVar, (TaskCompletionSource) obj2), str);
            }
        }).e(1514).a());
    }
}
