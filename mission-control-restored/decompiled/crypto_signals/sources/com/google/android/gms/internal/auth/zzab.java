package com.google.android.gms.internal.auth;

import P3.v;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.internal.AbstractC0419w;
import com.google.android.gms.common.api.internal.InterfaceC0416t;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import k1.AbstractC0753f;
import k1.C0749b;
import u1.C1202d;
import x1.C1402a;

/* JADX INFO: loaded from: classes.dex */
final class zzab extends l implements zzg {
    private static final h zza;
    private static final a zzb;
    private static final i zzc;
    private static final C1402a zzd;
    private final Context zze;

    static {
        h hVar = new h();
        zza = hVar;
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzc = new i("GoogleAuthService.API", zzvVar, hVar);
        zzd = new C1402a("Auth", "GoogleAuthServiceClient");
    }

    public zzab(Context context) {
        super(context, null, zzc, e.i, k.f5176c);
        this.zze = context;
    }

    public static void zzf(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (status.m() ? taskCompletionSource.trySetResult(obj) : taskCompletionSource.trySetException(I.k(status))) {
            return;
        }
        zzd.f("The task is already complete.", new Object[0]);
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zza(final zzbw zzbwVar) {
        v vVarA = AbstractC0419w.a();
        vVarA.f2606d = new C1202d[]{AbstractC0753f.f7830c};
        vVarA.f2605c = new InterfaceC0416t() { // from class: com.google.android.gms.internal.auth.zzt
            @Override // com.google.android.gms.common.api.internal.InterfaceC0416t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzd(new zzx(zzabVar, (TaskCompletionSource) obj2), zzbwVar);
            }
        };
        vVarA.f2604b = 1513;
        return doWrite(vVarA.a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzb(final C0749b c0749b) {
        I.h(c0749b, "request cannot be null.");
        v vVarA = AbstractC0419w.a();
        vVarA.f2606d = new C1202d[]{AbstractC0753f.f7829b};
        vVarA.f2605c = new InterfaceC0416t() { // from class: com.google.android.gms.internal.auth.zzu
            @Override // com.google.android.gms.common.api.internal.InterfaceC0416t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                C0749b c0749b2 = c0749b;
                ((zzp) ((zzi) obj).getService()).zze(new zzz(zzabVar, (TaskCompletionSource) obj2), c0749b2);
            }
        };
        vVarA.f2604b = 1515;
        return doWrite(vVarA.a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzc(final Account account, final String str, final Bundle bundle) {
        I.h(account, "Account name cannot be null!");
        I.e(str, "Scope cannot be null!");
        v vVarA = AbstractC0419w.a();
        vVarA.f2606d = new C1202d[]{AbstractC0753f.f7830c};
        vVarA.f2605c = new InterfaceC0416t() { // from class: com.google.android.gms.internal.auth.zzs
            @Override // com.google.android.gms.common.api.internal.InterfaceC0416t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzf(new zzw(zzabVar, (TaskCompletionSource) obj2), account, str, bundle);
            }
        };
        vVarA.f2604b = 1512;
        return doWrite(vVarA.a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzd(final Account account) {
        I.h(account, "account cannot be null.");
        v vVarA = AbstractC0419w.a();
        vVarA.f2606d = new C1202d[]{AbstractC0753f.f7829b};
        vVarA.f2605c = new InterfaceC0416t() { // from class: com.google.android.gms.internal.auth.zzr
            @Override // com.google.android.gms.common.api.internal.InterfaceC0416t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzg(new zzaa(zzabVar, (TaskCompletionSource) obj2), account);
            }
        };
        vVarA.f2604b = 1517;
        return doWrite(vVarA.a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zze(final String str) {
        I.h(str, "Client package name cannot be null!");
        v vVarA = AbstractC0419w.a();
        vVarA.f2606d = new C1202d[]{AbstractC0753f.f7829b};
        vVarA.f2605c = new InterfaceC0416t() { // from class: com.google.android.gms.internal.auth.zzq
            @Override // com.google.android.gms.common.api.internal.InterfaceC0416t
            public final void accept(Object obj, Object obj2) {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzh(new zzy(zzabVar, (TaskCompletionSource) obj2), str);
            }
        };
        vVarA.f2604b = 1514;
        return doWrite(vVarA.a());
    }
}
