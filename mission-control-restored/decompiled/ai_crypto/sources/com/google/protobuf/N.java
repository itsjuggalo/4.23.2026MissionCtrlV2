package com.google.protobuf;

import com.google.protobuf.B0;

/* JADX INFO: loaded from: classes.dex */
public class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12592c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final B0.b f12593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f12594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final B0.b f12595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f12596d;

        public a(B0.b bVar, Object obj, B0.b bVar2, Object obj2) {
            this.f12593a = bVar;
            this.f12594b = obj;
            this.f12595c = bVar2;
            this.f12596d = obj2;
        }
    }

    public N(B0.b bVar, Object obj, B0.b bVar2, Object obj2) {
        this.f12590a = new a(bVar, obj, bVar2, obj2);
        this.f12591b = obj;
        this.f12592c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C1251u.b(aVar.f12593a, 1, obj) + C1251u.b(aVar.f12595c, 2, obj2);
    }

    public static N d(B0.b bVar, Object obj, B0.b bVar2, Object obj2) {
        return new N(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC1243l abstractC1243l, a aVar, Object obj, Object obj2) {
        C1251u.u(abstractC1243l, aVar.f12593a, 1, obj);
        C1251u.u(abstractC1243l, aVar.f12595c, 2, obj2);
    }

    public int a(int i7, Object obj, Object obj2) {
        return AbstractC1243l.Q(i7) + AbstractC1243l.A(b(this.f12590a, obj, obj2));
    }

    public a c() {
        return this.f12590a;
    }
}
