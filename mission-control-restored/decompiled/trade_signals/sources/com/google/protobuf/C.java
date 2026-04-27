package com.google.protobuf;

import com.google.protobuf.l0;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16281c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0.b f16282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f16283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l0.b f16284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f16285d;

        public a(l0.b bVar, Object obj, l0.b bVar2, Object obj2) {
            this.f16282a = bVar;
            this.f16283b = obj;
            this.f16284c = bVar2;
            this.f16285d = obj2;
        }
    }

    public C(l0.b bVar, Object obj, l0.b bVar2, Object obj2) {
        this.f16279a = new a(bVar, obj, bVar2, obj2);
        this.f16280b = obj;
        this.f16281c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C1478q.b(aVar.f16282a, 1, obj) + C1478q.b(aVar.f16284c, 2, obj2);
    }

    public static C d(l0.b bVar, Object obj, l0.b bVar2, Object obj2) {
        return new C(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC1470i abstractC1470i, a aVar, Object obj, Object obj2) {
        C1478q.u(abstractC1470i, aVar.f16282a, 1, obj);
        C1478q.u(abstractC1470i, aVar.f16284c, 2, obj2);
    }

    public int a(int i8, Object obj, Object obj2) {
        return AbstractC1470i.P(i8) + AbstractC1470i.z(b(this.f16279a, obj, obj2));
    }

    public a c() {
        return this.f16279a;
    }
}
