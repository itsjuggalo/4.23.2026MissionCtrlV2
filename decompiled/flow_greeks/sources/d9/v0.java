package d9;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import d9.w0;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7951a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w0 f7952b = w0.f7961g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource f7953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Task f7954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue f7955e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f7956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c1 f7957b;

        public a(Executor executor, c1 c1Var) {
            this.f7956a = executor == null ? TaskExecutors.MAIN_THREAD : executor;
            this.f7957b = c1Var;
        }

        public void b(final w0 w0Var) {
            this.f7956a.execute(new Runnable() { // from class: d9.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7949a.f7957b.a(w0Var);
                }
            });
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f7957b.equals(((a) obj).f7957b);
        }

        public int hashCode() {
            return this.f7957b.hashCode();
        }
    }

    public v0() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7953c = taskCompletionSource;
        this.f7954d = taskCompletionSource.getTask();
        this.f7955e = new ArrayDeque();
    }

    public v0 a(c1 c1Var) {
        a aVar = new a(null, c1Var);
        synchronized (this.f7951a) {
            this.f7955e.add(aVar);
        }
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return this.f7954d.addOnCanceledListener(onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        return this.f7954d.addOnCompleteListener(onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnFailureListener(OnFailureListener onFailureListener) {
        return this.f7954d.addOnFailureListener(onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        return this.f7954d.addOnSuccessListener(onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public w0 getResult() {
        return (w0) this.f7954d.getResult();
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public w0 getResult(Class cls) {
        return (w0) this.f7954d.getResult(cls);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWith(Continuation continuation) {
        return this.f7954d.continueWith(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWithTask(Continuation continuation) {
        return this.f7954d.continueWithTask(continuation);
    }

    public void d(Exception exc) {
        synchronized (this.f7951a) {
            try {
                w0 w0Var = new w0(this.f7952b.d(), this.f7952b.g(), this.f7952b.c(), this.f7952b.f(), exc, w0.a.ERROR);
                this.f7952b = w0Var;
                Iterator it = this.f7955e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(w0Var);
                }
                this.f7955e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f7953c.setException(exc);
    }

    public void e(w0 w0Var) {
        n9.b.d(w0Var.e().equals(w0.a.SUCCESS), "Expected success, but was " + w0Var.e(), new Object[0]);
        synchronized (this.f7951a) {
            try {
                this.f7952b = w0Var;
                Iterator it = this.f7955e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(this.f7952b);
                }
                this.f7955e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f7953c.setResult(w0Var);
    }

    public void f(w0 w0Var) {
        synchronized (this.f7951a) {
            try {
                this.f7952b = w0Var;
                Iterator it = this.f7955e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(w0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        return this.f7954d.getException();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return this.f7954d.isCanceled();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return this.f7954d.isComplete();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return this.f7954d.isSuccessful();
    }

    @Override // com.google.android.gms.tasks.Task
    public Task onSuccessTask(SuccessContinuation successContinuation) {
        return this.f7954d.onSuccessTask(successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return this.f7954d.addOnCanceledListener(executor, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        return this.f7954d.addOnCompleteListener(executor, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return this.f7954d.addOnFailureListener(executor, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        return this.f7954d.addOnSuccessListener(executor, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWith(Executor executor, Continuation continuation) {
        return this.f7954d.continueWith(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWithTask(Executor executor, Continuation continuation) {
        return this.f7954d.continueWithTask(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        return this.f7954d.onSuccessTask(executor, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        return this.f7954d.addOnCanceledListener(activity, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        return this.f7954d.addOnCompleteListener(activity, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        return this.f7954d.addOnFailureListener(activity, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        return this.f7954d.addOnSuccessListener(activity, onSuccessListener);
    }
}
