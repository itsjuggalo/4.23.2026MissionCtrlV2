package o5;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2467E implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21951b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f21952a;

    /* JADX INFO: renamed from: o5.E$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ C2467E(short s8) {
        this.f21952a = s8;
    }

    public static final /* synthetic */ C2467E a(short s8) {
        return new C2467E(s8);
    }

    public static boolean g(short s8, Object obj) {
        return (obj instanceof C2467E) && s8 == ((C2467E) obj).l();
    }

    public static int i(short s8) {
        return Short.hashCode(s8);
    }

    public static String k(short s8) {
        return String.valueOf(s8 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return AbstractC2304t.g(l() & 65535, ((C2467E) obj).l() & 65535);
    }

    public boolean equals(Object obj) {
        return g(this.f21952a, obj);
    }

    public int hashCode() {
        return i(this.f21952a);
    }

    public final /* synthetic */ short l() {
        return this.f21952a;
    }

    public String toString() {
        return k(this.f21952a);
    }

    public static short b(short s8) {
        return s8;
    }
}
