package D3;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import b3.h;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import i3.k;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.s;
import t3.C1832p;
import t3.InterfaceC1830o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    public static final class a implements OnCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1830o f326a;

        public a(InterfaceC1830o interfaceC1830o) {
            this.f326a = interfaceC1830o;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            Exception exception = task.getException();
            if (exception != null) {
                InterfaceC1830o interfaceC1830o = this.f326a;
                p.a aVar = p.f5487b;
                interfaceC1830o.resumeWith(p.b(q.a(exception)));
            } else {
                if (task.isCanceled()) {
                    InterfaceC1830o.a.a(this.f326a, null, 1, null);
                    return;
                }
                InterfaceC1830o interfaceC1830o2 = this.f326a;
                p.a aVar2 = p.f5487b;
                interfaceC1830o2.resumeWith(p.b(task.getResult()));
            }
        }
    }

    /* JADX INFO: renamed from: D3.b$b, reason: collision with other inner class name */
    public static final class C0013b extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationTokenSource f327a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0013b(CancellationTokenSource cancellationTokenSource) {
            super(1);
            this.f327a = cancellationTokenSource;
        }

        public final void a(Throwable th) {
            this.f327a.cancel();
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f5463a;
        }
    }

    public static final Object a(Task task, e eVar) {
        return b(task, null, eVar);
    }

    public static final Object b(Task task, CancellationTokenSource cancellationTokenSource, e eVar) throws Exception {
        if (!task.isComplete()) {
            C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
            c1832p.A();
            task.addOnCompleteListener(D3.a.f325a, new a(c1832p));
            if (cancellationTokenSource != null) {
                c1832p.g(new C0013b(cancellationTokenSource));
            }
            Object objX = c1832p.x();
            if (objX == AbstractC0787c.e()) {
                h.c(eVar);
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
