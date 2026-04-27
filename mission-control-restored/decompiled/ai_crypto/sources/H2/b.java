package H2;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static abstract class a extends b {
    }

    /* JADX INFO: renamed from: H2.b$b, reason: collision with other inner class name */
    public static final class C0022b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f2586a;

        public C0022b(char c7) {
            this.f2586a = c7;
        }

        public String toString() {
            return "CharMatcher.is('" + b.d(this.f2586a) + "')";
        }
    }

    public static abstract class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2587a;

        public c(String str) {
            this.f2587a = (String) m.n(str);
        }

        public final String toString() {
            return this.f2587a;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f2588b = new d();

        public d() {
            super("CharMatcher.none()");
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f2589b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f2590c = new e();

        public e() {
            super("CharMatcher.whitespace()");
        }
    }

    public static b b(char c7) {
        return new C0022b(c7);
    }

    public static b c() {
        return d.f2588b;
    }

    public static String d(char c7) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            cArr[5 - i7] = "0123456789ABCDEF".charAt(c7 & 15);
            c7 = (char) (c7 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b e() {
        return e.f2590c;
    }
}
