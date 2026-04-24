package v2;

import java.io.Serializable;
import v2.AbstractC2854t;

/* JADX INFO: renamed from: v2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2854t {

    /* JADX INFO: renamed from: v2.t$a */
    public static class a implements InterfaceC2853s, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2853s f23779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile transient boolean f23780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Object f23781c;

        public a(InterfaceC2853s interfaceC2853s) {
            this.f23779a = (InterfaceC2853s) AbstractC2848n.n(interfaceC2853s);
        }

        @Override // v2.InterfaceC2853s
        public Object get() {
            if (!this.f23780b) {
                synchronized (this) {
                    try {
                        if (!this.f23780b) {
                            Object obj = this.f23779a.get();
                            this.f23781c = obj;
                            this.f23780b = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC2843i.a(this.f23781c);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f23780b) {
                obj = "<supplier that returned " + this.f23781c + ">";
            } else {
                obj = this.f23779a;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: v2.t$b */
    public static class b implements InterfaceC2853s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final InterfaceC2853s f23782c = new InterfaceC2853s() { // from class: v2.u
            @Override // v2.InterfaceC2853s
            public final Object get() {
                return AbstractC2854t.b.b();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile InterfaceC2853s f23783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f23784b;

        public b(InterfaceC2853s interfaceC2853s) {
            this.f23783a = (InterfaceC2853s) AbstractC2848n.n(interfaceC2853s);
        }

        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // v2.InterfaceC2853s
        public Object get() {
            InterfaceC2853s interfaceC2853s = this.f23783a;
            InterfaceC2853s interfaceC2853s2 = f23782c;
            if (interfaceC2853s != interfaceC2853s2) {
                synchronized (this) {
                    try {
                        if (this.f23783a != interfaceC2853s2) {
                            Object obj = this.f23783a.get();
                            this.f23784b = obj;
                            this.f23783a = interfaceC2853s2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC2843i.a(this.f23784b);
        }

        public String toString() {
            Object obj = this.f23783a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f23782c) {
                obj = "<supplier that returned " + this.f23784b + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: v2.t$c */
    public static class c implements InterfaceC2853s, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f23785a;

        public c(Object obj) {
            this.f23785a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return AbstractC2844j.a(this.f23785a, ((c) obj).f23785a);
            }
            return false;
        }

        @Override // v2.InterfaceC2853s
        public Object get() {
            return this.f23785a;
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f23785a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f23785a + ")";
        }
    }

    public static InterfaceC2853s a(InterfaceC2853s interfaceC2853s) {
        return ((interfaceC2853s instanceof b) || (interfaceC2853s instanceof a)) ? interfaceC2853s : interfaceC2853s instanceof Serializable ? new a(interfaceC2853s) : new b(interfaceC2853s);
    }

    public static InterfaceC2853s b(Object obj) {
        return new c(obj);
    }
}
