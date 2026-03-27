package p2;

import K2.AbstractC0356d;
import K2.C0355c;
import K2.a0;
import S2.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a0 f14072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a0 f14073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a0 f14074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a0 f14075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a0 f14076e;

    public class a implements b.a {
        @Override // S2.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(AbstractC0356d abstractC0356d, C0355c c0355c) {
            return new b(abstractC0356d, c0355c, null);
        }
    }

    public static final class b extends S2.a {
        public /* synthetic */ b(AbstractC0356d abstractC0356d, C0355c c0355c, a aVar) {
            this(abstractC0356d, c0355c);
        }

        @Override // S2.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b a(AbstractC0356d abstractC0356d, C0355c c0355c) {
            return new b(abstractC0356d, c0355c);
        }

        public b(AbstractC0356d abstractC0356d, C0355c c0355c) {
            super(abstractC0356d, c0355c);
        }
    }

    public static a0 a() {
        a0 a0VarA;
        a0 a0Var = f14072a;
        if (a0Var != null) {
            return a0Var;
        }
        synchronized (r.class) {
            try {
                a0VarA = f14072a;
                if (a0VarA == null) {
                    a0VarA = a0.g().f(a0.d.SERVER_STREAMING).b(a0.b("google.firestore.v1.Firestore", "BatchGetDocuments")).e(true).c(R2.b.b(C1707d.o())).d(R2.b.b(C1708e.k())).a();
                    f14072a = a0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0VarA;
    }

    public static a0 b() {
        a0 a0VarA;
        a0 a0Var = f14073b;
        if (a0Var != null) {
            return a0Var;
        }
        synchronized (r.class) {
            try {
                a0VarA = f14073b;
                if (a0VarA == null) {
                    a0VarA = a0.g().f(a0.d.UNARY).b(a0.b("google.firestore.v1.Firestore", "Commit")).e(true).c(R2.b.b(C1711h.m())).d(R2.b.b(C1712i.l())).a();
                    f14073b = a0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0VarA;
    }

    public static a0 c() {
        a0 a0VarA;
        a0 a0Var = f14076e;
        if (a0Var != null) {
            return a0Var;
        }
        synchronized (r.class) {
            try {
                a0VarA = f14076e;
                if (a0VarA == null) {
                    a0VarA = a0.g().f(a0.d.BIDI_STREAMING).b(a0.b("google.firestore.v1.Firestore", "Listen")).e(true).c(R2.b.b(s.o())).d(R2.b.b(t.k())).a();
                    f14076e = a0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0VarA;
    }

    public static a0 d() {
        a0 a0VarA;
        a0 a0Var = f14074c;
        if (a0Var != null) {
            return a0Var;
        }
        synchronized (r.class) {
            try {
                a0VarA = f14074c;
                if (a0VarA == null) {
                    a0VarA = a0.g().f(a0.d.SERVER_STREAMING).b(a0.b("google.firestore.v1.Firestore", "RunAggregationQuery")).e(true).c(R2.b.b(w.m())).d(R2.b.b(x.k())).a();
                    f14074c = a0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0VarA;
    }

    public static a0 e() {
        a0 a0VarA;
        a0 a0Var = f14075d;
        if (a0Var != null) {
            return a0Var;
        }
        synchronized (r.class) {
            try {
                a0VarA = f14075d;
                if (a0VarA == null) {
                    a0VarA = a0.g().f(a0.d.BIDI_STREAMING).b(a0.b("google.firestore.v1.Firestore", "Write")).e(true).c(R2.b.b(C1701G.n())).d(R2.b.b(C1702H.l())).a();
                    f14075d = a0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0VarA;
    }

    public static b f(AbstractC0356d abstractC0356d) {
        return (b) S2.a.e(new a(), abstractC0356d);
    }
}
