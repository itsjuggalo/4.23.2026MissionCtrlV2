package com.google.android.recaptcha.internal;

import X2.AbstractC0769p;
import X2.u;
import Z2.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class zzl {
    private final List zza;
    private zzek zzb;

    /* JADX WARN: Multi-variable type inference failed */
    public zzl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void zzh(zze... zzeVarArr) {
        u.u(this.zza, zzeVarArr);
    }

    public final Object zzb(String str, long j4, e eVar) {
        return M.e(new zzh(this, str, j4, null), eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzc(long r12, com.google.android.recaptcha.internal.zzsc r14, com.google.android.recaptcha.internal.zzek r15, Z2.e r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzi
            if (r1 == 0) goto L15
            r1 = r0
            com.google.android.recaptcha.internal.zzi r1 = (com.google.android.recaptcha.internal.zzi) r1
            int r2 = r1.zzc
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.zzc = r2
            goto L1a
        L15:
            com.google.android.recaptcha.internal.zzi r1 = new com.google.android.recaptcha.internal.zzi
            r1.<init>(r11, r0)
        L1a:
            java.lang.Object r0 = r1.zza
            java.lang.Object r9 = a3.AbstractC0787c.e()
            int r2 = r1.zzc
            r10 = 1
            if (r2 == 0) goto L33
            if (r2 != r10) goto L2b
            W2.q.b(r0)
            goto L49
        L2b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L33:
            W2.q.b(r0)
            com.google.android.recaptcha.internal.zzk r2 = new com.google.android.recaptcha.internal.zzk
            r8 = 0
            r3 = r11
            r5 = r12
            r7 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r7, r8)
            r1.zzc = r10
            java.lang.Object r0 = t3.M.e(r2, r1)
            if (r0 != r9) goto L49
            return r9
        L49:
            W2.p r0 = (W2.p) r0
            java.lang.Object r0 = r0.j()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzl.zzc(long, com.google.android.recaptcha.internal.zzsc, com.google.android.recaptcha.internal.zzek, Z2.e):java.lang.Object");
    }

    public final List zzd() {
        return this.zza;
    }

    public final void zzf(zze... zzeVarArr) {
        zzh((zze[]) Arrays.copyOf(zzeVarArr, 1));
    }

    public final void zzg(zzsr zzsrVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zze) it.next()).zzk(zzsrVar);
        }
    }

    public /* synthetic */ zzl(List list, int i4, AbstractC1585j abstractC1585j) {
        List listG = AbstractC0769p.g();
        this.zza = new ArrayList();
        zze[] zzeVarArr = (zze[]) listG.toArray(new zze[0]);
        zzh((zze[]) Arrays.copyOf(zzeVarArr, zzeVarArr.length));
    }
}
