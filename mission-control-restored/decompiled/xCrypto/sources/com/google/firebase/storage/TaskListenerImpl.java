package com.google.firebase.storage;

import android.app.Activity;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.internal.ActivityLifecycleListener;
import com.google.firebase.storage.internal.SmartHandler;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class TaskListenerImpl<ListenerTypeT, ResultT extends StorageTask.ProvideError> {
    private OnRaise<ListenerTypeT, ResultT> onRaise;
    private int targetStates;
    private StorageTask<ResultT> task;
    private final Queue<ListenerTypeT> listenerQueue = new ConcurrentLinkedQueue();
    private final HashMap<ListenerTypeT, SmartHandler> handlerMap = new HashMap<>();

    public interface OnRaise<ListenerTypeT, ResultT> {
        void raise(ListenerTypeT listenertypet, ResultT resultt);
    }

    public TaskListenerImpl(StorageTask<ResultT> storageTask, int i4, OnRaise<ListenerTypeT, ResultT> onRaise) {
        this.task = storageTask;
        this.targetStates = i4;
        this.onRaise = onRaise;
    }

    public void addListener(Activity activity, Executor executor, final ListenerTypeT listenertypet) {
        boolean z4;
        SmartHandler smartHandler;
        AbstractC0940s.k(listenertypet);
        synchronized (this.task.getSyncObject()) {
            try {
                z4 = (this.task.getInternalState() & this.targetStates) != 0;
                this.listenerQueue.add(listenertypet);
                smartHandler = new SmartHandler(executor);
                this.handlerMap.put(listenertypet, smartHandler);
                if (activity != null) {
                    AbstractC0940s.b(!activity.isDestroyed(), "Activity is already destroyed!");
                    ActivityLifecycleListener.getInstance().runOnActivityStopped(activity, listenertypet, new Runnable() { // from class: com.google.firebase.storage.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f10847a.removeListener(listenertypet);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            final StorageTask.ProvideError provideErrorSnapState = this.task.snapState();
            smartHandler.callBack(new Runnable() { // from class: com.google.firebase.storage.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10849a.onRaise.raise(listenertypet, provideErrorSnapState);
                }
            });
        }
    }

    public int getListenerCount() {
        return Math.max(this.listenerQueue.size(), this.handlerMap.size());
    }

    public void onInternalStateChanged() {
        if ((this.task.getInternalState() & this.targetStates) != 0) {
            final StorageTask.ProvideError provideErrorSnapState = this.task.snapState();
            for (final ListenerTypeT listenertypet : this.listenerQueue) {
                SmartHandler smartHandler = this.handlerMap.get(listenertypet);
                if (smartHandler != null) {
                    smartHandler.callBack(new Runnable() { // from class: com.google.firebase.storage.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f10844a.onRaise.raise(listenertypet, provideErrorSnapState);
                        }
                    });
                }
            }
        }
    }

    public void removeListener(ListenerTypeT listenertypet) {
        AbstractC0940s.k(listenertypet);
        synchronized (this.task.getSyncObject()) {
            this.handlerMap.remove(listenertypet);
            this.listenerQueue.remove(listenertypet);
            ActivityLifecycleListener.getInstance().removeCookie(listenertypet);
        }
    }
}
