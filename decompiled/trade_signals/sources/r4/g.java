package r4;

import F4.AbstractC0490d;
import F4.C0489c;
import F4.Y;
import M4.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Y f22919a;

    public class a implements b.a {
        @Override // M4.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(AbstractC0490d abstractC0490d, C0489c c0489c) {
            return new b(abstractC0490d, c0489c, null);
        }
    }

    public static final class b extends M4.a {
        public b(AbstractC0490d abstractC0490d, C0489c c0489c) {
            super(abstractC0490d, c0489c);
        }

        @Override // M4.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b a(AbstractC0490d abstractC0490d, C0489c c0489c) {
            return new b(abstractC0490d, c0489c);
        }

        public e h(d dVar) {
            return (e) M4.c.b(c(), g.a(), b(), dVar);
        }

        public /* synthetic */ b(AbstractC0490d abstractC0490d, C0489c c0489c, f fVar) {
            this(abstractC0490d, c0489c);
        }
    }

    public static Y a() {
        Y yA = f22919a;
        if (yA == null) {
            synchronized (g.class) {
                try {
                    yA = f22919a;
                    if (yA == null) {
                        yA = Y.g().f(Y.d.UNARY).b(Y.b("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", "FetchEligibleCampaigns")).e(true).c(L4.b.b(d.Y())).d(L4.b.b(e.T())).a();
                        f22919a = yA;
                    }
                } finally {
                }
            }
        }
        return yA;
    }

    public static b b(AbstractC0490d abstractC0490d) {
        return (b) M4.a.e(new a(), abstractC0490d);
    }
}
