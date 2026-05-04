package ib;

import rb.z0;
import zb.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile z0 f12281a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements c.a {
        @Override // zb.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(rb.d dVar, rb.c cVar) {
            return new b(dVar, cVar, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends zb.b {
        public /* synthetic */ b(rb.d dVar, rb.c cVar, f fVar) {
            this(dVar, cVar);
        }

        @Override // zb.c
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b a(rb.d dVar, rb.c cVar) {
            return new b(dVar, cVar);
        }

        public e j(d dVar) {
            return (e) zb.d.b(c(), g.a(), b(), dVar);
        }

        public b(rb.d dVar, rb.c cVar) {
            super(dVar, cVar);
        }
    }

    public static z0 a() {
        z0 z0VarA;
        z0 z0Var = f12281a;
        if (z0Var != null) {
            return z0Var;
        }
        synchronized (g.class) {
            try {
                z0VarA = f12281a;
                if (z0VarA == null) {
                    z0VarA = z0.g().f(z0.d.UNARY).b(z0.b("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", "FetchEligibleCampaigns")).e(true).c(yb.b.b(d.g0())).d(yb.b.b(e.b0())).a();
                    f12281a = z0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z0VarA;
    }

    public static b b(rb.d dVar) {
        return (b) zb.b.g(new a(), dVar);
    }
}
