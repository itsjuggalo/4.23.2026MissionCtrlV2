package fh;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9544a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9546c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f9545b = new f0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f9547d = new StringBuilder();

    public static /* synthetic */ boolean O(a aVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return aVar.N(z10);
    }

    public static final double n(long j10, boolean z10) {
        if (!z10) {
            return Math.pow(10.0d, -j10);
        }
        if (z10) {
            return Math.pow(10.0d, j10);
        }
        throw new cd.o();
    }

    public static /* synthetic */ Void x(a aVar, String str, int i10, String str2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i11 & 2) != 0) {
            i10 = aVar.f9544a;
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        return aVar.w(str, i10, str2);
    }

    public static /* synthetic */ Void z(a aVar, byte b10, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return aVar.y(b10, z10);
    }

    public final void A(String key) {
        kotlin.jvm.internal.t.f(key, "key");
        w("Encountered an unknown key '" + key + '\'', kg.c0.i0(K(0, this.f9544a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new cd.h();
    }

    public final int B(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
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
        throw new cd.h();
    }

    public abstract CharSequence C();

    public final boolean D(char c10) {
        return (c10 == ',' || c10 == ':' || c10 == ']' || c10 == '}') ? false : true;
    }

    public abstract String E(String str, boolean z10);

    public byte F() {
        CharSequence charSequenceC = C();
        int i10 = this.f9544a;
        while (true) {
            int iH = H(i10);
            if (iH == -1) {
                this.f9544a = iH;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iH);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f9544a = iH;
                return b.a(cCharAt);
            }
            i10 = iH + 1;
        }
    }

    public final String G(boolean z10) {
        String strO;
        byte bF = F();
        if (z10) {
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
        this.f9546c = strO;
        return strO;
    }

    public abstract int H(int i10);

    public final void I(boolean z10) {
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
                } else if (bF2 == 9) {
                    if (((Number) dd.a0.k0(arrayList)).byteValue() != 8) {
                        throw c0.f(this.f9544a, "found ] instead of } at path: " + this.f9545b, C());
                    }
                    dd.w.E(arrayList);
                } else if (bF2 == 7) {
                    if (((Number) dd.a0.k0(arrayList)).byteValue() != 6) {
                        throw c0.f(this.f9544a, "found } instead of ] at path: " + this.f9545b, C());
                    }
                    dd.w.E(arrayList);
                } else if (bF2 == 10) {
                    x(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new cd.h();
                }
                j();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z10) {
                q();
            } else {
                i();
            }
        }
    }

    public abstract int J();

    public String K(int i10, int i11) {
        return C().subSequence(i10, i11).toString();
    }

    public final String L() {
        String str = this.f9546c;
        kotlin.jvm.internal.t.c(str);
        this.f9546c = null;
        return str;
    }

    public final boolean M() {
        int iJ = J();
        CharSequence charSequenceC = C();
        if (iJ >= charSequenceC.length() || iJ == -1 || charSequenceC.charAt(iJ) != ',') {
            return false;
        }
        this.f9544a++;
        return true;
    }

    public final boolean N(boolean z10) {
        int iH = H(J());
        int length = C().length() - iH;
        if (length < 4 || iH == -1) {
            return false;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            if ("null".charAt(i10) != C().charAt(iH + i10)) {
                return false;
            }
        }
        if (length > 4 && b.a(C().charAt(iH + 4)) == 0) {
            return false;
        }
        if (!z10) {
            return true;
        }
        this.f9544a = iH + 4;
        return true;
    }

    public final void P(char c10) {
        int i10 = this.f9544a;
        if (i10 > 0 && c10 == '\"') {
            try {
                this.f9544a = i10 - 1;
                String strQ = q();
                this.f9544a = i10;
                if (kotlin.jvm.internal.t.b(strQ, "null")) {
                    w("Expected string literal but 'null' literal was found", this.f9544a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new cd.h();
                }
            } catch (Throwable th) {
                this.f9544a = i10;
                throw th;
            }
        }
        z(this, b.a(c10), false, 2, null);
        throw new cd.h();
    }

    public final boolean Q() {
        return C().charAt(this.f9544a - 1) != '\"';
    }

    public final int a(int i10) {
        int iH = H(i10);
        if (iH == -1) {
            x(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new cd.h();
        }
        int i11 = iH + 1;
        char cCharAt = C().charAt(iH);
        if (cCharAt == 'u') {
            return c(C(), i11);
        }
        char cB = b.b(cCharAt);
        if (cB != 0) {
            this.f9547d.append(cB);
            return i11;
        }
        x(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new cd.h();
    }

    public final int b(int i10, int i11) {
        d(i10, i11);
        return a(i11 + 1);
    }

    public final int c(CharSequence charSequence, int i10) {
        int i11 = i10 + 4;
        if (i11 < charSequence.length()) {
            this.f9547d.append((char) ((B(charSequence, i10) << 12) + (B(charSequence, i10 + 1) << 8) + (B(charSequence, i10 + 2) << 4) + B(charSequence, i10 + 3)));
            return i11;
        }
        this.f9544a = i10;
        u();
        if (this.f9544a + 4 < charSequence.length()) {
            return c(charSequence, this.f9544a);
        }
        x(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new cd.h();
    }

    public void d(int i10, int i11) {
        this.f9547d.append(C(), i10, i11);
    }

    public abstract boolean e();

    public final boolean f(int i10) {
        int iH = H(i10);
        if (iH >= C().length() || iH == -1) {
            x(this, "EOF", 0, null, 6, null);
            throw new cd.h();
        }
        int i11 = iH + 1;
        int iCharAt = C().charAt(iH) | ' ';
        if (iCharAt == 102) {
            h("alse", i11);
            return false;
        }
        if (iCharAt == 116) {
            h("rue", i11);
            return true;
        }
        x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
        throw new cd.h();
    }

    public final boolean g() {
        boolean z10;
        int iJ = J();
        if (iJ == C().length()) {
            x(this, "EOF", 0, null, 6, null);
            throw new cd.h();
        }
        if (C().charAt(iJ) == '\"') {
            iJ++;
            z10 = true;
        } else {
            z10 = false;
        }
        boolean zF = f(iJ);
        if (!z10) {
            return zF;
        }
        if (this.f9544a == C().length()) {
            x(this, "EOF", 0, null, 6, null);
            throw new cd.h();
        }
        if (C().charAt(this.f9544a) == '\"') {
            this.f9544a++;
            return zF;
        }
        x(this, "Expected closing quotation mark", 0, null, 6, null);
        throw new cd.h();
    }

    public final void h(String str, int i10) {
        if (C().length() - i10 < str.length()) {
            x(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new cd.h();
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != (C().charAt(i10 + i11) | ' ')) {
                x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
                throw new cd.h();
            }
        }
        this.f9544a = i10 + str.length();
    }

    public abstract String i();

    public abstract byte j();

    public final byte k(byte b10) {
        byte bJ = j();
        if (bJ == b10) {
            return bJ;
        }
        z(this, b10, false, 2, null);
        throw new cd.h();
    }

    public abstract void l(char c10);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f1, code lost:
    
        x(r18, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0201, code lost:
    
        throw new cd.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011a, code lost:
    
        x(r18, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013e, code lost:
    
        throw new cd.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013f, code lost:
    
        if (r2 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0141, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0144, code lost:
    
        if (r1 == r2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0146, code lost:
    
        if (r9 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014a, code lost:
    
        if (r1 == (r2 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        if (r0 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        if (r4 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0158, code lost:
    
        if (C().charAt(r2) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015a, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015f, code lost:
    
        x(r18, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016f, code lost:
    
        throw new cd.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0170, code lost:
    
        x(r18, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0180, code lost:
    
        throw new cd.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0181, code lost:
    
        r18.f9544a = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0183, code lost:
    
        if (r8 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0185, code lost:
    
        r1 = r10 * n(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018f, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0195, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019d, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a1, code lost:
    
        x(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
    
        throw new cd.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c4, code lost:
    
        x(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d4, code lost:
    
        throw new cd.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d5, code lost:
    
        if (r9 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d7, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01dc, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01df, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e0, code lost:
    
        x(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f0, code lost:
    
        throw new cd.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m() {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fh.a.m():long");
    }

    public final String o() {
        return this.f9546c != null ? L() : i();
    }

    public final String p(CharSequence source, int i10, int i11) {
        kotlin.jvm.internal.t.f(source, "source");
        char cCharAt = source.charAt(i11);
        boolean z10 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                int iH = H(b(i10, i11));
                if (iH == -1) {
                    x(this, "Unexpected EOF", iH, null, 4, null);
                    throw new cd.h();
                }
                z10 = true;
                i10 = iH;
                i11 = i10;
            } else {
                i11++;
                if (i11 >= source.length()) {
                    d(i10, i11);
                    int iH2 = H(i11);
                    if (iH2 == -1) {
                        x(this, "Unexpected EOF", iH2, null, 4, null);
                        throw new cd.h();
                    }
                    i10 = iH2;
                    i11 = i10;
                    z10 = true;
                } else {
                    continue;
                }
            }
            cCharAt = source.charAt(i11);
        }
        String strK = !z10 ? K(i10, i11) : s(i10, i11);
        this.f9544a = i11 + 1;
        return strK;
    }

    public final String q() {
        if (this.f9546c != null) {
            return L();
        }
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            x(this, "EOF", iJ, null, 4, null);
            throw new cd.h();
        }
        byte bA = b.a(C().charAt(iJ));
        if (bA == 1) {
            return o();
        }
        if (bA != 0) {
            x(this, "Expected beginning of the string, but got " + C().charAt(iJ), 0, null, 6, null);
            throw new cd.h();
        }
        boolean z10 = false;
        while (b.a(C().charAt(iJ)) == 0) {
            iJ++;
            if (iJ >= C().length()) {
                d(this.f9544a, iJ);
                int iH = H(iJ);
                if (iH == -1) {
                    this.f9544a = iJ;
                    return s(0, 0);
                }
                iJ = iH;
                z10 = true;
            }
        }
        String strK = !z10 ? K(this.f9544a, iJ) : s(this.f9544a, iJ);
        this.f9544a = iJ;
        return strK;
    }

    public final String r() {
        String strQ = q();
        if (!kotlin.jvm.internal.t.b(strQ, "null") || !Q()) {
            return strQ;
        }
        x(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new cd.h();
    }

    public final String s(int i10, int i11) {
        d(i10, i11);
        String string = this.f9547d.toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        this.f9547d.setLength(0);
        return string;
    }

    public final void t() {
        this.f9546c = null;
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f9544a + ')';
    }

    public final void v() {
        if (j() == 10) {
            return;
        }
        x(this, "Expected EOF after parsing, but had " + C().charAt(this.f9544a - 1) + " instead", 0, null, 6, null);
        throw new cd.h();
    }

    public final Void w(String message, int i10, String hint) {
        String str;
        kotlin.jvm.internal.t.f(message, "message");
        kotlin.jvm.internal.t.f(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw c0.f(i10, message + " at path: " + this.f9545b.a() + str, C());
    }

    public final Void y(byte b10, boolean z10) {
        String strC = b.c(b10);
        int i10 = z10 ? this.f9544a - 1 : this.f9544a;
        x(this, "Expected " + strC + ", but had '" + ((this.f9544a == C().length() || i10 < 0) ? "EOF" : String.valueOf(C().charAt(i10))) + "' instead", i10, null, 4, null);
        throw new cd.h();
    }

    public void u() {
    }
}
