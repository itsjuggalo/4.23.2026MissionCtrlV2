package l4;

import android.content.Context;
import l4.v;
import t4.n0;
import t4.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f15391a;

        public b() {
        }

        @Override // l4.v.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f15391a = (Context) n4.d.b(context);
            return this;
        }

        @Override // l4.v.a
        public v build() {
            n4.d.a(this.f15391a, Context.class);
            return new c(this.f15391a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f15392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bd.a f15393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bd.a f15394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bd.a f15395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public bd.a f15396e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public bd.a f15397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public bd.a f15398g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public bd.a f15399h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public bd.a f15400i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public bd.a f15401j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public bd.a f15402k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public bd.a f15403l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public bd.a f15404m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public bd.a f15405n;

        @Override // l4.v
        public t4.d b() {
            return (t4.d) this.f15399h.get();
        }

        @Override // l4.v
        public u c() {
            return (u) this.f15405n.get();
        }

        public final void e(Context context) {
            this.f15393b = n4.a.a(k.a());
            n4.b bVarA = n4.c.a(context);
            this.f15394c = bVarA;
            m4.j jVarA = m4.j.a(bVarA, v4.c.a(), v4.d.a());
            this.f15395d = jVarA;
            this.f15396e = n4.a.a(m4.l.a(this.f15394c, jVarA));
            this.f15397f = w0.a(this.f15394c, t4.g.a(), t4.i.a());
            this.f15398g = n4.a.a(t4.h.a(this.f15394c));
            this.f15399h = n4.a.a(n0.a(v4.c.a(), v4.d.a(), t4.j.a(), this.f15397f, this.f15398g));
            r4.g gVarB = r4.g.b(v4.c.a());
            this.f15400i = gVarB;
            r4.i iVarA = r4.i.a(this.f15394c, this.f15399h, gVarB, v4.d.a());
            this.f15401j = iVarA;
            bd.a aVar = this.f15393b;
            bd.a aVar2 = this.f15396e;
            bd.a aVar3 = this.f15399h;
            this.f15402k = r4.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
            bd.a aVar4 = this.f15394c;
            bd.a aVar5 = this.f15396e;
            bd.a aVar6 = this.f15399h;
            this.f15403l = s4.s.a(aVar4, aVar5, aVar6, this.f15401j, this.f15393b, aVar6, v4.c.a(), v4.d.a(), this.f15399h);
            bd.a aVar7 = this.f15393b;
            bd.a aVar8 = this.f15399h;
            this.f15404m = s4.w.a(aVar7, aVar8, this.f15401j, aVar8);
            this.f15405n = n4.a.a(w.a(v4.c.a(), v4.d.a(), this.f15402k, this.f15403l, this.f15404m));
        }

        public c(Context context) {
            this.f15392a = this;
            e(context);
        }
    }

    public static v.a a() {
        return new b();
    }
}
