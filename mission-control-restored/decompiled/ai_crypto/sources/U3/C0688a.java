package U3;

import w3.InterfaceC2775a;
import w3.InterfaceC2776b;
import y3.C2842a;

/* JADX INFO: renamed from: U3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0688a implements InterfaceC2775a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2775a f4842a = new C0688a();

    /* JADX INFO: renamed from: U3.a$a, reason: collision with other inner class name */
    public static final class C0084a implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0084a f4843a = new C0084a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f4844b = v3.d.a("projectNumber").b(C2842a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f4845c = v3.d.a("messageId").b(C2842a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final v3.d f4846d = v3.d.a("instanceId").b(C2842a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final v3.d f4847e = v3.d.a("messageType").b(C2842a.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final v3.d f4848f = v3.d.a("sdkPlatform").b(C2842a.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final v3.d f4849g = v3.d.a("packageName").b(C2842a.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final v3.d f4850h = v3.d.a("collapseKey").b(C2842a.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final v3.d f4851i = v3.d.a("priority").b(C2842a.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final v3.d f4852j = v3.d.a("ttl").b(C2842a.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final v3.d f4853k = v3.d.a("topic").b(C2842a.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final v3.d f4854l = v3.d.a("bulkId").b(C2842a.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final v3.d f4855m = v3.d.a("event").b(C2842a.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final v3.d f4856n = v3.d.a("analyticsLabel").b(C2842a.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final v3.d f4857o = v3.d.a("campaignId").b(C2842a.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final v3.d f4858p = v3.d.a("composerLabel").b(C2842a.b().c(15).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(V3.a aVar, v3.f fVar) {
            fVar.c(f4844b, aVar.l());
            fVar.d(f4845c, aVar.h());
            fVar.d(f4846d, aVar.g());
            fVar.d(f4847e, aVar.i());
            fVar.d(f4848f, aVar.m());
            fVar.d(f4849g, aVar.j());
            fVar.d(f4850h, aVar.d());
            fVar.b(f4851i, aVar.k());
            fVar.b(f4852j, aVar.o());
            fVar.d(f4853k, aVar.n());
            fVar.c(f4854l, aVar.b());
            fVar.d(f4855m, aVar.f());
            fVar.d(f4856n, aVar.a());
            fVar.c(f4857o, aVar.c());
            fVar.d(f4858p, aVar.e());
        }
    }

    /* JADX INFO: renamed from: U3.a$b */
    public static final class b implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4859a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f4860b = v3.d.a("messagingClientEvent").b(C2842a.b().c(1).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(V3.b bVar, v3.f fVar) {
            fVar.d(f4860b, bVar.a());
        }
    }

    /* JADX INFO: renamed from: U3.a$c */
    public static final class c implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4861a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f4862b = v3.d.d("messagingClientEventExtension");

        @Override // v3.InterfaceC2766b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.session.b.a(obj);
            b(null, (v3.f) obj2);
        }

        public void b(K k7, v3.f fVar) {
            throw null;
        }
    }

    @Override // w3.InterfaceC2775a
    public void a(InterfaceC2776b interfaceC2776b) {
        interfaceC2776b.a(K.class, c.f4861a);
        interfaceC2776b.a(V3.b.class, b.f4859a);
        interfaceC2776b.a(V3.a.class, C0084a.f4843a);
    }
}
