package com.google.android.recaptcha.internal;

import G4.l;
import I4.d;
import a5.A;
import a5.InterfaceC0312t;
import android.content.Context;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import j5.a;
import j5.e;

/* JADX INFO: loaded from: classes.dex */
public final class zzan {
    public InterfaceC0312t zza;
    private final A zzb;
    private final zzek zzc;
    private final StandardIntegrityManager zzd;
    private long zzf;
    private boolean zzh;
    private zzao zze = zzao.zza;
    private final a zzg = e.a();

    public zzan(Context context, A a6, zzek zzekVar, StandardIntegrityManager standardIntegrityManager, long j4) {
        this.zzb = a6;
        this.zzc = zzekVar;
        this.zzd = standardIntegrityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzi(I4.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzag
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzag r0 = (com.google.android.recaptcha.internal.zzag) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzag r0 = new com.google.android.recaptcha.internal.zzag
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.zza
            J4.a r1 = J4.a.f791a
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.AbstractC0284a.E(r7)
            return r7
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L2f:
            a.AbstractC0284a.E(r7)
            com.google.android.play.core.integrity.StandardIntegrityManager$PrepareIntegrityTokenRequest$Builder r7 = com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.builder()
            long r4 = r6.zzf
            com.google.android.play.core.integrity.StandardIntegrityManager$PrepareIntegrityTokenRequest$Builder r7 = r7.setCloudProjectNumber(r4)
            com.google.android.play.core.integrity.StandardIntegrityManager$PrepareIntegrityTokenRequest r7 = r7.build()
            com.google.android.play.core.integrity.StandardIntegrityManager r2 = r6.zzd
            com.google.android.gms.tasks.Task r7 = r2.prepareIntegrityToken(r7)
            a5.F r7 = com.google.android.recaptcha.internal.zzbx.zza(r7)
            r0.zzc = r3
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zzi(I4.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        if (r7 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzj(java.lang.String r6, I4.d r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzah
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzah r0 = (com.google.android.recaptcha.internal.zzah) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzah r0 = new com.google.android.recaptcha.internal.zzah
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            J4.a r1 = J4.a.f791a
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            a.AbstractC0284a.E(r7)
            goto L6d
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.String r6 = r0.zzd
            a.AbstractC0284a.E(r7)
            goto L4b
        L38:
            a.AbstractC0284a.E(r7)
            a5.t r7 = r5.zzf()
            r0.zzd = r6
            r0.zzc = r4
            a5.u r7 = (a5.C0313u) r7
            java.lang.Object r7 = r7.h(r0)
            if (r7 == r1) goto L74
        L4b:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r7
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r2 = com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest.builder()
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r6 = r2.setRequestHash(r6)
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest r6 = r6.build()
            com.google.android.gms.tasks.Task r6 = r7.request(r6)
            a5.F r6 = com.google.android.recaptcha.internal.zzbx.zza(r6)
            r7 = 0
            r0.zzd = r7
            r0.zzc = r3
            java.lang.Object r7 = r6.await(r0)
            if (r7 != r1) goto L6d
            goto L74
        L6d:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityToken r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken) r7
            java.lang.String r6 = r7.token()
            return r6
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zzj(java.lang.String, I4.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        if (r8 == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067 A[PHI: r2 r7
      0x0067: PHI (r2v6 com.google.android.recaptcha.internal.zzan) = (r2v3 com.google.android.recaptcha.internal.zzan), (r2v8 com.google.android.recaptcha.internal.zzan) binds: [B:29:0x0064, B:16:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0067: PHI (r7v4 java.lang.String) = (r7v1 java.lang.String), (r7v6 java.lang.String) binds: [B:29:0x0064, B:16:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzc(java.lang.String r7, I4.d r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzaf
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.recaptcha.internal.zzaf r0 = (com.google.android.recaptcha.internal.zzaf) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.zza
            J4.a r1 = J4.a.f791a
            int r2 = r0.zzc
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            a.AbstractC0284a.E(r8)
            goto L74
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.String r7 = r0.zze
            com.google.android.recaptcha.internal.zzan r2 = r0.zzd
            a.AbstractC0284a.E(r8)
            goto L67
        L3d:
            java.lang.String r7 = r0.zze
            com.google.android.recaptcha.internal.zzan r2 = r0.zzd
            a.AbstractC0284a.E(r8)     // Catch: java.lang.Exception -> L5a
            goto L56
        L45:
            a.AbstractC0284a.E(r8)
            r0.zzd = r6     // Catch: java.lang.Exception -> L59
            r0.zze = r7     // Catch: java.lang.Exception -> L59
            r0.zzc = r5     // Catch: java.lang.Exception -> L59
            java.lang.Object r8 = r6.zzj(r7, r0)     // Catch: java.lang.Exception -> L59
            if (r8 != r1) goto L55
            goto L77
        L55:
            r2 = r6
        L56:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L5a
            return r8
        L59:
            r2 = r6
        L5a:
            r0.zzd = r2
            r0.zze = r7
            r0.zzc = r4
            java.lang.Object r8 = r2.zze(r0)
            if (r8 != r1) goto L67
            goto L77
        L67:
            r8 = 0
            r0.zzd = r8
            r0.zze = r8
            r0.zzc = r3
            java.lang.Object r8 = r2.zzj(r7, r0)
            if (r8 == r1) goto L77
        L74:
            java.lang.String r8 = (java.lang.String) r8
            return r8
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zzc(java.lang.String, I4.d):java.lang.Object");
    }

    public final Object zzd(long j4, d dVar) {
        this.zzf = j4;
        return l.f540a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zze(I4.d r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzak
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzak r0 = (com.google.android.recaptcha.internal.zzak) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzak r0 = new com.google.android.recaptcha.internal.zzak
            r0.<init>(r13, r14)
        L18:
            java.lang.Object r14 = r0.zzb
            J4.a r1 = J4.a.f791a
            int r2 = r0.zzd
            G4.l r3 = G4.l.f540a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            a.AbstractC0284a.E(r14)
            return r3
        L2c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L34:
            java.lang.Object r2 = r0.zza
            j5.a r2 = (j5.a) r2
            com.google.android.recaptcha.internal.zzan r6 = r0.zze
            a.AbstractC0284a.E(r14)
            goto L53
        L3e:
            a.AbstractC0284a.E(r14)
            j5.a r14 = r13.zzg
            r0.zze = r13
            r0.zza = r14
            r0.zzd = r5
            r2 = r14
            j5.d r2 = (j5.d) r2
            java.lang.Object r14 = r2.d(r0)
            if (r14 == r1) goto Lb7
            r6 = r13
        L53:
            r14 = 0
            com.google.android.recaptcha.internal.zzao r7 = r6.zze     // Catch: java.lang.Throwable -> Lb0
            com.google.android.recaptcha.internal.zzao r8 = com.google.android.recaptcha.internal.zzao.zza     // Catch: java.lang.Throwable -> Lb0
            boolean r7 = kotlin.jvm.internal.j.a(r7, r8)     // Catch: java.lang.Throwable -> Lb0
            if (r7 != 0) goto L64
            j5.d r2 = (j5.d) r2
            r2.f(r14)
            return r3
        L64:
            com.google.android.recaptcha.internal.zzao r7 = com.google.android.recaptcha.internal.zzao.zzb     // Catch: java.lang.Throwable -> Lb0
            r6.zze = r7     // Catch: java.lang.Throwable -> Lb0
            j5.d r2 = (j5.d) r2
            r2.f(r14)
            com.google.android.recaptcha.internal.zzek r2 = r6.zzc
            java.lang.String r7 = r2.zzd()
            r2.zzc(r7)
            r2.zzb(r4)
            r7 = 38
            com.google.android.recaptcha.internal.zzen r2 = r2.zzf(r7)
            a5.u r7 = a5.C.a()
            r6.zza = r7
            a5.A r7 = r6.zzb
            com.google.android.recaptcha.internal.zzam r8 = new com.google.android.recaptcha.internal.zzam
            r8.<init>(r6, r2, r14)
            a5.C.p(r7, r8)
            r0.zze = r14
            r0.zza = r14
            r0.zzd = r4
            boolean r14 = r6.zzh
            if (r14 != 0) goto Lac
            java.util.Timer r7 = new java.util.Timer
            r7.<init>()
            com.google.android.recaptcha.internal.zzai r8 = new com.google.android.recaptcha.internal.zzai
            r8.<init>(r6)
            r9 = 28800000(0x1b77400, double:1.42290906E-316)
            r11 = r9
            r7.schedule(r8, r9, r11)
            r6.zzh = r5
        Lac:
            if (r3 != r1) goto Laf
            goto Lb7
        Laf:
            return r3
        Lb0:
            r0 = move-exception
            j5.d r2 = (j5.d) r2
            r2.f(r14)
            throw r0
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zze(I4.d):java.lang.Object");
    }

    public final InterfaceC0312t zzf() {
        InterfaceC0312t interfaceC0312t = this.zza;
        if (interfaceC0312t != null) {
            return interfaceC0312t;
        }
        return null;
    }
}
