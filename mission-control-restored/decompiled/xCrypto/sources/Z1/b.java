package Z1;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static abstract class a extends b {
    }

    /* JADX INFO: renamed from: Z1.b$b, reason: collision with other inner class name */
    public static final class C0082b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f5961a;

        public C0082b(char c4) {
            this.f5961a = c4;
        }

        public String toString() {
            return "CharMatcher.is('" + b.d(this.f5961a) + "')";
        }
    }

    public static abstract class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5962a;

        public c(String str) {
            this.f5962a = (String) m.n(str);
        }

        public final String toString() {
            return this.f5962a;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f5963b = new d();

        public d() {
            super("CharMatcher.none()");
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f5964b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f5965c = new e();

        public e() {
            super("CharMatcher.whitespace()");
        }
    }

    public static b b(char c4) {
        return new C0082b(c4);
    }

    public static b c() {
        return d.f5963b;
    }

    public static String d(char c4) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            cArr[5 - i4] = "0123456789ABCDEF".charAt(c4 & 15);
            c4 = (char) (c4 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b e() {
        return e.f5965c;
    }
}
