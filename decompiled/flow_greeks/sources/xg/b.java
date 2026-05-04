package xg;

import cd.h0;
import cd.r;
import cd.s;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import gd.e;
import hd.c;
import id.h;
import java.util.concurrent.CancellationException;
import ng.n;
import ng.p;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements OnCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f25111a;

        public a(n nVar) {
            this.f25111a = nVar;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            Exception exception = task.getException();
            if (exception != null) {
                n nVar = this.f25111a;
                r.a aVar = r.f3870b;
                nVar.resumeWith(r.b(s.a(exception)));
            } else {
                if (task.isCanceled()) {
                    n.a.a(this.f25111a, null, 1, null);
                    return;
                }
                n nVar2 = this.f25111a;
                r.a aVar2 = r.f3870b;
                nVar2.resumeWith(r.b(task.getResult()));
            }
        }
    }

    /* JADX INFO: renamed from: xg.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0462b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationTokenSource f25112a;

        public C0462b(CancellationTokenSource cancellationTokenSource) {
            this.f25112a = cancellationTokenSource;
        }

        public final void a(Throwable th) {
            this.f25112a.cancel();
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return h0.f3852a;
        }
    }

    public static final Object a(Task task, e eVar) {
        return b(task, null, eVar);
    }

    public static final Object b(Task task, CancellationTokenSource cancellationTokenSource, e eVar) throws Exception {
        if (!task.isComplete()) {
            p pVar = new p(hd.b.c(eVar), 1);
            pVar.E();
            task.addOnCompleteListener(xg.a.f25110a, new a(pVar));
            if (cancellationTokenSource != null) {
                pVar.f(new C0462b(cancellationTokenSource));
            }
            Object objY = pVar.y();
            if (objY == c.f()) {
                h.c(eVar);
            }
            return objY;
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
