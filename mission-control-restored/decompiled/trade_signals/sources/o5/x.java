package o5;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21995b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f21996a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ x(byte b8) {
        this.f21996a = b8;
    }

    public static final /* synthetic */ x a(byte b8) {
        return new x(b8);
    }

    public static boolean g(byte b8, Object obj) {
        return (obj instanceof x) && b8 == ((x) obj).l();
    }

    public static int i(byte b8) {
        return Byte.hashCode(b8);
    }

    public static String k(byte b8) {
        return String.valueOf(b8 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return AbstractC2304t.g(l() & 255, ((x) obj).l() & 255);
    }

    public boolean equals(Object obj) {
        return g(this.f21996a, obj);
    }

    public int hashCode() {
        return i(this.f21996a);
    }

    public final /* synthetic */ byte l() {
        return this.f21996a;
    }

    public String toString() {
        return k(this.f21996a);
    }

    public static byte b(byte b8) {
        return b8;
    }
}
