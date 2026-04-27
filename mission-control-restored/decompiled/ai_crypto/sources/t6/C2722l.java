package t6;

/* JADX INFO: renamed from: t6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2722l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2722l f24330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f24331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f24332c;

    static {
        C2722l c2722l = new C2722l();
        f24330a = c2722l;
        f24331b = new char[117];
        f24332c = new byte[126];
        c2722l.f();
        c2722l.e();
    }

    public final void a(char c7, char c8) {
        b(c7, c8);
    }

    public final void b(int i7, char c7) {
        if (c7 != 'u') {
            f24331b[c7] = (char) i7;
        }
    }

    public final void c(char c7, byte b7) {
        d(c7, b7);
    }

    public final void d(int i7, byte b7) {
        f24332c[i7] = b7;
    }

    public final void e() {
        for (int i7 = 0; i7 < 33; i7++) {
            d(i7, (byte) 127);
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
        for (int i7 = 0; i7 < 32; i7++) {
            b(i7, 'u');
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
