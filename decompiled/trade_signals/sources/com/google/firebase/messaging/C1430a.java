package com.google.firebase.messaging;

import io.flutter.plugins.firebase.database.Constants;
import x3.InterfaceC2956a;
import z3.C3005a;

/* JADX INFO: renamed from: com.google.firebase.messaging.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1430a implements InterfaceC2956a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2956a f15671a = new C1430a();

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    public static final class C0252a implements w3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0252a f15672a = new C0252a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w3.d f15673b = w3.d.a("projectNumber").b(C3005a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w3.d f15674c = w3.d.a("messageId").b(C3005a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w3.d f15675d = w3.d.a("instanceId").b(C3005a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final w3.d f15676e = w3.d.a("messageType").b(C3005a.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final w3.d f15677f = w3.d.a("sdkPlatform").b(C3005a.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final w3.d f15678g = w3.d.a("packageName").b(C3005a.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final w3.d f15679h = w3.d.a("collapseKey").b(C3005a.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final w3.d f15680i = w3.d.a(Constants.PRIORITY).b(C3005a.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final w3.d f15681j = w3.d.a("ttl").b(C3005a.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final w3.d f15682k = w3.d.a("topic").b(C3005a.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final w3.d f15683l = w3.d.a("bulkId").b(C3005a.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final w3.d f15684m = w3.d.a("event").b(C3005a.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final w3.d f15685n = w3.d.a("analyticsLabel").b(C3005a.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final w3.d f15686o = w3.d.a("campaignId").b(C3005a.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final w3.d f15687p = w3.d.a("composerLabel").b(C3005a.b().c(15).a()).a();

        @Override // w3.InterfaceC2923b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Y3.a aVar, w3.f fVar) {
            fVar.a(f15673b, aVar.l());
            fVar.g(f15674c, aVar.h());
            fVar.g(f15675d, aVar.g());
            fVar.g(f15676e, aVar.i());
            fVar.g(f15677f, aVar.m());
            fVar.g(f15678g, aVar.j());
            fVar.g(f15679h, aVar.d());
            fVar.b(f15680i, aVar.k());
            fVar.b(f15681j, aVar.o());
            fVar.g(f15682k, aVar.n());
            fVar.a(f15683l, aVar.b());
            fVar.g(f15684m, aVar.f());
            fVar.g(f15685n, aVar.a());
            fVar.a(f15686o, aVar.c());
            fVar.g(f15687p, aVar.e());
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$b */
    public static final class b implements w3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15688a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w3.d f15689b = w3.d.a("messagingClientEvent").b(C3005a.b().c(1).a()).a();

        @Override // w3.InterfaceC2923b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Y3.b bVar, w3.f fVar) {
            fVar.g(f15689b, bVar.a());
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$c */
    public static final class c implements w3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f15690a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w3.d f15691b = w3.d.d("messagingClientEventExtension");

        @Override // w3.InterfaceC2923b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.session.b.a(obj);
            b(null, (w3.f) obj2);
        }

        public void b(N n8, w3.f fVar) {
            throw null;
        }
    }

    @Override // x3.InterfaceC2956a
    public void a(x3.b bVar) {
        bVar.a(N.class, c.f15690a);
        bVar.a(Y3.b.class, b.f15688a);
        bVar.a(Y3.a.class, C0252a.f15672a);
    }
}
