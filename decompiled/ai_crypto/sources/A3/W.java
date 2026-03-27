package A3;

import A3.X;
import K3.AbstractC0612b;
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
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class W extends Task {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f144a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public X f145b = X.f151g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource f146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Task f147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue f148e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d0 f150b;

        public a(Executor executor, d0 d0Var) {
            this.f149a = executor == null ? TaskExecutors.MAIN_THREAD : executor;
            this.f150b = d0Var;
        }

        public void b(final X x7) {
            this.f149a.execute(new Runnable() { // from class: A3.V
                @Override // java.lang.Runnable
                public final void run() {
                    this.f142a.c(x7);
                }
            });
        }

        public final /* synthetic */ void c(X x7) {
            this.f150b.a(x7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f150b.equals(((a) obj).f150b);
        }

        public int hashCode() {
            return this.f150b.hashCode();
        }
    }

    public W() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f146c = taskCompletionSource;
        this.f147d = taskCompletionSource.getTask();
        this.f148e = new ArrayDeque();
    }

    public W a(d0 d0Var) {
        a aVar = new a(null, d0Var);
        synchronized (this.f144a) {
            this.f148e.add(aVar);
        }
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return this.f147d.addOnCanceledListener(onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        return this.f147d.addOnCompleteListener(onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnFailureListener(OnFailureListener onFailureListener) {
        return this.f147d.addOnFailureListener(onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        return this.f147d.addOnSuccessListener(onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public X getResult() {
        return (X) this.f147d.getResult();
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public X getResult(Class cls) {
        return (X) this.f147d.getResult(cls);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWith(Continuation continuation) {
        return this.f147d.continueWith(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWithTask(Continuation continuation) {
        return this.f147d.continueWithTask(continuation);
    }

    public void d(Exception exc) {
        synchronized (this.f144a) {
            try {
                X x7 = new X(this.f145b.d(), this.f145b.g(), this.f145b.c(), this.f145b.f(), exc, X.a.ERROR);
                this.f145b = x7;
                Iterator it = this.f148e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(x7);
                }
                this.f148e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f146c.setException(exc);
    }

    public void e(X x7) {
        AbstractC0612b.d(x7.e().equals(X.a.SUCCESS), "Expected success, but was " + x7.e(), new Object[0]);
        synchronized (this.f144a) {
            try {
                this.f145b = x7;
                Iterator it = this.f148e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(this.f145b);
                }
                this.f148e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f146c.setResult(x7);
    }

    public void f(X x7) {
        synchronized (this.f144a) {
            try {
                this.f145b = x7;
                Iterator it = this.f148e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b(x7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        return this.f147d.getException();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return this.f147d.isCanceled();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return this.f147d.isComplete();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return this.f147d.isSuccessful();
    }

    @Override // com.google.android.gms.tasks.Task
    public Task onSuccessTask(SuccessContinuation successContinuation) {
        return this.f147d.onSuccessTask(successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return this.f147d.addOnCanceledListener(executor, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        return this.f147d.addOnCompleteListener(executor, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return this.f147d.addOnFailureListener(executor, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        return this.f147d.addOnSuccessListener(executor, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWith(Executor executor, Continuation continuation) {
        return this.f147d.continueWith(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWithTask(Executor executor, Continuation continuation) {
        return this.f147d.continueWithTask(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        return this.f147d.onSuccessTask(executor, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        return this.f147d.addOnCanceledListener(activity, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        return this.f147d.addOnCompleteListener(activity, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        return this.f147d.addOnFailureListener(activity, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        return this.f147d.addOnSuccessListener(activity, onSuccessListener);
    }
}
