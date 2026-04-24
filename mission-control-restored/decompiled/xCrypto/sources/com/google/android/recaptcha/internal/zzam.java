package com.google.android.recaptcha.internal;

import W2.E;
import Z2.e;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzam extends l implements o {
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

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzam(this.zzc, this.zzd, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzam) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    @Override // b3.AbstractC0863a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = a3.AbstractC0787c.e()
            int r1 = r6.zzb
            if (r1 == 0) goto L12
            java.lang.Object r0 = r6.zza
            kotlin.jvm.internal.F r0 = (kotlin.jvm.internal.F) r0
            W2.q.b(r7)     // Catch: java.lang.Exception -> L10
            goto L60
        L10:
            r7 = move-exception
            goto L37
        L12:
            W2.q.b(r7)
            kotlin.jvm.internal.F r7 = new kotlin.jvm.internal.F
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
            java.lang.Object r7 = t3.X0.c(r2, r1, r6)     // Catch: java.lang.Exception -> L33
            if (r7 != r0) goto L60
            return r0
        L33:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L37:
            com.google.android.recaptcha.internal.zzan r1 = r6.zzc
            t3.x r1 = r1.zzf()
            java.lang.Object r0 = r0.f13410a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 != 0) goto L44
            r0 = r7
        L44:
            r1.G(r0)
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
            W2.E r7 = W2.E.f5463a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzam.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
