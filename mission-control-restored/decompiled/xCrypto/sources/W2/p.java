package W2;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5487b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5488a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f5489a;

        public b(Throwable exception) {
            kotlin.jvm.internal.r.f(exception, "exception");
            this.f5489a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.r.b(this.f5489a, ((b) obj).f5489a);
        }

        public int hashCode() {
            return this.f5489a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f5489a + ')';
        }
    }

    public /* synthetic */ p(Object obj) {
        this.f5488a = obj;
    }

    public static final /* synthetic */ p a(Object obj) {
        return new p(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof p) && kotlin.jvm.internal.r.b(obj, ((p) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.r.b(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f5489a;
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
        return c(this.f5488a, obj);
    }

    public int hashCode() {
        return f(this.f5488a);
    }

    public final /* synthetic */ Object j() {
        return this.f5488a;
    }

    public String toString() {
        return i(this.f5488a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
