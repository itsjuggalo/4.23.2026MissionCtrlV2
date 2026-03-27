package t6;

import E5.C0462g;
import java.util.ArrayList;

/* JADX INFO: renamed from: t6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2711a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24298a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24300c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G f24299b = new G();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f24301d = new StringBuilder();

    public static /* synthetic */ boolean N(AbstractC2711a abstractC2711a, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i7 & 1) != 0) {
            z7 = true;
        }
        return abstractC2711a.M(z7);
    }

    public static /* synthetic */ Void y(AbstractC2711a abstractC2711a, String str, int i7, String str2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i8 & 2) != 0) {
            i7 = abstractC2711a.f24298a;
        }
        if ((i8 & 4) != 0) {
            str2 = "";
        }
        return abstractC2711a.x(str, i7, str2);
    }

    public final void A(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        x("Encountered an unknown key '" + key + '\'', Z5.u.T(J(0, this.f24298a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new C0462g();
    }

    public final int B(CharSequence charSequence, int i7) {
        char cCharAt = charSequence.charAt(i7);
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
        throw new C0462g();
    }

    public abstract CharSequence C();

    public final boolean D(char c7) {
        return !(c7 == '}' || c7 == ']' || c7 == ':' || c7 == ',');
    }

    public final byte E() {
        CharSequence charSequenceC = C();
        int i7 = this.f24298a;
        while (true) {
            int iG = G(i7);
            if (iG == -1) {
                this.f24298a = iG;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iG);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f24298a = iG;
                return AbstractC2712b.a(cCharAt);
            }
            i7 = iG + 1;
        }
    }

    public final String F(boolean z7) {
        String strQ;
        byte bE = E();
        if (z7) {
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
        this.f24300c = strQ;
        return strQ;
    }

    public abstract int G(int i7);

    public final void H(boolean z7) {
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
                    if (((Number) F5.v.S(arrayList)).byteValue() != 8) {
                        throw E.f(this.f24298a, "found ] instead of } at path: " + this.f24299b, C());
                    }
                    F5.s.y(arrayList);
                } else if (bE2 == 7) {
                    if (((Number) F5.v.S(arrayList)).byteValue() != 6) {
                        throw E.f(this.f24298a, "found } instead of ] at path: " + this.f24299b, C());
                    }
                    F5.s.y(arrayList);
                } else if (bE2 == 10) {
                    y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new C0462g();
                }
                m();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z7) {
                s();
            } else {
                k();
            }
        }
    }

    public abstract int I();

    public String J(int i7, int i8) {
        return C().subSequence(i7, i8).toString();
    }

    public final String K() {
        String str = this.f24300c;
        kotlin.jvm.internal.r.c(str);
        this.f24300c = null;
        return str;
    }

    public abstract boolean L();

    public final boolean M(boolean z7) {
        int iG = G(I());
        int length = C().length() - iG;
        if (length < 4 || iG == -1) {
            return false;
        }
        for (int i7 = 0; i7 < 4; i7++) {
            if ("null".charAt(i7) != C().charAt(iG + i7)) {
                return false;
            }
        }
        if (length > 4 && AbstractC2712b.a(C().charAt(iG + 4)) == 0) {
            return false;
        }
        if (!z7) {
            return true;
        }
        this.f24298a = iG + 4;
        return true;
    }

    public final void O(char c7) {
        int i7 = this.f24298a - 1;
        this.f24298a = i7;
        if (i7 >= 0 && c7 == '\"' && kotlin.jvm.internal.r.b(s(), "null")) {
            x("Expected string literal but 'null' literal was found", this.f24298a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new C0462g();
        }
        z(AbstractC2712b.a(c7));
        throw new C0462g();
    }

    public final boolean P() {
        return C().charAt(this.f24298a - 1) != '\"';
    }

    public final int b(int i7) {
        int iG = G(i7);
        if (iG == -1) {
            y(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new C0462g();
        }
        int i8 = iG + 1;
        char cCharAt = C().charAt(iG);
        if (cCharAt == 'u') {
            return d(C(), i8);
        }
        char cB = AbstractC2712b.b(cCharAt);
        if (cB != 0) {
            this.f24301d.append(cB);
            return i8;
        }
        y(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new C0462g();
    }

    public final int c(int i7, int i8) {
        e(i7, i8);
        return b(i8 + 1);
    }

    public final int d(CharSequence charSequence, int i7) {
        int i8 = i7 + 4;
        if (i8 < charSequence.length()) {
            this.f24301d.append((char) ((B(charSequence, i7) << 12) + (B(charSequence, i7 + 1) << 8) + (B(charSequence, i7 + 2) << 4) + B(charSequence, i7 + 3)));
            return i8;
        }
        this.f24298a = i7;
        v();
        if (this.f24298a + 4 < charSequence.length()) {
            return d(charSequence, this.f24298a);
        }
        y(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new C0462g();
    }

    public void e(int i7, int i8) {
        this.f24301d.append(C(), i7, i8);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean h(int i7) {
        int iG = G(i7);
        if (iG >= C().length() || iG == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0462g();
        }
        int i8 = iG + 1;
        int iCharAt = C().charAt(iG) | ' ';
        if (iCharAt == 102) {
            j("alse", i8);
            return false;
        }
        if (iCharAt == 116) {
            j("rue", i8);
            return true;
        }
        y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
        throw new C0462g();
    }

    public final boolean i() {
        boolean z7;
        int I6 = I();
        if (I6 == C().length()) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0462g();
        }
        if (C().charAt(I6) == '\"') {
            I6++;
            z7 = true;
        } else {
            z7 = false;
        }
        boolean zH = h(I6);
        if (z7) {
            if (this.f24298a == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new C0462g();
            }
            if (C().charAt(this.f24298a) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new C0462g();
            }
            this.f24298a++;
        }
        return zH;
    }

    public final void j(String str, int i7) {
        if (C().length() - i7 < str.length()) {
            y(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new C0462g();
        }
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (str.charAt(i8) != (C().charAt(i7 + i8) | ' ')) {
                y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new C0462g();
            }
        }
        this.f24298a = i7 + str.length();
    }

    public abstract String k();

    public abstract String l(String str, boolean z7);

    public abstract byte m();

    public final byte n(byte b7) {
        byte bM = m();
        if (bM == b7) {
            return bM;
        }
        z(b7);
        throw new C0462g();
    }

    public abstract void o(char c7);

    public final long p() {
        boolean z7;
        int iG = G(I());
        if (iG >= C().length() || iG == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new C0462g();
        }
        if (C().charAt(iG) == '\"') {
            iG++;
            if (iG == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new C0462g();
            }
            z7 = true;
        } else {
            z7 = false;
        }
        int i7 = iG;
        long j7 = 0;
        boolean z8 = true;
        boolean z9 = false;
        while (z8) {
            char cCharAt = C().charAt(i7);
            if (cCharAt != '-') {
                if (AbstractC2712b.a(cCharAt) != 0) {
                    break;
                }
                i7++;
                z8 = i7 != C().length();
                int i8 = cCharAt - '0';
                if (i8 < 0 || i8 >= 10) {
                    y(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", 0, null, 6, null);
                    throw new C0462g();
                }
                j7 = (j7 * ((long) 10)) - ((long) i8);
                if (j7 > 0) {
                    y(this, "Numeric value overflow", 0, null, 6, null);
                    throw new C0462g();
                }
            } else {
                if (i7 != iG) {
                    y(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                    throw new C0462g();
                }
                i7++;
                z9 = true;
            }
        }
        if (iG == i7 || (z9 && iG == i7 - 1)) {
            y(this, "Expected numeric literal", 0, null, 6, null);
            throw new C0462g();
        }
        if (z7) {
            if (!z8) {
                y(this, "EOF", 0, null, 6, null);
                throw new C0462g();
            }
            if (C().charAt(i7) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new C0462g();
            }
            i7++;
        }
        this.f24298a = i7;
        if (z9) {
            return j7;
        }
        if (j7 != Long.MIN_VALUE) {
            return -j7;
        }
        y(this, "Numeric value overflow", 0, null, 6, null);
        throw new C0462g();
    }

    public final String q() {
        return this.f24300c != null ? K() : k();
    }

    public final String r(CharSequence source, int i7, int i8) {
        int iG;
        kotlin.jvm.internal.r.f(source, "source");
        char cCharAt = source.charAt(i8);
        boolean z7 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                iG = G(c(i7, i8));
                if (iG == -1) {
                    y(this, "EOF", iG, null, 4, null);
                    throw new C0462g();
                }
            } else {
                i8++;
                if (i8 >= source.length()) {
                    e(i7, i8);
                    iG = G(i8);
                    if (iG == -1) {
                        y(this, "EOF", iG, null, 4, null);
                        throw new C0462g();
                    }
                } else {
                    continue;
                    cCharAt = source.charAt(i8);
                }
            }
            z7 = true;
            i7 = iG;
            i8 = i7;
            cCharAt = source.charAt(i8);
        }
        String strJ = !z7 ? J(i7, i8) : u(i7, i8);
        this.f24298a = i8 + 1;
        return strJ;
    }

    public final String s() {
        if (this.f24300c != null) {
            return K();
        }
        int I6 = I();
        if (I6 >= C().length() || I6 == -1) {
            y(this, "EOF", I6, null, 4, null);
            throw new C0462g();
        }
        byte bA = AbstractC2712b.a(C().charAt(I6));
        if (bA == 1) {
            return q();
        }
        if (bA != 0) {
            y(this, "Expected beginning of the string, but got " + C().charAt(I6), 0, null, 6, null);
            throw new C0462g();
        }
        boolean z7 = false;
        while (AbstractC2712b.a(C().charAt(I6)) == 0) {
            I6++;
            if (I6 >= C().length()) {
                e(this.f24298a, I6);
                int iG = G(I6);
                if (iG == -1) {
                    this.f24298a = I6;
                    return u(0, 0);
                }
                I6 = iG;
                z7 = true;
            }
        }
        String strJ = !z7 ? J(this.f24298a, I6) : u(this.f24298a, I6);
        this.f24298a = I6;
        return strJ;
    }

    public final String t() {
        String strS = s();
        if (!kotlin.jvm.internal.r.b(strS, "null") || !P()) {
            return strS;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new C0462g();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f24298a + ')';
    }

    public final String u(int i7, int i8) {
        e(i7, i8);
        String string = this.f24301d.toString();
        kotlin.jvm.internal.r.e(string, "escapedString.toString()");
        this.f24301d.setLength(0);
        return string;
    }

    public final void w() {
        if (m() == 10) {
            return;
        }
        y(this, "Expected EOF after parsing, but had " + C().charAt(this.f24298a - 1) + " instead", 0, null, 6, null);
        throw new C0462g();
    }

    public final Void x(String message, int i7, String hint) {
        String str;
        kotlin.jvm.internal.r.f(message, "message");
        kotlin.jvm.internal.r.f(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw E.f(i7, message + " at path: " + this.f24299b.a() + str, C());
    }

    public final Void z(byte b7) {
        y(this, "Expected " + (b7 == 1 ? "quotation mark '\"'" : b7 == 4 ? "comma ','" : b7 == 5 ? "colon ':'" : b7 == 6 ? "start of the object '{'" : b7 == 7 ? "end of the object '}'" : b7 == 8 ? "start of the array '['" : b7 == 9 ? "end of the array ']'" : "valid token") + ", but had '" + ((this.f24298a == C().length() || this.f24298a <= 0) ? "EOF" : String.valueOf(C().charAt(this.f24298a - 1))) + "' instead", this.f24298a - 1, null, 4, null);
        throw new C0462g();
    }

    public void v() {
    }
}
