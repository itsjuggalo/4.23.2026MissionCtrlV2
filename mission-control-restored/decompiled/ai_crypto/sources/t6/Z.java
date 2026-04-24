package t6;

import E5.C0462g;

/* JADX INFO: loaded from: classes2.dex */
public final class Z extends AbstractC2711a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24297e;

    public Z(String source) {
        kotlin.jvm.internal.r.f(source, "source");
        this.f24297e = source;
    }

    @Override // t6.AbstractC2711a
    public int G(int i7) {
        if (i7 < C().length()) {
            return i7;
        }
        return -1;
    }

    @Override // t6.AbstractC2711a
    public int I() {
        char cCharAt;
        int i7 = this.f24298a;
        if (i7 == -1) {
            return i7;
        }
        while (i7 < C().length() && ((cCharAt = C().charAt(i7)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i7++;
        }
        this.f24298a = i7;
        return i7;
    }

    @Override // t6.AbstractC2711a
    public boolean L() {
        int I6 = I();
        if (I6 == C().length() || I6 == -1 || C().charAt(I6) != ',') {
            return false;
        }
        this.f24298a++;
        return true;
    }

    @Override // t6.AbstractC2711a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.f24297e;
    }

    @Override // t6.AbstractC2711a
    public boolean f() {
        int i7 = this.f24298a;
        if (i7 == -1) {
            return false;
        }
        while (i7 < C().length()) {
            char cCharAt = C().charAt(i7);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f24298a = i7;
                return D(cCharAt);
            }
            i7++;
        }
        this.f24298a = i7;
        return false;
    }

    @Override // t6.AbstractC2711a
    public String k() {
        o('\"');
        int i7 = this.f24298a;
        int iM = Z5.u.M(C(), '\"', i7, false, 4, null);
        if (iM == -1) {
            z((byte) 1);
            throw new C0462g();
        }
        for (int i8 = i7; i8 < iM; i8++) {
            if (C().charAt(i8) == '\\') {
                return r(C(), this.f24298a, i8);
            }
        }
        this.f24298a = iM + 1;
        String strSubstring = C().substring(i7, iM);
        kotlin.jvm.internal.r.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @Override // t6.AbstractC2711a
    public String l(String keyToMatch, boolean z7) {
        kotlin.jvm.internal.r.f(keyToMatch, "keyToMatch");
        int i7 = this.f24298a;
        try {
            if (m() != 6) {
                this.f24298a = i7;
                return null;
            }
            if (!kotlin.jvm.internal.r.b(z7 ? k() : t(), keyToMatch)) {
                this.f24298a = i7;
                return null;
            }
            if (m() != 5) {
                this.f24298a = i7;
                return null;
            }
            String strQ = z7 ? q() : t();
            this.f24298a = i7;
            return strQ;
        } catch (Throwable th) {
            this.f24298a = i7;
            throw th;
        }
    }

    @Override // t6.AbstractC2711a
    public byte m() {
        byte bA;
        String strC = C();
        do {
            int i7 = this.f24298a;
            if (i7 == -1 || i7 >= strC.length()) {
                return (byte) 10;
            }
            int i8 = this.f24298a;
            this.f24298a = i8 + 1;
            bA = AbstractC2712b.a(strC.charAt(i8));
        } while (bA == 3);
        return bA;
    }

    @Override // t6.AbstractC2711a
    public void o(char c7) {
        if (this.f24298a == -1) {
            O(c7);
        }
        String strC = C();
        while (this.f24298a < strC.length()) {
            int i7 = this.f24298a;
            this.f24298a = i7 + 1;
            char cCharAt = strC.charAt(i7);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt == c7) {
                    return;
                } else {
                    O(c7);
                }
            }
        }
        O(c7);
    }
}
