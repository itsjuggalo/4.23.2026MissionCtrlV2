package cd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3884b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3885a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ x(byte b10) {
        this.f3885a = b10;
    }

    public static final /* synthetic */ x a(byte b10) {
        return new x(b10);
    }

    public static boolean c(byte b10, Object obj) {
        return (obj instanceof x) && b10 == ((x) obj).k();
    }

    public static int h(byte b10) {
        return Byte.hashCode(b10);
    }

    public static String i(byte b10) {
        return String.valueOf(b10 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.t.g(k() & 255, ((x) obj).k() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f3885a, obj);
    }

    public int hashCode() {
        return h(this.f3885a);
    }

    public final /* synthetic */ byte k() {
        return this.f3885a;
    }

    public String toString() {
        return i(this.f3885a);
    }

    public static byte b(byte b10) {
        return b10;
    }
}
