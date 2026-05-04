package com.google.android.recaptcha.internal;

import cd.h0;
import gd.e;
import id.m;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzam extends m implements o {
    Object zza;
    int zzb;
    final /* synthetic */ zzan zzc;
    final /* synthetic */ zzen zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzam(zzan zzanVar, zzen zzenVar, e eVar) {
        super(2, eVar);
        this.zzc = zzanVar;
        this.zzd = zzenVar;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzam(this.zzc, this.zzd, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzam) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    @Override // id.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = hd.c.f()
            int r1 = r6.zzb
            if (r1 == 0) goto L12
            java.lang.Object r0 = r6.zza
            kotlin.jvm.internal.m0 r0 = (kotlin.jvm.internal.m0) r0
            cd.s.b(r7)     // Catch: java.lang.Exception -> L10
            goto L60
        L10:
            r7 = move-exception
            goto L37
        L12:
            cd.s.b(r7)
            kotlin.jvm.internal.m0 r7 = new kotlin.jvm.internal.m0
            r7.<init>()
            com.google.android.recaptcha.internal.zzal r1 = new com.google.android.recaptcha.internal.zzal     // Catch: java.lang.Exception -> L33
            com.google.android.recaptcha.internal.zzan r2 = r6.zzc     // Catch: java.lang.Exception -> L33
            com.google.android.recaptcha.internal.zzen r3 = r6.zzd     // Catch: java.lang.Exception -> L33
            r4 = 0
            r1.<init>(r2, r3, r7, r4)     // Catch: java.lang.Exception -> L33
            r6.zza = r7     // Catch: java.lang.Exception -> L33
            r2 = 1
            r6.zzb = r2     // Catch: java.lang.Exception -> L33
            r2 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r7 = ng.y2.c(r2, r1, r6)     // Catch: java.lang.Exception -> L33
            if (r7 != r0) goto L60
            return r0
        L33:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L37:
            com.google.android.recaptcha.internal.zzan r1 = r6.zzc
            ng.x r1 = r1.zzf()
            java.lang.Object r0 = r0.f14947a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 != 0) goto L44
            r0 = r7
        L44:
            r1.E(r0)
            com.google.android.recaptcha.internal.zzan r0 = r6.zzc
            com.google.android.recaptcha.internal.zzao r1 = com.google.android.recaptcha.internal.zzao.zza
            com.google.android.recaptcha.internal.zzan.zzh(r0, r1)
            com.google.android.recaptcha.internal.zzen r0 = r6.zzd
            com.google.android.recaptcha.internal.zzbd r1 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r2 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r3 = com.google.android.recaptcha.internal.zzba.zza
            java.lang.String r7 = r7.getMessage()
            r1.<init>(r2, r3, r7)
            r0.zzb(r1)
        L60:
            cd.h0 r7 = cd.h0.f3852a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzam.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
