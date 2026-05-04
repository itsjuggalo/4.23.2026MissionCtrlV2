package vb;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f23304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f23305g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f23299a = name;
        this.f23300b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.f23302d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.f23303e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f23301c
            r8.f23302d = r0
            r8.f23303e = r0
        L6:
            int r0 = r8.f23301c
            int r1 = r8.f23300b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f23305g
            int r2 = r8.f23302d
            int r3 = r8.f23303e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f23305g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.f23303e
            int r4 = r3 + 1
            r8.f23303e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f23301c = r0
            goto L6
        L3e:
            int r0 = r8.f23303e
            int r2 = r0 + 1
            r8.f23303e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f23301c
            int r0 = r0 + 1
            r8.f23301c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f23302d
            int r3 = r8.f23303e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f23303e
            r8.f23304f = r2
            int r0 = r0 + 1
            r8.f23301c = r0
            int r0 = r2 + 1
            r8.f23303e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f23301c
            int r1 = r8.f23300b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f23305g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f23303e
            int r7 = r1 + 1
            r8.f23303e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f23301c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f23305g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f23305g
            int r2 = r8.f23302d
            int r3 = r8.f23304f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vb.d.a():java.lang.String");
    }

    public String b(String str) {
        this.f23301c = 0;
        this.f23302d = 0;
        this.f23303e = 0;
        this.f23304f = 0;
        this.f23305g = this.f23299a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i10 = this.f23301c;
            if (i10 == this.f23300b) {
                return null;
            }
            char c10 = this.f23305g[i10];
            String strA = c10 != '\"' ? c10 != '#' ? (c10 == '+' || c10 == ',' || c10 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(strG)) {
                return strA;
            }
            int i11 = this.f23301c;
            if (i11 >= this.f23300b) {
                return null;
            }
            char c11 = this.f23305g[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f23299a);
            }
            this.f23301c = i11 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f23299a);
    }

    public final int c(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.f23300b) {
            throw new IllegalStateException("Malformed DN: " + this.f23299a);
        }
        char[] cArr = this.f23305g;
        char c10 = cArr[i10];
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i11 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f23299a);
            }
            i11 = c10 - '7';
        }
        char c11 = cArr[i13];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f23299a);
            }
            i12 = c11 - '7';
        }
        return (i11 << 4) + i12;
    }

    public final char d() {
        int i10 = this.f23301c + 1;
        this.f23301c = i10;
        if (i10 == this.f23300b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f23299a);
        }
        char c10 = this.f23305g[i10];
        if (c10 == ' ' || c10 == '%' || c10 == '\\' || c10 == '_' || c10 == '\"' || c10 == '#') {
            return c10;
        }
        switch (c10) {
            case '*':
            case '+':
            case ',':
                return c10;
            default:
                switch (c10) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c10;
                    default:
                        return e();
                }
        }
    }

    public final char e() {
        int i10;
        int i11;
        int iC = c(this.f23301c);
        this.f23301c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i10 = iC & 31;
            i11 = 1;
        } else if (iC <= 239) {
            i10 = iC & 15;
            i11 = 2;
        } else {
            i10 = iC & 7;
            i11 = 3;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f23301c;
            int i14 = i13 + 1;
            this.f23301c = i14;
            if (i14 == this.f23300b || this.f23305g[i14] != '\\') {
                return '?';
            }
            int i15 = i13 + 2;
            this.f23301c = i15;
            int iC2 = c(i15);
            this.f23301c++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (iC2 & 63);
        }
        return (char) i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.f23303e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f23301c
            int r1 = r0 + 4
            int r2 = r6.f23300b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L98
            r6.f23302d = r0
            int r0 = r0 + 1
            r6.f23301c = r0
        L10:
            int r0 = r6.f23301c
            int r1 = r6.f23300b
            if (r0 == r1) goto L54
            char[] r1 = r6.f23305g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L54
            r4 = 44
            if (r2 == r4) goto L54
            r4 = 59
            if (r2 != r4) goto L27
            goto L54
        L27:
            r4 = 32
            if (r2 != r4) goto L42
            r6.f23303e = r0
            int r0 = r0 + 1
            r6.f23301c = r0
        L31:
            int r0 = r6.f23301c
            int r1 = r6.f23300b
            if (r0 >= r1) goto L56
            char[] r1 = r6.f23305g
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.f23301c = r0
            goto L31
        L42:
            r4 = 65
            if (r2 < r4) goto L4f
            r4 = 70
            if (r2 > r4) goto L4f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L4f:
            int r0 = r0 + 1
            r6.f23301c = r0
            goto L10
        L54:
            r6.f23303e = r0
        L56:
            int r0 = r6.f23303e
            int r1 = r6.f23302d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L81
            r2 = r0 & 1
            if (r2 == 0) goto L81
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L69:
            if (r4 >= r2) goto L77
            int r5 = r6.c(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f23305g
            int r3 = r6.f23302d
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f23299a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L98:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f23299a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vb.d.f():java.lang.String");
    }

    public final String g() {
        int i10;
        int i11;
        int i12;
        int i13;
        char c10;
        int i14;
        int i15;
        char c11;
        char c12;
        while (true) {
            i10 = this.f23301c;
            i11 = this.f23300b;
            if (i10 >= i11 || this.f23305g[i10] != ' ') {
                break;
            }
            this.f23301c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f23302d = i10;
        this.f23301c = i10 + 1;
        while (true) {
            i12 = this.f23301c;
            i13 = this.f23300b;
            if (i12 >= i13 || (c12 = this.f23305g[i12]) == '=' || c12 == ' ') {
                break;
            }
            this.f23301c = i12 + 1;
        }
        if (i12 >= i13) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f23299a);
        }
        this.f23303e = i12;
        if (this.f23305g[i12] == ' ') {
            while (true) {
                i14 = this.f23301c;
                i15 = this.f23300b;
                if (i14 >= i15 || (c11 = this.f23305g[i14]) == '=' || c11 != ' ') {
                    break;
                }
                this.f23301c = i14 + 1;
            }
            if (this.f23305g[i14] != '=' || i14 == i15) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f23299a);
            }
        }
        this.f23301c++;
        while (true) {
            int i16 = this.f23301c;
            if (i16 >= this.f23300b || this.f23305g[i16] != ' ') {
                break;
            }
            this.f23301c = i16 + 1;
        }
        int i17 = this.f23303e;
        int i18 = this.f23302d;
        if (i17 - i18 > 4) {
            char[] cArr = this.f23305g;
            if (cArr[i18 + 3] == '.' && (((c10 = cArr[i18]) == 'O' || c10 == 'o') && ((cArr[i18 + 1] == 'I' || cArr[i18 + 1] == 'i') && (cArr[i18 + 2] == 'D' || cArr[i18 + 2] == 'd')))) {
                this.f23302d = i18 + 4;
            }
        }
        char[] cArr2 = this.f23305g;
        int i19 = this.f23302d;
        return new String(cArr2, i19, i17 - i19);
    }

    public final String h() {
        int i10 = this.f23301c + 1;
        this.f23301c = i10;
        this.f23302d = i10;
        this.f23303e = i10;
        while (true) {
            int i11 = this.f23301c;
            if (i11 == this.f23300b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f23299a);
            }
            char[] cArr = this.f23305g;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                this.f23301c = i11 + 1;
                while (true) {
                    int i12 = this.f23301c;
                    if (i12 >= this.f23300b || this.f23305g[i12] != ' ') {
                        break;
                    }
                    this.f23301c = i12 + 1;
                }
                char[] cArr2 = this.f23305g;
                int i13 = this.f23302d;
                return new String(cArr2, i13, this.f23303e - i13);
            }
            if (c10 == '\\') {
                cArr[this.f23303e] = d();
            } else {
                cArr[this.f23303e] = c10;
            }
            this.f23301c++;
            this.f23303e++;
        }
    }
}
