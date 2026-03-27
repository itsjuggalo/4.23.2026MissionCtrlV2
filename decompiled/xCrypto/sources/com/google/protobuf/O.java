package com.google.protobuf;

import com.google.protobuf.C0;

/* JADX INFO: loaded from: classes.dex */
public class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10967c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0.b f10968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f10969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0.b f10970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f10971d;

        public a(C0.b bVar, Object obj, C0.b bVar2, Object obj2) {
            this.f10968a = bVar;
            this.f10969b = obj;
            this.f10970c = bVar2;
            this.f10971d = obj2;
        }
    }

    public O(C0.b bVar, Object obj, C0.b bVar2, Object obj2) {
        this.f10965a = new a(bVar, obj, bVar2, obj2);
        this.f10966b = obj;
        this.f10967c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C1073u.d(aVar.f10968a, 1, obj) + C1073u.d(aVar.f10970c, 2, obj2);
    }

    public static O d(C0.b bVar, Object obj, C0.b bVar2, Object obj2) {
        return new O(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC1065l abstractC1065l, a aVar, Object obj, Object obj2) {
        C1073u.y(abstractC1065l, aVar.f10968a, 1, obj);
        C1073u.y(abstractC1065l, aVar.f10970c, 2, obj2);
    }

    public int a(int i4, Object obj, Object obj2) {
        return AbstractC1065l.S(i4) + AbstractC1065l.A(b(this.f10965a, obj, obj2));
    }

    public a c() {
        return this.f10965a;
    }
}
