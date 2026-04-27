package L3;

import W2.C0739g;
import java.util.ArrayList;
import r3.AbstractC1753A;

/* JADX INFO: renamed from: L3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0378a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1505a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1507c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G f1506b = new G();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f1508d = new StringBuilder();

    public static /* synthetic */ boolean N(AbstractC0378a abstractC0378a, boolean z4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i4 & 1) != 0) {
            z4 = true;
        }
        return abstractC0378a.M(z4);
    }

    public static /* synthetic */ Void y(AbstractC0378a abstractC0378a, String str, int i4, String str2, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i5 & 2) != 0) {
            i4 = abstractC0378a.f1505a;
        }
        if ((i5 & 4) != 0) {
            str2 = "";
        }
        return abstractC0378a.x(str, i4, str2);
    }

    public final void A(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        x("Encountered an unknown key '" + key + '\'', AbstractC1753A.Y(J(0, this.f1505a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new C0739g();
    }

    public final int B(CharSequence charSequence, int i4) {
        char cCharAt = charSequence.charAt(i4);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        y(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new C0739g();
    }

    public abstract CharSequence C();

    public final boolean D(char c4) {
        return !(c4 == '}' || c4 == ']' || c4 == ':' || c4 == ',');
    }

    public final byte E() {
        CharSequence charSequenceC = C();
        int i4 = this.f1505a;
        while (true) {
            int iG = G(i4);
            if (iG == -1) {
                this.f1505a = iG;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iG);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f1505a = iG;
                return AbstractC0379b.a(cCharAt);
            }
            i4 = iG + 1;
        }
    }

    public final String F(boolean z4) {
        String strQ;
        byte bE = E();
        if (z4) {
            if (bE != 1 && bE != 0) {
                return null;
            }
            strQ = s();
        } else {
            if (bE != 1) {
                return null;
            }
            strQ = q();
        }
        this.f1507c = strQ;
        return strQ;
    }

    public abstract int G(int i4);

    public final void H(boolean z4) {
        ArrayList arrayList = new ArrayList();
        byte bE = E();
        if (bE != 8 && bE != 6) {
            s();
            return;
        }
        while (true) {
            byte bE2 = E();
            if (bE2 != 1) {
                if (bE2 == 8 || bE2 == 6) {
                    arrayList.add(Byte.valueOf(bE2));
                } else if (bE2 == 9) {
                    if (((Number) X2.x.R(arrayList)).byteValue() != 8) {
                        throw E.f(this.f1505a, "found ] instead of } at path: " + this.f1506b, C());
                    }
                    X2.u.y(arrayList);
                } else if (bE2 == 7) {
                    if (((Number) X2.x.R(arrayList)).byteValue() != 6) {
                        throw E.f(this.f1505a, "found } instead of ] at path: " + this.f1506b, C());
                    }
                    X2.u.y(arrayList);
                } else if (bE2 == 10) {
                    y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new C0739g();
                }
                m();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z4) {
                s();
            } else {
                k();
            }
        }
    }

    public abstract int I();

    public String J(int i4, int i5) {
        return C().subSequence(i4, i5).toString();
    }

    public final String K() {
        String str = this.f1507c;
        kotlin.jvm.internal.r.c(str);
        this.f1507c = null;
        return str;
    }

    public abstract boolean L();

    public final boolean M(boolean z4) {
        int iG = G(I());
        int length = C().length() - iG;
        if (length < 4 || iG == -1) {
            return false;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            if ("null".charAt(i4) != C().charAt(iG + i4)) {
                return false;
            }
        }
        if (length > 4 && AbstractC0379b.a(C().charAt(iG + 4)) == 0) {
            return false;
        }
        if (!z4) {
            return true;
        }
        this.f1505a = iG + 4;
        return true;
    }

    public final void O(char c4) {
        int i4 = this.f1505a - 1;
        this.f1505a = i4;
        if (i4 >= 0 && c4 == '\"' && kotlin.jvm.internal.r.b(s(), "null")) {
            x("Expected string literal but 'null' literal was found", this.f1505a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new C0739g();
        }
        z(AbstractC0379b.a(c4));
        throw new C0739g();
    }

    public final boolean P() {
        return C().charAt(this.f1505a - 1) != '\"';
    }

    public final int b(int i4) {
        int iG = G(i4);
        if (iG == -1) {
            y(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new C0739g();
        }
        int i5 = iG + 1;
        char cCharAt = C().charAt(iG);
        if (cCharAt == 'u') {
            return d(C(), i5);
        }
        char cB = AbstractC0379b.b(cCharAt);
        if (cB != 0) {
            this.f1508d.append(cB);
            return i5;
        }
        y(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new C0739g();
    }

    public final int c(int i4, int i5) {
        e(i4, i5);
        return b(i5 + 1);
    }

    public final int d(CharSequence charSequence, int i4) {
        int i5 = i4 + 4;
        if (i5 < charSequence.length()) {
            this.f1508d.append((char) ((B(charSequence, i4) << 12) + (B(charSequence, i4 + 1) << 8) + (B(charSequence, i4 + 2) << 4) + B(charSequence, i4 + 3)));
            return i5;
        }
        this.f1505a = i4;
        v();
        if (this.f1505a + 4 < charSequence.length()) {
            return d(charSequence, this.f1505a);
        }
        y(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new C0739g();
    }

    public void e(int i4, int i5) {
        this.f1508d.append(C(), i4, i5);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean h(int i4) {
        int iG = G(i4);
        if (iG >= C().length() || iG == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0739g();
        }
        int i5 = iG + 1;
        int iCharAt = C().charAt(iG) | ' ';
        if (iCharAt == 102) {
            j("alse", i5);
            return false;
        }
        if (iCharAt == 116) {
            j("rue", i5);
            return true;
        }
        y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
        throw new C0739g();
    }

    public final boolean i() {
        boolean z4;
        int I4 = I();
        if (I4 == C().length()) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0739g();
        }
        if (C().charAt(I4) == '\"') {
            I4++;
            z4 = true;
        } else {
            z4 = false;
        }
        boolean zH = h(I4);
        if (!z4) {
            return zH;
        }
        if (this.f1505a == C().length()) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0739g();
        }
        if (C().charAt(this.f1505a) == '\"') {
            this.f1505a++;
            return zH;
        }
        y(this, "Expected closing quotation mark", 0, null, 6, null);
        throw new C0739g();
    }

    public final void j(String str, int i4) {
        if (C().length() - i4 < str.length()) {
            y(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new C0739g();
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (str.charAt(i5) != (C().charAt(i4 + i5) | ' ')) {
                y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new C0739g();
            }
        }
        this.f1505a = i4 + str.length();
    }

    public abstract String k();

    public abstract String l(String str, boolean z4);

    public abstract byte m();

    public final byte n(byte b4) {
        byte bM = m();
        if (bM == b4) {
            return bM;
        }
        z(b4);
        throw new C0739g();
    }

    public abstract void o(char c4);

    public final long p() {
        boolean z4;
        int iG = G(I());
        if (iG >= C().length() || iG == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0739g();
        }
        if (C().charAt(iG) == '\"') {
            iG++;
            if (iG == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new C0739g();
            }
            z4 = true;
        } else {
            z4 = false;
        }
        int i4 = iG;
        boolean z5 = false;
        boolean z6 = true;
        long j4 = 0;
        while (z6) {
            char cCharAt = C().charAt(i4);
            if (cCharAt != '-') {
                if (AbstractC0379b.a(cCharAt) != 0) {
                    break;
                }
                i4++;
                z6 = i4 != C().length();
                int i5 = cCharAt - '0';
                if (i5 < 0 || i5 >= 10) {
                    y(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", 0, null, 6, null);
                    throw new C0739g();
                }
                j4 = (j4 * ((long) 10)) - ((long) i5);
                if (j4 > 0) {
                    y(this, "Numeric value overflow", 0, null, 6, null);
                    throw new C0739g();
                }
            } else {
                if (i4 != iG) {
                    y(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                    throw new C0739g();
                }
                i4++;
                z5 = true;
            }
        }
        if (iG == i4 || (z5 && iG == i4 - 1)) {
            y(this, "Expected numeric literal", 0, null, 6, null);
            throw new C0739g();
        }
        if (z4) {
            if (!z6) {
                y(this, "EOF", 0, null, 6, null);
                throw new C0739g();
            }
            if (C().charAt(i4) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new C0739g();
            }
            i4++;
        }
        this.f1505a = i4;
        if (z5) {
            return j4;
        }
        if (j4 != Long.MIN_VALUE) {
            return -j4;
        }
        y(this, "Numeric value overflow", 0, null, 6, null);
        throw new C0739g();
    }

    public final String q() {
        return this.f1507c != null ? K() : k();
    }

    public final String r(CharSequence source, int i4, int i5) {
        kotlin.jvm.internal.r.f(source, "source");
        char cCharAt = source.charAt(i5);
        boolean z4 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                int iG = G(c(i4, i5));
                if (iG == -1) {
                    y(this, "EOF", iG, null, 4, null);
                    throw new C0739g();
                }
                z4 = true;
                i4 = iG;
                i5 = i4;
            } else {
                i5++;
                if (i5 >= source.length()) {
                    e(i4, i5);
                    int iG2 = G(i5);
                    if (iG2 == -1) {
                        y(this, "EOF", iG2, null, 4, null);
                        throw new C0739g();
                    }
                    i4 = iG2;
                    i5 = i4;
                    z4 = true;
                } else {
                    continue;
                }
            }
            cCharAt = source.charAt(i5);
        }
        String strJ = !z4 ? J(i4, i5) : u(i4, i5);
        this.f1505a = i5 + 1;
        return strJ;
    }

    public final String s() {
        if (this.f1507c != null) {
            return K();
        }
        int I4 = I();
        if (I4 >= C().length() || I4 == -1) {
            y(this, "EOF", I4, null, 4, null);
            throw new C0739g();
        }
        byte bA = AbstractC0379b.a(C().charAt(I4));
        if (bA == 1) {
            return q();
        }
        if (bA != 0) {
            y(this, "Expected beginning of the string, but got " + C().charAt(I4), 0, null, 6, null);
            throw new C0739g();
        }
        boolean z4 = false;
        while (AbstractC0379b.a(C().charAt(I4)) == 0) {
            I4++;
            if (I4 >= C().length()) {
                e(this.f1505a, I4);
                int iG = G(I4);
                if (iG == -1) {
                    this.f1505a = I4;
                    return u(0, 0);
                }
                I4 = iG;
                z4 = true;
            }
        }
        String strJ = !z4 ? J(this.f1505a, I4) : u(this.f1505a, I4);
        this.f1505a = I4;
        return strJ;
    }

    public final String t() {
        String strS = s();
        if (!kotlin.jvm.internal.r.b(strS, "null") || !P()) {
            return strS;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new C0739g();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f1505a + ')';
    }

    public final String u(int i4, int i5) {
        e(i4, i5);
        String string = this.f1508d.toString();
        kotlin.jvm.internal.r.e(string, "escapedString.toString()");
        this.f1508d.setLength(0);
        return string;
    }

    public final void w() {
        if (m() == 10) {
            return;
        }
        y(this, "Expected EOF after parsing, but had " + C().charAt(this.f1505a - 1) + " instead", 0, null, 6, null);
        throw new C0739g();
    }

    public final Void x(String message, int i4, String hint) {
        String str;
        kotlin.jvm.internal.r.f(message, "message");
        kotlin.jvm.internal.r.f(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw E.f(i4, message + " at path: " + this.f1506b.a() + str, C());
    }

    public final Void z(byte b4) {
        y(this, "Expected " + (b4 == 1 ? "quotation mark '\"'" : b4 == 4 ? "comma ','" : b4 == 5 ? "colon ':'" : b4 == 6 ? "start of the object '{'" : b4 == 7 ? "end of the object '}'" : b4 == 8 ? "start of the array '['" : b4 == 9 ? "end of the array ']'" : "valid token") + ", but had '" + ((this.f1505a == C().length() || this.f1505a <= 0) ? "EOF" : String.valueOf(C().charAt(this.f1505a - 1))) + "' instead", this.f1505a - 1, null, 4, null);
        throw new C0739g();
    }

    public void v() {
    }
}
