package d6;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13491a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f13492b = new c();

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f13493a;

        public a(Throwable th) {
            this.f13493a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.r.b(this.f13493a, ((a) obj).f13493a);
        }

        public int hashCode() {
            Throwable th = this.f13493a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // d6.h.c
        public String toString() {
            return "Closed(" + this.f13493a + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public final Object a(Throwable th) {
            return h.b(new a(th));
        }

        public final Object b() {
            return h.b(h.f13492b);
        }

        public final Object c(Object obj) {
            return h.b(obj);
        }

        public b() {
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static final Throwable c(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f13493a;
        }
        return null;
    }

    public static final Object d(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static final boolean e(Object obj) {
        return obj instanceof a;
    }

    public static final boolean f(Object obj) {
        return !(obj instanceof c);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
