package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdp extends zzcr {
    static final zzcr zza = new zzdp(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzdp(Object obj, Object[] objArr, int i7) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static zzdp zzg(int i7, Object[] objArr, zzcq zzcqVar) {
        short[] sArr;
        char c7;
        char c8;
        ?? r62;
        ?? r32;
        ?? r33;
        int i8 = i7;
        Object[] objArrCopyOf = objArr;
        if (i8 == 0) {
            return (zzdp) zza;
        }
        zzcp zzcpVar = null;
        ?? r34 = 0;
        zzcp zzcpVar2 = null;
        zzcp zzcpVar3 = null;
        int i9 = 1;
        if (i8 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzbw.zzb(obj, obj2);
            return new zzdp(null, objArrCopyOf, 1);
        }
        zzbe.zzb(i8, objArrCopyOf.length >> 1, "index");
        int iZzh = zzcv.zzh(i7);
        if (i8 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            zzbw.zzb(obj3, obj4);
            i8 = 1;
            c7 = 1;
            c8 = 2;
        } else {
            int i10 = iZzh - 1;
            byte b7 = -1;
            if (iZzh <= 128) {
                byte[] bArr = new byte[iZzh];
                Arrays.fill(bArr, (byte) -1);
                int i11 = 0;
                int i12 = 0;
                while (i11 < i8) {
                    int i13 = i12 + i12;
                    int i14 = i11 + i11;
                    Object obj5 = objArrCopyOf[i14];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArrCopyOf[i14 ^ i9];
                    Objects.requireNonNull(obj6);
                    zzbw.zzb(obj5, obj6);
                    int iZza = zzcg.zza(obj5.hashCode());
                    while (true) {
                        int i15 = iZza & i10;
                        int i16 = bArr[i15] & 255;
                        if (i16 == 255) {
                            bArr[i15] = (byte) i13;
                            if (i12 < i11) {
                                objArrCopyOf[i13] = obj5;
                                objArrCopyOf[i13 ^ 1] = obj6;
                            }
                            i12++;
                        } else {
                            if (obj5.equals(objArrCopyOf[i16 == true ? 1 : 0])) {
                                int i17 = ~i16;
                                Object obj7 = objArrCopyOf[i17 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                zzcp zzcpVar4 = new zzcp(obj5, obj6, obj7);
                                objArrCopyOf[i17 == true ? 1 : 0] = obj6;
                                zzcpVar2 = zzcpVar4;
                                break;
                            }
                            iZza = i15 + 1;
                        }
                    }
                    i11++;
                    i9 = 1;
                }
                if (i12 == i8) {
                    r32 = bArr;
                } else {
                    r33 = new Object[]{bArr, Integer.valueOf(i12), zzcpVar2};
                    c8 = 2;
                    c7 = 1;
                    r34 = r33;
                }
            } else {
                if (iZzh <= 32768) {
                    sArr = new short[iZzh];
                    Arrays.fill(sArr, (short) -1);
                    int i18 = 0;
                    for (int i19 = 0; i19 < i8; i19++) {
                        int i20 = i18 + i18;
                        int i21 = i19 + i19;
                        Object obj8 = objArrCopyOf[i21];
                        Objects.requireNonNull(obj8);
                        Object obj9 = objArrCopyOf[i21 ^ 1];
                        Objects.requireNonNull(obj9);
                        zzbw.zzb(obj8, obj9);
                        int iZza2 = zzcg.zza(obj8.hashCode());
                        while (true) {
                            int i22 = iZza2 & i10;
                            char c9 = (char) sArr[i22];
                            if (c9 == 65535) {
                                sArr[i22] = (short) i20;
                                if (i18 < i19) {
                                    objArrCopyOf[i20] = obj8;
                                    objArrCopyOf[i20 ^ 1] = obj9;
                                }
                                i18++;
                            } else {
                                if (obj8.equals(objArrCopyOf[c9])) {
                                    int i23 = c9 ^ 1;
                                    Object obj10 = objArrCopyOf[i23 == true ? 1 : 0];
                                    Objects.requireNonNull(obj10);
                                    zzcp zzcpVar5 = new zzcp(obj8, obj9, obj10);
                                    objArrCopyOf[i23 == true ? 1 : 0] = obj9;
                                    zzcpVar3 = zzcpVar5;
                                    break;
                                }
                                iZza2 = i22 + 1;
                            }
                        }
                    }
                    if (i18 != i8) {
                        Integer numValueOf = Integer.valueOf(i18);
                        c7 = 1;
                        c8 = 2;
                        r62 = new Object[]{sArr, numValueOf, zzcpVar3};
                        r34 = r62;
                    }
                    r32 = sArr;
                } else {
                    int i24 = 1;
                    sArr = new int[iZzh];
                    Arrays.fill((int[]) sArr, -1);
                    int i25 = 0;
                    int i26 = 0;
                    while (i25 < i8) {
                        int i27 = i26 + i26;
                        int i28 = i25 + i25;
                        Object obj11 = objArrCopyOf[i28];
                        Objects.requireNonNull(obj11);
                        Object obj12 = objArrCopyOf[i28 ^ i24];
                        Objects.requireNonNull(obj12);
                        zzbw.zzb(obj11, obj12);
                        int iZza3 = zzcg.zza(obj11.hashCode());
                        while (true) {
                            int i29 = iZza3 & i10;
                            ?? r15 = sArr[i29];
                            if (r15 == b7) {
                                sArr[i29] = i27;
                                if (i26 < i25) {
                                    objArrCopyOf[i27] = obj11;
                                    objArrCopyOf[i27 ^ 1] = obj12;
                                }
                                i26++;
                            } else {
                                if (obj11.equals(objArrCopyOf[r15])) {
                                    int i30 = r15 ^ 1;
                                    Object obj13 = objArrCopyOf[i30 == true ? 1 : 0];
                                    Objects.requireNonNull(obj13);
                                    zzcp zzcpVar6 = new zzcp(obj11, obj12, obj13);
                                    objArrCopyOf[i30 == true ? 1 : 0] = obj12;
                                    zzcpVar = zzcpVar6;
                                    break;
                                }
                                iZza3 = i29 + 1;
                                b7 = -1;
                            }
                        }
                        i25++;
                        i24 = 1;
                        b7 = -1;
                    }
                    if (i26 != i8) {
                        c7 = 1;
                        c8 = 2;
                        r62 = new Object[]{sArr, Integer.valueOf(i26), zzcpVar};
                        r34 = r62;
                    }
                    r32 = sArr;
                }
                c7 = 1;
                r34 = r33;
            }
            c8 = 2;
            r33 = r32;
            c7 = 1;
            r34 = r33;
        }
        boolean z7 = r34 instanceof Object[];
        ?? r35 = r34;
        if (z7) {
            Object[] objArr2 = (Object[]) r34;
            zzcp zzcpVar7 = (zzcp) objArr2[c8];
            if (zzcqVar == null) {
                throw zzcpVar7.zza();
            }
            zzcqVar.zzc = zzcpVar7;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c7]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r35 = obj14;
            i8 = iIntValue;
        }
        return new zzdp(r35, objArrCopyOf, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // com.google.android.gms.internal.play_billing.zzcr, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L20
            r1 = 0
            r1 = r2[r1]
            java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L3
            r10 = r2[r3]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L20:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzcg.zza(r1)
        L38:
            r1 = r1 & r6
            r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L4e:
            int r1 = r1 + 1
            goto L38
        L51:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzcg.zza(r1)
        L63:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L7a:
            int r1 = r1 + 1
            goto L63
        L7d:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.zzcg.zza(r6)
        L89:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdp.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcr
    public final zzcj zza() {
        return new zzdo(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcr
    public final zzcv zzd() {
        return new zzdm(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcr
    public final zzcv zze() {
        return new zzdn(this, new zzdo(this.zzb, 0, this.zzd));
    }
}
