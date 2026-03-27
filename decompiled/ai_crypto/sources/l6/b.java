package l6;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import I5.c;
import J5.h;
import Q5.k;
import b6.C1087p;
import b6.InterfaceC1085o;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    public static final class a implements OnCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1085o f18508a;

        public a(InterfaceC1085o interfaceC1085o) {
            this.f18508a = interfaceC1085o;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            Exception exception = task.getException();
            if (exception != null) {
                InterfaceC1085o interfaceC1085o = this.f18508a;
                p.a aVar = p.f1681b;
                interfaceC1085o.resumeWith(p.b(q.a(exception)));
            } else {
                if (task.isCanceled()) {
                    InterfaceC1085o.a.a(this.f18508a, null, 1, null);
                    return;
                }
                InterfaceC1085o interfaceC1085o2 = this.f18508a;
                p.a aVar2 = p.f1681b;
                interfaceC1085o2.resumeWith(p.b(task.getResult()));
            }
        }
    }

    /* JADX INFO: renamed from: l6.b$b, reason: collision with other inner class name */
    public static final class C0305b extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationTokenSource f18509a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0305b(CancellationTokenSource cancellationTokenSource) {
            super(1);
            this.f18509a = cancellationTokenSource;
        }

        public final void a(Throwable th) {
            this.f18509a.cancel();
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f1657a;
        }
    }

    public static final Object a(Task task, d dVar) {
        return b(task, null, dVar);
    }

    public static final Object b(Task task, CancellationTokenSource cancellationTokenSource, d dVar) throws Exception {
        if (!task.isComplete()) {
            C1087p c1087p = new C1087p(I5.b.c(dVar), 1);
            c1087p.A();
            task.addOnCompleteListener(l6.a.f18507a, new a(c1087p));
            if (cancellationTokenSource != null) {
                c1087p.g(new C0305b(cancellationTokenSource));
            }
            Object objX = c1087p.x();
            if (objX == c.e()) {
                h.c(dVar);
            }
            return objX;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
