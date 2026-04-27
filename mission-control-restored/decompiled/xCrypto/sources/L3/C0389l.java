package L3;

/* JADX INFO: renamed from: L3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0389l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0389l f1537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f1538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f1539c;

    static {
        C0389l c0389l = new C0389l();
        f1537a = c0389l;
        f1538b = new char[117];
        f1539c = new byte[126];
        c0389l.f();
        c0389l.e();
    }

    public final void a(char c4, char c5) {
        b(c4, c5);
    }

    public final void b(int i4, char c4) {
        if (c4 != 'u') {
            f1538b[c4] = (char) i4;
        }
    }

    public final void c(char c4, byte b4) {
        d(c4, b4);
    }

    public final void d(int i4, byte b4) {
        f1539c[i4] = b4;
    }

    public final void e() {
        for (int i4 = 0; i4 < 33; i4++) {
            d(i4, (byte) 127);
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
        for (int i4 = 0; i4 < 32; i4++) {
            b(i4, 'u');
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
