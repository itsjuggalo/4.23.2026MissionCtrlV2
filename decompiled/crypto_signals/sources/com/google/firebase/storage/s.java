package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.internal.I;
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
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class s extends AbstractC0449b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f5596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f5597k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f5599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f5600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f5601d;
    public final z e;
    public r i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5598a = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z f5602f = new z(this, -465, new C2.c(20));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z f5603g = new z(this, 16, new C2.c(21));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f5604h = 1;

    static {
        HashMap map = new HashMap();
        f5596j = map;
        HashMap map2 = new HashMap();
        f5597k = map2;
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

    public s() {
        final int i = 0;
        this.f5599b = new z(this, 128, new y(this) { // from class: com.google.firebase.storage.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f5585b;

            {
                this.f5585b = this;
            }

            @Override // com.google.firebase.storage.y
            public final void a(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        s sVar = this.f5585b;
                        sVar.getClass();
                        t.f5605c.a(sVar);
                        ((OnSuccessListener) obj).onSuccess((r) obj2);
                        break;
                    case 1:
                        s sVar2 = this.f5585b;
                        sVar2.getClass();
                        t.f5605c.a(sVar2);
                        ((OnFailureListener) obj).onFailure(((r) obj2).f5594a);
                        break;
                    case 2:
                        s sVar3 = this.f5585b;
                        sVar3.getClass();
                        t.f5605c.a(sVar3);
                        ((OnCompleteListener) obj).onComplete(sVar3);
                        break;
                    default:
                        s sVar4 = this.f5585b;
                        sVar4.getClass();
                        t.f5605c.a(sVar4);
                        ((OnCanceledListener) obj).onCanceled();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f5600c = new z(this, 64, new y(this) { // from class: com.google.firebase.storage.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f5585b;

            {
                this.f5585b = this;
            }

            @Override // com.google.firebase.storage.y
            public final void a(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        s sVar = this.f5585b;
                        sVar.getClass();
                        t.f5605c.a(sVar);
                        ((OnSuccessListener) obj).onSuccess((r) obj2);
                        break;
                    case 1:
                        s sVar2 = this.f5585b;
                        sVar2.getClass();
                        t.f5605c.a(sVar2);
                        ((OnFailureListener) obj).onFailure(((r) obj2).f5594a);
                        break;
                    case 2:
                        s sVar3 = this.f5585b;
                        sVar3.getClass();
                        t.f5605c.a(sVar3);
                        ((OnCompleteListener) obj).onComplete(sVar3);
                        break;
                    default:
                        s sVar4 = this.f5585b;
                        sVar4.getClass();
                        t.f5605c.a(sVar4);
                        ((OnCanceledListener) obj).onCanceled();
                        break;
                }
            }
        });
        final int i7 = 2;
        this.f5601d = new z(this, 448, new y(this) { // from class: com.google.firebase.storage.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f5585b;

            {
                this.f5585b = this;
            }

            @Override // com.google.firebase.storage.y
            public final void a(Object obj, Object obj2) {
                switch (i7) {
                    case 0:
                        s sVar = this.f5585b;
                        sVar.getClass();
                        t.f5605c.a(sVar);
                        ((OnSuccessListener) obj).onSuccess((r) obj2);
                        break;
                    case 1:
                        s sVar2 = this.f5585b;
                        sVar2.getClass();
                        t.f5605c.a(sVar2);
                        ((OnFailureListener) obj).onFailure(((r) obj2).f5594a);
                        break;
                    case 2:
                        s sVar3 = this.f5585b;
                        sVar3.getClass();
                        t.f5605c.a(sVar3);
                        ((OnCompleteListener) obj).onComplete(sVar3);
                        break;
                    default:
                        s sVar4 = this.f5585b;
                        sVar4.getClass();
                        t.f5605c.a(sVar4);
                        ((OnCanceledListener) obj).onCanceled();
                        break;
                }
            }
        });
        final int i8 = 3;
        this.e = new z(this, 256, new y(this) { // from class: com.google.firebase.storage.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f5585b;

            {
                this.f5585b = this;
            }

            @Override // com.google.firebase.storage.y
            public final void a(Object obj, Object obj2) {
                switch (i8) {
                    case 0:
                        s sVar = this.f5585b;
                        sVar.getClass();
                        t.f5605c.a(sVar);
                        ((OnSuccessListener) obj).onSuccess((r) obj2);
                        break;
                    case 1:
                        s sVar2 = this.f5585b;
                        sVar2.getClass();
                        t.f5605c.a(sVar2);
                        ((OnFailureListener) obj).onFailure(((r) obj2).f5594a);
                        break;
                    case 2:
                        s sVar3 = this.f5585b;
                        sVar3.getClass();
                        t.f5605c.a(sVar3);
                        ((OnCompleteListener) obj).onComplete(sVar3);
                        break;
                    default:
                        s sVar4 = this.f5585b;
                        sVar4.getClass();
                        t.f5605c.a(sVar4);
                        ((OnCanceledListener) obj).onCanceled();
                        break;
                }
            }
        });
    }

    public static String c(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? "Unknown Internal State!" : "INTERNAL_STATE_CANCELED" : "INTERNAL_STATE_SUCCESS" : "INTERNAL_STATE_FAILURE" : "INTERNAL_STATE_CANCELING" : "INTERNAL_STATE_PAUSED" : "INTERNAL_STATE_PAUSING" : "INTERNAL_STATE_IN_PROGRESS" : "INTERNAL_STATE_QUEUED" : "INTERNAL_STATE_NOT_STARTED";
    }

    public final void a() {
        if (isComplete() || (this.f5604h & 16) != 0 || this.f5604h == 2 || o(256, false)) {
            return;
        }
        o(64, false);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        I.g(onCanceledListener);
        this.e.b(null, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        I.g(onCompleteListener);
        this.f5601d.b(null, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnFailureListener(OnFailureListener onFailureListener) {
        I.g(onFailureListener);
        this.f5600c.b(null, null, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        I.g(onSuccessListener);
        this.f5599b.b(null, null, onSuccessListener);
        return this;
    }

    public final r b() {
        r rVar = this.i;
        if (rVar != null) {
            return rVar;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.i == null) {
            this.i = m();
        }
        return this.i;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWith(Continuation continuation) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5601d.b(null, null, new T2.m(this, continuation, taskCompletionSource, 4));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWithTask(Continuation continuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f5601d.b(null, null, new p(this, continuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    public abstract m d();

    public abstract void e();

    public void f() {
    }

    public boolean g() {
        return p(new int[]{16, 8}, true);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        if (b() == null) {
            return null;
        }
        return b().f5594a;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult() {
        if (b() == null) {
            throw new IllegalStateException();
        }
        i iVar = b().f5594a;
        if (iVar == null) {
            return b();
        }
        throw new RuntimeExecutionException(iVar);
    }

    public final void h() {
        if (o(2, false)) {
            l();
        }
    }

    public void i() {
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.f5604h == 256;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        return (this.f5604h & 448) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        return (this.f5604h & 128) != 0;
    }

    public boolean j() {
        if (!o(2, true)) {
            return false;
        }
        i();
        l();
        return true;
    }

    public abstract void k();

    public abstract void l();

    public final r m() {
        r rVarN;
        synchronized (this.f5598a) {
            rVarN = n();
        }
        return rVarN;
    }

    public abstract r n();

    public final boolean o(int i, boolean z6) {
        return p(new int[]{i}, z6);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task onSuccessTask(SuccessContinuation successContinuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f5599b.b(null, null, new q(successContinuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    public final boolean p(int[] iArr, boolean z6) {
        String strSubstring;
        HashMap map = z6 ? f5596j : f5597k;
        synchronized (this.f5598a) {
            try {
                for (int i : iArr) {
                    HashSet hashSet = (HashSet) map.get(Integer.valueOf(this.f5604h));
                    if (hashSet != null && hashSet.contains(Integer.valueOf(i))) {
                        this.f5604h = i;
                        int i6 = this.f5604h;
                        if (i6 == 2) {
                            t tVar = t.f5605c;
                            synchronized (tVar.f5607b) {
                                tVar.f5606a.put(d().toString(), new WeakReference(this));
                            }
                        } else if (i6 == 4) {
                            f();
                        } else if (i6 != 16 && i6 != 64 && i6 != 128 && i6 == 256) {
                            e();
                        }
                        this.f5599b.p();
                        this.f5600c.p();
                        this.e.p();
                        this.f5601d.p();
                        this.f5603g.p();
                        this.f5602f.p();
                        if (Log.isLoggable("StorageTask", 3)) {
                            Log.d("StorageTask", "changed internal state to: " + c(i) + " isUser: " + z6 + " from state:" + c(this.f5604h));
                        }
                        return true;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unable to change internal state to: ");
                if (iArr.length == 0) {
                    strSubstring = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i7 : iArr) {
                        sb2.append(c(i7));
                        sb2.append(", ");
                    }
                    strSubstring = sb2.substring(0, sb2.length() - 2);
                }
                sb.append(strSubstring);
                sb.append(" isUser: ");
                sb.append(z6);
                sb.append(" from state:");
                sb.append(c(this.f5604h));
                Log.w("StorageTask", sb.toString());
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        I.g(onCanceledListener);
        I.g(executor);
        this.e.b(null, executor, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        I.g(onCompleteListener);
        I.g(executor);
        this.f5601d.b(null, executor, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        I.g(onFailureListener);
        I.g(executor);
        this.f5600c.b(null, executor, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        I.g(executor);
        I.g(onSuccessListener);
        this.f5599b.b(null, executor, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWith(Executor executor, Continuation continuation) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5601d.b(null, executor, new T2.m(this, continuation, taskCompletionSource, 4));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        I.g(onCanceledListener);
        I.g(activity);
        this.e.b(activity, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        I.g(onCompleteListener);
        I.g(activity);
        this.f5601d.b(activity, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        I.g(onFailureListener);
        I.g(activity);
        this.f5600c.b(activity, null, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        I.g(activity);
        I.g(onSuccessListener);
        this.f5599b.b(activity, null, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWithTask(Executor executor, Continuation continuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f5601d.b(null, executor, new p(this, continuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.f5599b.b(null, executor, new q(successContinuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult(Class cls) throws Throwable {
        if (b() != null) {
            if (!cls.isInstance(b().f5594a)) {
                i iVar = b().f5594a;
                if (iVar == null) {
                    return b();
                }
                throw new RuntimeExecutionException(iVar);
            }
            throw ((Throwable) cls.cast(b().f5594a));
        }
        throw new IllegalStateException();
    }
}
