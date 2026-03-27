package Z1;

import Z1.s;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    public static class a implements r, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f5994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile transient boolean f5995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Object f5996c;

        public a(r rVar) {
            this.f5994a = (r) m.n(rVar);
        }

        @Override // Z1.r
        public Object get() {
            if (!this.f5995b) {
                synchronized (this) {
                    try {
                        if (!this.f5995b) {
                            Object obj = this.f5994a.get();
                            this.f5996c = obj;
                            this.f5995b = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return h.a(this.f5996c);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f5995b) {
                obj = "<supplier that returned " + this.f5996c + ">";
            } else {
                obj = this.f5994a;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b implements r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final r f5997c = new r() { // from class: Z1.t
            @Override // Z1.r
            public final Object get() {
                return s.b.a();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile r f5998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f5999b;

        public b(r rVar) {
            this.f5998a = (r) m.n(rVar);
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // Z1.r
        public Object get() {
            r rVar = this.f5998a;
            r rVar2 = f5997c;
            if (rVar != rVar2) {
                synchronized (this) {
                    try {
                        if (this.f5998a != rVar2) {
                            Object obj = this.f5998a.get();
                            this.f5999b = obj;
                            this.f5998a = rVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return h.a(this.f5999b);
        }

        public String toString() {
            Object obj = this.f5998a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f5997c) {
                obj = "<supplier that returned " + this.f5999b + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class c implements r, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6000a;

        public c(Object obj) {
            this.f6000a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return i.a(this.f6000a, ((c) obj).f6000a);
            }
            return false;
        }

        @Override // Z1.r
        public Object get() {
            return this.f6000a;
        }

        public int hashCode() {
            return i.b(this.f6000a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f6000a + ")";
        }
    }

    public static r a(r rVar) {
        return ((rVar instanceof b) || (rVar instanceof a)) ? rVar : rVar instanceof Serializable ? new a(rVar) : new b(rVar);
    }

    public static r b(Object obj) {
        return new c(obj);
    }
}
