package E5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1692b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f1693a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ u(byte b7) {
        this.f1693a = b7;
    }

    public static final /* synthetic */ u a(byte b7) {
        return new u(b7);
    }

    public static boolean c(byte b7, Object obj) {
        return (obj instanceof u) && b7 == ((u) obj).j();
    }

    public static int h(byte b7) {
        return Byte.hashCode(b7);
    }

    public static String i(byte b7) {
        return String.valueOf(b7 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.r.g(j() & 255, ((u) obj).j() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f1693a, obj);
    }

    public int hashCode() {
        return h(this.f1693a);
    }

    public final /* synthetic */ byte j() {
        return this.f1693a;
    }

    public String toString() {
        return i(this.f1693a);
    }

    public static byte b(byte b7) {
        return b7;
    }
}
