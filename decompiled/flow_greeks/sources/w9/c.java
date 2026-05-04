package w9;

import v9.g;
import v9.h;
import v9.i;
import x9.q;
import x9.r;
import x9.s;
import x9.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f23765a;

        public e a() {
            t9.d.a(this.f23765a, q.class);
            return new C0417c(this.f23765a);
        }

        public b b(q qVar) {
            this.f23765a = (q) t9.d.b(qVar);
            return this;
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: w9.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0417c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0417c f23766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t9.e f23767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t9.e f23768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t9.e f23769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t9.e f23770e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t9.e f23771f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t9.e f23772g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public t9.e f23773h;

        @Override // w9.e
        public v9.f a() {
            return (v9.f) this.f23770e.get();
        }

        @Override // w9.e
        public v9.d b() {
            return (v9.d) this.f23773h.get();
        }

        @Override // w9.e
        public v9.a c() {
            return (v9.a) this.f23772g.get();
        }

        @Override // w9.e
        public h d() {
            return (h) this.f23771f.get();
        }

        public final void e(q qVar) {
            this.f23767b = t9.b.a(r.a(qVar));
            this.f23768c = t9.b.a(t.a(qVar));
            s sVarA = s.a(qVar);
            this.f23769d = sVarA;
            this.f23770e = t9.b.a(g.a(this.f23767b, this.f23768c, sVarA));
            this.f23771f = t9.b.a(i.a(this.f23767b, this.f23768c, this.f23769d));
            this.f23772g = t9.b.a(v9.b.a(this.f23767b, this.f23768c, this.f23769d));
            this.f23773h = t9.b.a(v9.e.a(this.f23767b, this.f23768c, this.f23769d));
        }

        public C0417c(q qVar) {
            this.f23766a = this;
            e(qVar);
        }
    }

    public static b a() {
        return new b();
    }
}
