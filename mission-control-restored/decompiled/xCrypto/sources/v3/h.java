package v3;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f15364b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f15365c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f15366a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f15367a;

        public a(Throwable th) {
            this.f15367a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.r.b(this.f15367a, ((a) obj).f15367a);
        }

        public int hashCode() {
            Throwable th = this.f15367a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // v3.h.c
        public String toString() {
            return "Closed(" + this.f15367a + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        public final Object a(Throwable th) {
            return h.c(new a(th));
        }

        public final Object b() {
            return h.c(h.f15365c);
        }

        public final Object c(Object obj) {
            return h.c(obj);
        }

        public b() {
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ h(Object obj) {
        this.f15366a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && kotlin.jvm.internal.r.b(obj, ((h) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f15367a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f15366a, obj);
    }

    public int hashCode() {
        return g(this.f15366a);
    }

    public final /* synthetic */ Object k() {
        return this.f15366a;
    }

    public String toString() {
        return j(this.f15366a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
