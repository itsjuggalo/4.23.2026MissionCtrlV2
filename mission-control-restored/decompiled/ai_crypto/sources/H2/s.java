package H2;

import H2.s;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    public static class a implements r, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f2619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile transient boolean f2620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Object f2621c;

        public a(r rVar) {
            this.f2619a = (r) m.n(rVar);
        }

        @Override // H2.r
        public Object get() {
            if (!this.f2620b) {
                synchronized (this) {
                    try {
                        if (!this.f2620b) {
                            Object obj = this.f2619a.get();
                            this.f2621c = obj;
                            this.f2620b = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return h.a(this.f2621c);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f2620b) {
                obj = "<supplier that returned " + this.f2621c + ">";
            } else {
                obj = this.f2619a;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b implements r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final r f2622c = new r() { // from class: H2.t
            @Override // H2.r
            public final Object get() {
                return s.b.b();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile r f2623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f2624b;

        public b(r rVar) {
            this.f2623a = (r) m.n(rVar);
        }

        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // H2.r
        public Object get() {
            r rVar = this.f2623a;
            r rVar2 = f2622c;
            if (rVar != rVar2) {
                synchronized (this) {
                    try {
                        if (this.f2623a != rVar2) {
                            Object obj = this.f2623a.get();
                            this.f2624b = obj;
                            this.f2623a = rVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return h.a(this.f2624b);
        }

        public String toString() {
            Object obj = this.f2623a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f2622c) {
                obj = "<supplier that returned " + this.f2624b + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class c implements r, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2625a;

        public c(Object obj) {
            this.f2625a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return i.a(this.f2625a, ((c) obj).f2625a);
            }
            return false;
        }

        @Override // H2.r
        public Object get() {
            return this.f2625a;
        }

        public int hashCode() {
            return i.b(this.f2625a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f2625a + ")";
        }
    }

    public static r a(r rVar) {
        return ((rVar instanceof b) || (rVar instanceof a)) ? rVar : rVar instanceof Serializable ? new a(rVar) : new b(rVar);
    }

    public static r b(Object obj) {
        return new c(obj);
    }
}
