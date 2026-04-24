package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.E;
import com.google.firebase.storage.L;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class E extends AbstractC1217c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f12327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f12328k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12329a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f12330b = new L(this, 128, new L.a() { // from class: com.google.firebase.storage.r
        @Override // com.google.firebase.storage.L.a
        public final void a(Object obj, Object obj2) {
            this.f12497a.P((OnSuccessListener) obj, (E.a) obj2);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final L f12331c = new L(this, 64, new L.a() { // from class: com.google.firebase.storage.v
        @Override // com.google.firebase.storage.L.a
        public final void a(Object obj, Object obj2) {
            this.f12501a.Q((OnFailureListener) obj, (E.a) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L f12332d = new L(this, 448, new L.a() { // from class: com.google.firebase.storage.w
        @Override // com.google.firebase.storage.L.a
        public final void a(Object obj, Object obj2) {
            this.f12502a.R((OnCompleteListener) obj, (E.a) obj2);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final L f12333e = new L(this, 256, new L.a() { // from class: com.google.firebase.storage.x
        @Override // com.google.firebase.storage.L.a
        public final void a(Object obj, Object obj2) {
            this.f12503a.S((OnCanceledListener) obj, (E.a) obj2);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final L f12334f = new L(this, -465, new L.a() { // from class: com.google.firebase.storage.y
        @Override // com.google.firebase.storage.L.a
        public final void a(Object obj, Object obj2) {
            ((InterfaceC1227m) obj).a((E.a) obj2);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final L f12335g = new L(this, 16, new L.a() { // from class: com.google.firebase.storage.z
        @Override // com.google.firebase.storage.L.a
        public final void a(Object obj, Object obj2) {
            ((InterfaceC1226l) obj).a((E.a) obj2);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f12336h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f12337i;

    public interface a {
        Exception a();
    }

    public class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Exception f12338a;

        public b(Exception exc) {
            if (exc != null) {
                this.f12338a = exc;
                return;
            }
            if (E.this.isCanceled()) {
                this.f12338a = C1228n.c(Status.f10842j);
            } else if (E.this.B() == 64) {
                this.f12338a = C1228n.c(Status.f10840h);
            } else {
                this.f12338a = null;
            }
        }

        @Override // com.google.firebase.storage.E.a
        public Exception a() {
            return this.f12338a;
        }

        public p b() {
            return c().I();
        }

        public E c() {
            return E.this;
        }
    }

    static {
        HashMap map = new HashMap();
        f12327j = map;
        HashMap map2 = new HashMap();
        f12328k = map2;
        map.put(1, new HashSet(Arrays.asList(16, 256)));
        map.put(2, new HashSet(Arrays.asList(8, 32)));
        map.put(4, new HashSet(Arrays.asList(8, 32)));
        map.put(16, new HashSet(Arrays.asList(2, 256)));
        map.put(64, new HashSet(Arrays.asList(2, 256)));
        map2.put(1, new HashSet(Arrays.asList(2, 64)));
        map2.put(2, new HashSet(Arrays.asList(4, 64, 128)));
        map2.put(4, new HashSet(Arrays.asList(4, 64, 128)));
        map2.put(8, new HashSet(Arrays.asList(16, 64, 128)));
        map2.put(32, new HashSet(Arrays.asList(256, 64, 128)));
    }

    public static /* synthetic */ void T(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, a aVar) {
        try {
            Task taskThen = successContinuation.then(aVar);
            Objects.requireNonNull(taskCompletionSource);
            taskThen.addOnSuccessListener(new s(taskCompletionSource));
            taskThen.addOnFailureListener(new t(taskCompletionSource));
            Objects.requireNonNull(cancellationTokenSource);
            taskThen.addOnCanceledListener(new u(cancellationTokenSource));
        } catch (RuntimeExecutionException e7) {
            if (e7.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e7.getCause());
            } else {
                taskCompletionSource.setException(e7);
            }
        } catch (Exception e8) {
            taskCompletionSource.setException(e8);
        }
    }

    public final a A() {
        a aVar = this.f12337i;
        if (aVar != null) {
            return aVar;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.f12337i == null) {
            this.f12337i = g0();
        }
        return this.f12337i;
    }

    public int B() {
        return this.f12336h;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a getResult() {
        if (A() == null) {
            throw new IllegalStateException();
        }
        Exception excA = A().a();
        if (excA == null) {
            return A();
        }
        throw new RuntimeExecutionException(excA);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a getResult(Class cls) throws Throwable {
        if (A() == null) {
            throw new IllegalStateException();
        }
        if (cls.isInstance(A().a())) {
            throw ((Throwable) cls.cast(A().a()));
        }
        Exception excA = A().a();
        if (excA == null) {
            return A();
        }
        throw new RuntimeExecutionException(excA);
    }

    public Runnable E() {
        return new Runnable() { // from class: com.google.firebase.storage.B
            @Override // java.lang.Runnable
            public final void run() {
                this.f12319a.O();
            }
        };
    }

    public a F() {
        return g0();
    }

    public final String G(int i7) {
        return i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 8 ? i7 != 16 ? i7 != 32 ? i7 != 64 ? i7 != 128 ? i7 != 256 ? "Unknown Internal State!" : "INTERNAL_STATE_CANCELED" : "INTERNAL_STATE_SUCCESS" : "INTERNAL_STATE_FAILURE" : "INTERNAL_STATE_CANCELING" : "INTERNAL_STATE_PAUSED" : "INTERNAL_STATE_PAUSING" : "INTERNAL_STATE_IN_PROGRESS" : "INTERNAL_STATE_QUEUED" : "INTERNAL_STATE_NOT_STARTED";
    }

    public final String H(int[] iArr) {
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 : iArr) {
            sb.append(G(i7));
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public abstract p I();

    public Object J() {
        return this.f12329a;
    }

    public boolean K() {
        return (B() & (-465)) != 0;
    }

    public boolean L() {
        return (B() & 16) != 0;
    }

    public final /* synthetic */ void M(Continuation continuation, TaskCompletionSource taskCompletionSource, Task task) {
        try {
            Object objThen = continuation.then(this);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            taskCompletionSource.setResult(objThen);
        } catch (RuntimeExecutionException e7) {
            if (e7.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e7.getCause());
            } else {
                taskCompletionSource.setException(e7);
            }
        } catch (Exception e8) {
            taskCompletionSource.setException(e8);
        }
    }

    public final /* synthetic */ void N(Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, Task task) {
        try {
            Task task2 = (Task) continuation.then(this);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            if (task2 == null) {
                taskCompletionSource.setException(new NullPointerException("Continuation returned null"));
                return;
            }
            task2.addOnSuccessListener(new s(taskCompletionSource));
            task2.addOnFailureListener(new t(taskCompletionSource));
            Objects.requireNonNull(cancellationTokenSource);
            task2.addOnCanceledListener(new u(cancellationTokenSource));
        } catch (RuntimeExecutionException e7) {
            if (e7.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e7.getCause());
            } else {
                taskCompletionSource.setException(e7);
            }
        } catch (Exception e8) {
            taskCompletionSource.setException(e8);
        }
    }

    public final /* synthetic */ void O() {
        try {
            e0();
        } finally {
            z();
        }
    }

    public final /* synthetic */ void P(OnSuccessListener onSuccessListener, a aVar) {
        F.b().c(this);
        onSuccessListener.onSuccess(aVar);
    }

    public final /* synthetic */ void Q(OnFailureListener onFailureListener, a aVar) {
        F.b().c(this);
        onFailureListener.onFailure(aVar.a());
    }

    public final /* synthetic */ void R(OnCompleteListener onCompleteListener, a aVar) {
        F.b().c(this);
        onCompleteListener.onComplete(this);
    }

    public final /* synthetic */ void S(OnCanceledListener onCanceledListener, a aVar) {
        F.b().c(this);
        onCanceledListener.onCanceled();
    }

    public void U() {
    }

    public void V() {
    }

    public void W() {
    }

    public void X() {
    }

    public void Y() {
    }

    public void Z() {
    }

    public boolean a0() {
        return k0(new int[]{16, 8}, true);
    }

    public boolean b0() {
        if (!j0(2, false)) {
            return false;
        }
        f0();
        return true;
    }

    public void c0() {
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWith(Continuation continuation) {
        return x(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWithTask(Continuation continuation) {
        return y(null, continuation);
    }

    public boolean d0() {
        if (!j0(2, true)) {
            return false;
        }
        c0();
        f0();
        return true;
    }

    public abstract void e0();

    public abstract void f0();

    public a g0() {
        a aVarH0;
        synchronized (this.f12329a) {
            aVarH0 = h0();
        }
        return aVarH0;
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        if (A() == null) {
            return null;
        }
        return A().a();
    }

    public abstract a h0();

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public E addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        AbstractC1207s.k(onCanceledListener);
        AbstractC1207s.k(activity);
        this.f12333e.d(activity, null, onCanceledListener);
        return this;
    }

    public final Task i0(Executor executor, final SuccessContinuation successContinuation) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f12330b.d(null, executor, new OnSuccessListener() { // from class: com.google.firebase.storage.D
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                E.T(successContinuation, taskCompletionSource, cancellationTokenSource, (E.a) obj);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return B() == 256;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return (B() & 448) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return (B() & 128) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public E addOnCanceledListener(OnCanceledListener onCanceledListener) {
        AbstractC1207s.k(onCanceledListener);
        this.f12333e.d(null, null, onCanceledListener);
        return this;
    }

    public boolean j0(int i7, boolean z7) {
        return k0(new int[]{i7}, z7);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public E addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        AbstractC1207s.k(onCanceledListener);
        AbstractC1207s.k(executor);
        this.f12333e.d(null, executor, onCanceledListener);
        return this;
    }

    public boolean k0(int[] iArr, boolean z7) {
        HashMap map = z7 ? f12327j : f12328k;
        synchronized (this.f12329a) {
            try {
                for (int i7 : iArr) {
                    HashSet hashSet = (HashSet) map.get(Integer.valueOf(B()));
                    if (hashSet != null && hashSet.contains(Integer.valueOf(i7))) {
                        this.f12336h = i7;
                        int i8 = this.f12336h;
                        if (i8 == 2) {
                            F.b().a(this);
                            Y();
                        } else if (i8 == 4) {
                            X();
                        } else if (i8 == 16) {
                            W();
                        } else if (i8 == 64) {
                            V();
                        } else if (i8 == 128) {
                            Z();
                        } else if (i8 == 256) {
                            U();
                        }
                        this.f12330b.h();
                        this.f12331c.h();
                        this.f12333e.h();
                        this.f12332d.h();
                        this.f12335g.h();
                        this.f12334f.h();
                        if (Log.isLoggable("StorageTask", 3)) {
                            Log.d("StorageTask", "changed internal state to: " + G(i7) + " isUser: " + z7 + " from state:" + G(this.f12336h));
                        }
                        return true;
                    }
                }
                Log.w("StorageTask", "unable to change internal state to: " + H(iArr) + " isUser: " + z7 + " from state:" + G(this.f12336h));
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public E addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        AbstractC1207s.k(onCompleteListener);
        AbstractC1207s.k(activity);
        this.f12332d.d(activity, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public E addOnCompleteListener(OnCompleteListener onCompleteListener) {
        AbstractC1207s.k(onCompleteListener);
        this.f12332d.d(null, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public E addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        AbstractC1207s.k(onCompleteListener);
        AbstractC1207s.k(executor);
        this.f12332d.d(null, executor, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public E addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        AbstractC1207s.k(onFailureListener);
        AbstractC1207s.k(activity);
        this.f12331c.d(activity, null, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public Task onSuccessTask(SuccessContinuation successContinuation) {
        return i0(null, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public E addOnFailureListener(OnFailureListener onFailureListener) {
        AbstractC1207s.k(onFailureListener);
        this.f12331c.d(null, null, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public E addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        AbstractC1207s.k(onFailureListener);
        AbstractC1207s.k(executor);
        this.f12331c.d(null, executor, onFailureListener);
        return this;
    }

    public E r(InterfaceC1226l interfaceC1226l) {
        AbstractC1207s.k(interfaceC1226l);
        this.f12335g.d(null, null, interfaceC1226l);
        return this;
    }

    public E s(InterfaceC1227m interfaceC1227m) {
        AbstractC1207s.k(interfaceC1227m);
        this.f12334f.d(null, null, interfaceC1227m);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public E addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        AbstractC1207s.k(activity);
        AbstractC1207s.k(onSuccessListener);
        this.f12330b.d(activity, null, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public E addOnSuccessListener(OnSuccessListener onSuccessListener) {
        AbstractC1207s.k(onSuccessListener);
        this.f12330b.d(null, null, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public E addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        AbstractC1207s.k(executor);
        AbstractC1207s.k(onSuccessListener);
        this.f12330b.d(null, executor, onSuccessListener);
        return this;
    }

    public boolean w() {
        return k0(new int[]{256, 32}, true);
    }

    public final Task x(Executor executor, final Continuation continuation) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f12332d.d(null, executor, new OnCompleteListener() { // from class: com.google.firebase.storage.A
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12316a.M(continuation, taskCompletionSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task y(Executor executor, final Continuation continuation) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f12332d.d(null, executor, new OnCompleteListener() { // from class: com.google.firebase.storage.C
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12320a.N(continuation, taskCompletionSource, cancellationTokenSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final void z() {
        if (isComplete() || L() || B() == 2 || j0(256, false)) {
            return;
        }
        j0(64, false);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWith(Executor executor, Continuation continuation) {
        return x(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task continueWithTask(Executor executor, Continuation continuation) {
        return y(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        return i0(executor, successContinuation);
    }
}
