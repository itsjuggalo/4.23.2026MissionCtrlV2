package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1312b0 extends Q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Q f15395g = new C1312b0(null, new Object[0], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object f15396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f15397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f15398f;

    public C1312b0(Object obj, Object[] objArr, int i8) {
        this.f15396d = obj;
        this.f15397e = objArr;
        this.f15398f = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static C1312b0 g(int i8, Object[] objArr, P p8) {
        int iHighestOneBit;
        short[] sArr;
        char c8;
        char c9;
        ?? r32;
        ?? r33;
        int i9 = i8;
        Object[] objArrCopyOf = objArr;
        if (i9 == 0) {
            return (C1312b0) f15395g;
        }
        O o8 = null;
        ?? r34 = 0;
        O o9 = null;
        O o10 = null;
        int i10 = 1;
        if (i9 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            I.a(obj, obj2);
            return new C1312b0(null, objArrCopyOf, 1);
        }
        A.b(i9, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iMax = Math.max(i9, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i9 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            I.a(obj3, obj4);
            i9 = 1;
            c8 = 1;
            c9 = 2;
        } else {
            int i11 = iHighestOneBit - 1;
            byte b8 = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i12 = 0;
                int i13 = 0;
                while (i12 < i9) {
                    int i14 = i13 + i13;
                    int i15 = i12 + i12;
                    Object obj5 = objArrCopyOf[i15];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArrCopyOf[i15 ^ i10];
                    Objects.requireNonNull(obj6);
                    I.a(obj5, obj6);
                    int iA = J.a(obj5.hashCode());
                    while (true) {
                        int i16 = iA & i11;
                        int i17 = bArr[i16] & 255;
                        if (i17 == 255) {
                            bArr[i16] = (byte) i14;
                            if (i13 < i12) {
                                objArrCopyOf[i14] = obj5;
                                objArrCopyOf[i14 ^ 1] = obj6;
                            }
                            i13++;
                        } else {
                            if (obj5.equals(objArrCopyOf[i17 == true ? 1 : 0])) {
                                int i18 = ~i17;
                                Object obj7 = objArrCopyOf[i18 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                O o11 = new O(obj5, obj6, obj7);
                                objArrCopyOf[i18 == true ? 1 : 0] = obj6;
                                o9 = o11;
                                break;
                            }
                            iA = i16 + 1;
                        }
                    }
                    i12++;
                    i10 = 1;
                }
                if (i13 == i9) {
                    r32 = bArr;
                } else {
                    r33 = new Object[]{bArr, Integer.valueOf(i13), o9};
                    c9 = 2;
                    c8 = 1;
                    r34 = r33;
                }
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i19 = 0;
                for (int i20 = 0; i20 < i9; i20++) {
                    int i21 = i19 + i19;
                    int i22 = i20 + i20;
                    Object obj8 = objArrCopyOf[i22];
                    Objects.requireNonNull(obj8);
                    Object obj9 = objArrCopyOf[i22 ^ 1];
                    Objects.requireNonNull(obj9);
                    I.a(obj8, obj9);
                    int iA2 = J.a(obj8.hashCode());
                    while (true) {
                        int i23 = iA2 & i11;
                        char c10 = (char) sArr[i23];
                        if (c10 == 65535) {
                            sArr[i23] = (short) i21;
                            if (i19 < i20) {
                                objArrCopyOf[i21] = obj8;
                                objArrCopyOf[i21 ^ 1] = obj9;
                            }
                            i19++;
                        } else {
                            if (obj8.equals(objArrCopyOf[c10])) {
                                int i24 = c10 ^ 1;
                                Object obj10 = objArrCopyOf[i24 == true ? 1 : 0];
                                Objects.requireNonNull(obj10);
                                O o12 = new O(obj8, obj9, obj10);
                                objArrCopyOf[i24 == true ? 1 : 0] = obj9;
                                o10 = o12;
                                break;
                            }
                            iA2 = i23 + 1;
                        }
                    }
                }
                if (i19 != i9) {
                    c9 = 2;
                    r34 = new Object[]{sArr, Integer.valueOf(i19), o10};
                    c8 = 1;
                }
                r32 = sArr;
            } else {
                int i25 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i26 = 0;
                int i27 = 0;
                while (i26 < i9) {
                    int i28 = i27 + i27;
                    int i29 = i26 + i26;
                    Object obj11 = objArrCopyOf[i29];
                    Objects.requireNonNull(obj11);
                    Object obj12 = objArrCopyOf[i29 ^ i25];
                    Objects.requireNonNull(obj12);
                    I.a(obj11, obj12);
                    int iA3 = J.a(obj11.hashCode());
                    while (true) {
                        int i30 = iA3 & i11;
                        ?? r15 = sArr[i30];
                        if (r15 == b8) {
                            sArr[i30] = i28;
                            if (i27 < i26) {
                                objArrCopyOf[i28] = obj11;
                                objArrCopyOf[i28 ^ 1] = obj12;
                            }
                            i27++;
                        } else {
                            if (obj11.equals(objArrCopyOf[r15])) {
                                int i31 = r15 ^ 1;
                                Object obj13 = objArrCopyOf[i31 == true ? 1 : 0];
                                Objects.requireNonNull(obj13);
                                O o13 = new O(obj11, obj12, obj13);
                                objArrCopyOf[i31 == true ? 1 : 0] = obj12;
                                o8 = o13;
                                break;
                            }
                            iA3 = i30 + 1;
                            b8 = -1;
                        }
                    }
                    i26++;
                    i25 = 1;
                    b8 = -1;
                }
                if (i27 != i9) {
                    c8 = 1;
                    c9 = 2;
                    r34 = new Object[]{sArr, Integer.valueOf(i27), o8};
                }
                r32 = sArr;
            }
            c9 = 2;
            r33 = r32;
            c8 = 1;
            r34 = r33;
        }
        boolean z7 = r34 instanceof Object[];
        ?? r35 = r34;
        if (z7) {
            Object[] objArr2 = (Object[]) r34;
            O o14 = (O) objArr2[c9];
            if (p8 == null) {
                throw o14.a();
            }
            p8.f15202c = o14;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c8]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r35 = obj14;
            i9 = iIntValue;
        }
        return new C1312b0(r35, objArrCopyOf, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.Q
    public final K a() {
        return new C1307a0(this.f15397e, 1, this.f15398f);
    }

    @Override // com.google.android.gms.internal.play_billing.Q
    public final S d() {
        return new Y(this, this.f15397e, 0, this.f15398f);
    }

    @Override // com.google.android.gms.internal.play_billing.Q
    public final S e() {
        return new Z(this, new C1307a0(this.f15397e, 0, this.f15398f));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // com.google.android.gms.internal.play_billing.Q, java.util.Map
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
            int r1 = r9.f15398f
            java.lang.Object[] r2 = r9.f15397e
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
            java.lang.Object r1 = r9.f15396d
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
            int r1 = com.google.android.gms.internal.play_billing.J.a(r1)
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
            int r1 = com.google.android.gms.internal.play_billing.J.a(r1)
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
            int r6 = com.google.android.gms.internal.play_billing.J.a(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C1312b0.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f15398f;
    }
}
