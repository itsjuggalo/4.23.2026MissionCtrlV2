package com.google.firebase.messaging;

import io.flutter.plugins.firebase.database.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements z8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z8.a f6259a = new a();

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0102a implements y8.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0102a f6260a = new C0102a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final y8.d f6261b = y8.d.a("projectNumber").b(b9.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final y8.d f6262c = y8.d.a("messageId").b(b9.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final y8.d f6263d = y8.d.a("instanceId").b(b9.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final y8.d f6264e = y8.d.a("messageType").b(b9.a.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final y8.d f6265f = y8.d.a("sdkPlatform").b(b9.a.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final y8.d f6266g = y8.d.a("packageName").b(b9.a.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final y8.d f6267h = y8.d.a("collapseKey").b(b9.a.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final y8.d f6268i = y8.d.a(Constants.PRIORITY).b(b9.a.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final y8.d f6269j = y8.d.a("ttl").b(b9.a.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final y8.d f6270k = y8.d.a("topic").b(b9.a.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final y8.d f6271l = y8.d.a("bulkId").b(b9.a.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final y8.d f6272m = y8.d.a("event").b(b9.a.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final y8.d f6273n = y8.d.a("analyticsLabel").b(b9.a.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final y8.d f6274o = y8.d.a("campaignId").b(b9.a.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final y8.d f6275p = y8.d.a("composerLabel").b(b9.a.b().c(15).a()).a();

        @Override // y8.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ma.a aVar, y8.f fVar) {
            fVar.d(f6261b, aVar.l());
            fVar.e(f6262c, aVar.h());
            fVar.e(f6263d, aVar.g());
            fVar.e(f6264e, aVar.i());
            fVar.e(f6265f, aVar.m());
            fVar.e(f6266g, aVar.j());
            fVar.e(f6267h, aVar.d());
            fVar.c(f6268i, aVar.k());
            fVar.c(f6269j, aVar.o());
            fVar.e(f6270k, aVar.n());
            fVar.d(f6271l, aVar.b());
            fVar.e(f6272m, aVar.f());
            fVar.e(f6273n, aVar.a());
            fVar.d(f6274o, aVar.c());
            fVar.e(f6275p, aVar.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements y8.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6276a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final y8.d f6277b = y8.d.a("messagingClientEvent").b(b9.a.b().c(1).a()).a();

        @Override // y8.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ma.b bVar, y8.f fVar) {
            fVar.e(f6277b, bVar.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements y8.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6278a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final y8.d f6279b = y8.d.d("messagingClientEventExtension");

        @Override // y8.b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.session.b.a(obj);
            b(null, (y8.f) obj2);
        }

        public void b(n0 n0Var, y8.f fVar) {
            throw null;
        }
    }

    @Override // z8.a
    public void a(z8.b bVar) {
        bVar.a(n0.class, c.f6278a);
        bVar.a(ma.b.class, b.f6276a);
        bVar.a(ma.a.class, C0102a.f6260a);
    }
}
