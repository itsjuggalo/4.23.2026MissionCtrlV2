package q7;

/* JADX INFO: renamed from: q7.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2655m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2655m f22895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f22896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f22897c;

    static {
        C2655m c2655m = new C2655m();
        f22895a = c2655m;
        f22896b = new char[117];
        f22897c = new byte[126];
        c2655m.f();
        c2655m.e();
    }

    public final void a(char c8, char c9) {
        b(c8, c9);
    }

    public final void b(int i8, char c8) {
        if (c8 != 'u') {
            f22896b[c8] = (char) i8;
        }
    }

    public final void c(char c8, byte b8) {
        d(c8, b8);
    }

    public final void d(int i8, byte b8) {
        f22897c[i8] = b8;
    }

    public final void e() {
        for (int i8 = 0; i8 < 33; i8++) {
            d(i8, (byte) 127);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    public final void f() {
        for (int i8 = 0; i8 < 32; i8++) {
            b(i8, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
