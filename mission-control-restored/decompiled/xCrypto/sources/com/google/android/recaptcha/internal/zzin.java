package com.google.android.recaptcha.internal;

import W2.E;
import Z2.e;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzin extends l implements o {
    int zza;
    final /* synthetic */ zzja zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzin(zzja zzjaVar, String str, e eVar) {
        super(2, eVar);
        this.zzb = zzjaVar;
        this.zzc = str;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzin(this.zzb, this.zzc, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzin) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r4.zzF(r1, r3) == r0) goto L13;
     */
    @Override // b3.AbstractC0863a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.Object r0 = a3.AbstractC0787c.e()
            int r1 = r3.zza
            r2 = 1
            W2.q.b(r4)
            if (r1 == 0) goto Lf
            if (r1 == r2) goto L19
            goto L2c
        Lf:
            com.google.android.recaptcha.internal.zzja r4 = r3.zzb
            r3.zza = r2
            java.lang.Object r4 = r4.zzw(r3)
            if (r4 == r0) goto L2f
        L19:
            android.webkit.WebView r4 = (android.webkit.WebView) r4
            r4.clearCache(r2)
            com.google.android.recaptcha.internal.zzja r4 = r3.zzb
            java.lang.String r1 = r3.zzc
            r2 = 2
            r3.zza = r2
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzja.zzu(r4, r1, r3)
            if (r4 != r0) goto L2c
            goto L2f
        L2c:
            W2.E r4 = W2.E.f5463a
            return r4
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzin.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
