package y4;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: renamed from: y4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1433c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11687d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f11689g;

    public C1433c(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f11684a = name;
        this.f11685b = name.length();
    }

    public final int a(int i) {
        int i6;
        int i7;
        int i8 = i + 1;
        int i9 = this.f11685b;
        String str = this.f11684a;
        if (i8 >= i9) {
            throw new IllegalStateException("Malformed DN: " + str);
        }
        char[] cArr = this.f11689g;
        char c6 = cArr[i];
        if (c6 >= '0' && c6 <= '9') {
            i6 = c6 - '0';
        } else if (c6 >= 'a' && c6 <= 'f') {
            i6 = c6 - 'W';
        } else {
            if (c6 < 'A' || c6 > 'F') {
                throw new IllegalStateException("Malformed DN: " + str);
            }
            i6 = c6 - '7';
        }
        char c7 = cArr[i8];
        if (c7 >= '0' && c7 <= '9') {
            i7 = c7 - '0';
        } else if (c7 >= 'a' && c7 <= 'f') {
            i7 = c7 - 'W';
        } else {
            if (c7 < 'A' || c7 > 'F') {
                throw new IllegalStateException("Malformed DN: " + str);
            }
            i7 = c7 - '7';
        }
        return (i6 << 4) + i7;
    }

    public final char b() {
        int i;
        int i6;
        int i7 = this.f11686c + 1;
        this.f11686c = i7;
        int i8 = this.f11685b;
        if (i7 == i8) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f11684a);
        }
        char c6 = this.f11689g[i7];
        if (c6 != ' ' && c6 != '%' && c6 != '\\' && c6 != '_' && c6 != '\"' && c6 != '#') {
            switch (c6) {
                default:
                    switch (c6) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            int iA = a(i7);
                            this.f11686c++;
                            if (iA < 128) {
                                return (char) iA;
                            }
                            if (iA < 192 || iA > 247) {
                                return '?';
                            }
                            if (iA <= 223) {
                                i = iA & 31;
                                i6 = 1;
                            } else if (iA <= 239) {
                                i = iA & 15;
                                i6 = 2;
                            } else {
                                i = iA & 7;
                                i6 = 3;
                            }
                            for (int i9 = 0; i9 < i6; i9++) {
                                int i10 = this.f11686c;
                                int i11 = i10 + 1;
                                this.f11686c = i11;
                                if (i11 == i8 || this.f11689g[i11] != '\\') {
                                    return '?';
                                }
                                int i12 = i10 + 2;
                                this.f11686c = i12;
                                int iA2 = a(i12);
                                this.f11686c++;
                                if ((iA2 & 192) != 128) {
                                    return '?';
                                }
                                i = (i << 6) + (iA2 & 63);
                            }
                            return (char) i;
                    }
                case '*':
                case '+':
                case ',':
                    return c6;
            }
        }
        return c6;
    }

    public final String c() {
        int i;
        int i6;
        int i7;
        char c6;
        int i8;
        char c7;
        char c8;
        while (true) {
            i = this.f11686c;
            i6 = this.f11685b;
            if (i >= i6 || this.f11689g[i] != ' ') {
                break;
            }
            this.f11686c = i + 1;
        }
        if (i == i6) {
            return null;
        }
        this.f11687d = i;
        this.f11686c = i + 1;
        while (true) {
            i7 = this.f11686c;
            if (i7 >= i6 || (c8 = this.f11689g[i7]) == '=' || c8 == ' ') {
                break;
            }
            this.f11686c = i7 + 1;
        }
        String str = this.f11684a;
        if (i7 >= i6) {
            throw new IllegalStateException("Unexpected end of DN: " + str);
        }
        this.e = i7;
        if (this.f11689g[i7] == ' ') {
            while (true) {
                i8 = this.f11686c;
                if (i8 >= i6 || (c7 = this.f11689g[i8]) == '=' || c7 != ' ') {
                    break;
                }
                this.f11686c = i8 + 1;
            }
            if (this.f11689g[i8] != '=' || i8 == i6) {
                throw new IllegalStateException("Unexpected end of DN: " + str);
            }
        }
        this.f11686c++;
        while (true) {
            int i9 = this.f11686c;
            if (i9 >= i6 || this.f11689g[i9] != ' ') {
                break;
            }
            this.f11686c = i9 + 1;
        }
        int i10 = this.e;
        int i11 = this.f11687d;
        if (i10 - i11 > 4) {
            char[] cArr = this.f11689g;
            if (cArr[i11 + 3] == '.' && (((c6 = cArr[i11]) == 'O' || c6 == 'o') && ((cArr[i11 + 1] == 'I' || cArr[i11 + 1] == 'i') && (cArr[i11 + 2] == 'D' || cArr[i11 + 2] == 'd')))) {
                this.f11687d = i11 + 4;
            }
        }
        char[] cArr2 = this.f11689g;
        int i12 = this.f11687d;
        return new String(cArr2, i12, i10 - i12);
    }
}
