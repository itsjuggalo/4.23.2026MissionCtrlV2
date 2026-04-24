package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzom implements zzow {
    private final zzoi zza;
    private final zzpl zzb;
    private final boolean zzc;
    private final zzmp zzd;

    private zzom(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        this.zzb = zzplVar;
        this.zzc = zzoiVar instanceof zzna;
        this.zzd = zzmpVar;
        this.zza = zzoiVar;
    }

    public static zzom zzc(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        return new zzom(zzplVar, zzmpVar, zzoiVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int iZzb = ((zznd) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzna) obj).zzb.zzb() : iZzb;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zzb(Object obj) {
        int iHashCode = ((zznd) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzna) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        zzoi zzoiVar = this.zza;
        return zzoiVar instanceof zznd ? ((zznd) zzoiVar).zzv() : zzoiVar.zzad().zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzg(Object obj, Object obj2) {
        zzoy.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzoy.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzh(Object obj, zzov zzovVar, zzmo zzmoVar) {
        boolean zZzO;
        zzpl zzplVar = this.zzb;
        Object objZza = zzplVar.zza(obj);
        ((zzna) obj).zzi();
        while (zzovVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzovVar.zzd();
                int iZzj = 0;
                if (iZzd != 11) {
                    if ((iZzd & 7) != 2) {
                        zZzO = zzovVar.zzO();
                    } else {
                        if (zzmoVar.zza(this.zza, iZzd >>> 3) != null) {
                            throw null;
                        }
                        zZzO = zzplVar.zzk(objZza, zzovVar, 0);
                    }
                    if (!zZzO) {
                        break;
                    }
                } else {
                    zznc zzncVarZza = null;
                    zzle zzleVarZzp = null;
                    while (zzovVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzovVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzovVar.zzj();
                            zzncVarZza = zzmoVar.zza(this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (zzncVarZza != null) {
                                throw null;
                            }
                            zzleVarZzp = zzovVar.zzp();
                        } else if (!zzovVar.zzO()) {
                            break;
                        }
                    }
                    if (zzovVar.zzd() != 12) {
                        throw new zznn("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzleVarZzp == null) {
                        continue;
                    } else {
                        if (zzncVarZza != null) {
                            throw null;
                        }
                        zzplVar.zzg(objZza, iZzj, zzleVarZzp);
                    }
                }
            } finally {
                zzplVar.zzj(obj, objZza);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008b A[EDGE_INSN: B:59:0x008b->B:34:0x008b BREAK  A[LOOP:1: B:18:0x004f->B:62:0x004f], SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.recaptcha.internal.zzkt r14) throws com.google.android.recaptcha.internal.zznn {
        /*
            r9 = this;
            r0 = 3
            r1 = r10
            com.google.android.recaptcha.internal.zznd r1 = (com.google.android.recaptcha.internal.zznd) r1
            com.google.android.recaptcha.internal.zzpm r2 = r1.zzc
            com.google.android.recaptcha.internal.zzpm r3 = com.google.android.recaptcha.internal.zzpm.zzc()
            if (r2 != r3) goto L12
            com.google.android.recaptcha.internal.zzpm r2 = com.google.android.recaptcha.internal.zzpm.zzf()
            r1.zzc = r2
        L12:
            r7 = r2
            com.google.android.recaptcha.internal.zzna r10 = (com.google.android.recaptcha.internal.zzna) r10
            r10.zzi()
            r10 = 0
            r1 = r10
        L1a:
            if (r12 >= r13) goto L97
            int r5 = com.google.android.recaptcha.internal.zzku.zzi(r11, r12, r14)
            int r3 = r14.zza
            r12 = 11
            r2 = 2
            if (r3 == r12) goto L4a
            r12 = r3 & 7
            if (r12 != r2) goto L42
            com.google.android.recaptcha.internal.zzmo r12 = r14.zzd
            com.google.android.recaptcha.internal.zzoi r1 = r9.zza
            int r2 = r3 >>> 3
            com.google.android.recaptcha.internal.zznc r1 = r12.zza(r1, r2)
            if (r1 != 0) goto L3f
            r4 = r11
            r6 = r13
            r8 = r14
            int r12 = com.google.android.recaptcha.internal.zzku.zzh(r3, r4, r5, r6, r7, r8)
            goto L1a
        L3f:
            int r11 = com.google.android.recaptcha.internal.zzos.zza
            throw r10
        L42:
            r4 = r11
            r6 = r13
            r8 = r14
            int r12 = com.google.android.recaptcha.internal.zzku.zzo(r3, r4, r5, r6, r8)
            goto L1a
        L4a:
            r4 = r11
            r6 = r13
            r8 = r14
            r11 = 0
            r12 = r10
        L4f:
            if (r5 >= r6) goto L8a
            int r13 = com.google.android.recaptcha.internal.zzku.zzi(r4, r5, r8)
            int r14 = r8.zza
            int r3 = r14 >>> 3
            r5 = r14 & 7
            if (r3 == r2) goto L70
            if (r3 == r0) goto L60
            goto L81
        L60:
            if (r1 != 0) goto L6d
            if (r5 != r2) goto L81
            int r5 = com.google.android.recaptcha.internal.zzku.zza(r4, r13, r8)
            java.lang.Object r12 = r8.zzc
            com.google.android.recaptcha.internal.zzle r12 = (com.google.android.recaptcha.internal.zzle) r12
            goto L4f
        L6d:
            int r11 = com.google.android.recaptcha.internal.zzos.zza
            throw r10
        L70:
            if (r5 != 0) goto L81
            int r5 = com.google.android.recaptcha.internal.zzku.zzi(r4, r13, r8)
            int r11 = r8.zza
            com.google.android.recaptcha.internal.zzmo r13 = r8.zzd
            com.google.android.recaptcha.internal.zzoi r14 = r9.zza
            com.google.android.recaptcha.internal.zznc r1 = r13.zza(r14, r11)
            goto L4f
        L81:
            r3 = 12
            if (r14 == r3) goto L8b
            int r5 = com.google.android.recaptcha.internal.zzku.zzo(r14, r4, r13, r6, r8)
            goto L4f
        L8a:
            r13 = r5
        L8b:
            if (r12 == 0) goto L92
            int r11 = r11 << r0
            r11 = r11 | r2
            r7.zzj(r11, r12)
        L92:
            r12 = r13
            r11 = r4
            r13 = r6
            r14 = r8
            goto L1a
        L97:
            r6 = r13
            if (r12 != r6) goto L9b
            return
        L9b:
            com.google.android.recaptcha.internal.zznn r10 = new com.google.android.recaptcha.internal.zznn
            java.lang.String r11 = "Failed to parse the message."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzom.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzkt):void");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzj(Object obj, zzpy zzpyVar) {
        Iterator itZzf = ((zzna) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzms zzmsVar = (zzms) entry.getKey();
            if (zzmsVar.zze() != zzpx.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzmsVar.zzg();
            zzmsVar.zzf();
            if (entry instanceof zznp) {
                zzpyVar.zzw(zzmsVar.zza(), ((zznp) entry).zza().zzb());
            } else {
                zzpyVar.zzw(zzmsVar.zza(), entry.getValue());
            }
        }
        ((zznd) obj).zzc.zzk(zzpyVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
        return ((zzna) obj).zzb.zzk();
    }
}
