package o5;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2490r implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21981b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21982a;

    /* JADX INFO: renamed from: o5.r$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: o5.r$b */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f21983a;

        public b(Throwable exception) {
            AbstractC2304t.f(exception, "exception");
            this.f21983a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && AbstractC2304t.b(this.f21983a, ((b) obj).f21983a);
        }

        public int hashCode() {
            return this.f21983a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f21983a + ')';
        }
    }

    public /* synthetic */ C2490r(Object obj) {
        this.f21982a = obj;
    }

    public static final /* synthetic */ C2490r a(Object obj) {
        return new C2490r(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof C2490r) && AbstractC2304t.b(obj, ((C2490r) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return AbstractC2304t.b(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f21983a;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof b;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof b);
    }

    public static String i(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f21982a, obj);
    }

    public int hashCode() {
        return f(this.f21982a);
    }

    public final /* synthetic */ Object j() {
        return this.f21982a;
    }

    public String toString() {
        return i(this.f21982a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
