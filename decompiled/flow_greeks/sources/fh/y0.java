package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 extends w0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(String source) {
        super(source);
        kotlin.jvm.internal.t.f(source, "source");
    }

    @Override // fh.a
    public byte F() {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            return (byte) 10;
        }
        this.f9544a = iJ;
        return b.a(strC.charAt(iJ));
    }

    @Override // fh.w0, fh.a
    public int J() {
        int i10;
        int iB0 = this.f9544a;
        if (iB0 == -1) {
            return iB0;
        }
        String strC = C();
        while (iB0 < strC.length()) {
            char cCharAt = strC.charAt(iB0);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt != '/' || (i10 = iB0 + 1) >= strC.length()) {
                    break;
                }
                char cCharAt2 = strC.charAt(i10);
                if (cCharAt2 == '*') {
                    int iC0 = kg.c0.c0(strC, "*/", iB0 + 2, false, 4, null);
                    if (iC0 == -1) {
                        this.f9544a = strC.length();
                        a.x(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                        throw new cd.h();
                    }
                    iB0 = iC0 + 2;
                } else {
                    if (cCharAt2 != '/') {
                        break;
                    }
                    iB0 = kg.c0.b0(strC, '\n', iB0 + 2, false, 4, null);
                    iB0 = iB0 == -1 ? strC.length() : iB0 + 1;
                }
            }
        }
        this.f9544a = iB0;
        return iB0;
    }

    @Override // fh.w0, fh.a
    public boolean e() {
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            return false;
        }
        return D(C().charAt(iJ));
    }

    @Override // fh.w0, fh.a
    public byte j() {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            return (byte) 10;
        }
        this.f9544a = iJ + 1;
        return b.a(strC.charAt(iJ));
    }

    @Override // fh.w0, fh.a
    public void l(char c10) {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            this.f9544a = -1;
            P(c10);
        }
        char cCharAt = strC.charAt(iJ);
        this.f9544a = iJ + 1;
        if (cCharAt == c10) {
            return;
        }
        P(c10);
    }
}
