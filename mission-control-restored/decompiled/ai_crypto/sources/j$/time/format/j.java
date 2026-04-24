package j$.time.format;

import com.revenuecat.purchases.common.Constants;
import k4.C2105D;

/* JADX INFO: loaded from: classes3.dex */
final class j implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f17176d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final j f17177e = new j("+HH:MM:ss", "Z");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final j f17178f = new j("+HH:MM:ss", "0");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17181c;

    j(String str, String str2) {
        int i7 = 0;
        while (true) {
            String[] strArr = f17176d;
            if (i7 < 22) {
                if (strArr[i7].equals(str)) {
                    this.f17180b = i7;
                    this.f17181c = i7 % 11;
                    this.f17179a = str2;
                    return;
                }
                i7++;
            } else {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            }
        }
    }

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        Long lE = tVar.e(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z7 = false;
        if (lE == null) {
            return false;
        }
        int intExact = Math.toIntExact(lE.longValue());
        String str = this.f17179a;
        if (intExact == 0) {
            sb.append(str);
        } else {
            int iAbs = Math.abs((intExact / 3600) % 100);
            int iAbs2 = Math.abs((intExact / 60) % 60);
            int iAbs3 = Math.abs(intExact % 60);
            int length = sb.length();
            sb.append(intExact < 0 ? "-" : "+");
            if (this.f17180b < 11 || iAbs >= 10) {
                a(false, iAbs, sb);
            } else {
                sb.append((char) (iAbs + 48));
            }
            int i7 = this.f17181c;
            if ((i7 >= 3 && i7 <= 8) || ((i7 >= 9 && iAbs3 > 0) || (i7 >= 1 && iAbs2 > 0))) {
                a(i7 > 0 && i7 % 2 == 0, iAbs2, sb);
                iAbs += iAbs2;
                if (i7 == 7 || i7 == 8 || (i7 >= 5 && iAbs3 > 0)) {
                    if (i7 > 0 && i7 % 2 == 0) {
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

    private static void a(boolean z7, int i7, StringBuilder sb) {
        sb.append(z7 ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "");
        sb.append((char) ((i7 / 10) + 48));
        sb.append((char) ((i7 % 10) + 48));
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int length = charSequence.length();
        int length2 = this.f17179a.length();
        if (length2 != 0) {
            if (i7 == length) {
                return ~i7;
            }
            if (qVar.r(charSequence, i7, this.f17179a, 0, length2)) {
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i7, i7 + length2);
            }
        } else if (i7 == length) {
            return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i7, i7);
        }
        char cCharAt = charSequence.charAt(i7);
        if (cCharAt == '+' || cCharAt == '-') {
            int i12 = cCharAt == '-' ? -1 : 1;
            int i13 = this.f17181c;
            boolean z7 = i13 > 0 && i13 % 2 == 0;
            int i14 = this.f17180b;
            boolean z8 = i14 < 11;
            int[] iArr = new int[4];
            iArr[0] = i7 + 1;
            if (!qVar.k()) {
                if (z8) {
                    if (z7 || (i14 == 0 && length > (i11 = i7 + 3) && charSequence.charAt(i11) == ':')) {
                        i14 = 10;
                        z7 = true;
                    } else {
                        i14 = 9;
                    }
                } else if (z7 || (i14 == 11 && length > (i10 = i7 + 3) && (charSequence.charAt(i7 + 2) == ':' || charSequence.charAt(i10) == ':'))) {
                    i14 = 21;
                    z7 = true;
                } else {
                    i14 = 20;
                }
            }
            switch (i14) {
                case 0:
                case 11:
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
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
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
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
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
                case com.amazon.c.a.a.c.f10119g /* 16 */:
                    e(charSequence, 3, 6, iArr);
                    break;
                case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    e(charSequence, 5, 6, iArr);
                    break;
                case 20:
                    e(charSequence, 1, 6, iArr);
                    break;
            }
            int i15 = iArr[0];
            if (i15 > 0) {
                int i16 = iArr[1];
                if (i16 > 23 || (i8 = iArr[2]) > 59 || (i9 = iArr[3]) > 59) {
                    throw new j$.time.c("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return qVar.n(j$.time.temporal.a.OFFSET_SECONDS, ((((long) i8) * 60) + (((long) i16) * 3600) + ((long) i9)) * ((long) i12), i7, i15);
            }
        }
        return length2 == 0 ? qVar.n(j$.time.temporal.a.OFFSET_SECONDS, 0L, i7, i7) : ~i7;
    }

    private static void c(CharSequence charSequence, boolean z7, int[] iArr) {
        if (z7) {
            if (b(charSequence, false, 1, iArr)) {
                return;
            }
            iArr[0] = ~iArr[0];
            return;
        }
        e(charSequence, 1, 2, iArr);
    }

    private static void d(CharSequence charSequence, boolean z7, boolean z8, int[] iArr) {
        if (b(charSequence, z7, 2, iArr) || !z8) {
            return;
        }
        iArr[0] = ~iArr[0];
    }

    private static boolean b(CharSequence charSequence, boolean z7, int i7, int[] iArr) {
        int i8 = iArr[0];
        if (i8 < 0) {
            return true;
        }
        if (z7 && i7 != 1) {
            int i9 = i8 + 1;
            if (i9 > charSequence.length() || charSequence.charAt(i8) != ':') {
                return false;
            }
            i8 = i9;
        }
        int i10 = i8 + 2;
        if (i10 > charSequence.length()) {
            return false;
        }
        int i11 = i8 + 1;
        char cCharAt = charSequence.charAt(i8);
        char cCharAt2 = charSequence.charAt(i11);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            int i12 = (cCharAt2 - '0') + ((cCharAt - '0') * 10);
            if (i12 >= 0 && i12 <= 59) {
                iArr[i7] = i12;
                iArr[0] = i10;
                return true;
            }
        }
        return false;
    }

    private static void e(CharSequence charSequence, int i7, int i8, int[] iArr) {
        int i9;
        char cCharAt;
        int i10 = iArr[0];
        char[] cArr = new char[i8];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i8 && (i9 = i10 + 1) <= charSequence.length() && (cCharAt = charSequence.charAt(i10)) >= '0' && cCharAt <= '9') {
            cArr[i11] = cCharAt;
            i12++;
            i11++;
            i10 = i9;
        }
        if (i12 < i7) {
            iArr[0] = ~iArr[0];
            return;
        }
        switch (i12) {
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
        iArr[0] = i10;
    }

    public final String toString() {
        String strReplace = this.f17179a.replace("'", "''");
        return "Offset(" + f17176d[this.f17180b] + ",'" + strReplace + "')";
    }
}
