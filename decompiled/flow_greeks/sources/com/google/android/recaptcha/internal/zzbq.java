package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbq {
    public static final zzbq zza = new zzbq();

    private zzbq() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
    
        if (ng.x0.a(r7, r1) != r3) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ae -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zza(pd.k r18, long r19, long r21, double r23, pd.k r25, gd.e r26) throws java.lang.Exception {
        /*
            r17 = this;
            r0 = r26
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzbp
            if (r1 == 0) goto L17
            r1 = r0
            com.google.android.recaptcha.internal.zzbp r1 = (com.google.android.recaptcha.internal.zzbp) r1
            int r2 = r1.zzh
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.zzh = r2
            r2 = r17
            goto L1e
        L17:
            com.google.android.recaptcha.internal.zzbp r1 = new com.google.android.recaptcha.internal.zzbp
            r2 = r17
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.zzf
            java.lang.Object r3 = hd.c.f()
            int r4 = r1.zzh
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L62
            if (r4 == r6) goto L4e
            if (r4 != r5) goto L46
            long r7 = r1.zzd
            double r9 = r1.zze
            long r11 = r1.zzc
            java.lang.Object r4 = r1.zzb
            pd.k r4 = (pd.k) r4
            java.lang.Object r13 = r1.zza
            pd.k r13 = (pd.k) r13
            cd.s.b(r0)
        L3f:
            r15 = r13
            r13 = r1
            r1 = r15
            r15 = r11
            r11 = r9
            r9 = r15
            goto L70
        L46:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4e:
            long r7 = r1.zzd
            double r9 = r1.zze
            long r11 = r1.zzc
            java.lang.Object r4 = r1.zzb
            pd.k r4 = (pd.k) r4
            java.lang.Object r13 = r1.zza
            pd.k r13 = (pd.k) r13
            cd.s.b(r0)     // Catch: java.lang.Exception -> L60
            return r0
        L60:
            r0 = move-exception
            goto L8b
        L62:
            cd.s.b(r0)
            r7 = r19
            r9 = r21
            r11 = r23
            r4 = r25
            r13 = r1
            r1 = r18
        L70:
            r13.zza = r1     // Catch: java.lang.Exception -> L84
            r13.zzb = r4     // Catch: java.lang.Exception -> L84
            r13.zzc = r9     // Catch: java.lang.Exception -> L84
            r13.zze = r11     // Catch: java.lang.Exception -> L84
            r13.zzd = r7     // Catch: java.lang.Exception -> L84
            r13.zzh = r6     // Catch: java.lang.Exception -> L84
            java.lang.Object r0 = r4.invoke(r13)     // Catch: java.lang.Exception -> L84
            if (r0 != r3) goto L83
            goto Lb1
        L83:
            return r0
        L84:
            r0 = move-exception
            r15 = r13
            r13 = r1
            r1 = r15
            r15 = r11
            r11 = r9
            r9 = r15
        L8b:
            java.lang.Object r14 = r13.invoke(r0)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto Lb2
            double r7 = (double) r7
            double r7 = r7 * r9
            long r7 = (long) r7
            long r7 = vd.l.e(r7, r11)
            r1.zza = r13
            r1.zzb = r4
            r1.zzc = r11
            r1.zze = r9
            r1.zzd = r7
            r1.zzh = r5
            java.lang.Object r0 = ng.x0.a(r7, r1)
            if (r0 == r3) goto Lb1
            goto L3f
        Lb1:
            return r3
        Lb2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbq.zza(pd.k, long, long, double, pd.k, gd.e):java.lang.Object");
    }
}
