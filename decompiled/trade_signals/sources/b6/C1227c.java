package b6;

import I6.AbstractC0613d0;
import R5.h0;
import c6.InterfaceC1263g;
import h6.InterfaceC1892a;
import h6.InterfaceC1893b;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import p5.M;
import p5.z;

/* JADX INFO: renamed from: b6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1227c implements InterfaceC1263g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f13187f = {O.g(new G(C1227c.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.c f13188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f13189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.i f13190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC1893b f13191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13192e;

    public C1227c(d6.k c8, InterfaceC1892a interfaceC1892a, q6.c fqName) {
        h0 NO_SOURCE;
        Collection collectionA;
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(fqName, "fqName");
        this.f13188a = fqName;
        if (interfaceC1892a == null || (NO_SOURCE = c8.a().t().a(interfaceC1892a)) == null) {
            NO_SOURCE = h0.f7249a;
            AbstractC2304t.e(NO_SOURCE, "NO_SOURCE");
        }
        this.f13189b = NO_SOURCE;
        this.f13190c = c8.e().e(new C1226b(c8, this));
        this.f13191d = (interfaceC1892a == null || (collectionA = interfaceC1892a.a()) == null) ? null : (InterfaceC1893b) z.Z(collectionA);
        boolean z7 = false;
        if (interfaceC1892a != null && interfaceC1892a.f()) {
            z7 = true;
        }
        this.f13192e = z7;
    }

    public static final AbstractC0613d0 g(d6.k kVar, C1227c c1227c) {
        AbstractC0613d0 abstractC0613d0T = kVar.d().q().p(c1227c.e()).t();
        AbstractC2304t.e(abstractC0613d0T, "getDefaultType(...)");
        return abstractC0613d0T;
    }

    @Override // S5.c
    public Map a() {
        return M.h();
    }

    public final InterfaceC1893b c() {
        return this.f13191d;
    }

    @Override // S5.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC0613d0 getType() {
        return (AbstractC0613d0) H6.m.a(this.f13190c, this, f13187f[0]);
    }

    @Override // S5.c
    public q6.c e() {
        return this.f13188a;
    }

    @Override // c6.InterfaceC1263g
    public boolean f() {
        return this.f13192e;
    }

    @Override // S5.c
    public h0 j() {
        return this.f13189b;
    }
}
