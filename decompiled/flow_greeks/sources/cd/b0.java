package cd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3836b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3837a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ b0(long j10) {
        this.f3837a = j10;
    }

    public static final /* synthetic */ b0 a(long j10) {
        return new b0(j10);
    }

    public static boolean c(long j10, Object obj) {
        return (obj instanceof b0) && j10 == ((b0) obj).k();
    }

    public static int h(long j10) {
        return Long.hashCode(j10);
    }

    public static String i(long j10) {
        return j0.c(j10, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return j0.b(k(), ((b0) obj).k());
    }

    public boolean equals(Object obj) {
        return c(this.f3837a, obj);
    }

    public int hashCode() {
        return h(this.f3837a);
    }

    public final /* synthetic */ long k() {
        return this.f3837a;
    }

    public String toString() {
        return i(this.f3837a);
    }

    public static long b(long j10) {
        return j10;
    }
}
