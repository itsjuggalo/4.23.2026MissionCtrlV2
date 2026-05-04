package com.google.protobuf;

import com.google.protobuf.a2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7109c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a2.b f7110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f7111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a2.b f7112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f7113d;

        public a(a2.b bVar, Object obj, a2.b bVar2, Object obj2) {
            this.f7110a = bVar;
            this.f7111b = obj;
            this.f7112c = bVar2;
            this.f7113d = obj2;
        }
    }

    public n0(a2.b bVar, Object obj, a2.b bVar2, Object obj2) {
        this.f7107a = new a(bVar, obj, bVar2, obj2);
        this.f7108b = obj;
        this.f7109c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return u.b(aVar.f7110a, 1, obj) + u.b(aVar.f7112c, 2, obj2);
    }

    public static n0 d(a2.b bVar, Object obj, a2.b bVar2, Object obj2) {
        return new n0(bVar, obj, bVar2, obj2);
    }

    public static void e(l lVar, a aVar, Object obj, Object obj2) {
        u.u(lVar, aVar.f7110a, 1, obj);
        u.u(lVar, aVar.f7112c, 2, obj2);
    }

    public int a(int i10, Object obj, Object obj2) {
        return l.Q(i10) + l.A(b(this.f7107a, obj, obj2));
    }

    public a c() {
        return this.f7107a;
    }
}
