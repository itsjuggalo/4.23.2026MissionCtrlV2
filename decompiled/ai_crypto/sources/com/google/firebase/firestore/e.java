package com.google.firebase.firestore;

import A3.C0419t;
import D3.C0441k;
import D3.C0446p;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f12127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0441k.a f12128b;

        public a(List list, C0441k.a aVar) {
            this.f12127a = list;
            this.f12128b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12128b == aVar.f12128b && Objects.equals(this.f12127a, aVar.f12127a);
        }

        public int hashCode() {
            List list = this.f12127a;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            C0441k.a aVar = this.f12128b;
            return iHashCode + (aVar != null ? aVar.hashCode() : 0);
        }

        public List m() {
            return this.f12127a;
        }

        public C0441k.a n() {
            return this.f12128b;
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0419t f12129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0446p.b f12130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f12131c;

        public b(C0419t c0419t, C0446p.b bVar, Object obj) {
            this.f12129a = c0419t;
            this.f12130b = bVar;
            this.f12131c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12130b == bVar.f12130b && Objects.equals(this.f12129a, bVar.f12129a) && Objects.equals(this.f12131c, bVar.f12131c);
        }

        public int hashCode() {
            C0419t c0419t = this.f12129a;
            int iHashCode = (c0419t != null ? c0419t.hashCode() : 0) * 31;
            C0446p.b bVar = this.f12130b;
            int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
            Object obj = this.f12131c;
            return iHashCode2 + (obj != null ? obj.hashCode() : 0);
        }

        public C0419t m() {
            return this.f12129a;
        }

        public C0446p.b n() {
            return this.f12130b;
        }

        public Object o() {
            return this.f12131c;
        }
    }

    public static e a(e... eVarArr) {
        return new a(Arrays.asList(eVarArr), C0441k.a.AND);
    }

    public static e b(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.ARRAY_CONTAINS, obj);
    }

    public static e c(C0419t c0419t, List list) {
        return new b(c0419t, C0446p.b.ARRAY_CONTAINS_ANY, list);
    }

    public static e d(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.EQUAL, obj);
    }

    public static e e(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.GREATER_THAN, obj);
    }

    public static e f(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.GREATER_THAN_OR_EQUAL, obj);
    }

    public static e g(C0419t c0419t, List list) {
        return new b(c0419t, C0446p.b.IN, list);
    }

    public static e h(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.LESS_THAN, obj);
    }

    public static e i(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.LESS_THAN_OR_EQUAL, obj);
    }

    public static e j(C0419t c0419t, Object obj) {
        return new b(c0419t, C0446p.b.NOT_EQUAL, obj);
    }

    public static e k(C0419t c0419t, List list) {
        return new b(c0419t, C0446p.b.NOT_IN, list);
    }

    public static e l(e... eVarArr) {
        return new a(Arrays.asList(eVarArr), C0441k.a.OR);
    }
}
