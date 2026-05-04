package rb;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap f19461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19462c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f19463a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f19464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IdentityHashMap f19465b;

        public a a() {
            if (this.f19465b != null) {
                for (Map.Entry entry : this.f19464a.f19463a.entrySet()) {
                    if (!this.f19465b.containsKey(entry.getKey())) {
                        this.f19465b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f19464a = new a(this.f19465b);
                this.f19465b = null;
            }
            return this.f19464a;
        }

        public final IdentityHashMap b(int i10) {
            if (this.f19465b == null) {
                this.f19465b = new IdentityHashMap(i10);
            }
            return this.f19465b;
        }

        public b c(c cVar) {
            if (this.f19464a.f19463a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f19464a.f19463a);
                identityHashMap.remove(cVar);
                this.f19464a = new a(identityHashMap);
            }
            IdentityHashMap identityHashMap2 = this.f19465b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        public b d(c cVar, Object obj) {
            b(1).put(cVar, obj);
            return this;
        }

        public b(a aVar) {
            this.f19464a = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19466a;

        public c(String str) {
            this.f19466a = str;
        }

        public static c a(String str) {
            return new c(str);
        }

        public String toString() {
            return this.f19466a;
        }
    }

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f19461b = identityHashMap;
        f19462c = new a(identityHashMap);
    }

    public static b c() {
        return new b();
    }

    public Object b(c cVar) {
        return this.f19463a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f19463a.size() != aVar.f19463a.size()) {
            return false;
        }
        for (Map.Entry entry : this.f19463a.entrySet()) {
            if (!aVar.f19463a.containsKey(entry.getKey()) || !p6.j.a(entry.getValue(), aVar.f19463a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iB = 0;
        for (Map.Entry entry : this.f19463a.entrySet()) {
            iB += p6.j.b(entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public String toString() {
        return this.f19463a.toString();
    }

    public a(IdentityHashMap identityHashMap) {
        this.f19463a = identityHashMap;
    }
}
