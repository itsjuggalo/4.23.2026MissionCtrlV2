package p6;

import java.io.Serializable;
import p6.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements s, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f18339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile transient boolean f18340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Object f18341c;

        public a(s sVar) {
            this.f18339a = (s) n.n(sVar);
        }

        @Override // p6.s
        public Object get() {
            if (!this.f18340b) {
                synchronized (this) {
                    try {
                        if (!this.f18340b) {
                            Object obj = this.f18339a.get();
                            this.f18341c = obj;
                            this.f18340b = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return i.a(this.f18341c);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.f18340b) {
                obj = "<supplier that returned " + this.f18341c + ">";
            } else {
                obj = this.f18339a;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final s f18342c = new s() { // from class: p6.u
            @Override // p6.s
            public final Object get() {
                return t.b.a();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile s f18343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f18344b;

        public b(s sVar) {
            this.f18343a = (s) n.n(sVar);
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // p6.s
        public Object get() {
            s sVar = this.f18343a;
            s sVar2 = f18342c;
            if (sVar != sVar2) {
                synchronized (this) {
                    try {
                        if (this.f18343a != sVar2) {
                            Object obj = this.f18343a.get();
                            this.f18344b = obj;
                            this.f18343a = sVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return i.a(this.f18344b);
        }

        public String toString() {
            Object obj = this.f18343a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == f18342c) {
                obj = "<supplier that returned " + this.f18344b + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements s, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18345a;

        public c(Object obj) {
            this.f18345a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return j.a(this.f18345a, ((c) obj).f18345a);
            }
            return false;
        }

        @Override // p6.s
        public Object get() {
            return this.f18345a;
        }

        public int hashCode() {
            return j.b(this.f18345a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f18345a + ")";
        }
    }

    public static s a(s sVar) {
        return ((sVar instanceof b) || (sVar instanceof a)) ? sVar : sVar instanceof Serializable ? new a(sVar) : new b(sVar);
    }

    public static s b(Object obj) {
        return new c(obj);
    }
}
