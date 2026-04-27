package a7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f10222b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f10223c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10224a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f10225a;

        public a(Throwable th) {
            this.f10225a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC2304t.b(this.f10225a, ((a) obj).f10225a);
        }

        public int hashCode() {
            Throwable th = this.f10225a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // a7.k.c
        public String toString() {
            return "Closed(" + this.f10225a + ')';
        }
    }

    public static final class b {
        public b() {
        }

        public final Object a(Throwable th) {
            return k.c(new a(th));
        }

        public final Object b() {
            return k.c(k.f10223c);
        }

        public final Object c(Object obj) {
            return k.c(obj);
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ k(Object obj) {
        this.f10224a = obj;
    }

    public static final /* synthetic */ k b(Object obj) {
        return new k(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof k) && AbstractC2304t.b(obj, ((k) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f10225a;
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
        return d(this.f10224a, obj);
    }

    public int hashCode() {
        return g(this.f10224a);
    }

    public final /* synthetic */ Object k() {
        return this.f10224a;
    }

    public String toString() {
        return j(this.f10224a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
