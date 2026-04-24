package z0;

import E5.E;
import M2.e;
import Q5.k;
import b6.T;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import v.AbstractC2760c;

/* JADX INFO: renamed from: z0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2852b {

    /* JADX INFO: renamed from: z0.b$a */
    public static final class a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2760c.a f25947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f25948b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC2760c.a aVar, T t7) {
            super(1);
            this.f25947a = aVar;
            this.f25948b = t7;
        }

        public final void a(Throwable th) {
            if (th == null) {
                this.f25947a.b(this.f25948b.getCompleted());
            } else if (th instanceof CancellationException) {
                this.f25947a.c();
            } else {
                this.f25947a.e(th);
            }
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f1657a;
        }
    }

    public static final e b(final T t7, final Object obj) {
        r.f(t7, "<this>");
        e eVarA = AbstractC2760c.a(new AbstractC2760c.InterfaceC0385c() { // from class: z0.a
            @Override // v.AbstractC2760c.InterfaceC0385c
            public final Object a(AbstractC2760c.a aVar) {
                return AbstractC2852b.d(t7, obj, aVar);
            }
        });
        r.e(eVarA, "getFuture { completer ->…      }\n        tag\n    }");
        return eVarA;
    }

    public static /* synthetic */ e c(T t7, Object obj, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(t7, obj);
    }

    public static final Object d(T this_asListenableFuture, Object obj, AbstractC2760c.a completer) {
        r.f(this_asListenableFuture, "$this_asListenableFuture");
        r.f(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new a(completer, this_asListenableFuture));
        return obj;
    }
}
