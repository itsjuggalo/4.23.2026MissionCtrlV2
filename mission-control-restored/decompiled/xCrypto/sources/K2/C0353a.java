package K2;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: renamed from: K2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0353a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap f1110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0353a f1111c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f1112a;

    /* JADX INFO: renamed from: K2.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0353a f1113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IdentityHashMap f1114b;

        public C0353a a() {
            if (this.f1114b != null) {
                for (Map.Entry entry : this.f1113a.f1112a.entrySet()) {
                    if (!this.f1114b.containsKey(entry.getKey())) {
                        this.f1114b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f1113a = new C0353a(this.f1114b);
                this.f1114b = null;
            }
            return this.f1113a;
        }

        public final IdentityHashMap b(int i4) {
            if (this.f1114b == null) {
                this.f1114b = new IdentityHashMap(i4);
            }
            return this.f1114b;
        }

        public b c(c cVar) {
            if (this.f1113a.f1112a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f1113a.f1112a);
                identityHashMap.remove(cVar);
                this.f1113a = new C0353a(identityHashMap);
            }
            IdentityHashMap identityHashMap2 = this.f1114b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        public b d(c cVar, Object obj) {
            b(1).put(cVar, obj);
            return this;
        }

        public b(C0353a c0353a) {
            this.f1113a = c0353a;
        }
    }

    /* JADX INFO: renamed from: K2.a$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1115a;

        public c(String str) {
            this.f1115a = str;
        }

        public static c a(String str) {
            return new c(str);
        }

        public String toString() {
            return this.f1115a;
        }
    }

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f1110b = identityHashMap;
        f1111c = new C0353a(identityHashMap);
    }

    public static b c() {
        return new b();
    }

    public Object b(c cVar) {
        return this.f1112a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0353a.class != obj.getClass()) {
            return false;
        }
        C0353a c0353a = (C0353a) obj;
        if (this.f1112a.size() != c0353a.f1112a.size()) {
            return false;
        }
        for (Map.Entry entry : this.f1112a.entrySet()) {
            if (!c0353a.f1112a.containsKey(entry.getKey()) || !Z1.i.a(entry.getValue(), c0353a.f1112a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iB = 0;
        for (Map.Entry entry : this.f1112a.entrySet()) {
            iB += Z1.i.b(entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public String toString() {
        return this.f1112a.toString();
    }

    public C0353a(IdentityHashMap identityHashMap) {
        this.f1112a = identityHashMap;
    }
}
