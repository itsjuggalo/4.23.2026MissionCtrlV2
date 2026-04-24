package e3;

import f3.C0604d;
import f3.EnumC0601a;
import f3.EnumC0603c;

/* JADX INFO: renamed from: e3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0541a implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0541a f6116a = new C0541a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6117b = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(1))), "projectNumber");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6118c = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(2))), "messageId");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6119d = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(3))), "instanceId");
    public static final F2.c e = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(4))), "messageType");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f6120f = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(5))), "sdkPlatform");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f6121g = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(6))), "packageName");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f6122h = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(7))), "collapseKey");
    public static final F2.c i = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(8))), "priority");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F2.c f6123j = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(9))), "ttl");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final F2.c f6124k = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(10))), "topic");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final F2.c f6125l = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(11))), "bulkId");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final F2.c f6126m = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(12))), "event");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final F2.c f6127n = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(13))), "analyticsLabel");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final F2.c f6128o = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(14))), "campaignId");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final F2.c f6129p = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(15))), "composerLabel");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0604d c0604d = (C0604d) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.f(f6117b, c0604d.f6449a);
        eVar.a(f6118c, c0604d.f6450b);
        eVar.a(f6119d, c0604d.f6451c);
        eVar.a(e, c0604d.f6452d);
        eVar.a(f6120f, EnumC0603c.ANDROID);
        eVar.a(f6121g, c0604d.e);
        eVar.a(f6122h, c0604d.f6453f);
        eVar.g(i, c0604d.f6454g);
        eVar.g(f6123j, c0604d.f6455h);
        eVar.a(f6124k, c0604d.i);
        eVar.f(f6125l, 0L);
        eVar.a(f6126m, EnumC0601a.MESSAGE_DELIVERED);
        eVar.a(f6127n, c0604d.f6456j);
        eVar.f(f6128o, 0L);
        eVar.a(f6129p, c0604d.f6457k);
    }
}
