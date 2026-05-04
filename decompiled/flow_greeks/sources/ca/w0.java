package ca;

import aa.m2;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f3807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f3809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f3810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f3811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bd.a f3812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bd.a f3813g;

    public w0(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7) {
        this.f3807a = aVar;
        this.f3808b = aVar2;
        this.f3809c = aVar3;
        this.f3810d = aVar4;
        this.f3811e = aVar5;
        this.f3812f = aVar6;
        this.f3813g = aVar7;
    }

    public static w0 a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7) {
        return new w0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static m2 c(a7.g gVar, i4.j jVar, AnalyticsConnector analyticsConnector, ga.h hVar, da.a aVar, aa.o oVar, Executor executor) {
        return (m2) r9.d.e(v0.c(gVar, jVar, analyticsConnector, hVar, aVar, oVar, executor));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m2 get() {
        return c((a7.g) this.f3807a.get(), (i4.j) this.f3808b.get(), (AnalyticsConnector) this.f3809c.get(), (ga.h) this.f3810d.get(), (da.a) this.f3811e.get(), (aa.o) this.f3812f.get(), (Executor) this.f3813g.get());
    }
}
