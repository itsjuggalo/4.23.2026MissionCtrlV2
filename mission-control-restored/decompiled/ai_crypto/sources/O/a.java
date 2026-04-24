package O;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f3968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f3970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f3972h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f3975c;

    /* JADX INFO: renamed from: O.a$a, reason: collision with other inner class name */
    public static final class C0060a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f3978c;

        public C0060a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z7) {
            return z7 ? a.f3972h : a.f3971g;
        }

        public a a() {
            return (this.f3977b == 2 && this.f3978c == a.f3968d) ? b(this.f3976a) : new a(this.f3976a, this.f3977b, this.f3978c);
        }

        public final void c(boolean z7) {
            this.f3976a = z7;
            this.f3978c = a.f3968d;
            this.f3977b = 2;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f3979f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f3980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public char f3984e;

        static {
            for (int i7 = 0; i7 < 1792; i7++) {
                f3979f[i7] = Character.getDirectionality(i7);
            }
        }

        public b(CharSequence charSequence, boolean z7) {
            this.f3980a = charSequence;
            this.f3981b = z7;
            this.f3982c = charSequence.length();
        }

        public static byte c(char c7) {
            return c7 < 1792 ? f3979f[c7] : Character.getDirectionality(c7);
        }

        public byte a() {
            char cCharAt = this.f3980a.charAt(this.f3983d - 1);
            this.f3984e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f3980a, this.f3983d);
                this.f3983d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f3983d--;
            byte bC = c(this.f3984e);
            if (!this.f3981b) {
                return bC;
            }
            char c7 = this.f3984e;
            return c7 == '>' ? h() : c7 == ';' ? f() : bC;
        }

        public byte b() {
            char cCharAt = this.f3980a.charAt(this.f3983d);
            this.f3984e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f3980a, this.f3983d);
                this.f3983d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f3983d++;
            byte bC = c(this.f3984e);
            if (!this.f3981b) {
                return bC;
            }
            char c7 = this.f3984e;
            return c7 == '<' ? i() : c7 == '&' ? g() : bC;
        }

        public int d() {
            this.f3983d = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (this.f3983d < this.f3982c && i7 == 0) {
                byte b7 = b();
                if (b7 != 0) {
                    if (b7 == 1 || b7 == 2) {
                        if (i9 == 0) {
                            return 1;
                        }
                    } else if (b7 != 9) {
                        switch (b7) {
                            case 14:
                            case 15:
                                i9++;
                                i8 = -1;
                                continue;
                            case com.amazon.c.a.a.c.f10119g /* 16 */:
                            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                i9++;
                                i8 = 1;
                                continue;
                            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                i9--;
                                i8 = 0;
                                continue;
                        }
                    }
                } else if (i9 == 0) {
                    return -1;
                }
                i7 = i9;
            }
            if (i7 == 0) {
                return 0;
            }
            if (i8 != 0) {
                return i8;
            }
            while (this.f3983d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i7 == i9) {
                            return -1;
                        }
                        break;
                    case com.amazon.c.a.a.c.f10119g /* 16 */:
                    case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        if (i7 == i9) {
                            return 1;
                        }
                        break;
                    case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        i9++;
                        continue;
                }
                i9--;
            }
            return 0;
        }

        public int e() {
            this.f3983d = this.f3982c;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                while (this.f3983d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i7 == 0) {
                            return -1;
                        }
                        if (i8 == 0) {
                            break;
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i7 == 0) {
                            return 1;
                        }
                        if (i8 == 0) {
                            break;
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i8 == i7) {
                                    return -1;
                                }
                                i7--;
                                break;
                            case com.amazon.c.a.a.c.f10119g /* 16 */:
                            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                if (i8 == i7) {
                                    return 1;
                                }
                                i7--;
                                break;
                            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                i7++;
                                break;
                            default:
                                if (i8 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char cCharAt;
            int i7 = this.f3983d;
            do {
                int i8 = this.f3983d;
                if (i8 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f3980a;
                int i9 = i8 - 1;
                this.f3983d = i9;
                cCharAt = charSequence.charAt(i9);
                this.f3984e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f3983d = i7;
            this.f3984e = ';';
            return (byte) 13;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i7 = this.f3983d;
                if (i7 >= this.f3982c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f3980a;
                this.f3983d = i7 + 1;
                cCharAt = charSequence.charAt(i7);
                this.f3984e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char cCharAt;
            int i7 = this.f3983d;
            while (true) {
                int i8 = this.f3983d;
                if (i8 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f3980a;
                int i9 = i8 - 1;
                this.f3983d = i9;
                char cCharAt2 = charSequence.charAt(i9);
                this.f3984e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i10 = this.f3983d;
                        if (i10 > 0) {
                            CharSequence charSequence2 = this.f3980a;
                            int i11 = i10 - 1;
                            this.f3983d = i11;
                            cCharAt = charSequence2.charAt(i11);
                            this.f3984e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f3983d = i7;
            this.f3984e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char cCharAt;
            int i7 = this.f3983d;
            while (true) {
                int i8 = this.f3983d;
                if (i8 >= this.f3982c) {
                    this.f3983d = i7;
                    this.f3984e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f3980a;
                this.f3983d = i8 + 1;
                char cCharAt2 = charSequence.charAt(i8);
                this.f3984e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i9 = this.f3983d;
                        if (i9 < this.f3982c) {
                            CharSequence charSequence2 = this.f3980a;
                            this.f3983d = i9 + 1;
                            cCharAt = charSequence2.charAt(i9);
                            this.f3984e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        n nVar = o.f3996c;
        f3968d = nVar;
        f3969e = Character.toString((char) 8206);
        f3970f = Character.toString((char) 8207);
        f3971g = new a(false, 2, nVar);
        f3972h = new a(true, 2, nVar);
    }

    public a(boolean z7, int i7, n nVar) {
        this.f3973a = z7;
        this.f3974b = i7;
        this.f3975c = nVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0060a().a();
    }

    public static boolean e(Locale locale) {
        return p.a(locale) == 1;
    }

    public boolean d() {
        return (this.f3974b & 2) != 0;
    }

    public final String f(CharSequence charSequence, n nVar) {
        boolean zA = nVar.a(charSequence, 0, charSequence.length());
        return (this.f3973a || !(zA || b(charSequence) == 1)) ? this.f3973a ? (!zA || b(charSequence) == -1) ? f3970f : "" : "" : f3969e;
    }

    public final String g(CharSequence charSequence, n nVar) {
        boolean zA = nVar.a(charSequence, 0, charSequence.length());
        return (this.f3973a || !(zA || a(charSequence) == 1)) ? this.f3973a ? (!zA || a(charSequence) == -1) ? f3970f : "" : "" : f3969e;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f3975c, true);
    }

    public CharSequence i(CharSequence charSequence, n nVar, boolean z7) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = nVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z7) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? o.f3995b : o.f3994a));
        }
        if (zA != this.f3973a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z7) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? o.f3995b : o.f3994a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f3975c, true);
    }

    public String k(String str, n nVar, boolean z7) {
        if (str == null) {
            return null;
        }
        return i(str, nVar, z7).toString();
    }
}
