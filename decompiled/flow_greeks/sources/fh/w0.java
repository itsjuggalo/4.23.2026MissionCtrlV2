package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class w0 extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9652e;

    public w0(String source) {
        kotlin.jvm.internal.t.f(source, "source");
        this.f9652e = source;
    }

    @Override // fh.a
    public String E(String keyToMatch, boolean z10) {
        kotlin.jvm.internal.t.f(keyToMatch, "keyToMatch");
        int i10 = this.f9544a;
        try {
            if (j() == 6 && kotlin.jvm.internal.t.b(G(z10), keyToMatch)) {
                t();
                if (j() == 5) {
                    return G(z10);
                }
            }
            return null;
        } finally {
            this.f9544a = i10;
            t();
        }
    }

    @Override // fh.a
    public int H(int i10) {
        if (i10 < C().length()) {
            return i10;
        }
        return -1;
    }

    @Override // fh.a
    public int J() {
        char cCharAt;
        int i10 = this.f9544a;
        if (i10 == -1) {
            return i10;
        }
        String strC = C();
        while (i10 < strC.length() && ((cCharAt = strC.charAt(i10)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i10++;
        }
        this.f9544a = i10;
        return i10;
    }

    @Override // fh.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.f9652e;
    }

    @Override // fh.a
    public boolean e() {
        int i10 = this.f9544a;
        if (i10 == -1) {
            return false;
        }
        String strC = C();
        while (i10 < strC.length()) {
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f9544a = i10;
                return D(cCharAt);
            }
            i10++;
        }
        this.f9544a = i10;
        return false;
    }

    @Override // fh.a
    public String i() {
        l('\"');
        int i10 = this.f9544a;
        int iB0 = kg.c0.b0(C(), '\"', i10, false, 4, null);
        if (iB0 == -1) {
            q();
            y((byte) 1, false);
            throw new cd.h();
        }
        for (int i11 = i10; i11 < iB0; i11++) {
            if (C().charAt(i11) == '\\') {
                return p(C(), this.f9544a, i11);
            }
        }
        this.f9544a = iB0 + 1;
        String strSubstring = C().substring(i10, iB0);
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // fh.a
    public byte j() {
        String strC = C();
        int i10 = this.f9544a;
        while (i10 != -1 && i10 < strC.length()) {
            int i11 = i10 + 1;
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f9544a = i11;
                return b.a(cCharAt);
            }
            i10 = i11;
        }
        this.f9544a = strC.length();
        return (byte) 10;
    }

    @Override // fh.a
    public void l(char c10) {
        if (this.f9544a == -1) {
            P(c10);
        }
        String strC = C();
        int i10 = this.f9544a;
        while (i10 < strC.length()) {
            int i11 = i10 + 1;
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f9544a = i11;
                if (cCharAt == c10) {
                    return;
                } else {
                    P(c10);
                }
            }
            i10 = i11;
        }
        this.f9544a = -1;
        P(c10);
    }
}
