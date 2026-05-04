package com.google.firebase.firestore;

import d9.t;
import g9.k;
import g9.p;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f6149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k.a f6150b;

        public a(List list, k.a aVar) {
            this.f6149a = list;
            this.f6150b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f6150b == aVar.f6150b && Objects.equals(this.f6149a, aVar.f6149a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            List list = this.f6149a;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            k.a aVar = this.f6150b;
            return iHashCode + (aVar != null ? aVar.hashCode() : 0);
        }

        public List m() {
            return this.f6149a;
        }

        public k.a n() {
            return this.f6150b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f6151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p.b f6152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f6153c;

        public b(t tVar, p.b bVar, Object obj) {
            this.f6151a = tVar;
            this.f6152b = bVar;
            this.f6153c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                b bVar = (b) obj;
                if (this.f6152b == bVar.f6152b && Objects.equals(this.f6151a, bVar.f6151a) && Objects.equals(this.f6153c, bVar.f6153c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            t tVar = this.f6151a;
            int iHashCode = (tVar != null ? tVar.hashCode() : 0) * 31;
            p.b bVar = this.f6152b;
            int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
            Object obj = this.f6153c;
            return iHashCode2 + (obj != null ? obj.hashCode() : 0);
        }

        public t m() {
            return this.f6151a;
        }

        public p.b n() {
            return this.f6152b;
        }

        public Object o() {
            return this.f6153c;
        }
    }

    public static e a(e... eVarArr) {
        return new a(Arrays.asList(eVarArr), k.a.AND);
    }

    public static e b(t tVar, Object obj) {
        return new b(tVar, p.b.ARRAY_CONTAINS, obj);
    }

    public static e c(t tVar, List list) {
        return new b(tVar, p.b.ARRAY_CONTAINS_ANY, list);
    }

    public static e d(t tVar, Object obj) {
        return new b(tVar, p.b.EQUAL, obj);
    }

    public static e e(t tVar, Object obj) {
        return new b(tVar, p.b.GREATER_THAN, obj);
    }

    public static e f(t tVar, Object obj) {
        return new b(tVar, p.b.GREATER_THAN_OR_EQUAL, obj);
    }

    public static e g(t tVar, List list) {
        return new b(tVar, p.b.IN, list);
    }

    public static e h(t tVar, Object obj) {
        return new b(tVar, p.b.LESS_THAN, obj);
    }

    public static e i(t tVar, Object obj) {
        return new b(tVar, p.b.LESS_THAN_OR_EQUAL, obj);
    }

    public static e j(t tVar, Object obj) {
        return new b(tVar, p.b.NOT_EQUAL, obj);
    }

    public static e k(t tVar, List list) {
        return new b(tVar, p.b.NOT_IN, list);
    }

    public static e l(e... eVarArr) {
        return new a(Arrays.asList(eVarArr), k.a.OR);
    }
}
