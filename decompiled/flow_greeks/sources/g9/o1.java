package g9;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.f;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n9.g f10317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m9.s0 f10318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n9.t f10319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n9.r f10321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TaskCompletionSource f10322f = new TaskCompletionSource();

    public o1(n9.g gVar, m9.s0 s0Var, d9.w1 w1Var, n9.t tVar) {
        this.f10317a = gVar;
        this.f10318b = s0Var;
        this.f10319c = tVar;
        this.f10320d = w1Var.a();
        this.f10321e = new n9.r(gVar, g.d.RETRY_TRANSACTION);
    }

    public static /* synthetic */ void a(final o1 o1Var, k1 k1Var, final Task task) {
        o1Var.getClass();
        if (task.isSuccessful()) {
            k1Var.c().addOnCompleteListener(o1Var.f10317a.o(), new OnCompleteListener() { // from class: g9.n1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    o1.c(this.f10292a, task, task2);
                }
            });
        } else {
            o1Var.d(task);
        }
    }

    public static /* synthetic */ void b(final o1 o1Var) {
        final k1 k1VarP = o1Var.f10318b.p();
        ((Task) o1Var.f10319c.apply(k1VarP)).addOnCompleteListener(o1Var.f10317a.o(), new OnCompleteListener() { // from class: g9.m1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                o1.a(this.f10287a, k1VarP, task);
            }
        });
    }

    public static /* synthetic */ void c(o1 o1Var, Task task, Task task2) {
        o1Var.getClass();
        if (task2.isSuccessful()) {
            o1Var.f10322f.setResult(task.getResult());
        } else {
            o1Var.d(task2);
        }
    }

    public static boolean e(Exception exc) {
        if (!(exc instanceof com.google.firebase.firestore.f)) {
            return false;
        }
        com.google.firebase.firestore.f fVar = (com.google.firebase.firestore.f) exc;
        f.a aVarA = fVar.a();
        return aVarA == f.a.ABORTED || aVarA == f.a.ALREADY_EXISTS || aVarA == f.a.FAILED_PRECONDITION || !m9.q.h(fVar.a());
    }

    public final void d(Task task) {
        if (this.f10320d <= 0 || !e(task.getException())) {
            this.f10322f.setException(task.getException());
        } else {
            g();
        }
    }

    public Task f() {
        g();
        return this.f10322f.getTask();
    }

    public final void g() {
        this.f10320d--;
        this.f10321e.b(new Runnable() { // from class: g9.l1
            @Override // java.lang.Runnable
            public final void run() {
                o1.b(this.f10276a);
            }
        });
    }
}
