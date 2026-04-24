package L3;

import W2.C0739g;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class Z extends AbstractC0378a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1504e;

    public Z(String source) {
        kotlin.jvm.internal.r.f(source, "source");
        this.f1504e = source;
    }

    @Override // L3.AbstractC0378a
    public int G(int i4) {
        if (i4 < C().length()) {
            return i4;
        }
        return -1;
    }

    @Override // L3.AbstractC0378a
    public int I() {
        char cCharAt;
        int i4 = this.f1505a;
        if (i4 == -1) {
            return i4;
        }
        while (i4 < C().length() && ((cCharAt = C().charAt(i4)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i4++;
        }
        this.f1505a = i4;
        return i4;
    }

    @Override // L3.AbstractC0378a
    public boolean L() {
        int I4 = I();
        if (I4 == C().length() || I4 == -1 || C().charAt(I4) != ',') {
            return false;
        }
        this.f1505a++;
        return true;
    }

    @Override // L3.AbstractC0378a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.f1504e;
    }

    @Override // L3.AbstractC0378a
    public boolean f() {
        int i4 = this.f1505a;
        if (i4 == -1) {
            return false;
        }
        while (i4 < C().length()) {
            char cCharAt = C().charAt(i4);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f1505a = i4;
                return D(cCharAt);
            }
            i4++;
        }
        this.f1505a = i4;
        return false;
    }

    @Override // L3.AbstractC0378a
    public String k() {
        o('\"');
        int i4 = this.f1505a;
        int iR = AbstractC1753A.R(C(), '\"', i4, false, 4, null);
        if (iR == -1) {
            z((byte) 1);
            throw new C0739g();
        }
        for (int i5 = i4; i5 < iR; i5++) {
            if (C().charAt(i5) == '\\') {
                return r(C(), this.f1505a, i5);
            }
        }
        this.f1505a = iR + 1;
        String strSubstring = C().substring(i4, iR);
        kotlin.jvm.internal.r.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @Override // L3.AbstractC0378a
    public String l(String keyToMatch, boolean z4) {
        kotlin.jvm.internal.r.f(keyToMatch, "keyToMatch");
        int i4 = this.f1505a;
        try {
            if (m() != 6) {
                this.f1505a = i4;
                return null;
            }
            if (!kotlin.jvm.internal.r.b(z4 ? k() : t(), keyToMatch)) {
                this.f1505a = i4;
                return null;
            }
            if (m() != 5) {
                this.f1505a = i4;
                return null;
            }
            String strQ = z4 ? q() : t();
            this.f1505a = i4;
            return strQ;
        } catch (Throwable th) {
            this.f1505a = i4;
            throw th;
        }
    }

    @Override // L3.AbstractC0378a
    public byte m() {
        byte bA;
        String strC = C();
        do {
            int i4 = this.f1505a;
            if (i4 == -1 || i4 >= strC.length()) {
                return (byte) 10;
            }
            int i5 = this.f1505a;
            this.f1505a = i5 + 1;
            bA = AbstractC0379b.a(strC.charAt(i5));
        } while (bA == 3);
        return bA;
    }

    @Override // L3.AbstractC0378a
    public void o(char c4) {
        if (this.f1505a == -1) {
            O(c4);
        }
        String strC = C();
        while (this.f1505a < strC.length()) {
            int i4 = this.f1505a;
            this.f1505a = i4 + 1;
            char cCharAt = strC.charAt(i4);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt == c4) {
                    return;
                } else {
                    O(c4);
                }
            }
        }
        O(c4);
    }
}
