package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.TaskListenerImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class StorageTask<ResultT extends ProvideError> extends ControllableTask<ResultT> {
    static final int INTERNAL_STATE_CANCELED = 256;
    static final int INTERNAL_STATE_CANCELING = 32;
    static final int INTERNAL_STATE_FAILURE = 64;
    static final int INTERNAL_STATE_IN_PROGRESS = 4;
    static final int INTERNAL_STATE_NOT_STARTED = 1;
    static final int INTERNAL_STATE_PAUSED = 16;
    static final int INTERNAL_STATE_PAUSING = 8;
    static final int INTERNAL_STATE_QUEUED = 2;
    static final int INTERNAL_STATE_SUCCESS = 128;
    static final int STATES_CANCELED = 256;
    static final int STATES_COMPLETE = 448;
    static final int STATES_FAILURE = 64;
    static final int STATES_INPROGRESS = -465;
    static final int STATES_PAUSED = 16;
    static final int STATES_SUCCESS = 128;
    private static final String TAG = "StorageTask";
    private static final HashMap<Integer, HashSet<Integer>> ValidTaskInitiatedStateChanges;
    private static final HashMap<Integer, HashSet<Integer>> ValidUserInitiatedStateChanges;
    private ResultT finalResult;
    protected final Object syncObject = new Object();
    final TaskListenerImpl<OnSuccessListener<? super ResultT>, ResultT> successManager = new TaskListenerImpl<>(this, UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.g
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void raise(Object obj, Object obj2) {
            StorageTask.g(this.f10819a, (OnSuccessListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    final TaskListenerImpl<OnFailureListener, ResultT> failureManager = new TaskListenerImpl<>(this, 64, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.k
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void raise(Object obj, Object obj2) {
            StorageTask.d(this.f10828a, (OnFailureListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    final TaskListenerImpl<OnCompleteListener<ResultT>, ResultT> completeListener = new TaskListenerImpl<>(this, STATES_COMPLETE, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.l
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void raise(Object obj, Object obj2) {
            StorageTask.e(this.f10836a, (OnCompleteListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    final TaskListenerImpl<OnCanceledListener, ResultT> cancelManager = new TaskListenerImpl<>(this, 256, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.m
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void raise(Object obj, Object obj2) {
            StorageTask.h(this.f10837a, (OnCanceledListener) obj, (StorageTask.ProvideError) obj2);
        }
    });
    final TaskListenerImpl<OnProgressListener<? super ResultT>, ResultT> progressManager = new TaskListenerImpl<>(this, STATES_INPROGRESS, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.n
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void raise(Object obj, Object obj2) {
            ((OnProgressListener) obj).onProgress((StorageTask.ProvideError) obj2);
        }
    });
    final TaskListenerImpl<OnPausedListener<? super ResultT>, ResultT> pausedManager = new TaskListenerImpl<>(this, 16, new TaskListenerImpl.OnRaise() { // from class: com.google.firebase.storage.o
        @Override // com.google.firebase.storage.TaskListenerImpl.OnRaise
        public final void raise(Object obj, Object obj2) {
            ((OnPausedListener) obj).onPaused((StorageTask.ProvideError) obj2);
        }
    });
    private volatile int currentState = 1;

    public interface ProvideError {
        Exception getError();
    }

    public class SnapshotBase implements ProvideError {
        private final Exception error;

        public SnapshotBase(Exception exc) {
            if (exc != null) {
                this.error = exc;
                return;
            }
            if (StorageTask.this.isCanceled()) {
                this.error = StorageException.fromErrorStatus(Status.f9657j);
            } else if (StorageTask.this.getInternalState() == 64) {
                this.error = StorageException.fromErrorStatus(Status.f9655h);
            } else {
                this.error = null;
            }
        }

        @Override // com.google.firebase.storage.StorageTask.ProvideError
        public Exception getError() {
            return this.error;
        }

        public StorageReference getStorage() {
            return getTask().getStorage();
        }

        public StorageTask<ResultT> getTask() {
            return StorageTask.this;
        }
    }

    static {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        ValidUserInitiatedStateChanges = map;
        HashMap<Integer, HashSet<Integer>> map2 = new HashMap<>();
        ValidTaskInitiatedStateChanges = map2;
        map.put(1, new HashSet<>(Arrays.asList(16, 256)));
        map.put(2, new HashSet<>(Arrays.asList(8, 32)));
        map.put(4, new HashSet<>(Arrays.asList(8, 32)));
        map.put(16, new HashSet<>(Arrays.asList(2, 256)));
        map.put(64, new HashSet<>(Arrays.asList(2, 256)));
        map2.put(1, new HashSet<>(Arrays.asList(2, 64)));
        Integer numValueOf = Integer.valueOf(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        map2.put(2, new HashSet<>(Arrays.asList(4, 64, numValueOf)));
        map2.put(4, new HashSet<>(Arrays.asList(4, 64, numValueOf)));
        map2.put(8, new HashSet<>(Arrays.asList(16, 64, numValueOf)));
        map2.put(32, new HashSet<>(Arrays.asList(256, 64, numValueOf)));
    }

    public static /* synthetic */ void a(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, Task task) {
        storageTask.getClass();
        try {
            Object objThen = continuation.then(storageTask);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            taskCompletionSource.setResult(objThen);
        } catch (RuntimeExecutionException e4) {
            if (e4.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e4.getCause());
            } else {
                taskCompletionSource.setException(e4);
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    public static /* synthetic */ void b(StorageTask storageTask) {
        storageTask.getClass();
        try {
            storageTask.run();
        } finally {
            storageTask.ensureFinalState();
        }
    }

    public static /* synthetic */ void c(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, ProvideError provideError) {
        try {
            Task taskThen = successContinuation.then(provideError);
            Objects.requireNonNull(taskCompletionSource);
            taskThen.addOnSuccessListener(new q(taskCompletionSource));
            taskThen.addOnFailureListener(new C1049r(taskCompletionSource));
            Objects.requireNonNull(cancellationTokenSource);
            taskThen.addOnCanceledListener(new s(cancellationTokenSource));
        } catch (RuntimeExecutionException e4) {
            if (e4.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e4.getCause());
            } else {
                taskCompletionSource.setException(e4);
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    private <ContinuationResultT> Task<ContinuationResultT> continueWithImpl(Executor executor, final Continuation<ResultT, ContinuationResultT> continuation) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.completeListener.addListener(null, executor, new OnCompleteListener() { // from class: com.google.firebase.storage.p
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                StorageTask.a(this.f10838a, continuation, taskCompletionSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    private <ContinuationResultT> Task<ContinuationResultT> continueWithTaskImpl(Executor executor, final Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.completeListener.addListener(null, executor, new OnCompleteListener() { // from class: com.google.firebase.storage.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                StorageTask.f(this.f10821a, continuation, taskCompletionSource, cancellationTokenSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void d(StorageTask storageTask, OnFailureListener onFailureListener, ProvideError provideError) {
        storageTask.getClass();
        StorageTaskManager.getInstance().unRegister(storageTask);
        onFailureListener.onFailure(provideError.getError());
    }

    public static /* synthetic */ void e(StorageTask storageTask, OnCompleteListener onCompleteListener, ProvideError provideError) {
        storageTask.getClass();
        StorageTaskManager.getInstance().unRegister(storageTask);
        onCompleteListener.onComplete(storageTask);
    }

    private void ensureFinalState() {
        if (isComplete() || isPaused() || getInternalState() == 2 || tryChangeState(256, false)) {
            return;
        }
        tryChangeState(64, false);
    }

    public static /* synthetic */ void f(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, Task task) {
        storageTask.getClass();
        try {
            Task task2 = (Task) continuation.then(storageTask);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            if (task2 == null) {
                taskCompletionSource.setException(new NullPointerException("Continuation returned null"));
                return;
            }
            task2.addOnSuccessListener(new q(taskCompletionSource));
            task2.addOnFailureListener(new C1049r(taskCompletionSource));
            Objects.requireNonNull(cancellationTokenSource);
            task2.addOnCanceledListener(new s(cancellationTokenSource));
        } catch (RuntimeExecutionException e4) {
            if (e4.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e4.getCause());
            } else {
                taskCompletionSource.setException(e4);
            }
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    public static /* synthetic */ void g(StorageTask storageTask, OnSuccessListener onSuccessListener, ProvideError provideError) {
        storageTask.getClass();
        StorageTaskManager.getInstance().unRegister(storageTask);
        onSuccessListener.onSuccess(provideError);
    }

    private ResultT getFinalResult() {
        ResultT resultt = this.finalResult;
        if (resultt != null) {
            return resultt;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.finalResult == null) {
            this.finalResult = (ResultT) snapState();
        }
        return this.finalResult;
    }

    private String getStateString(int[] iArr) {
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 : iArr) {
            sb.append(getStateString(i4));
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static /* synthetic */ void h(StorageTask storageTask, OnCanceledListener onCanceledListener, ProvideError provideError) {
        storageTask.getClass();
        StorageTaskManager.getInstance().unRegister(storageTask);
        onCanceledListener.onCanceled();
    }

    private <ContinuationResultT> Task<ContinuationResultT> successTaskImpl(Executor executor, final SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.successManager.addListener(null, executor, new OnSuccessListener() { // from class: com.google.firebase.storage.j
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                StorageTask.c(successContinuation, taskCompletionSource, cancellationTokenSource, (StorageTask.ProvideError) obj);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.firebase.storage.CancellableTask
    public boolean cancel() {
        return tryChangeState(new int[]{256, 32}, true);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(Continuation<ResultT, ContinuationResultT> continuation) {
        return continueWithImpl(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return continueWithTaskImpl(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        if (getFinalResult() == null) {
            return null;
        }
        return getFinalResult().getError();
    }

    public int getInternalState() {
        return this.currentState;
    }

    public Runnable getRunnable() {
        return new Runnable() { // from class: com.google.firebase.storage.h
            @Override // java.lang.Runnable
            public final void run() {
                StorageTask.b(this.f10820a);
            }
        };
    }

    public ResultT getSnapshot() {
        return (ResultT) snapState();
    }

    public abstract StorageReference getStorage();

    public Object getSyncObject() {
        return this.syncObject;
    }

    @Override // com.google.firebase.storage.CancellableTask, com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return getInternalState() == 256;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return (getInternalState() & STATES_COMPLETE) != 0;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public boolean isInProgress() {
        return (getInternalState() & STATES_INPROGRESS) != 0;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isPaused() {
        return (getInternalState() & 16) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return (getInternalState() & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0;
    }

    public void onCanceled() {
    }

    public void onFailure() {
    }

    public void onPaused() {
    }

    public void onProgress() {
    }

    public void onQueued() {
    }

    public void onSuccess() {
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return successTaskImpl(null, successContinuation);
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean pause() {
        return tryChangeState(new int[]{16, 8}, true);
    }

    public boolean queue() {
        if (!tryChangeState(2, false)) {
            return false;
        }
        schedule();
        return true;
    }

    public StorageTask<ResultT> removeOnCanceledListener(OnCanceledListener onCanceledListener) {
        AbstractC0940s.k(onCanceledListener);
        this.cancelManager.removeListener(onCanceledListener);
        return this;
    }

    public StorageTask<ResultT> removeOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        AbstractC0940s.k(onCompleteListener);
        this.completeListener.removeListener(onCompleteListener);
        return this;
    }

    public StorageTask<ResultT> removeOnFailureListener(OnFailureListener onFailureListener) {
        AbstractC0940s.k(onFailureListener);
        this.failureManager.removeListener(onFailureListener);
        return this;
    }

    public StorageTask<ResultT> removeOnPausedListener(OnPausedListener<? super ResultT> onPausedListener) {
        AbstractC0940s.k(onPausedListener);
        this.pausedManager.removeListener(onPausedListener);
        return this;
    }

    public StorageTask<ResultT> removeOnProgressListener(OnProgressListener<? super ResultT> onProgressListener) {
        AbstractC0940s.k(onProgressListener);
        this.progressManager.removeListener(onProgressListener);
        return this;
    }

    public StorageTask<ResultT> removeOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        AbstractC0940s.k(onSuccessListener);
        this.successManager.removeListener(onSuccessListener);
        return this;
    }

    public void resetState() {
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean resume() {
        if (!tryChangeState(2, true)) {
            return false;
        }
        resetState();
        schedule();
        return true;
    }

    public abstract void run();

    public abstract void schedule();

    public ResultT snapState() {
        ResultT resultt;
        synchronized (this.syncObject) {
            resultt = (ResultT) snapStateImpl();
        }
        return resultt;
    }

    public abstract ResultT snapStateImpl();

    public boolean tryChangeState(int[] iArr, boolean z4) {
        HashMap<Integer, HashSet<Integer>> map = z4 ? ValidUserInitiatedStateChanges : ValidTaskInitiatedStateChanges;
        synchronized (this.syncObject) {
            try {
                for (int i4 : iArr) {
                    HashSet<Integer> hashSet = map.get(Integer.valueOf(getInternalState()));
                    if (hashSet != null && hashSet.contains(Integer.valueOf(i4))) {
                        this.currentState = i4;
                        int i5 = this.currentState;
                        if (i5 == 2) {
                            StorageTaskManager.getInstance().ensureRegistered(this);
                            onQueued();
                        } else if (i5 == 4) {
                            onProgress();
                        } else if (i5 == 16) {
                            onPaused();
                        } else if (i5 == 64) {
                            onFailure();
                        } else if (i5 == 128) {
                            onSuccess();
                        } else if (i5 == 256) {
                            onCanceled();
                        }
                        this.successManager.onInternalStateChanged();
                        this.failureManager.onInternalStateChanged();
                        this.cancelManager.onInternalStateChanged();
                        this.completeListener.onInternalStateChanged();
                        this.pausedManager.onInternalStateChanged();
                        this.progressManager.onInternalStateChanged();
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "changed internal state to: " + getStateString(i4) + " isUser: " + z4 + " from state:" + getStateString(this.currentState));
                        }
                        return true;
                    }
                }
                Log.w(TAG, "unable to change internal state to: " + getStateString(iArr) + " isUser: " + z4 + " from state:" + getStateString(this.currentState));
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(Executor executor, Continuation<ResultT, ContinuationResultT> continuation) {
        return continueWithImpl(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(Executor executor, Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return continueWithTaskImpl(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(Executor executor, SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return successTaskImpl(executor, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public ResultT getResult() {
        if (getFinalResult() != null) {
            Exception error = getFinalResult().getError();
            if (error == null) {
                return (ResultT) getFinalResult();
            }
            throw new RuntimeExecutionException(error);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        AbstractC0940s.k(onCanceledListener);
        this.cancelManager.addListener(null, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        AbstractC0940s.k(onCompleteListener);
        this.completeListener.addListener(null, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        AbstractC0940s.k(onFailureListener);
        this.failureManager.addListener(null, null, onFailureListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public StorageTask<ResultT> addOnPausedListener(OnPausedListener<? super ResultT> onPausedListener) {
        AbstractC0940s.k(onPausedListener);
        this.pausedManager.addListener(null, null, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public StorageTask<ResultT> addOnProgressListener(OnProgressListener<? super ResultT> onProgressListener) {
        AbstractC0940s.k(onProgressListener);
        this.progressManager.addListener(null, null, onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        AbstractC0940s.k(onSuccessListener);
        this.successManager.addListener(null, null, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        AbstractC0940s.k(onCanceledListener);
        AbstractC0940s.k(executor);
        this.cancelManager.addListener(null, executor, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        AbstractC0940s.k(onCompleteListener);
        AbstractC0940s.k(executor);
        this.completeListener.addListener(null, executor, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        AbstractC0940s.k(onFailureListener);
        AbstractC0940s.k(executor);
        this.failureManager.addListener(null, executor, onFailureListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public StorageTask<ResultT> addOnPausedListener(Executor executor, OnPausedListener<? super ResultT> onPausedListener) {
        AbstractC0940s.k(onPausedListener);
        AbstractC0940s.k(executor);
        this.pausedManager.addListener(null, executor, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public StorageTask<ResultT> addOnProgressListener(Executor executor, OnProgressListener<? super ResultT> onProgressListener) {
        AbstractC0940s.k(onProgressListener);
        AbstractC0940s.k(executor);
        this.progressManager.addListener(null, executor, onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        AbstractC0940s.k(executor);
        AbstractC0940s.k(onSuccessListener);
        this.successManager.addListener(null, executor, onSuccessListener);
        return this;
    }

    private String getStateString(int i4) {
        if (i4 == 1) {
            return "INTERNAL_STATE_NOT_STARTED";
        }
        if (i4 == 2) {
            return "INTERNAL_STATE_QUEUED";
        }
        if (i4 == 4) {
            return "INTERNAL_STATE_IN_PROGRESS";
        }
        if (i4 == 8) {
            return "INTERNAL_STATE_PAUSING";
        }
        if (i4 == 16) {
            return "INTERNAL_STATE_PAUSED";
        }
        if (i4 == 32) {
            return "INTERNAL_STATE_CANCELING";
        }
        if (i4 == 64) {
            return "INTERNAL_STATE_FAILURE";
        }
        if (i4 == 128) {
            return "INTERNAL_STATE_SUCCESS";
        }
        if (i4 != 256) {
            return "Unknown Internal State!";
        }
        return "INTERNAL_STATE_CANCELED";
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    @Override // com.google.android.gms.tasks.Task
    public <X extends Throwable> ResultT getResult(Class<X> cls) throws X {
        if (getFinalResult() != null) {
            if (!cls.isInstance(getFinalResult().getError())) {
                Exception error = getFinalResult().getError();
                if (error == null) {
                    return (ResultT) getFinalResult();
                }
                throw new RuntimeExecutionException(error);
            }
            throw cls.cast(getFinalResult().getError());
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        AbstractC0940s.k(onCanceledListener);
        AbstractC0940s.k(activity);
        this.cancelManager.addListener(activity, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCompleteListener(Activity activity, OnCompleteListener<ResultT> onCompleteListener) {
        AbstractC0940s.k(onCompleteListener);
        AbstractC0940s.k(activity);
        this.completeListener.addListener(activity, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        AbstractC0940s.k(onFailureListener);
        AbstractC0940s.k(activity);
        this.failureManager.addListener(activity, null, onFailureListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public StorageTask<ResultT> addOnPausedListener(Activity activity, OnPausedListener<? super ResultT> onPausedListener) {
        AbstractC0940s.k(onPausedListener);
        AbstractC0940s.k(activity);
        this.pausedManager.addListener(activity, null, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public StorageTask<ResultT> addOnProgressListener(Activity activity, OnProgressListener<? super ResultT> onProgressListener) {
        AbstractC0940s.k(onProgressListener);
        AbstractC0940s.k(activity);
        this.progressManager.addListener(activity, null, onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnSuccessListener(Activity activity, OnSuccessListener<? super ResultT> onSuccessListener) {
        AbstractC0940s.k(activity);
        AbstractC0940s.k(onSuccessListener);
        this.successManager.addListener(activity, null, onSuccessListener);
        return this;
    }

    public boolean tryChangeState(int i4, boolean z4) {
        return tryChangeState(new int[]{i4}, z4);
    }
}
