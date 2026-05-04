package bb;

import rb.z0;
import zb.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile z0 f3226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile z0 f3227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile z0 f3228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile z0 f3229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile z0 f3230e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements c.a {
        @Override // zb.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(rb.d dVar, rb.c cVar) {
            return new b(dVar, cVar, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends zb.a {
        public /* synthetic */ b(rb.d dVar, rb.c cVar, a aVar) {
            this(dVar, cVar);
        }

        @Override // zb.c
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b a(rb.d dVar, rb.c cVar) {
            return new b(dVar, cVar);
        }

        public b(rb.d dVar, rb.c cVar) {
            super(dVar, cVar);
        }
    }

    public static z0 a() {
        z0 z0VarA;
        z0 z0Var = f3226a;
        if (z0Var != null) {
            return z0Var;
        }
        synchronized (r.class) {
            try {
                z0VarA = f3226a;
                if (z0VarA == null) {
                    z0VarA = z0.g().f(z0.d.SERVER_STREAMING).b(z0.b("google.firestore.v1.Firestore", "BatchGetDocuments")).e(true).c(yb.b.b(d.e0())).d(yb.b.b(e.a0())).a();
                    f3226a = z0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z0VarA;
    }

    public static z0 b() {
        z0 z0VarA;
        z0 z0Var = f3227b;
        if (z0Var != null) {
            return z0Var;
        }
        synchronized (r.class) {
            try {
                z0VarA = f3227b;
                if (z0VarA == null) {
                    z0VarA = z0.g().f(z0.d.UNARY).b(z0.b("google.firestore.v1.Firestore", "Commit")).e(true).c(yb.b.b(h.e0())).d(yb.b.b(i.b0())).a();
                    f3227b = z0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z0VarA;
    }

    public static z0 c() {
        z0 z0VarA;
        z0 z0Var = f3230e;
        if (z0Var != null) {
            return z0Var;
        }
        synchronized (r.class) {
            try {
                z0VarA = f3230e;
                if (z0VarA == null) {
                    z0VarA = z0.g().f(z0.d.BIDI_STREAMING).b(z0.b("google.firestore.v1.Firestore", "Listen")).e(true).c(yb.b.b(s.e0())).d(yb.b.b(t.a0())).a();
                    f3230e = z0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z0VarA;
    }

    public static z0 d() {
        z0 z0VarA;
        z0 z0Var = f3228c;
        if (z0Var != null) {
            return z0Var;
        }
        synchronized (r.class) {
            try {
                z0VarA = f3228c;
                if (z0VarA == null) {
                    z0VarA = z0.g().f(z0.d.SERVER_STREAMING).b(z0.b("google.firestore.v1.Firestore", "RunAggregationQuery")).e(true).c(yb.b.b(w.c0())).d(yb.b.b(x.a0())).a();
                    f3228c = z0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z0VarA;
    }

    public static z0 e() {
        z0 z0VarA;
        z0 z0Var = f3229d;
        if (z0Var != null) {
            return z0Var;
        }
        synchronized (r.class) {
            try {
                z0VarA = f3229d;
                if (z0VarA == null) {
                    z0VarA = z0.g().f(z0.d.BIDI_STREAMING).b(z0.b("google.firestore.v1.Firestore", "Write")).e(true).c(yb.b.b(f0.f0())).d(yb.b.b(g0.b0())).a();
                    f3229d = z0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z0VarA;
    }

    public static b f(rb.d dVar) {
        return (b) zb.a.g(new a(), dVar);
    }
}
