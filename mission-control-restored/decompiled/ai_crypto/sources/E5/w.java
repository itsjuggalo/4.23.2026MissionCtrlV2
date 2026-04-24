package E5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1697b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1698a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ w(int i7) {
        this.f1698a = i7;
    }

    public static final /* synthetic */ w a(int i7) {
        return new w(i7);
    }

    public static boolean c(int i7, Object obj) {
        return (obj instanceof w) && i7 == ((w) obj).j();
    }

    public static int h(int i7) {
        return Integer.hashCode(i7);
    }

    public static String i(int i7) {
        return String.valueOf(((long) i7) & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return G.a(j(), ((w) obj).j());
    }

    public boolean equals(Object obj) {
        return c(this.f1698a, obj);
    }

    public int hashCode() {
        return h(this.f1698a);
    }

    public final /* synthetic */ int j() {
        return this.f1698a;
    }

    public String toString() {
        return i(this.f1698a);
    }

    public static int b(int i7) {
        return i7;
    }
}
