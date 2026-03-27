package q7;

import java.util.ArrayList;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2480h;
import o5.C2487o;

/* JADX INFO: renamed from: q7.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2643a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22858a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22860c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J f22859b = new J();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f22861d = new StringBuilder();

    public static /* synthetic */ boolean O(AbstractC2643a abstractC2643a, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i8 & 1) != 0) {
            z7 = true;
        }
        return abstractC2643a.N(z7);
    }

    public static final double n(long j8, boolean z7) {
        double d8;
        if (!z7) {
            d8 = -j8;
        } else {
            if (!z7) {
                throw new C2487o();
            }
            d8 = j8;
        }
        return Math.pow(10.0d, d8);
    }

    public static /* synthetic */ Void x(AbstractC2643a abstractC2643a, String str, int i8, String str2, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i9 & 2) != 0) {
            i8 = abstractC2643a.f22858a;
        }
        if ((i9 & 4) != 0) {
            str2 = "";
        }
        return abstractC2643a.w(str, i8, str2);
    }

    public static /* synthetic */ Void z(AbstractC2643a abstractC2643a, byte b8, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i8 & 2) != 0) {
            z7 = true;
        }
        return abstractC2643a.y(b8, z7);
    }

    public final void A(String key) {
        AbstractC2304t.f(key, "key");
        w("Encountered an unknown key '" + key + '\'', V6.C.e0(K(0, this.f22858a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new C2480h();
    }

    public final int B(CharSequence charSequence, int i8) {
        char cCharAt = charSequence.charAt(i8);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        x(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new C2480h();
    }

    public abstract CharSequence C();

    public final boolean D(char c8) {
        return (c8 == ',' || c8 == ':' || c8 == ']' || c8 == '}') ? false : true;
    }

    public abstract String E(String str, boolean z7);

    public byte F() {
        CharSequence charSequenceC = C();
        int i8 = this.f22858a;
        while (true) {
            int iH = H(i8);
            if (iH == -1) {
                this.f22858a = iH;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iH);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f22858a = iH;
                return AbstractC2644b.a(cCharAt);
            }
            i8 = iH + 1;
        }
    }

    public final String G(boolean z7) {
        String strO;
        byte bF = F();
        if (z7) {
            if (bF != 1 && bF != 0) {
                return null;
            }
            strO = q();
        } else {
            if (bF != 1) {
                return null;
            }
            strO = o();
        }
        this.f22860c = strO;
        return strO;
    }

    public abstract int H(int i8);

    public final void I(boolean z7) {
        ArrayList arrayList = new ArrayList();
        byte bF = F();
        if (bF != 8 && bF != 6) {
            q();
            return;
        }
        while (true) {
            byte bF2 = F();
            if (bF2 != 1) {
                if (bF2 == 8 || bF2 == 6) {
                    arrayList.add(Byte.valueOf(bF2));
                } else {
                    if (bF2 == 9) {
                        if (((Number) p5.z.j0(arrayList)).byteValue() != 8) {
                            throw G.f(this.f22858a, "found ] instead of } at path: " + this.f22859b, C());
                        }
                    } else if (bF2 == 7) {
                        if (((Number) p5.z.j0(arrayList)).byteValue() != 6) {
                            throw G.f(this.f22858a, "found } instead of ] at path: " + this.f22859b, C());
                        }
                    } else if (bF2 == 10) {
                        x(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                        throw new C2480h();
                    }
                    p5.v.C(arrayList);
                }
                j();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z7) {
                q();
            } else {
                i();
            }
        }
    }

    public abstract int J();

    public String K(int i8, int i9) {
        return C().subSequence(i8, i9).toString();
    }

    public final String L() {
        String str = this.f22860c;
        AbstractC2304t.c(str);
        this.f22860c = null;
        return str;
    }

    public final boolean M() {
        int iJ = J();
        CharSequence charSequenceC = C();
        if (iJ >= charSequenceC.length() || iJ == -1 || charSequenceC.charAt(iJ) != ',') {
            return false;
        }
        this.f22858a++;
        return true;
    }

    public final boolean N(boolean z7) {
        int iH = H(J());
        int length = C().length() - iH;
        if (length < 4 || iH == -1) {
            return false;
        }
        for (int i8 = 0; i8 < 4; i8++) {
            if ("null".charAt(i8) != C().charAt(iH + i8)) {
                return false;
            }
        }
        if (length > 4 && AbstractC2644b.a(C().charAt(iH + 4)) == 0) {
            return false;
        }
        if (!z7) {
            return true;
        }
        this.f22858a = iH + 4;
        return true;
    }

    public final void P(char c8) {
        int i8 = this.f22858a;
        if (i8 > 0 && c8 == '\"') {
            try {
                this.f22858a = i8 - 1;
                String strQ = q();
                this.f22858a = i8;
                if (AbstractC2304t.b(strQ, "null")) {
                    w("Expected string literal but 'null' literal was found", this.f22858a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new C2480h();
                }
            } catch (Throwable th) {
                this.f22858a = i8;
                throw th;
            }
        }
        z(this, AbstractC2644b.a(c8), false, 2, null);
        throw new C2480h();
    }

    public final boolean Q() {
        return C().charAt(this.f22858a - 1) != '\"';
    }

    public final int a(int i8) {
        int iH = H(i8);
        if (iH == -1) {
            x(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new C2480h();
        }
        int i9 = iH + 1;
        char cCharAt = C().charAt(iH);
        if (cCharAt == 'u') {
            return c(C(), i9);
        }
        char cB = AbstractC2644b.b(cCharAt);
        if (cB != 0) {
            this.f22861d.append(cB);
            return i9;
        }
        x(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new C2480h();
    }

    public final int b(int i8, int i9) {
        d(i8, i9);
        return a(i9 + 1);
    }

    public final int c(CharSequence charSequence, int i8) {
        int i9 = i8 + 4;
        if (i9 < charSequence.length()) {
            this.f22861d.append((char) ((B(charSequence, i8) << 12) + (B(charSequence, i8 + 1) << 8) + (B(charSequence, i8 + 2) << 4) + B(charSequence, i8 + 3)));
            return i9;
        }
        this.f22858a = i8;
        u();
        if (this.f22858a + 4 < charSequence.length()) {
            return c(charSequence, this.f22858a);
        }
        x(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new C2480h();
    }

    public void d(int i8, int i9) {
        this.f22861d.append(C(), i8, i9);
    }

    public abstract boolean e();

    public final boolean f(int i8) {
        int iH = H(i8);
        if (iH >= C().length() || iH == -1) {
            x(this, "EOF", 0, null, 6, null);
            throw new C2480h();
        }
        int i9 = iH + 1;
        int iCharAt = C().charAt(iH) | ' ';
        if (iCharAt == 102) {
            h("alse", i9);
            return false;
        }
        if (iCharAt == 116) {
            h("rue", i9);
            return true;
        }
        x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
        throw new C2480h();
    }

    public final boolean g() {
        boolean z7;
        int iJ = J();
        if (iJ == C().length()) {
            x(this, "EOF", 0, null, 6, null);
            throw new C2480h();
        }
        if (C().charAt(iJ) == '\"') {
            iJ++;
            z7 = true;
        } else {
            z7 = false;
        }
        boolean zF = f(iJ);
        if (z7) {
            if (this.f22858a == C().length()) {
                x(this, "EOF", 0, null, 6, null);
                throw new C2480h();
            }
            if (C().charAt(this.f22858a) != '\"') {
                x(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new C2480h();
            }
            this.f22858a++;
        }
        return zF;
    }

    public final void h(String str, int i8) {
        if (C().length() - i8 < str.length()) {
            x(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new C2480h();
        }
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            if (str.charAt(i9) != (C().charAt(i8 + i9) | ' ')) {
                x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
                throw new C2480h();
            }
        }
        this.f22858a = i8 + str.length();
    }

    public abstract String i();

    public abstract byte j();

    public final byte k(byte b8) {
        byte bJ = j();
        if (bJ == b8) {
            return bJ;
        }
        z(this, b8, false, 2, null);
        throw new C2480h();
    }

    public abstract void l(char c8);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f4, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f5, code lost:
    
        x(r17, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0205, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011c, code lost:
    
        x(r17, "Unexpected symbol '" + r3 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0140, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0141, code lost:
    
        if (r5 == r0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0143, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0145, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0146, code lost:
    
        if (r0 == r5) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0148, code lost:
    
        if (r10 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014c, code lost:
    
        if (r0 == (r5 - 1)) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014e, code lost:
    
        if (r1 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0150, code lost:
    
        if (r3 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015c, code lost:
    
        if (C().charAt(r5) != '\"') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015e, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0161, code lost:
    
        x(r17, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0171, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0172, code lost:
    
        x(r17, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0182, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0183, code lost:
    
        r17.f22858a = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0185, code lost:
    
        if (r9 == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0187, code lost:
    
        r0 = r11 * n(r13, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0191, code lost:
    
        if (r0 > 9.223372036854776E18d) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0197, code lost:
    
        if (r0 < (-9.223372036854776E18d)) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
    
        if (java.lang.Math.floor(r0) != r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a1, code lost:
    
        r11 = (long) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a3, code lost:
    
        x(r17, "Can't convert " + r0 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c7, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c8, code lost:
    
        x(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d8, code lost:
    
        throw new o5.C2480h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d9, code lost:
    
        if (r10 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e0, code lost:
    
        if (r11 == Long.MIN_VALUE) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e3, code lost:
    
        return -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e4, code lost:
    
        x(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m() {
        /*
            Method dump skipped, instruction units count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.AbstractC2643a.m():long");
    }

    public final String o() {
        return this.f22860c != null ? L() : i();
    }

    public final String p(CharSequence source, int i8, int i9) {
        int iH;
        AbstractC2304t.f(source, "source");
        char cCharAt = source.charAt(i9);
        boolean z7 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                iH = H(b(i8, i9));
                if (iH == -1) {
                    x(this, "Unexpected EOF", iH, null, 4, null);
                    throw new C2480h();
                }
            } else {
                i9++;
                if (i9 >= source.length()) {
                    d(i8, i9);
                    iH = H(i9);
                    if (iH == -1) {
                        x(this, "Unexpected EOF", iH, null, 4, null);
                        throw new C2480h();
                    }
                } else {
                    continue;
                    cCharAt = source.charAt(i9);
                }
            }
            z7 = true;
            i8 = iH;
            i9 = i8;
            cCharAt = source.charAt(i9);
        }
        String strK = !z7 ? K(i8, i9) : s(i8, i9);
        this.f22858a = i9 + 1;
        return strK;
    }

    public final String q() {
        if (this.f22860c != null) {
            return L();
        }
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            x(this, "EOF", iJ, null, 4, null);
            throw new C2480h();
        }
        byte bA = AbstractC2644b.a(C().charAt(iJ));
        if (bA == 1) {
            return o();
        }
        if (bA != 0) {
            x(this, "Expected beginning of the string, but got " + C().charAt(iJ), 0, null, 6, null);
            throw new C2480h();
        }
        boolean z7 = false;
        while (AbstractC2644b.a(C().charAt(iJ)) == 0) {
            iJ++;
            if (iJ >= C().length()) {
                d(this.f22858a, iJ);
                int iH = H(iJ);
                if (iH == -1) {
                    this.f22858a = iJ;
                    return s(0, 0);
                }
                iJ = iH;
                z7 = true;
            }
        }
        int i8 = this.f22858a;
        String strK = !z7 ? K(i8, iJ) : s(i8, iJ);
        this.f22858a = iJ;
        return strK;
    }

    public final String r() {
        String strQ = q();
        if (!AbstractC2304t.b(strQ, "null") || !Q()) {
            return strQ;
        }
        x(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new C2480h();
    }

    public final String s(int i8, int i9) {
        d(i8, i9);
        String string = this.f22861d.toString();
        AbstractC2304t.e(string, "toString(...)");
        this.f22861d.setLength(0);
        return string;
    }

    public final void t() {
        this.f22860c = null;
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f22858a + ')';
    }

    public final void v() {
        if (j() == 10) {
            return;
        }
        x(this, "Expected EOF after parsing, but had " + C().charAt(this.f22858a - 1) + " instead", 0, null, 6, null);
        throw new C2480h();
    }

    public final Void w(String message, int i8, String hint) {
        String str;
        AbstractC2304t.f(message, "message");
        AbstractC2304t.f(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw G.f(i8, message + " at path: " + this.f22859b.a() + str, C());
    }

    public final Void y(byte b8, boolean z7) {
        String strC = AbstractC2644b.c(b8);
        int i8 = z7 ? this.f22858a - 1 : this.f22858a;
        x(this, "Expected " + strC + ", but had '" + ((this.f22858a == C().length() || i8 < 0) ? "EOF" : String.valueOf(C().charAt(i8))) + "' instead", i8, null, 4, null);
        throw new C2480h();
    }

    public void u() {
    }
}
