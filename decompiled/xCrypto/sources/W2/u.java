package W2;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5498b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f5499a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ u(byte b4) {
        this.f5499a = b4;
    }

    public static final /* synthetic */ u a(byte b4) {
        return new u(b4);
    }

    public static boolean g(byte b4, Object obj) {
        return (obj instanceof u) && b4 == ((u) obj).k();
    }

    public static int h(byte b4) {
        return Byte.hashCode(b4);
    }

    public static String i(byte b4) {
        return String.valueOf(b4 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.r.g(k() & 255, ((u) obj).k() & 255);
    }

    public boolean equals(Object obj) {
        return g(this.f5499a, obj);
    }

    public int hashCode() {
        return h(this.f5499a);
    }

    public final /* synthetic */ byte k() {
        return this.f5499a;
    }

    public String toString() {
        return i(this.f5499a);
    }

    public static byte c(byte b4) {
        return b4;
    }
}
