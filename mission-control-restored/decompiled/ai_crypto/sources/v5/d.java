package v5;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f24884g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f24878a = name;
        this.f24879b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.f24881d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.f24882e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f24880c
            r8.f24881d = r0
            r8.f24882e = r0
        L6:
            int r0 = r8.f24880c
            int r1 = r8.f24879b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f24884g
            int r2 = r8.f24881d
            int r3 = r8.f24882e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f24884g
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
            int r3 = r8.f24882e
            int r4 = r3 + 1
            r8.f24882e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f24880c = r0
            goto L6
        L3e:
            int r0 = r8.f24882e
            int r2 = r0 + 1
            r8.f24882e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f24880c
            int r0 = r0 + 1
            r8.f24880c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f24881d
            int r3 = r8.f24882e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f24882e
            r8.f24883f = r2
            int r0 = r0 + 1
            r8.f24880c = r0
            int r0 = r2 + 1
            r8.f24882e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f24880c
            int r1 = r8.f24879b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f24884g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f24882e
            int r7 = r1 + 1
            r8.f24882e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f24880c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f24884g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f24884g
            int r2 = r8.f24881d
            int r3 = r8.f24883f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.d.a():java.lang.String");
    }

    public String b(String str) {
        this.f24880c = 0;
        this.f24881d = 0;
        this.f24882e = 0;
        this.f24883f = 0;
        this.f24884g = this.f24878a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i7 = this.f24880c;
            if (i7 == this.f24879b) {
                return null;
            }
            char c7 = this.f24884g[i7];
            String strA = c7 != '\"' ? c7 != '#' ? (c7 == '+' || c7 == ',' || c7 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(strG)) {
                return strA;
            }
            int i8 = this.f24880c;
            if (i8 >= this.f24879b) {
                return null;
            }
            char c8 = this.f24884g[i8];
            if (c8 != ',' && c8 != ';' && c8 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f24878a);
            }
            this.f24880c = i8 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f24878a);
    }

    public final int c(int i7) {
        int i8;
        int i9;
        int i10 = i7 + 1;
        if (i10 >= this.f24879b) {
            throw new IllegalStateException("Malformed DN: " + this.f24878a);
        }
        char[] cArr = this.f24884g;
        char c7 = cArr[i7];
        if (c7 >= '0' && c7 <= '9') {
            i8 = c7 - '0';
        } else if (c7 >= 'a' && c7 <= 'f') {
            i8 = c7 - 'W';
        } else {
            if (c7 < 'A' || c7 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f24878a);
            }
            i8 = c7 - '7';
        }
        char c8 = cArr[i10];
        if (c8 >= '0' && c8 <= '9') {
            i9 = c8 - '0';
        } else if (c8 >= 'a' && c8 <= 'f') {
            i9 = c8 - 'W';
        } else {
            if (c8 < 'A' || c8 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f24878a);
            }
            i9 = c8 - '7';
        }
        return (i8 << 4) + i9;
    }

    public final char d() {
        int i7 = this.f24880c + 1;
        this.f24880c = i7;
        if (i7 == this.f24879b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f24878a);
        }
        char c7 = this.f24884g[i7];
        if (c7 == ' ' || c7 == '%' || c7 == '\\' || c7 == '_' || c7 == '\"' || c7 == '#') {
            return c7;
        }
        switch (c7) {
            case '*':
            case '+':
            case ',':
                return c7;
            default:
                switch (c7) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c7;
                    default:
                        return e();
                }
        }
    }

    public final char e() {
        int i7;
        int i8;
        int iC = c(this.f24880c);
        this.f24880c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i7 = iC & 31;
            i8 = 1;
        } else if (iC <= 239) {
            i7 = iC & 15;
            i8 = 2;
        } else {
            i7 = iC & 7;
            i8 = 3;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = this.f24880c;
            int i11 = i10 + 1;
            this.f24880c = i11;
            if (i11 == this.f24879b || this.f24884g[i11] != '\\') {
                return '?';
            }
            int i12 = i10 + 2;
            this.f24880c = i12;
            int iC2 = c(i12);
            this.f24880c++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i7 = (i7 << 6) + (iC2 & 63);
        }
        return (char) i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.f24882e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f24880c
            int r1 = r0 + 4
            int r2 = r6.f24879b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L98
            r6.f24881d = r0
            int r0 = r0 + 1
            r6.f24880c = r0
        L10:
            int r0 = r6.f24880c
            int r1 = r6.f24879b
            if (r0 == r1) goto L54
            char[] r1 = r6.f24884g
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
            r6.f24882e = r0
            int r0 = r0 + 1
            r6.f24880c = r0
        L31:
            int r0 = r6.f24880c
            int r1 = r6.f24879b
            if (r0 >= r1) goto L56
            char[] r1 = r6.f24884g
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.f24880c = r0
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
            r6.f24880c = r0
            goto L10
        L54:
            r6.f24882e = r0
        L56:
            int r0 = r6.f24882e
            int r1 = r6.f24881d
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
            char[] r2 = r6.f24884g
            int r3 = r6.f24881d
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f24878a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L98:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f24878a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.d.f():java.lang.String");
    }

    public final String g() {
        int i7;
        int i8;
        int i9;
        int i10;
        char c7;
        int i11;
        int i12;
        char c8;
        char c9;
        while (true) {
            i7 = this.f24880c;
            i8 = this.f24879b;
            if (i7 >= i8 || this.f24884g[i7] != ' ') {
                break;
            }
            this.f24880c = i7 + 1;
        }
        if (i7 == i8) {
            return null;
        }
        this.f24881d = i7;
        this.f24880c = i7 + 1;
        while (true) {
            i9 = this.f24880c;
            i10 = this.f24879b;
            if (i9 >= i10 || (c9 = this.f24884g[i9]) == '=' || c9 == ' ') {
                break;
            }
            this.f24880c = i9 + 1;
        }
        if (i9 >= i10) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f24878a);
        }
        this.f24882e = i9;
        if (this.f24884g[i9] == ' ') {
            while (true) {
                i11 = this.f24880c;
                i12 = this.f24879b;
                if (i11 >= i12 || (c8 = this.f24884g[i11]) == '=' || c8 != ' ') {
                    break;
                }
                this.f24880c = i11 + 1;
            }
            if (this.f24884g[i11] != '=' || i11 == i12) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f24878a);
            }
        }
        this.f24880c++;
        while (true) {
            int i13 = this.f24880c;
            if (i13 >= this.f24879b || this.f24884g[i13] != ' ') {
                break;
            }
            this.f24880c = i13 + 1;
        }
        int i14 = this.f24882e;
        int i15 = this.f24881d;
        if (i14 - i15 > 4) {
            char[] cArr = this.f24884g;
            if (cArr[i15 + 3] == '.' && (((c7 = cArr[i15]) == 'O' || c7 == 'o') && ((cArr[i15 + 1] == 'I' || cArr[i15 + 1] == 'i') && (cArr[i15 + 2] == 'D' || cArr[i15 + 2] == 'd')))) {
                this.f24881d = i15 + 4;
            }
        }
        char[] cArr2 = this.f24884g;
        int i16 = this.f24881d;
        return new String(cArr2, i16, i14 - i16);
    }

    public final String h() {
        int i7 = this.f24880c + 1;
        this.f24880c = i7;
        this.f24881d = i7;
        this.f24882e = i7;
        while (true) {
            int i8 = this.f24880c;
            if (i8 == this.f24879b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f24878a);
            }
            char[] cArr = this.f24884g;
            char c7 = cArr[i8];
            if (c7 == '\"') {
                this.f24880c = i8 + 1;
                while (true) {
                    int i9 = this.f24880c;
                    if (i9 >= this.f24879b || this.f24884g[i9] != ' ') {
                        break;
                    }
                    this.f24880c = i9 + 1;
                }
                char[] cArr2 = this.f24884g;
                int i10 = this.f24881d;
                return new String(cArr2, i10, this.f24882e - i10);
            }
            if (c7 == '\\') {
                cArr[this.f24882e] = d();
            } else {
                cArr[this.f24882e] = c7;
            }
            this.f24880c++;
            this.f24882e++;
        }
    }
}
