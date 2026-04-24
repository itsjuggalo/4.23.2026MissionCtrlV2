package io.flutter.embedding.engine;

import M4.a;
import U4.f;
import U4.g;
import U4.k;
import U4.l;
import U4.m;
import U4.n;
import U4.o;
import U4.s;
import U4.t;
import U4.u;
import U4.v;
import U4.w;
import U4.x;
import U4.y;
import U4.z;
import W4.d;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.C2025w;
import io.flutter.plugin.platform.P;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q5.AbstractC2569h;

/* JADX INFO: loaded from: classes2.dex */
public class a implements AbstractC2569h.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static long f16494A = 1;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Map f16495B = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f16496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterRenderer f16497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final M4.a f16498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L4.b f16499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f16500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final U4.a f16501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f16502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f16503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f16504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f16505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n f16506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f16507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t f16508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final o f16509n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s f16510o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final u f16511p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v f16512q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final w f16513r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final x f16514s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y f16515t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final z f16516u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final C2025w f16517v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final P f16518w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Set f16519x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f16520y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f16521z;

    /* JADX INFO: renamed from: io.flutter.embedding.engine.a$a, reason: collision with other inner class name */
    public class C0256a implements b {
        public C0256a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
            J4.b.f("FlutterEngine", "onPreEngineRestart()");
            Iterator it = a.this.f16519x.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b();
            }
            a.this.f16517v.l0();
            a.this.f16518w.D();
            a.this.f16508m.g();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public a(Context context) {
        this(context, null);
    }

    public x A() {
        return this.f16514s;
    }

    public y B() {
        return this.f16515t;
    }

    public z C() {
        return this.f16516u;
    }

    public final boolean D() {
        return this.f16496a.isAttached();
    }

    public a E(Context context, a.c cVar, String str, List list, C2025w c2025w, boolean z7, boolean z8) {
        if (D()) {
            return new a(context, null, this.f16496a.spawn(cVar.f3858c, cVar.f3857b, str, list, f16494A), c2025w, null, z7, z8);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    @Override // q5.AbstractC2569h.a
    public void a(float f7, float f8, float f9) {
        this.f16496a.updateDisplayMetrics(0, f7, f8, f9);
    }

    public void f(b bVar) {
        this.f16519x.add(bVar);
    }

    public final void g() {
        J4.b.f("FlutterEngine", "Attaching to JNI.");
        this.f16496a.attachToNative();
        if (!D()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    public void h() {
        J4.b.f("FlutterEngine", "Destroying.");
        Iterator it = this.f16519x.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
        this.f16499d.i();
        this.f16517v.h0();
        this.f16518w.A();
        this.f16498c.o();
        this.f16496a.removeEngineLifecycleListener(this.f16521z);
        this.f16496a.setDeferredComponentManager(null);
        this.f16496a.detachFromNativeAndReleaseResources();
        J4.a.e().a();
        f16495B.remove(Long.valueOf(this.f16520y));
    }

    public U4.a i() {
        return this.f16501f;
    }

    public R4.b j() {
        return this.f16499d;
    }

    public f k() {
        return this.f16507l;
    }

    public M4.a l() {
        return this.f16498c;
    }

    public k m() {
        return this.f16503h;
    }

    public d n() {
        return this.f16500e;
    }

    public m o() {
        return this.f16505j;
    }

    public n p() {
        return this.f16506k;
    }

    public o q() {
        return this.f16509n;
    }

    public C2025w r() {
        return this.f16517v;
    }

    public P s() {
        return this.f16518w;
    }

    public Q4.b t() {
        return this.f16499d;
    }

    public s u() {
        return this.f16510o;
    }

    public FlutterRenderer v() {
        return this.f16497b;
    }

    public t w() {
        return this.f16508m;
    }

    public u x() {
        return this.f16511p;
    }

    public v y() {
        return this.f16512q;
    }

    public w z() {
        return this.f16513r;
    }

    public a(Context context, String[] strArr) {
        this(context, null, null, strArr, true);
    }

    public a(Context context, O4.f fVar, FlutterJNI flutterJNI, String[] strArr, boolean z7) {
        this(context, fVar, flutterJNI, new C2025w(), strArr, z7);
    }

    public a(Context context, O4.f fVar, FlutterJNI flutterJNI, C2025w c2025w, String[] strArr, boolean z7) {
        this(context, fVar, flutterJNI, c2025w, strArr, z7, false);
    }

    public a(Context context, O4.f fVar, FlutterJNI flutterJNI, C2025w c2025w, String[] strArr, boolean z7, boolean z8) {
        this(context, fVar, flutterJNI, c2025w, strArr, z7, z8, null);
    }

    public a(Context context, O4.f fVar, FlutterJNI flutterJNI, C2025w c2025w, String[] strArr, boolean z7, boolean z8, io.flutter.embedding.engine.b bVar) {
        AssetManager assets;
        this.f16519x = new HashSet();
        this.f16521z = new C0256a();
        long j7 = f16494A;
        f16494A = 1 + j7;
        this.f16520y = j7;
        f16495B.put(Long.valueOf(j7), this);
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        J4.a aVarE = J4.a.e();
        flutterJNI = flutterJNI == null ? aVarE.d().a() : flutterJNI;
        this.f16496a = flutterJNI;
        M4.a aVar = new M4.a(flutterJNI, assets, this.f16520y);
        this.f16498c = aVar;
        aVar.n();
        J4.a.e().a();
        this.f16501f = new U4.a(aVar, flutterJNI);
        this.f16502g = new g(aVar);
        this.f16503h = new k(aVar);
        l lVar = new l(aVar);
        this.f16504i = lVar;
        this.f16505j = new m(aVar);
        this.f16506k = new n(aVar);
        this.f16507l = new f(aVar);
        this.f16509n = new o(aVar);
        this.f16510o = new s(aVar, context.getPackageManager());
        this.f16508m = new t(aVar, z8);
        this.f16511p = new u(aVar);
        this.f16512q = new v(aVar);
        this.f16513r = new w(aVar);
        this.f16514s = new x(aVar);
        this.f16515t = new y(aVar);
        this.f16516u = new z(aVar);
        d dVar = new d(context, lVar);
        this.f16500e = dVar;
        fVar = fVar == null ? aVarE.c() : fVar;
        if (!flutterJNI.isAttached()) {
            fVar.r(context.getApplicationContext());
            fVar.h(context, strArr);
        }
        P p7 = new P();
        p7.J(c2025w.W());
        p7.I(flutterJNI);
        c2025w.t0(flutterJNI);
        flutterJNI.addEngineLifecycleListener(this.f16521z);
        flutterJNI.setPlatformViewsController(c2025w);
        flutterJNI.setPlatformViewsController2(p7);
        flutterJNI.setLocalizationPlugin(dVar);
        aVarE.a();
        flutterJNI.setDeferredComponentManager(null);
        if (!flutterJNI.isAttached()) {
            g();
        }
        this.f16497b = new FlutterRenderer(flutterJNI);
        this.f16517v = c2025w;
        this.f16518w = p7;
        L4.b bVar2 = new L4.b(context.getApplicationContext(), this, fVar, bVar);
        this.f16499d = bVar2;
        dVar.d(context.getResources().getConfiguration());
        if (z7 && fVar.g()) {
            T4.a.a(this);
        }
        AbstractC2569h.c(context, this);
        bVar2.e(new Y4.a(u()));
    }
}
