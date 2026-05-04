package p6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends c {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f18306a;

        public b(char c10) {
            this.f18306a = c10;
        }

        public String toString() {
            return "CharMatcher.is('" + c.d(this.f18306a) + "')";
        }
    }

    /* JADX INFO: renamed from: p6.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0310c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18307a;

        public AbstractC0310c(String str) {
            this.f18307a = (String) n.n(str);
        }

        public final String toString() {
            return this.f18307a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends AbstractC0310c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f18308b = new d();

        public d() {
            super("CharMatcher.none()");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends AbstractC0310c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f18309b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f18310c = new e();

        public e() {
            super("CharMatcher.whitespace()");
        }
    }

    public static c b(char c10) {
        return new b(c10);
    }

    public static c c() {
        return d.f18308b;
    }

    public static String d(char c10) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static c e() {
        return e.f18310c;
    }
}
