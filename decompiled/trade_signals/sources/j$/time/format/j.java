package j$.time.format;

import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
final class j implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f19753d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final j f19754e = new j("+HH:MM:ss", "Z");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final j f19755f = new j("+HH:MM:ss", "0");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19758c;

    j(String str, String str2) {
        int i8 = 0;
        while (true) {
            String[] strArr = f19753d;
            if (i8 >= 22) {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            }
            if (strArr[i8].equals(str)) {
                this.f19757b = i8;
                this.f19758c = i8 % 11;
                this.f19756a = str2;
                return;
            }
            i8++;
        }
    }

    private static void a(boolean z7, int i8, StringBuilder sb) {
        sb.append(z7 ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "");
        sb.append((char) ((i8 / 10) + 48));
        sb.append((char) ((i8 % 10) + 48));
    }

    private static boolean b(CharSequence charSequence, boolean z7, int i8, int[] iArr) {
        int i9 = iArr[0];
        if (i9 < 0) {
            return true;
        }
        if (z7 && i8 != 1) {
            int i10 = i9 + 1;
            if (i10 > charSequence.length() || charSequence.charAt(i9) != ':') {
                return false;
            }
            i9 = i10;
        }
        int i11 = i9 + 2;
        if (i11 > charSequence.length()) {
            return false;
        }
        int i12 = i9 + 1;
        char cCharAt = charSequence.charAt(i9);
        char cCharAt2 = charSequence.charAt(i12);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            int i13 = (cCharAt2 - '0') + ((cCharAt - '0') * 10);
            if (i13 >= 0 && i13 <= 59) {
                iArr[i8] = i13;
                iArr[0] = i11;
                return true;
            }
        }
        return false;
    }

    private static void c(CharSequence charSequence, boolean z7, int[] iArr) {
        if (!z7) {
            e(charSequence, 1, 2, iArr);
        } else {
            if (b(charSequence, false, 1, iArr)) {
                return;
            }
            iArr[0] = ~iArr[0];
        }
    }

    private static void d(CharSequence charSequence, boolean z7, boolean z8, int[] iArr) {
        if (b(charSequence, z7, 2, iArr) || !z8) {
            return;
        }
        iArr[0] = ~iArr[0];
    }

    private static void e(CharSequence charSequence, int i8, int i9, int[] iArr) {
        int i10;
        char cCharAt;
        int i11 = iArr[0];
        char[] cArr = new char[i9];
        int i12 = 0;
        int i13 = 0;
        while (i12 < i9 && (i10 = i11 + 1) <= charSequence.length() && (cCharAt = charSequence.charAt(i11)) >= '0' && cCharAt <= '9') {
            cArr[i12] = cCharAt;
            i13++;
            i12++;
            i11 = i10;
        }
        if (i13 < i8) {
            iArr[0] = ~iArr[0];
            return;
        }
        switch (i13) {
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
        iArr[0] = i11;
    }

    @Override // j$.time.format.f
    public final boolean o(t tVar, StringBuilder sb) {
        Long lE = tVar.e(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z7 = false;
        if (lE == null) {
            return false;
        }
        int intExact = Math.toIntExact(lE.longValue());
        String str = this.f19756a;
        if (intExact == 0) {
            sb.append(str);
        } else {
            int iAbs = Math.abs((intExact / 3600) % 100);
            int iAbs2 = Math.abs((intExact / 60) % 60);
            int iAbs3 = Math.abs(intExact % 60);
            int length = sb.length();
            sb.append(intExact < 0 ? "-" : "+");
            if (this.f19757b >= 11 && iAbs < 10) {
                sb.append((char) (iAbs + 48));
            } else {
                a(false, iAbs, sb);
            }
            int i8 = this.f19758c;
            if ((i8 >= 3 && i8 <= 8) || ((i8 >= 9 && iAbs3 > 0) || (i8 >= 1 && iAbs2 > 0))) {
                a(i8 > 0 && i8 % 2 == 0, iAbs2, sb);
                iAbs += iAbs2;
                if (i8 == 7 || i8 == 8 || (i8 >= 5 && iAbs3 > 0)) {
                    if (i8 > 0 && i8 % 2 == 0) {
                        z7 = true;
                    }
                    a(z7, iAbs3, sb);
                    iAbs += iAbs3;
                }
            }
            if (iAbs == 0) {
                sb.setLength(length);
                sb.append(str);
            }
        }
        return true;
    }

    @Override // j$.time.format.f
    public final int q(q qVar, CharSequence charSequence, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int length = charSequence.length();
        int length2 = this.f19756a.length();
        if (length2 != 0) {
            if (i8 == length) {
                return ~i8;
            }
            if (qVar.r(charSequence, i8, this.f19756a, 0, length2)) {
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i8, i8 + length2);
            }
        } else if (i8 == length) {
            return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i8, i8);
        }
        char cCharAt = charSequence.charAt(i8);
        if (cCharAt == '+' || cCharAt == '-') {
            int i13 = cCharAt == '-' ? -1 : 1;
            int i14 = this.f19758c;
            boolean z7 = i14 > 0 && i14 % 2 == 0;
            int i15 = this.f19757b;
            boolean z8 = i15 < 11;
            int[] iArr = new int[4];
            iArr[0] = i8 + 1;
            if (!qVar.k()) {
                if (z8) {
                    if (z7 || (i15 == 0 && length > (i12 = i8 + 3) && charSequence.charAt(i12) == ':')) {
                        i15 = 10;
                        z7 = true;
                    } else {
                        i15 = 9;
                    }
                } else if (z7 || (i15 == 11 && length > (i11 = i8 + 3) && (charSequence.charAt(i8 + 2) == ':' || charSequence.charAt(i11) == ':'))) {
                    i15 = 21;
                    z7 = true;
                } else {
                    i15 = 20;
                }
            }
            switch (i15) {
                case 0:
                case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    c(charSequence, z8, iArr);
                    break;
                case 1:
                case 2:
                case 13:
                    c(charSequence, z8, iArr);
                    d(charSequence, z7, false, iArr);
                    break;
                case 3:
                case 4:
                case 15:
                    c(charSequence, z8, iArr);
                    d(charSequence, z7, true, iArr);
                    break;
                case 5:
                case 6:
                case 17:
                    c(charSequence, z8, iArr);
                    d(charSequence, z7, true, iArr);
                    b(charSequence, z7, 3, iArr);
                    break;
                case 7:
                case 8:
                case 19:
                    c(charSequence, z8, iArr);
                    d(charSequence, z7, true, iArr);
                    if (!b(charSequence, z7, 3, iArr)) {
                        iArr[0] = ~iArr[0];
                    }
                    break;
                case 9:
                case 10:
                case 21:
                    c(charSequence, z8, iArr);
                    if (b(charSequence, z7, 2, iArr)) {
                        b(charSequence, z7, 3, iArr);
                    }
                    break;
                case 12:
                    e(charSequence, 1, 4, iArr);
                    break;
                case 14:
                    e(charSequence, 3, 4, iArr);
                    break;
                case com.amazon.c.a.a.c.f14230g /* 16 */:
                    e(charSequence, 3, 6, iArr);
                    break;
                case 18:
                    e(charSequence, 5, 6, iArr);
                    break;
                case 20:
                    e(charSequence, 1, 6, iArr);
                    break;
            }
            int i16 = iArr[0];
            if (i16 > 0) {
                int i17 = iArr[1];
                if (i17 > 23 || (i9 = iArr[2]) > 59 || (i10 = iArr[3]) > 59) {
                    throw new j$.time.c("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, ((((long) i9) * 60) + (((long) i17) * 3600) + ((long) i10)) * ((long) i13), i8, i16);
            }
        }
        return length2 == 0 ? qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i8, i8) : ~i8;
    }

    public final String toString() {
        String strReplace = this.f19756a.replace("'", "''");
        return "Offset(" + f19753d[this.f19757b] + ",'" + strReplace + "')";
    }
}
