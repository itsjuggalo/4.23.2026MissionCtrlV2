package O2;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f3253g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f3247a = name;
        this.f3248b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.f3250d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.f3251e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f3249c
            r8.f3250d = r0
            r8.f3251e = r0
        L6:
            int r0 = r8.f3249c
            int r1 = r8.f3248b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f3253g
            int r2 = r8.f3250d
            int r3 = r8.f3251e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f3253g
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
            int r3 = r8.f3251e
            int r4 = r3 + 1
            r8.f3251e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f3249c = r0
            goto L6
        L3e:
            int r0 = r8.f3251e
            int r2 = r0 + 1
            r8.f3251e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f3249c
            int r0 = r0 + 1
            r8.f3249c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f3250d
            int r3 = r8.f3251e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f3251e
            r8.f3252f = r2
            int r0 = r0 + 1
            r8.f3249c = r0
            int r0 = r2 + 1
            r8.f3251e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f3249c
            int r1 = r8.f3248b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f3253g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f3251e
            int r7 = r1 + 1
            r8.f3251e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f3249c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f3253g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f3253g
            int r2 = r8.f3250d
            int r3 = r8.f3252f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.d.a():java.lang.String");
    }

    public String b(String str) {
        this.f3249c = 0;
        this.f3250d = 0;
        this.f3251e = 0;
        this.f3252f = 0;
        this.f3253g = this.f3247a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i4 = this.f3249c;
            if (i4 == this.f3248b) {
                return null;
            }
            char c4 = this.f3253g[i4];
            String strA = c4 != '\"' ? c4 != '#' ? (c4 == '+' || c4 == ',' || c4 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(strG)) {
                return strA;
            }
            int i5 = this.f3249c;
            if (i5 >= this.f3248b) {
                return null;
            }
            char c5 = this.f3253g[i5];
            if (c5 != ',' && c5 != ';' && c5 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f3247a);
            }
            this.f3249c = i5 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f3247a);
    }

    public final int c(int i4) {
        int i5;
        int i6;
        int i7 = i4 + 1;
        if (i7 >= this.f3248b) {
            throw new IllegalStateException("Malformed DN: " + this.f3247a);
        }
        char[] cArr = this.f3253g;
        char c4 = cArr[i4];
        if (c4 >= '0' && c4 <= '9') {
            i5 = c4 - '0';
        } else if (c4 >= 'a' && c4 <= 'f') {
            i5 = c4 - 'W';
        } else {
            if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f3247a);
            }
            i5 = c4 - '7';
        }
        char c5 = cArr[i7];
        if (c5 >= '0' && c5 <= '9') {
            i6 = c5 - '0';
        } else if (c5 >= 'a' && c5 <= 'f') {
            i6 = c5 - 'W';
        } else {
            if (c5 < 'A' || c5 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f3247a);
            }
            i6 = c5 - '7';
        }
        return (i5 << 4) + i6;
    }

    public final char d() {
        int i4 = this.f3249c + 1;
        this.f3249c = i4;
        if (i4 == this.f3248b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f3247a);
        }
        char c4 = this.f3253g[i4];
        if (c4 == ' ' || c4 == '%' || c4 == '\\' || c4 == '_' || c4 == '\"' || c4 == '#') {
            return c4;
        }
        switch (c4) {
            case '*':
            case '+':
            case ',':
                return c4;
            default:
                switch (c4) {
                    case ';':
                    case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE_SEGMENT /* 60 */:
                    case '=':
                    case '>':
                        return c4;
                    default:
                        return e();
                }
        }
    }

    public final char e() {
        int i4;
        int i5;
        int iC = c(this.f3249c);
        this.f3249c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i4 = iC & 31;
            i5 = 1;
        } else if (iC <= 239) {
            i4 = iC & 15;
            i5 = 2;
        } else {
            i4 = iC & 7;
            i5 = 3;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = this.f3249c;
            int i8 = i7 + 1;
            this.f3249c = i8;
            if (i8 == this.f3248b || this.f3253g[i8] != '\\') {
                return '?';
            }
            int i9 = i7 + 2;
            this.f3249c = i9;
            int iC2 = c(i9);
            this.f3249c++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i4 = (i4 << 6) + (iC2 & 63);
        }
        return (char) i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.f3251e = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f3249c
            int r1 = r0 + 4
            int r2 = r6.f3248b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L98
            r6.f3250d = r0
            int r0 = r0 + 1
            r6.f3249c = r0
        L10:
            int r0 = r6.f3249c
            int r1 = r6.f3248b
            if (r0 == r1) goto L54
            char[] r1 = r6.f3253g
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
            r6.f3251e = r0
            int r0 = r0 + 1
            r6.f3249c = r0
        L31:
            int r0 = r6.f3249c
            int r1 = r6.f3248b
            if (r0 >= r1) goto L56
            char[] r1 = r6.f3253g
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.f3249c = r0
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
            r6.f3249c = r0
            goto L10
        L54:
            r6.f3251e = r0
        L56:
            int r0 = r6.f3251e
            int r1 = r6.f3250d
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
            char[] r2 = r6.f3253g
            int r3 = r6.f3250d
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f3247a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L98:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f3247a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.d.f():java.lang.String");
    }

    public final String g() {
        int i4;
        int i5;
        int i6;
        int i7;
        char c4;
        int i8;
        int i9;
        char c5;
        char c6;
        while (true) {
            i4 = this.f3249c;
            i5 = this.f3248b;
            if (i4 >= i5 || this.f3253g[i4] != ' ') {
                break;
            }
            this.f3249c = i4 + 1;
        }
        if (i4 == i5) {
            return null;
        }
        this.f3250d = i4;
        this.f3249c = i4 + 1;
        while (true) {
            i6 = this.f3249c;
            i7 = this.f3248b;
            if (i6 >= i7 || (c6 = this.f3253g[i6]) == '=' || c6 == ' ') {
                break;
            }
            this.f3249c = i6 + 1;
        }
        if (i6 >= i7) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f3247a);
        }
        this.f3251e = i6;
        if (this.f3253g[i6] == ' ') {
            while (true) {
                i8 = this.f3249c;
                i9 = this.f3248b;
                if (i8 >= i9 || (c5 = this.f3253g[i8]) == '=' || c5 != ' ') {
                    break;
                }
                this.f3249c = i8 + 1;
            }
            if (this.f3253g[i8] != '=' || i8 == i9) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f3247a);
            }
        }
        this.f3249c++;
        while (true) {
            int i10 = this.f3249c;
            if (i10 >= this.f3248b || this.f3253g[i10] != ' ') {
                break;
            }
            this.f3249c = i10 + 1;
        }
        int i11 = this.f3251e;
        int i12 = this.f3250d;
        if (i11 - i12 > 4) {
            char[] cArr = this.f3253g;
            if (cArr[i12 + 3] == '.' && (((c4 = cArr[i12]) == 'O' || c4 == 'o') && ((cArr[i12 + 1] == 'I' || cArr[i12 + 1] == 'i') && (cArr[i12 + 2] == 'D' || cArr[i12 + 2] == 'd')))) {
                this.f3250d = i12 + 4;
            }
        }
        char[] cArr2 = this.f3253g;
        int i13 = this.f3250d;
        return new String(cArr2, i13, i11 - i13);
    }

    public final String h() {
        int i4 = this.f3249c + 1;
        this.f3249c = i4;
        this.f3250d = i4;
        this.f3251e = i4;
        while (true) {
            int i5 = this.f3249c;
            if (i5 == this.f3248b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f3247a);
            }
            char[] cArr = this.f3253g;
            char c4 = cArr[i5];
            if (c4 == '\"') {
                this.f3249c = i5 + 1;
                while (true) {
                    int i6 = this.f3249c;
                    if (i6 >= this.f3248b || this.f3253g[i6] != ' ') {
                        break;
                    }
                    this.f3249c = i6 + 1;
                }
                char[] cArr2 = this.f3253g;
                int i7 = this.f3250d;
                return new String(cArr2, i7, this.f3251e - i7);
            }
            if (c4 == '\\') {
                cArr[this.f3251e] = d();
            } else {
                cArr[this.f3251e] = c4;
            }
            this.f3249c++;
            this.f3251e++;
        }
    }
}
