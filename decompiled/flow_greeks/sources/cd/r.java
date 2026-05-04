package cd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3870b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3871a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f3872a;

        public b(Throwable exception) {
            kotlin.jvm.internal.t.f(exception, "exception");
            this.f3872a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.t.b(this.f3872a, ((b) obj).f3872a);
        }

        public int hashCode() {
            return this.f3872a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f3872a + ')';
        }
    }

    public /* synthetic */ r(Object obj) {
        this.f3871a = obj;
    }

    public static final /* synthetic */ r a(Object obj) {
        return new r(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof r) && kotlin.jvm.internal.t.b(obj, ((r) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.t.b(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f3872a;
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
        return c(this.f3871a, obj);
    }

    public int hashCode() {
        return f(this.f3871a);
    }

    public final /* synthetic */ Object j() {
        return this.f3871a;
    }

    public String toString() {
        return i(this.f3871a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
