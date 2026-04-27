package r1;

import u1.C2745a;
import u1.C2746b;
import u1.C2747c;
import u1.C2748d;
import u1.C2749e;
import u1.C2750f;
import w3.InterfaceC2775a;
import w3.InterfaceC2776b;
import y3.C2842a;

/* JADX INFO: renamed from: r1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2573a implements InterfaceC2775a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2775a f22354a = new C2573a();

    /* JADX INFO: renamed from: r1.a$a, reason: collision with other inner class name */
    public static final class C0341a implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0341a f22355a = new C0341a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22356b = v3.d.a("window").b(C2842a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f22357c = v3.d.a("logSourceMetrics").b(C2842a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final v3.d f22358d = v3.d.a("globalMetrics").b(C2842a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final v3.d f22359e = v3.d.a("appNamespace").b(C2842a.b().c(4).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2745a c2745a, v3.f fVar) {
            fVar.d(f22356b, c2745a.d());
            fVar.d(f22357c, c2745a.c());
            fVar.d(f22358d, c2745a.b());
            fVar.d(f22359e, c2745a.a());
        }
    }

    /* JADX INFO: renamed from: r1.a$b */
    public static final class b implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22360a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22361b = v3.d.a("storageMetrics").b(C2842a.b().c(1).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2746b c2746b, v3.f fVar) {
            fVar.d(f22361b, c2746b.a());
        }
    }

    /* JADX INFO: renamed from: r1.a$c */
    public static final class c implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22362a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22363b = v3.d.a("eventsDroppedCount").b(C2842a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f22364c = v3.d.a("reason").b(C2842a.b().c(3).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2747c c2747c, v3.f fVar) {
            fVar.c(f22363b, c2747c.a());
            fVar.d(f22364c, c2747c.b());
        }
    }

    /* JADX INFO: renamed from: r1.a$d */
    public static final class d implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f22365a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22366b = v3.d.a("logSource").b(C2842a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f22367c = v3.d.a("logEventDropped").b(C2842a.b().c(2).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2748d c2748d, v3.f fVar) {
            fVar.d(f22366b, c2748d.b());
            fVar.d(f22367c, c2748d.a());
        }
    }

    /* JADX INFO: renamed from: r1.a$e */
    public static final class e implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f22368a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22369b = v3.d.d("clientMetrics");

        @Override // v3.InterfaceC2766b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.session.b.a(obj);
            b(null, (v3.f) obj2);
        }

        public void b(m mVar, v3.f fVar) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: r1.a$f */
    public static final class f implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f22370a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22371b = v3.d.a("currentCacheSizeBytes").b(C2842a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f22372c = v3.d.a("maxCacheSizeBytes").b(C2842a.b().c(2).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2749e c2749e, v3.f fVar) {
            fVar.c(f22371b, c2749e.a());
            fVar.c(f22372c, c2749e.b());
        }
    }

    /* JADX INFO: renamed from: r1.a$g */
    public static final class g implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f22373a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f22374b = v3.d.a("startMs").b(C2842a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f22375c = v3.d.a("endMs").b(C2842a.b().c(2).a()).a();

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2750f c2750f, v3.f fVar) {
            fVar.c(f22374b, c2750f.b());
            fVar.c(f22375c, c2750f.a());
        }
    }

    @Override // w3.InterfaceC2775a
    public void a(InterfaceC2776b interfaceC2776b) {
        interfaceC2776b.a(m.class, e.f22368a);
        interfaceC2776b.a(C2745a.class, C0341a.f22355a);
        interfaceC2776b.a(C2750f.class, g.f22373a);
        interfaceC2776b.a(C2748d.class, d.f22365a);
        interfaceC2776b.a(C2747c.class, c.f22362a);
        interfaceC2776b.a(C2746b.class, b.f22360a);
        interfaceC2776b.a(C2749e.class, f.f22370a);
    }
}
