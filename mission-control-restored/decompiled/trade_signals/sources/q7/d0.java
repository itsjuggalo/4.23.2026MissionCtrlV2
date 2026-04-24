package q7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2480h;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends b0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(String source) {
        super(source);
        AbstractC2304t.f(source, "source");
    }

    @Override // q7.AbstractC2643a
    public byte F() {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            return (byte) 10;
        }
        this.f22858a = iJ;
        return AbstractC2644b.a(strC.charAt(iJ));
    }

    @Override // q7.b0, q7.AbstractC2643a
    public int J() {
        int i8;
        int iX = this.f22858a;
        if (iX == -1) {
            return iX;
        }
        String strC = C();
        while (iX < strC.length()) {
            char cCharAt = strC.charAt(iX);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt != '/' || (i8 = iX + 1) >= strC.length()) {
                    break;
                }
                char cCharAt2 = strC.charAt(i8);
                if (cCharAt2 == '*') {
                    int iY = V6.C.Y(strC, "*/", iX + 2, false, 4, null);
                    if (iY == -1) {
                        this.f22858a = strC.length();
                        AbstractC2643a.x(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                        throw new C2480h();
                    }
                    iX = iY + 2;
                } else {
                    if (cCharAt2 != '/') {
                        break;
                    }
                    iX = V6.C.X(strC, '\n', iX + 2, false, 4, null);
                    if (iX == -1) {
                        iX = strC.length();
                    }
                }
            }
            iX++;
        }
        this.f22858a = iX;
        return iX;
    }

    @Override // q7.b0, q7.AbstractC2643a
    public boolean e() {
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            return false;
        }
        return D(C().charAt(iJ));
    }

    @Override // q7.b0, q7.AbstractC2643a
    public byte j() {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            return (byte) 10;
        }
        this.f22858a = iJ + 1;
        return AbstractC2644b.a(strC.charAt(iJ));
    }

    @Override // q7.b0, q7.AbstractC2643a
    public void l(char c8) {
        String strC = C();
        int iJ = J();
        if (iJ >= strC.length() || iJ == -1) {
            this.f22858a = -1;
            P(c8);
        }
        char cCharAt = strC.charAt(iJ);
        this.f22858a = iJ + 1;
        if (cCharAt == c8) {
            return;
        }
        P(c8);
    }
}
