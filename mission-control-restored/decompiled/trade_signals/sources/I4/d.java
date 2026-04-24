package I4;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f4239g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f4233a = name;
        this.f4234b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        r2 = r8.f4236d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        return new java.lang.String(r1, r2, r8.f4237e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f4235c
            r8.f4236d = r0
            r8.f4237e = r0
        L6:
            int r0 = r8.f4235c
            int r1 = r8.f4234b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4239g
            int r2 = r8.f4236d
            int r3 = r8.f4237e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f4239g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L58
            if (r2 == r5) goto L4d
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L4d
            if (r2 == r3) goto L4d
            int r3 = r8.f4237e
            int r4 = r3 + 1
            r8.f4237e = r4
            r1[r3] = r2
        L39:
            int r0 = r0 + 1
            r8.f4235c = r0
            goto L6
        L3e:
            int r0 = r8.f4237e
            int r2 = r0 + 1
            r8.f4237e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f4235c
            goto L39
        L4d:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f4236d
            int r3 = r8.f4237e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L58:
            int r2 = r8.f4237e
            r8.f4238f = r2
            int r0 = r0 + 1
            r8.f4235c = r0
            int r0 = r2 + 1
            r8.f4237e = r0
            r1[r2] = r6
        L66:
            int r0 = r8.f4235c
            int r1 = r8.f4234b
            if (r0 >= r1) goto L7f
            char[] r2 = r8.f4239g
            char r7 = r2[r0]
            if (r7 != r6) goto L7f
            int r1 = r8.f4237e
            int r7 = r1 + 1
            r8.f4237e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f4235c = r0
            goto L66
        L7f:
            if (r0 == r1) goto L8b
            char[] r1 = r8.f4239g
            char r0 = r1[r0]
            if (r0 == r3) goto L8b
            if (r0 == r4) goto L8b
            if (r0 != r5) goto L6
        L8b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4239g
            int r2 = r8.f4236d
            int r3 = r8.f4238f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I4.d.a():java.lang.String");
    }

    public String b(String str) {
        this.f4235c = 0;
        this.f4236d = 0;
        this.f4237e = 0;
        this.f4238f = 0;
        this.f4239g = this.f4233a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i8 = this.f4235c;
            if (i8 == this.f4234b) {
                return null;
            }
            char c8 = this.f4239g[i8];
            String strA = c8 != '\"' ? c8 != '#' ? (c8 == '+' || c8 == ',' || c8 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(strG)) {
                return strA;
            }
            int i9 = this.f4235c;
            if (i9 >= this.f4234b) {
                return null;
            }
            char c9 = this.f4239g[i9];
            if (c9 != ',' && c9 != ';' && c9 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f4233a);
            }
            this.f4235c = i9 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f4233a);
    }

    public final int c(int i8) {
        int i9;
        int i10;
        int i11 = i8 + 1;
        if (i11 >= this.f4234b) {
            throw new IllegalStateException("Malformed DN: " + this.f4233a);
        }
        char[] cArr = this.f4239g;
        char c8 = cArr[i8];
        if (c8 >= '0' && c8 <= '9') {
            i9 = c8 - '0';
        } else if (c8 >= 'a' && c8 <= 'f') {
            i9 = c8 - 'W';
        } else {
            if (c8 < 'A' || c8 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f4233a);
            }
            i9 = c8 - '7';
        }
        char c9 = cArr[i11];
        if (c9 >= '0' && c9 <= '9') {
            i10 = c9 - '0';
        } else if (c9 >= 'a' && c9 <= 'f') {
            i10 = c9 - 'W';
        } else {
            if (c9 < 'A' || c9 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f4233a);
            }
            i10 = c9 - '7';
        }
        return (i9 << 4) + i10;
    }

    public final char d() {
        int i8 = this.f4235c + 1;
        this.f4235c = i8;
        if (i8 == this.f4234b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4233a);
        }
        char c8 = this.f4239g[i8];
        if (c8 == ' ' || c8 == '%' || c8 == '\\' || c8 == '_' || c8 == '\"' || c8 == '#') {
            return c8;
        }
        switch (c8) {
            case '*':
            case '+':
            case ',':
                return c8;
            default:
                switch (c8) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c8;
                    default:
                        return e();
                }
        }
    }

    public final char e() {
        int i8;
        int i9;
        int iC = c(this.f4235c);
        this.f4235c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i8 = iC & 31;
            i9 = 1;
        } else if (iC <= 239) {
            i8 = iC & 15;
            i9 = 2;
        } else {
            i8 = iC & 7;
            i9 = 3;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = this.f4235c;
            int i12 = i11 + 1;
            this.f4235c = i12;
            if (i12 == this.f4234b || this.f4239g[i12] != '\\') {
                return '?';
            }
            int i13 = i11 + 2;
            this.f4235c = i13;
            int iC2 = c(i13);
            this.f4235c++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i8 = (i8 << 6) + (iC2 & 63);
        }
        return (char) i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        r6.f4237e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f4235c
            int r1 = r0 + 4
            int r2 = r6.f4234b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L90
            r6.f4236d = r0
        Lc:
            int r0 = r0 + 1
            r6.f4235c = r0
            int r0 = r6.f4235c
            int r1 = r6.f4234b
            if (r0 == r1) goto L4c
            char[] r1 = r6.f4239g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L4c
            r4 = 44
            if (r2 == r4) goto L4c
            r4 = 59
            if (r2 != r4) goto L27
            goto L4c
        L27:
            r4 = 32
            if (r2 != r4) goto L3e
            r6.f4237e = r0
        L2d:
            int r0 = r0 + 1
            r6.f4235c = r0
            int r0 = r6.f4235c
            int r1 = r6.f4234b
            if (r0 >= r1) goto L4e
            char[] r1 = r6.f4239g
            char r1 = r1[r0]
            if (r1 != r4) goto L4e
            goto L2d
        L3e:
            r4 = 65
            if (r2 < r4) goto Lc
            r4 = 70
            if (r2 > r4) goto Lc
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
            goto Lc
        L4c:
            r6.f4237e = r0
        L4e:
            int r0 = r6.f4237e
            int r1 = r6.f4236d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L79
            r2 = r0 & 1
            if (r2 == 0) goto L79
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L61:
            if (r4 >= r2) goto L6f
            int r5 = r6.c(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L61
        L6f:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f4239g
            int r3 = r6.f4236d
            r1.<init>(r2, r3, r0)
            return r1
        L79:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f4233a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L90:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f4233a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I4.d.f():java.lang.String");
    }

    public final String g() {
        int i8;
        int i9;
        int i10;
        char c8;
        int i11;
        int i12;
        char c9;
        char c10;
        while (true) {
            i8 = this.f4235c;
            i9 = this.f4234b;
            if (i8 >= i9 || this.f4239g[i8] != ' ') {
                break;
            }
            this.f4235c = i8 + 1;
        }
        if (i8 == i9) {
            return null;
        }
        this.f4236d = i8;
        do {
            this.f4235c = i8 + 1;
            i8 = this.f4235c;
            i10 = this.f4234b;
            if (i8 >= i10 || (c10 = this.f4239g[i8]) == '=') {
                break;
            }
        } while (c10 != ' ');
        if (i8 >= i10) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4233a);
        }
        this.f4237e = i8;
        if (this.f4239g[i8] == ' ') {
            while (true) {
                i11 = this.f4235c;
                i12 = this.f4234b;
                if (i11 >= i12 || (c9 = this.f4239g[i11]) == '=' || c9 != ' ') {
                    break;
                }
                this.f4235c = i11 + 1;
            }
            if (this.f4239g[i11] != '=' || i11 == i12) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4233a);
            }
        }
        int i13 = this.f4235c;
        do {
            this.f4235c = i13 + 1;
            i13 = this.f4235c;
            if (i13 >= this.f4234b) {
                break;
            }
        } while (this.f4239g[i13] == ' ');
        int i14 = this.f4237e;
        int i15 = this.f4236d;
        if (i14 - i15 > 4) {
            char[] cArr = this.f4239g;
            if (cArr[i15 + 3] == '.' && (((c8 = cArr[i15]) == 'O' || c8 == 'o') && ((cArr[i15 + 1] == 'I' || cArr[i15 + 1] == 'i') && (cArr[i15 + 2] == 'D' || cArr[i15 + 2] == 'd')))) {
                this.f4236d = i15 + 4;
            }
        }
        char[] cArr2 = this.f4239g;
        int i16 = this.f4236d;
        return new String(cArr2, i16, i14 - i16);
    }

    public final String h() {
        int i8 = this.f4235c + 1;
        this.f4235c = i8;
        this.f4236d = i8;
        while (true) {
            this.f4237e = i8;
            int i9 = this.f4235c;
            if (i9 == this.f4234b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4233a);
            }
            char[] cArr = this.f4239g;
            char c8 = cArr[i9];
            if (c8 == '\"') {
                do {
                    this.f4235c = i9 + 1;
                    i9 = this.f4235c;
                    if (i9 >= this.f4234b) {
                        break;
                    }
                } while (this.f4239g[i9] == ' ');
                char[] cArr2 = this.f4239g;
                int i10 = this.f4236d;
                return new String(cArr2, i10, this.f4237e - i10);
            }
            if (c8 == '\\') {
                cArr[this.f4237e] = d();
            } else {
                cArr[this.f4237e] = c8;
            }
            this.f4235c++;
            i8 = this.f4237e + 1;
        }
    }
}
