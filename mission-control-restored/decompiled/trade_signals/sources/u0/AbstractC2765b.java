package u0;

import A2.f;
import B5.k;
import Y6.T;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;
import y.AbstractC2966c;

/* JADX INFO: renamed from: u0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2765b {

    /* JADX INFO: renamed from: u0.b$a */
    public static final class a extends AbstractC2306v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2966c.a f23501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f23502b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC2966c.a aVar, T t8) {
            super(1);
            this.f23501a = aVar;
            this.f23502b = t8;
        }

        public final void a(Throwable th) {
            if (th == null) {
                this.f23501a.b(this.f23502b.f());
            } else if (th instanceof CancellationException) {
                this.f23501a.c();
            } else {
                this.f23501a.e(th);
            }
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C2470H.f21956a;
        }
    }

    public static final f b(final T t8, final Object obj) {
        AbstractC2304t.f(t8, "<this>");
        f fVarA = AbstractC2966c.a(new AbstractC2966c.InterfaceC0432c() { // from class: u0.a
            @Override // y.AbstractC2966c.InterfaceC0432c
            public final Object a(AbstractC2966c.a aVar) {
                return AbstractC2765b.d(t8, obj, aVar);
            }
        });
        AbstractC2304t.e(fVarA, "getFuture { completer ->…      }\n        tag\n    }");
        return fVarA;
    }

    public static /* synthetic */ f c(T t8, Object obj, int i8, Object obj2) {
        if ((i8 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(t8, obj);
    }

    public static final Object d(T this_asListenableFuture, Object obj, AbstractC2966c.a completer) {
        AbstractC2304t.f(this_asListenableFuture, "$this_asListenableFuture");
        AbstractC2304t.f(completer, "completer");
        this_asListenableFuture.E(new a(completer, this_asListenableFuture));
        return obj;
    }
}
