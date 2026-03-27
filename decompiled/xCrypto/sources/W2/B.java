package W2;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class B implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5458b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f5459a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ B(short s4) {
        this.f5459a = s4;
    }

    public static final /* synthetic */ B a(short s4) {
        return new B(s4);
    }

    public static boolean g(short s4, Object obj) {
        return (obj instanceof B) && s4 == ((B) obj).k();
    }

    public static int h(short s4) {
        return Short.hashCode(s4);
    }

    public static String i(short s4) {
        return String.valueOf(s4 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.r.g(k() & 65535, ((B) obj).k() & 65535);
    }

    public boolean equals(Object obj) {
        return g(this.f5459a, obj);
    }

    public int hashCode() {
        return h(this.f5459a);
    }

    public final /* synthetic */ short k() {
        return this.f5459a;
    }

    public String toString() {
        return i(this.f5459a);
    }

    public static short c(short s4) {
        return s4;
    }
}
