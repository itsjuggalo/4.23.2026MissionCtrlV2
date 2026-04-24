package q7;

/* JADX INFO: renamed from: q7.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2644b {
    public static final byte a(char c8) {
        if (c8 < '~') {
            return C2655m.f22897c[c8];
        }
        return (byte) 0;
    }

    public static final char b(int i8) {
        if (i8 < 117) {
            return C2655m.f22896b[i8];
        }
        return (char) 0;
    }

    public static final String c(byte b8) {
        return b8 == 1 ? "quotation mark '\"'" : b8 == 2 ? "string escape sequence '\\'" : b8 == 4 ? "comma ','" : b8 == 5 ? "colon ':'" : b8 == 6 ? "start of the object '{'" : b8 == 7 ? "end of the object '}'" : b8 == 8 ? "start of the array '['" : b8 == 9 ? "end of the array ']'" : b8 == 10 ? "end of the input" : b8 == 127 ? "invalid token" : "valid token";
    }
}
