package cd;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3889b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3890a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ z(int i10) {
        this.f3890a = i10;
    }

    public static final /* synthetic */ z a(int i10) {
        return new z(i10);
    }

    public static boolean c(int i10, Object obj) {
        return (obj instanceof z) && i10 == ((z) obj).k();
    }

    public static int h(int i10) {
        return Integer.hashCode(i10);
    }

    public static String i(int i10) {
        return String.valueOf(((long) i10) & KeyboardMap.kValueMask);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return j0.a(k(), ((z) obj).k());
    }

    public boolean equals(Object obj) {
        return c(this.f3890a, obj);
    }

    public int hashCode() {
        return h(this.f3890a);
    }

    public final /* synthetic */ int k() {
        return this.f3890a;
    }

    public String toString() {
        return i(this.f3890a);
    }

    public static int b(int i10) {
        return i10;
    }
}
