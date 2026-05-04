package w9;

import android.app.Application;
import java.util.Map;
import u9.h;
import x9.g;
import x9.i;
import x9.j;
import x9.k;
import x9.l;
import x9.m;
import x9.n;
import x9.o;
import x9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x9.a f23774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f23775b;

        public b a(x9.a aVar) {
            this.f23774a = (x9.a) t9.d.b(aVar);
            return this;
        }

        public f b() {
            t9.d.a(this.f23774a, x9.a.class);
            if (this.f23775b == null) {
                this.f23775b = new g();
            }
            return new c(this.f23774a, this.f23775b);
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f23776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f23777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t9.e f23778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t9.e f23779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t9.e f23780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t9.e f23781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t9.e f23782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public t9.e f23783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public t9.e f23784i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public t9.e f23785j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public t9.e f23786k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public t9.e f23787l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public t9.e f23788m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public t9.e f23789n;

        @Override // w9.f
        public u9.g a() {
            return (u9.g) this.f23779d.get();
        }

        @Override // w9.f
        public Application b() {
            return (Application) this.f23778c.get();
        }

        @Override // w9.f
        public Map c() {
            return t9.c.b(8).c("IMAGE_ONLY_PORTRAIT", this.f23782g).c("IMAGE_ONLY_LANDSCAPE", this.f23783h).c("MODAL_LANDSCAPE", this.f23784i).c("MODAL_PORTRAIT", this.f23785j).c("CARD_LANDSCAPE", this.f23786k).c("CARD_PORTRAIT", this.f23787l).c("BANNER_PORTRAIT", this.f23788m).c("BANNER_LANDSCAPE", this.f23789n).a();
        }

        @Override // w9.f
        public u9.a d() {
            return (u9.a) this.f23780e.get();
        }

        public final void e(x9.a aVar, g gVar) {
            this.f23778c = t9.b.a(x9.b.a(aVar));
            this.f23779d = t9.b.a(h.a());
            this.f23780e = t9.b.a(u9.b.a(this.f23778c));
            l lVarA = l.a(gVar, this.f23778c);
            this.f23781f = lVarA;
            this.f23782g = p.a(gVar, lVarA);
            this.f23783h = m.a(gVar, this.f23781f);
            this.f23784i = n.a(gVar, this.f23781f);
            this.f23785j = o.a(gVar, this.f23781f);
            this.f23786k = j.a(gVar, this.f23781f);
            this.f23787l = k.a(gVar, this.f23781f);
            this.f23788m = i.a(gVar, this.f23781f);
            this.f23789n = x9.h.a(gVar, this.f23781f);
        }

        public c(x9.a aVar, g gVar) {
            this.f23777b = this;
            this.f23776a = gVar;
            e(aVar, gVar);
        }
    }

    public static b a() {
        return new b();
    }
}
