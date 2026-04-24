package E5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class B implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1652b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f1653a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ B(short s7) {
        this.f1653a = s7;
    }

    public static final /* synthetic */ B a(short s7) {
        return new B(s7);
    }

    public static boolean c(short s7, Object obj) {
        return (obj instanceof B) && s7 == ((B) obj).j();
    }

    public static int h(short s7) {
        return Short.hashCode(s7);
    }

    public static String i(short s7) {
        return String.valueOf(s7 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.r.g(j() & 65535, ((B) obj).j() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f1653a, obj);
    }

    public int hashCode() {
        return h(this.f1653a);
    }

    public final /* synthetic */ short j() {
        return this.f1653a;
    }

    public String toString() {
        return i(this.f1653a);
    }

    public static short b(short s7) {
        return s7;
    }
}
