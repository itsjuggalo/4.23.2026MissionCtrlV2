package f2;

import cd.h0;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import ng.u0;
import pd.k;
import u6.f;
import y.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f9303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u0 f9304b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.a aVar, u0 u0Var) {
            super(1);
            this.f9303a = aVar;
            this.f9304b = u0Var;
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h0.f3852a;
        }

        public final void invoke(Throwable th) {
            if (th == null) {
                this.f9303a.b(this.f9304b.getCompleted());
            } else if (th instanceof CancellationException) {
                this.f9303a.c();
            } else {
                this.f9303a.e(th);
            }
        }
    }

    public static final f b(final u0 u0Var, final Object obj) {
        t.f(u0Var, "<this>");
        f fVarA = c.a(new c.InterfaceC0465c() { // from class: f2.a
            @Override // y.c.InterfaceC0465c
            public final Object a(c.a aVar) {
                return b.d(u0Var, obj, aVar);
            }
        });
        t.e(fVarA, "getFuture { completer ->…      }\n        tag\n    }");
        return fVarA;
    }

    public static /* synthetic */ f c(u0 u0Var, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(u0Var, obj);
    }

    public static final Object d(u0 this_asListenableFuture, Object obj, c.a completer) {
        t.f(this_asListenableFuture, "$this_asListenableFuture");
        t.f(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new a(completer, this_asListenableFuture));
        return obj;
    }
}
