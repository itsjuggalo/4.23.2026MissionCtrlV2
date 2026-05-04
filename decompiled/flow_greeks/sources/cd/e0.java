package cd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3846b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f3847a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ e0(short s10) {
        this.f3847a = s10;
    }

    public static final /* synthetic */ e0 a(short s10) {
        return new e0(s10);
    }

    public static boolean c(short s10, Object obj) {
        return (obj instanceof e0) && s10 == ((e0) obj).k();
    }

    public static int h(short s10) {
        return Short.hashCode(s10);
    }

    public static String i(short s10) {
        return String.valueOf(s10 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.t.g(k() & 65535, ((e0) obj).k() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f3847a, obj);
    }

    public int hashCode() {
        return h(this.f3847a);
    }

    public final /* synthetic */ short k() {
        return this.f3847a;
    }

    public String toString() {
        return i(this.f3847a);
    }

    public static short b(short s10) {
        return s10;
    }
}
