package j$.time.format;

import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes2.dex */
final class j implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f7459d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};
    static final j e = new j("+HH:MM:ss", "Z");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final j f7460f = new j("+HH:MM:ss", "0");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7463c;

    j(String str, String str2) {
        int i = 0;
        while (true) {
            String[] strArr = f7459d;
            if (i < 22) {
                if (strArr[i].equals(str)) {
                    this.f7462b = i;
                    this.f7463c = i % 11;
                    this.f7461a = str2;
                    return;
                }
                i++;
            } else {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            }
        }
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        Long lE = tVar.e(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z6 = false;
        if (lE == null) {
            return false;
        }
        int intExact = Math.toIntExact(lE.longValue());
        String str = this.f7461a;
        if (intExact == 0) {
            sb.append(str);
            return true;
        }
        int iAbs = Math.abs((intExact / 3600) % 100);
        int iAbs2 = Math.abs((intExact / 60) % 60);
        int iAbs3 = Math.abs(intExact % 60);
        int length = sb.length();
        sb.append(intExact < 0 ? "-" : "+");
        if (this.f7462b < 11 || iAbs >= 10) {
            a(false, iAbs, sb);
        } else {
            sb.append((char) (iAbs + 48));
        }
        int i = this.f7463c;
        if ((i >= 3 && i <= 8) || ((i >= 9 && iAbs3 > 0) || (i >= 1 && iAbs2 > 0))) {
            a(i > 0 && i % 2 == 0, iAbs2, sb);
            iAbs += iAbs2;
            if (i == 7 || i == 8 || (i >= 5 && iAbs3 > 0)) {
                if (i > 0 && i % 2 == 0) {
                    z6 = true;
                }
                a(z6, iAbs3, sb);
                iAbs += iAbs3;
            }
        }
        if (iAbs == 0) {
            sb.setLength(length);
            sb.append(str);
        }
        return true;
    }

    private static void a(boolean z6, int i, StringBuilder sb) {
        sb.append(z6 ? ":" : "");
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i) {
        CharSequence charSequence2;
        int i6;
        int i7;
        int i8;
        int i9;
        int length = charSequence.length();
        int length2 = this.f7461a.length();
        if (length2 == 0) {
            if (i == length) {
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i, i);
            }
            charSequence2 = charSequence;
        } else {
            if (i == length) {
                return ~i;
            }
            charSequence2 = charSequence;
            if (qVar.r(charSequence2, i, this.f7461a, 0, length2)) {
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i, i + length2);
            }
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == '+' || cCharAt == '-') {
            int i10 = cCharAt == '-' ? -1 : 1;
            int i11 = this.f7463c;
            boolean z6 = i11 > 0 && i11 % 2 == 0;
            int i12 = this.f7462b;
            boolean z7 = i12 < 11;
            int[] iArr = new int[4];
            iArr[0] = i + 1;
            if (!qVar.k()) {
                if (z7) {
                    if (z6 || (i12 == 0 && length > (i9 = i + 3) && charSequence2.charAt(i9) == ':')) {
                        i12 = 10;
                        z6 = true;
                    } else {
                        i12 = 9;
                    }
                } else if (z6 || (i12 == 11 && length > (i8 = i + 3) && (charSequence2.charAt(i + 2) == ':' || charSequence2.charAt(i8) == ':'))) {
                    i12 = 21;
                    z6 = true;
                } else {
                    i12 = 20;
                }
            }
            switch (i12) {
                case 0:
                case 11:
                    c(charSequence2, z7, iArr);
                    break;
                case 1:
                case 2:
                case 13:
                    c(charSequence2, z7, iArr);
                    d(charSequence2, z6, false, iArr);
                    break;
                case 3:
                case 4:
                case 15:
                    c(charSequence2, z7, iArr);
                    d(charSequence2, z6, true, iArr);
                    break;
                case 5:
                case 6:
                case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    c(charSequence2, z7, iArr);
                    d(charSequence2, z6, true, iArr);
                    b(charSequence2, z6, 3, iArr);
                    break;
                case 7:
                case 8:
                case 19:
                    c(charSequence2, z7, iArr);
                    d(charSequence2, z6, true, iArr);
                    if (!b(charSequence2, z6, 3, iArr)) {
                        iArr[0] = ~iArr[0];
                    }
                    break;
                case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                case 21:
                    c(charSequence2, z7, iArr);
                    if (b(charSequence2, z6, 2, iArr)) {
                        b(charSequence2, z6, 3, iArr);
                    }
                    break;
                case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    e(charSequence2, 1, 4, iArr);
                    break;
                case 14:
                    e(charSequence2, 3, 4, iArr);
                    break;
                case 16:
                    e(charSequence2, 3, 6, iArr);
                    break;
                case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    e(charSequence2, 5, 6, iArr);
                    break;
                case 20:
                    e(charSequence2, 1, 6, iArr);
                    break;
            }
            int i13 = iArr[0];
            if (i13 > 0) {
                int i14 = iArr[1];
                if (i14 > 23 || (i6 = iArr[2]) > 59 || (i7 = iArr[3]) > 59) {
                    throw new j$.time.c("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, ((((long) i6) * 60) + (((long) i14) * 3600) + ((long) i7)) * ((long) i10), i, i13);
            }
        }
        return length2 == 0 ? qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i, i) : ~i;
    }

    private static void c(CharSequence charSequence, boolean z6, int[] iArr) {
        if (z6) {
            if (b(charSequence, false, 1, iArr)) {
                return;
            }
            iArr[0] = ~iArr[0];
            return;
        }
        e(charSequence, 1, 2, iArr);
    }

    private static void d(CharSequence charSequence, boolean z6, boolean z7, int[] iArr) {
        if (b(charSequence, z6, 2, iArr) || !z7) {
            return;
        }
        iArr[0] = ~iArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean b(java.lang.CharSequence r5, boolean r6, int r7, int[] r8) {
        /*
            r0 = 0
            r1 = r8[r0]
            r2 = 1
            if (r1 >= 0) goto L7
            return r2
        L7:
            if (r6 == 0) goto L1d
            if (r7 == r2) goto L1d
            int r6 = r1 + 1
            int r3 = r5.length()
            if (r6 > r3) goto L4e
            char r1 = r5.charAt(r1)
            r3 = 58
            if (r1 == r3) goto L1c
            goto L4e
        L1c:
            r1 = r6
        L1d:
            int r6 = r1 + 2
            int r3 = r5.length()
            if (r6 <= r3) goto L26
            goto L4e
        L26:
            int r3 = r1 + 1
            char r1 = r5.charAt(r1)
            char r5 = r5.charAt(r3)
            r3 = 48
            if (r1 < r3) goto L4e
            r4 = 57
            if (r1 > r4) goto L4e
            if (r5 < r3) goto L4e
            if (r5 <= r4) goto L3d
            goto L4e
        L3d:
            int r1 = r1 - r3
            int r1 = r1 * 10
            int r5 = r5 - r3
            int r5 = r5 + r1
            if (r5 < 0) goto L4e
            r1 = 59
            if (r5 <= r1) goto L49
            goto L4e
        L49:
            r8[r7] = r5
            r8[r0] = r6
            return r2
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.j.b(java.lang.CharSequence, boolean, int, int[]):boolean");
    }

    private static void e(CharSequence charSequence, int i, int i6, int[] iArr) {
        int i7;
        char cCharAt;
        int i8 = iArr[0];
        char[] cArr = new char[i6];
        int i9 = 0;
        int i10 = 0;
        while (i9 < i6 && (i7 = i8 + 1) <= charSequence.length() && (cCharAt = charSequence.charAt(i8)) >= '0' && cCharAt <= '9') {
            cArr[i9] = cCharAt;
            i10++;
            i9++;
            i8 = i7;
        }
        if (i10 < i) {
            iArr[0] = ~iArr[0];
            return;
        }
        switch (i10) {
            case 1:
                iArr[1] = cArr[0] - '0';
                break;
            case 2:
                iArr[1] = (cArr[1] - '0') + ((cArr[0] - '0') * 10);
                break;
            case 3:
                iArr[1] = cArr[0] - '0';
                iArr[2] = (cArr[2] - '0') + ((cArr[1] - '0') * 10);
                break;
            case 4:
                iArr[1] = (cArr[1] - '0') + ((cArr[0] - '0') * 10);
                iArr[2] = (cArr[3] - '0') + ((cArr[2] - '0') * 10);
                break;
            case 5:
                iArr[1] = cArr[0] - '0';
                iArr[2] = (cArr[2] - '0') + ((cArr[1] - '0') * 10);
                iArr[3] = (cArr[4] - '0') + ((cArr[3] - '0') * 10);
                break;
            case 6:
                iArr[1] = (cArr[1] - '0') + ((cArr[0] - '0') * 10);
                iArr[2] = (cArr[3] - '0') + ((cArr[2] - '0') * 10);
                iArr[3] = (cArr[5] - '0') + ((cArr[4] - '0') * 10);
                break;
        }
        iArr[0] = i8;
    }

    public final String toString() {
        String strReplace = this.f7461a.replace("'", "''");
        return "Offset(" + f7459d[this.f7462b] + ",'" + strReplace + "')";
    }
}
