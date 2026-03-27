package F4;

import java.util.IdentityHashMap;
import java.util.Map;
import v2.AbstractC2844j;

/* JADX INFO: renamed from: F4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0487a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap f1723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0487a f1724c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f1725a;

    /* JADX INFO: renamed from: F4.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0487a f1726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IdentityHashMap f1727b;

        public b(C0487a c0487a) {
            this.f1726a = c0487a;
        }

        public C0487a a() {
            if (this.f1727b != null) {
                for (Map.Entry entry : this.f1726a.f1725a.entrySet()) {
                    if (!this.f1727b.containsKey(entry.getKey())) {
                        this.f1727b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f1726a = new C0487a(this.f1727b);
                this.f1727b = null;
            }
            return this.f1726a;
        }

        public final IdentityHashMap b(int i8) {
            if (this.f1727b == null) {
                this.f1727b = new IdentityHashMap(i8);
            }
            return this.f1727b;
        }

        public b c(c cVar) {
            if (this.f1726a.f1725a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f1726a.f1725a);
                identityHashMap.remove(cVar);
                this.f1726a = new C0487a(identityHashMap);
            }
            IdentityHashMap identityHashMap2 = this.f1727b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        public b d(c cVar, Object obj) {
            b(1).put(cVar, obj);
            return this;
        }
    }

    /* JADX INFO: renamed from: F4.a$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1728a;

        public c(String str) {
            this.f1728a = str;
        }

        public static c a(String str) {
            return new c(str);
        }

        public String toString() {
            return this.f1728a;
        }
    }

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f1723b = identityHashMap;
        f1724c = new C0487a(identityHashMap);
    }

    public C0487a(IdentityHashMap identityHashMap) {
        this.f1725a = identityHashMap;
    }

    public static b c() {
        return new b();
    }

    public Object b(c cVar) {
        return this.f1725a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0487a.class != obj.getClass()) {
            return false;
        }
        C0487a c0487a = (C0487a) obj;
        if (this.f1725a.size() != c0487a.f1725a.size()) {
            return false;
        }
        for (Map.Entry entry : this.f1725a.entrySet()) {
            if (!c0487a.f1725a.containsKey(entry.getKey()) || !AbstractC2844j.a(entry.getValue(), c0487a.f1725a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iB = 0;
        for (Map.Entry entry : this.f1725a.entrySet()) {
            iB += AbstractC2844j.b(entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public String toString() {
        return this.f1725a.toString();
    }
}
