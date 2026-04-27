package j$.time.format;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.common.Constants;
import io.flutter.Build;
import p2.C1698D;

/* JADX INFO: loaded from: classes2.dex */
final class j implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f13217d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final j f13218e = new j("+HH:MM:ss", "Z");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final j f13219f = new j("+HH:MM:ss", "0");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13222c;

    j(String str, String str2) {
        int i4 = 0;
        while (true) {
            String[] strArr = f13217d;
            if (i4 < 22) {
                if (strArr[i4].equals(str)) {
                    this.f13221b = i4;
                    this.f13222c = i4 % 11;
                    this.f13220a = str2;
                    return;
                }
                i4++;
            } else {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            }
        }
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        Long lE = tVar.e(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z4 = false;
        if (lE == null) {
            return false;
        }
        int intExact = Math.toIntExact(lE.longValue());
        String str = this.f13220a;
        if (intExact == 0) {
            sb.append(str);
            return true;
        }
        int iAbs = Math.abs((intExact / 3600) % 100);
        int iAbs2 = Math.abs((intExact / 60) % 60);
        int iAbs3 = Math.abs(intExact % 60);
        int length = sb.length();
        sb.append(intExact < 0 ? "-" : "+");
        if (this.f13221b < 11 || iAbs >= 10) {
            a(false, iAbs, sb);
        } else {
            sb.append((char) (iAbs + 48));
        }
        int i4 = this.f13222c;
        if ((i4 >= 3 && i4 <= 8) || ((i4 >= 9 && iAbs3 > 0) || (i4 >= 1 && iAbs2 > 0))) {
            a(i4 > 0 && i4 % 2 == 0, iAbs2, sb);
            iAbs += iAbs2;
            if (i4 == 7 || i4 == 8 || (i4 >= 5 && iAbs3 > 0)) {
                if (i4 > 0 && i4 % 2 == 0) {
                    z4 = true;
                }
                a(z4, iAbs3, sb);
                iAbs += iAbs3;
            }
        }
        if (iAbs == 0) {
            sb.setLength(length);
            sb.append(str);
        }
        return true;
    }

    private static void a(boolean z4, int i4, StringBuilder sb) {
        sb.append(z4 ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "");
        sb.append((char) ((i4 / 10) + 48));
        sb.append((char) ((i4 % 10) + 48));
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i4) {
        CharSequence charSequence2;
        int i5;
        int i6;
        int i7;
        int i8;
        int length = charSequence.length();
        int length2 = this.f13220a.length();
        if (length2 == 0) {
            if (i4 == length) {
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i4, i4);
            }
            charSequence2 = charSequence;
        } else {
            if (i4 == length) {
                return ~i4;
            }
            charSequence2 = charSequence;
            if (qVar.r(charSequence2, i4, this.f13220a, 0, length2)) {
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i4, i4 + length2);
            }
        }
        char cCharAt = charSequence.charAt(i4);
        if (cCharAt == '+' || cCharAt == '-') {
            int i9 = cCharAt == '-' ? -1 : 1;
            int i10 = this.f13222c;
            boolean z4 = i10 > 0 && i10 % 2 == 0;
            int i11 = this.f13221b;
            boolean z5 = i11 < 11;
            int[] iArr = new int[4];
            iArr[0] = i4 + 1;
            if (!qVar.k()) {
                if (z5) {
                    if (z4 || (i11 == 0 && length > (i8 = i4 + 3) && charSequence2.charAt(i8) == ':')) {
                        i11 = 10;
                        z4 = true;
                    } else {
                        i11 = 9;
                    }
                } else if (z4 || (i11 == 11 && length > (i7 = i4 + 3) && (charSequence2.charAt(i4 + 2) == ':' || charSequence2.charAt(i7) == ':'))) {
                    i11 = 21;
                    z4 = true;
                } else {
                    i11 = 20;
                }
            }
            switch (i11) {
                case 0:
                case 11:
                    c(charSequence2, z5, iArr);
                    break;
                case 1:
                case 2:
                case 13:
                    c(charSequence2, z5, iArr);
                    d(charSequence2, z4, false, iArr);
                    break;
                case 3:
                case 4:
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    c(charSequence2, z5, iArr);
                    d(charSequence2, z4, true, iArr);
                    break;
                case 5:
                case 6:
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    c(charSequence2, z5, iArr);
                    d(charSequence2, z4, true, iArr);
                    b(charSequence2, z4, 3, iArr);
                    break;
                case 7:
                case 8:
                case 19:
                    c(charSequence2, z5, iArr);
                    d(charSequence2, z4, true, iArr);
                    if (!b(charSequence2, z4, 3, iArr)) {
                        iArr[0] = ~iArr[0];
                    }
                    break;
                case 9:
                case 10:
                case Build.API_LEVELS.API_21 /* 21 */:
                    c(charSequence2, z5, iArr);
                    if (b(charSequence2, z4, 2, iArr)) {
                        b(charSequence2, z4, 3, iArr);
                    }
                    break;
                case 12:
                    e(charSequence2, 1, 4, iArr);
                    break;
                case 14:
                    e(charSequence2, 3, 4, iArr);
                    break;
                case 16:
                    e(charSequence2, 3, 6, iArr);
                    break;
                case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    e(charSequence2, 5, 6, iArr);
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                    e(charSequence2, 1, 6, iArr);
                    break;
            }
            int i12 = iArr[0];
            if (i12 > 0) {
                int i13 = iArr[1];
                if (i13 > 23 || (i5 = iArr[2]) > 59 || (i6 = iArr[3]) > 59) {
                    throw new j$.time.c("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, ((((long) i5) * 60) + (((long) i13) * 3600) + ((long) i6)) * ((long) i9), i4, i12);
            }
        }
        return length2 == 0 ? qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i4, i4) : ~i4;
    }

    private static void c(CharSequence charSequence, boolean z4, int[] iArr) {
        if (z4) {
            if (b(charSequence, false, 1, iArr)) {
                return;
            }
            iArr[0] = ~iArr[0];
            return;
        }
        e(charSequence, 1, 2, iArr);
    }

    private static void d(CharSequence charSequence, boolean z4, boolean z5, int[] iArr) {
        if (b(charSequence, z4, 2, iArr) || !z5) {
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

    private static void e(CharSequence charSequence, int i4, int i5, int[] iArr) {
        int i6;
        char cCharAt;
        int i7 = iArr[0];
        char[] cArr = new char[i5];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i5 && (i6 = i7 + 1) <= charSequence.length() && (cCharAt = charSequence.charAt(i7)) >= '0' && cCharAt <= '9') {
            cArr[i8] = cCharAt;
            i9++;
            i8++;
            i7 = i6;
        }
        if (i9 < i4) {
            iArr[0] = ~iArr[0];
            return;
        }
        switch (i9) {
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
        iArr[0] = i7;
    }

    public final String toString() {
        String strReplace = this.f13220a.replace("'", "''");
        return "Offset(" + f13217d[this.f13221b] + ",'" + strReplace + "')";
    }
}
