package com.google.firebase.firestore.remote;

import K2.AbstractC0354b;
import K2.AbstractC0359g;
import K2.C0355c;
import K2.EnumC0368p;
import K2.V;
import K2.W;
import K2.a0;
import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import p2.r;
import z1.C1990h;
import z1.C1991i;

/* JADX INFO: loaded from: classes.dex */
public class GrpcCallProvider {
    private static final int CONNECTIVITY_ATTEMPT_TIMEOUT_MS = 15000;
    private static final String LOG_TAG = "GrpcCallProvider";
    private static Supplier<W> overrideChannelBuilderSupplier;
    private final AsyncQueue asyncQueue;
    private C0355c callOptions;
    private Task<V> channelTask;
    private AsyncQueue.DelayedTask connectivityAttemptTimer;
    private final Context context;
    private final DatabaseInfo databaseInfo;
    private final AbstractC0354b firestoreHeaders;

    public GrpcCallProvider(AsyncQueue asyncQueue, Context context, DatabaseInfo databaseInfo, AbstractC0354b abstractC0354b) {
        this.asyncQueue = asyncQueue;
        this.context = context;
        this.databaseInfo = databaseInfo;
        this.firestoreHeaders = abstractC0354b;
        initChannelTask();
    }

    public static /* synthetic */ void a(GrpcCallProvider grpcCallProvider, V v4) {
        grpcCallProvider.getClass();
        v4.o();
        grpcCallProvider.initChannelTask();
    }

    private void clearConnectivityAttemptTimer() {
        if (this.connectivityAttemptTimer != null) {
            Logger.debug(LOG_TAG, "Clearing the connectivityAttemptTimer", new Object[0]);
            this.connectivityAttemptTimer.cancel();
            this.connectivityAttemptTimer = null;
        }
    }

    public static /* synthetic */ void e(GrpcCallProvider grpcCallProvider, V v4) {
        grpcCallProvider.getClass();
        Logger.debug(LOG_TAG, "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        grpcCallProvider.clearConnectivityAttemptTimer();
        grpcCallProvider.resetChannel(v4);
    }

    public static /* synthetic */ Task f(GrpcCallProvider grpcCallProvider, a0 a0Var, Task task) {
        grpcCallProvider.getClass();
        return Tasks.forResult(((V) task.getResult()).g(a0Var, grpcCallProvider.callOptions));
    }

    public static /* synthetic */ V g(final GrpcCallProvider grpcCallProvider) {
        final V vInitChannel = grpcCallProvider.initChannel(grpcCallProvider.context, grpcCallProvider.databaseInfo);
        grpcCallProvider.asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f10701a.onConnectivityStateChange(vInitChannel);
            }
        });
        grpcCallProvider.callOptions = ((r.b) ((r.b) p2.r.f(vInitChannel).c(grpcCallProvider.firestoreHeaders)).d(grpcCallProvider.asyncQueue.getExecutor())).b();
        Logger.debug(LOG_TAG, "Channel successfully reset.", new Object[0]);
        return vInitChannel;
    }

    private V initChannel(Context context, DatabaseInfo databaseInfo) {
        W w4;
        try {
            T1.a.a(context);
        } catch (IllegalStateException | C1990h | C1991i e4) {
            Logger.warn(LOG_TAG, "Failed to update ssl context: %s", e4);
        }
        Supplier<W> supplier = overrideChannelBuilderSupplier;
        if (supplier != null) {
            w4 = supplier.get();
        } else {
            W wB = W.b(databaseInfo.getHost());
            if (!databaseInfo.isSslEnabled()) {
                wB.d();
            }
            w4 = wB;
        }
        w4.c(30L, TimeUnit.SECONDS);
        return L2.a.k(w4).i(context).a();
    }

    private void initChannelTask() {
        this.channelTask = Tasks.call(Executors.BACKGROUND_EXECUTOR, new Callable() { // from class: com.google.firebase.firestore.remote.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GrpcCallProvider.g(this.f10698a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectivityStateChange(final V v4) {
        EnumC0368p enumC0368pL = v4.l(true);
        Logger.debug(LOG_TAG, "Current gRPC connectivity state: " + enumC0368pL, new Object[0]);
        clearConnectivityAttemptTimer();
        if (enumC0368pL == EnumC0368p.CONNECTING) {
            Logger.debug(LOG_TAG, "Setting the connectivityAttemptTimer", new Object[0]);
            this.connectivityAttemptTimer = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.CONNECTIVITY_ATTEMPT_TIMER, 15000L, new Runnable() { // from class: com.google.firebase.firestore.remote.p
                @Override // java.lang.Runnable
                public final void run() {
                    GrpcCallProvider.e(this.f10690a, v4);
                }
            });
        }
        v4.m(enumC0368pL, new Runnable() { // from class: com.google.firebase.firestore.remote.q
            @Override // java.lang.Runnable
            public final void run() {
                GrpcCallProvider grpcCallProvider = this.f10692a;
                grpcCallProvider.asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        grpcCallProvider.onConnectivityStateChange(v);
                    }
                });
            }
        });
    }

    private void resetChannel(final V v4) {
        this.asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.u
            @Override // java.lang.Runnable
            public final void run() {
                GrpcCallProvider.a(this.f10699a, v4);
            }
        });
    }

    public <ReqT, RespT> Task<AbstractC0359g> createClientCall(final a0 a0Var) {
        return this.channelTask.continueWithTask(this.asyncQueue.getExecutor(), new Continuation() { // from class: com.google.firebase.firestore.remote.s
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return GrpcCallProvider.f(this.f10696a, a0Var, task);
            }
        });
    }

    public void shutdown() {
        try {
            V v4 = (V) Tasks.await(this.channelTask);
            v4.n();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (v4.j(1L, timeUnit)) {
                    return;
                }
                Logger.debug(FirestoreChannel.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                v4.o();
                if (v4.j(60L, timeUnit)) {
                    return;
                }
                Logger.warn(FirestoreChannel.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
            } catch (InterruptedException unused) {
                v4.o();
                Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused2) {
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e4) {
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", e4);
        }
    }
}
