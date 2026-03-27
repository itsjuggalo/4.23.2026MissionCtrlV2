package v2;

/* JADX INFO: renamed from: v2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2837c {

    /* JADX INFO: renamed from: v2.c$a */
    public static abstract class a extends AbstractC2837c {
    }

    /* JADX INFO: renamed from: v2.c$b */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f23746a;

        public b(char c8) {
            this.f23746a = c8;
        }

        public String toString() {
            return "CharMatcher.is('" + AbstractC2837c.d(this.f23746a) + "')";
        }
    }

    /* JADX INFO: renamed from: v2.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0415c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23747a;

        public AbstractC0415c(String str) {
            this.f23747a = (String) AbstractC2848n.n(str);
        }

        public final String toString() {
            return this.f23747a;
        }
    }

    /* JADX INFO: renamed from: v2.c$d */
    public static final class d extends AbstractC0415c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f23748b = new d();

        public d() {
            super("CharMatcher.none()");
        }
    }

    /* JADX INFO: renamed from: v2.c$e */
    public static final class e extends AbstractC0415c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f23749b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f23750c = new e();

        public e() {
            super("CharMatcher.whitespace()");
        }
    }

    public static AbstractC2837c b(char c8) {
        return new b(c8);
    }

    public static AbstractC2837c c() {
        return d.f23748b;
    }

    public static String d(char c8) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            cArr[5 - i8] = "0123456789ABCDEF".charAt(c8 & 15);
            c8 = (char) (c8 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static AbstractC2837c e() {
        return e.f23750c;
    }
}
