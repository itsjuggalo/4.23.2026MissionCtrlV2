package j0;

import W2.E;
import androidx.concurrent.futures.c;
import e2.InterfaceFutureC1233e;
import i3.k;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import t3.T;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static final class a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f13379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f13380b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.a aVar, T t4) {
            super(1);
            this.f13379a = aVar;
            this.f13380b = t4;
        }

        public final void a(Throwable th) {
            if (th == null) {
                this.f13379a.b(this.f13380b.getCompleted());
            } else if (th instanceof CancellationException) {
                this.f13379a.c();
            } else {
                this.f13379a.e(th);
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f5463a;
        }
    }

    public static final InterfaceFutureC1233e b(final T t4, final Object obj) {
        r.f(t4, "<this>");
        InterfaceFutureC1233e interfaceFutureC1233eA = c.a(new c.InterfaceC0099c() { // from class: j0.a
            @Override // androidx.concurrent.futures.c.InterfaceC0099c
            public final Object a(c.a aVar) {
                return b.d(t4, obj, aVar);
            }
        });
        r.e(interfaceFutureC1233eA, "getFuture { completer ->…      }\n        tag\n    }");
        return interfaceFutureC1233eA;
    }

    public static /* synthetic */ InterfaceFutureC1233e c(T t4, Object obj, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(t4, obj);
    }

    public static final Object d(T this_asListenableFuture, Object obj, c.a completer) {
        r.f(this_asListenableFuture, "$this_asListenableFuture");
        r.f(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new a(completer, this_asListenableFuture));
        return obj;
    }
}
