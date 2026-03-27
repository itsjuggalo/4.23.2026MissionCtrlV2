package r5;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: renamed from: r5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2585a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap f22600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2585a f22601c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f22602a;

    /* JADX INFO: renamed from: r5.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2585a f22603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IdentityHashMap f22604b;

        public C2585a a() {
            if (this.f22604b != null) {
                for (Map.Entry entry : this.f22603a.f22602a.entrySet()) {
                    if (!this.f22604b.containsKey(entry.getKey())) {
                        this.f22604b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f22603a = new C2585a(this.f22604b);
                this.f22604b = null;
            }
            return this.f22603a;
        }

        public final IdentityHashMap b(int i7) {
            if (this.f22604b == null) {
                this.f22604b = new IdentityHashMap(i7);
            }
            return this.f22604b;
        }

        public b c(c cVar) {
            if (this.f22603a.f22602a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f22603a.f22602a);
                identityHashMap.remove(cVar);
                this.f22603a = new C2585a(identityHashMap);
            }
            IdentityHashMap identityHashMap2 = this.f22604b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        public b d(c cVar, Object obj) {
            b(1).put(cVar, obj);
            return this;
        }

        public b(C2585a c2585a) {
            this.f22603a = c2585a;
        }
    }

    /* JADX INFO: renamed from: r5.a$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22605a;

        public c(String str) {
            this.f22605a = str;
        }

        public static c a(String str) {
            return new c(str);
        }

        public String toString() {
            return this.f22605a;
        }
    }

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f22600b = identityHashMap;
        f22601c = new C2585a(identityHashMap);
    }

    public static b c() {
        return new b();
    }

    public Object b(c cVar) {
        return this.f22602a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2585a.class != obj.getClass()) {
            return false;
        }
        C2585a c2585a = (C2585a) obj;
        if (this.f22602a.size() != c2585a.f22602a.size()) {
            return false;
        }
        for (Map.Entry entry : this.f22602a.entrySet()) {
            if (!c2585a.f22602a.containsKey(entry.getKey()) || !H2.i.a(entry.getValue(), c2585a.f22602a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iB = 0;
        for (Map.Entry entry : this.f22602a.entrySet()) {
            iB += H2.i.b(entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public String toString() {
        return this.f22602a.toString();
    }

    public C2585a(IdentityHashMap identityHashMap) {
        this.f22602a = identityHashMap;
    }
}
