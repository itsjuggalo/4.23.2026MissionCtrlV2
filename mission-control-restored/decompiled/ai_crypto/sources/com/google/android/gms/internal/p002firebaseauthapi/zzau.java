package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzau<K, V> extends zzan<K, V> {
    private static final zzan<Object, Object> zza = new zzau(null, new Object[0], 0);
    private final transient Object zzb;
    private final transient Object[] zzc;
    private final transient int zzd;

    private zzau(Object obj, Object[] objArr, int i7) {
        this.zzb = obj;
        this.zzc = objArr;
        this.zzd = i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0009 A[EDGE_INSN: B:43:0x0009->B:4:0x0009 BREAK  A[LOOP:0: B:15:0x0037->B:21:0x004d], EDGE_INSN: B:45:0x0009->B:4:0x0009 BREAK  A[LOOP:1: B:25:0x0062->B:31:0x0079], EDGE_INSN: B:47:0x0009->B:4:0x0009 BREAK  A[LOOP:2: B:33:0x0088->B:42:0x00a0]] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zzb
            java.lang.Object[] r1 = r8.zzc
            int r2 = r8.zzd
            r3 = 0
            if (r9 != 0) goto Lc
        L9:
            r9 = r3
            goto L9c
        Lc:
            r4 = 1
            if (r2 != r4) goto L22
            r0 = 0
            r0 = r1[r0]
            java.util.Objects.requireNonNull(r0)
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L9
            r9 = r1[r4]
            java.util.Objects.requireNonNull(r9)
            goto L9c
        L22:
            if (r0 != 0) goto L25
            goto L9
        L25:
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L50
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r5 = r0 + (-1)
            int r0 = r9.hashCode()
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r0)
        L37:
            r0 = r0 & r5
            r6 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L40
            goto L9
        L40:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L4d
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9c
        L4d:
            int r0 = r0 + 1
            goto L37
        L50:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L7c
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r5 = r0 + (-1)
            int r0 = r9.hashCode()
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r0)
        L62:
            r0 = r0 & r5
            short r6 = r2[r0]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L6c
            goto L9
        L6c:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L79
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9c
        L79:
            int r0 = r0 + 1
            goto L62
        L7c:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 - r4
            int r5 = r9.hashCode()
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r5)
        L88:
            r5 = r5 & r2
            r6 = r0[r5]
            r7 = -1
            if (r6 != r7) goto L90
            goto L9
        L90:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La0
            r9 = r6 ^ 1
            r9 = r1[r9]
        L9c:
            if (r9 != 0) goto L9f
            return r3
        L9f:
            return r9
        La0:
            int r5 = r5 + 1
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzau.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    public final zzai<V> zza() {
        return new zzay(this.zzc, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    public final zzas<Map.Entry<K, V>> zzb() {
        return new zzat(this, this.zzc, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    public final zzas<K> zzc() {
        return new zzav(this, new zzay(this.zzc, 0, this.zzd));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    public final boolean zzd() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static <K, V> zzau<K, V> zza(int i7, Object[] objArr, zzaq<K, V> zzaqVar) {
        int iHighestOneBit;
        short[] sArr;
        char c7;
        char c8;
        ?? r32;
        ?? r33;
        int i8 = i7;
        Object[] objArrCopyOf = objArr;
        if (i8 == 0) {
            return (zzau) zza;
        }
        zzap zzapVar = null;
        ?? r34 = 0;
        zzap zzapVar2 = null;
        zzap zzapVar3 = null;
        int i9 = 1;
        if (i8 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzag.zza(obj, obj2);
            return new zzau<>(null, objArrCopyOf, 1);
        }
        zzw.zzb(i8, objArrCopyOf.length >> 1);
        int iMax = Math.max(i8, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
        } else {
            iHighestOneBit = 1073741824;
            zzw.zza(iMax < 1073741824, "collection too large");
        }
        if (i8 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            zzag.zza(obj3, obj4);
            c7 = 1;
            c8 = 2;
        } else {
            int i10 = iHighestOneBit - 1;
            byte b7 = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i11 = 0;
                int i12 = 0;
                while (i11 < i8) {
                    int i13 = i11 * 2;
                    int i14 = i12 * 2;
                    Object obj5 = objArrCopyOf[i13];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArrCopyOf[i13 ^ i9];
                    Objects.requireNonNull(obj6);
                    zzag.zza(obj5, obj6);
                    int iZza = zzaf.zza(obj5.hashCode());
                    while (true) {
                        int i15 = iZza & i10;
                        int i16 = bArr[i15] & 255;
                        if (i16 == 255) {
                            bArr[i15] = (byte) i14;
                            if (i12 < i11) {
                                objArrCopyOf[i14] = obj5;
                                objArrCopyOf[i14 ^ 1] = obj6;
                            }
                            i12++;
                        } else {
                            if (obj5.equals(objArrCopyOf[i16 == true ? 1 : 0])) {
                                int i17 = ~i16;
                                Object obj7 = objArrCopyOf[i17 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                zzapVar2 = new zzap(obj5, obj6, obj7);
                                objArrCopyOf[i17 == true ? 1 : 0] = obj6;
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
                    c8 = 2;
                    r33 = r32;
                    c7 = 1;
                    r34 = r33;
                } else {
                    r33 = new Object[]{bArr, Integer.valueOf(i12), zzapVar2};
                    c8 = 2;
                    c7 = 1;
                    r34 = r33;
                }
            } else {
                if (iHighestOneBit <= 32768) {
                    sArr = new short[iHighestOneBit];
                    Arrays.fill(sArr, (short) -1);
                    int i18 = 0;
                    for (int i19 = 0; i19 < i8; i19++) {
                        int i20 = i19 * 2;
                        int i21 = i18 * 2;
                        Object obj8 = objArrCopyOf[i20];
                        Objects.requireNonNull(obj8);
                        Object obj9 = objArrCopyOf[i20 ^ 1];
                        Objects.requireNonNull(obj9);
                        zzag.zza(obj8, obj9);
                        int iZza2 = zzaf.zza(obj8.hashCode());
                        while (true) {
                            int i22 = iZza2 & i10;
                            int i23 = sArr[i22] & 65535;
                            if (i23 == 65535) {
                                sArr[i22] = (short) i21;
                                if (i18 < i19) {
                                    objArrCopyOf[i21] = obj8;
                                    objArrCopyOf[i21 ^ 1] = obj9;
                                }
                                i18++;
                            } else {
                                if (obj8.equals(objArrCopyOf[i23 == true ? 1 : 0])) {
                                    int i24 = ~i23;
                                    Object obj10 = objArrCopyOf[i24 == true ? 1 : 0];
                                    Objects.requireNonNull(obj10);
                                    zzapVar3 = new zzap(obj8, obj9, obj10);
                                    objArrCopyOf[i24 == true ? 1 : 0] = obj9;
                                    break;
                                }
                                iZza2 = i22 + 1;
                            }
                        }
                    }
                    if (i18 != i8) {
                        c8 = 2;
                        r33 = new Object[]{sArr, Integer.valueOf(i18), zzapVar3};
                        c7 = 1;
                        r34 = r33;
                    }
                } else {
                    sArr = new int[iHighestOneBit];
                    Arrays.fill((int[]) sArr, -1);
                    int i25 = 0;
                    int i26 = 0;
                    while (i25 < i8) {
                        int i27 = i25 * 2;
                        int i28 = i26 * 2;
                        Object obj11 = objArrCopyOf[i27];
                        Objects.requireNonNull(obj11);
                        Object obj12 = objArrCopyOf[i27 ^ 1];
                        Objects.requireNonNull(obj12);
                        zzag.zza(obj11, obj12);
                        int iZza3 = zzaf.zza(obj11.hashCode());
                        while (true) {
                            int i29 = iZza3 & i10;
                            ?? r15 = sArr[i29];
                            if (r15 == b7) {
                                sArr[i29] = i28;
                                if (i26 < i25) {
                                    objArrCopyOf[i28] = obj11;
                                    objArrCopyOf[i28 ^ 1] = obj12;
                                }
                                i26++;
                            } else {
                                if (obj11.equals(objArrCopyOf[r15])) {
                                    int i30 = r15 ^ 1;
                                    Object obj13 = objArrCopyOf[i30 == true ? 1 : 0];
                                    Objects.requireNonNull(obj13);
                                    zzapVar = new zzap(obj11, obj12, obj13);
                                    objArrCopyOf[i30 == true ? 1 : 0] = obj12;
                                    break;
                                }
                                iZza3 = i29 + 1;
                                b7 = -1;
                            }
                        }
                        i25++;
                        b7 = -1;
                    }
                    if (i26 != i8) {
                        c7 = 1;
                        c8 = 2;
                        r34 = new Object[]{sArr, Integer.valueOf(i26), zzapVar};
                    }
                }
                r32 = sArr;
                c8 = 2;
                r33 = r32;
                c7 = 1;
                r34 = r33;
            }
        }
        boolean z7 = r34 instanceof Object[];
        ?? r35 = r34;
        if (z7) {
            Object[] objArr2 = (Object[]) r34;
            zzap zzapVar4 = (zzap) objArr2[c8];
            if (zzaqVar == null) {
                throw zzapVar4.zza();
            }
            zzaqVar.zza = zzapVar4;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c7]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue << 1);
            r35 = obj14;
            i8 = iIntValue;
        }
        return new zzau<>(r35, objArrCopyOf, i8);
    }
}
