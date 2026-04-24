package q7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2480h;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends AbstractC2643a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22863e;

    public b0(String source) {
        AbstractC2304t.f(source, "source");
        this.f22863e = source;
    }

    @Override // q7.AbstractC2643a
    public String E(String keyToMatch, boolean z7) {
        AbstractC2304t.f(keyToMatch, "keyToMatch");
        int i8 = this.f22858a;
        try {
            if (j() == 6 && AbstractC2304t.b(G(z7), keyToMatch)) {
                t();
                if (j() == 5) {
                    return G(z7);
                }
            }
            return null;
        } finally {
            this.f22858a = i8;
            t();
        }
    }

    @Override // q7.AbstractC2643a
    public int H(int i8) {
        if (i8 < C().length()) {
            return i8;
        }
        return -1;
    }

    @Override // q7.AbstractC2643a
    public int J() {
        char cCharAt;
        int i8 = this.f22858a;
        if (i8 == -1) {
            return i8;
        }
        String strC = C();
        while (i8 < strC.length() && ((cCharAt = strC.charAt(i8)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i8++;
        }
        this.f22858a = i8;
        return i8;
    }

    @Override // q7.AbstractC2643a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.f22863e;
    }

    @Override // q7.AbstractC2643a
    public boolean e() {
        int i8 = this.f22858a;
        if (i8 == -1) {
            return false;
        }
        String strC = C();
        while (i8 < strC.length()) {
            char cCharAt = strC.charAt(i8);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f22858a = i8;
                return D(cCharAt);
            }
            i8++;
        }
        this.f22858a = i8;
        return false;
    }

    @Override // q7.AbstractC2643a
    public String i() {
        l('\"');
        int i8 = this.f22858a;
        int iX = V6.C.X(C(), '\"', i8, false, 4, null);
        if (iX == -1) {
            q();
            y((byte) 1, false);
            throw new C2480h();
        }
        for (int i9 = i8; i9 < iX; i9++) {
            if (C().charAt(i9) == '\\') {
                return p(C(), this.f22858a, i9);
            }
        }
        this.f22858a = iX + 1;
        String strSubstring = C().substring(i8, iX);
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // q7.AbstractC2643a
    public byte j() {
        String strC = C();
        int i8 = this.f22858a;
        while (i8 != -1 && i8 < strC.length()) {
            int i9 = i8 + 1;
            char cCharAt = strC.charAt(i8);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f22858a = i9;
                return AbstractC2644b.a(cCharAt);
            }
            i8 = i9;
        }
        this.f22858a = strC.length();
        return (byte) 10;
    }

    @Override // q7.AbstractC2643a
    public void l(char c8) {
        if (this.f22858a == -1) {
            P(c8);
        }
        String strC = C();
        int i8 = this.f22858a;
        while (i8 < strC.length()) {
            int i9 = i8 + 1;
            char cCharAt = strC.charAt(i8);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f22858a = i9;
                if (cCharAt == c8) {
                    return;
                } else {
                    P(c8);
                }
            }
            i8 = i9;
        }
        this.f22858a = -1;
        P(c8);
    }
}
