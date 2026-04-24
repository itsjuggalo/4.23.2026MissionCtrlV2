package com.google.firebase.firestore.remote;

import K2.AbstractC0359g;
import K2.Z;
import K2.a0;
import K2.l0;
import com.google.firebase.firestore.remote.AbstractStream;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.remote.Stream.StreamCallback;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractStream<ReqT, RespT, CallbackT extends Stream.StreamCallback> implements Stream<CallbackT> {
    private static final long BACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS;
    private static final double BACKOFF_FACTOR = 1.5d;
    private static final long BACKOFF_INITIAL_DELAY_MS;
    private static final long BACKOFF_MAX_DELAY_MS;
    private static final long HEALTHY_TIMEOUT_MS;
    private static final long IDLE_TIMEOUT_MS;
    final ExponentialBackoff backoff;
    private AbstractC0359g call;
    private final FirestoreChannel firestoreChannel;
    private AsyncQueue.DelayedTask healthCheck;
    private final AsyncQueue.TimerId healthTimerId;
    private AsyncQueue.DelayedTask idleTimer;
    private final AsyncQueue.TimerId idleTimerId;
    final CallbackT listener;
    private final a0 methodDescriptor;
    private final AsyncQueue workerQueue;
    private Stream.State state = Stream.State.Initial;
    private long closeCount = 0;
    private final AbstractStream<ReqT, RespT, CallbackT>.IdleTimeoutRunnable idleTimeoutRunnable = new IdleTimeoutRunnable();

    public class CloseGuardedRunner {
        private final long initialCloseCount;

        public CloseGuardedRunner(long j4) {
            this.initialCloseCount = j4;
        }

        public void run(Runnable runnable) {
            AbstractStream.this.workerQueue.verifyIsCurrentThread();
            if (AbstractStream.this.closeCount == this.initialCloseCount) {
                runnable.run();
            } else {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    public class IdleTimeoutRunnable implements Runnable {
        public IdleTimeoutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractStream.this.handleIdleCloseTimer();
        }
    }

    public class StreamObserver implements IncomingStreamObserver<RespT> {
        private final AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner dispatcher;
        private int responseCount = 0;

        public StreamObserver(AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner closeGuardedRunner) {
            this.dispatcher = closeGuardedRunner;
        }

        public static /* synthetic */ void a(StreamObserver streamObserver, l0 l0Var) {
            streamObserver.getClass();
            if (l0Var.o()) {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(AbstractStream.this)));
            } else {
                Logger.warn(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(AbstractStream.this)), l0Var);
            }
            AbstractStream.this.handleServerClose(l0Var);
        }

        public static /* synthetic */ void b(StreamObserver streamObserver, Z z4) {
            streamObserver.getClass();
            if (Logger.isDebugEnabled()) {
                HashMap map = new HashMap();
                for (String str : z4.j()) {
                    if (Datastore.WHITE_LISTED_HEADERS.contains(str.toLowerCase(Locale.ENGLISH))) {
                        map.put(str, (String) z4.g(Z.g.e(str, Z.f1097e)));
                    }
                }
                if (map.isEmpty()) {
                    return;
                }
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(AbstractStream.this)), map);
            }
        }

        public static /* synthetic */ void c(StreamObserver streamObserver, int i4, Object obj) {
            streamObserver.getClass();
            if (Logger.isDebugEnabled()) {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream received (%s): %s", Integer.valueOf(System.identityHashCode(AbstractStream.this)), Integer.valueOf(i4), obj);
            }
            if (i4 == 1) {
                AbstractStream.this.onFirst(obj);
            } else {
                AbstractStream.this.onNext(obj);
            }
        }

        public static /* synthetic */ void d(StreamObserver streamObserver) {
            Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(AbstractStream.this)));
            AbstractStream.this.onOpen();
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onClose(final l0 l0Var) {
            this.dispatcher.run(new Runnable() { // from class: com.google.firebase.firestore.remote.f
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.a(this.f10669a, l0Var);
                }
            });
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onHeaders(final Z z4) {
            this.dispatcher.run(new Runnable() { // from class: com.google.firebase.firestore.remote.d
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.b(this.f10666a, z4);
                }
            });
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onNext(final RespT respt) {
            final int i4 = this.responseCount + 1;
            this.dispatcher.run(new Runnable() { // from class: com.google.firebase.firestore.remote.c
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.c(this.f10663a, i4, respt);
                }
            });
            this.responseCount = i4;
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onOpen() {
            this.dispatcher.run(new Runnable() { // from class: com.google.firebase.firestore.remote.e
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.d(this.f10668a);
                }
            });
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BACKOFF_INITIAL_DELAY_MS = timeUnit.toMillis(1L);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        BACKOFF_MAX_DELAY_MS = timeUnit2.toMillis(1L);
        IDLE_TIMEOUT_MS = timeUnit2.toMillis(1L);
        HEALTHY_TIMEOUT_MS = timeUnit.toMillis(10L);
        BACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS = timeUnit.toMillis(10L);
    }

    public AbstractStream(FirestoreChannel firestoreChannel, a0 a0Var, AsyncQueue asyncQueue, AsyncQueue.TimerId timerId, AsyncQueue.TimerId timerId2, AsyncQueue.TimerId timerId3, CallbackT callbackt) {
        this.firestoreChannel = firestoreChannel;
        this.methodDescriptor = a0Var;
        this.workerQueue = asyncQueue;
        this.idleTimerId = timerId2;
        this.healthTimerId = timerId3;
        this.listener = callbackt;
        this.backoff = new ExponentialBackoff(asyncQueue, timerId, BACKOFF_INITIAL_DELAY_MS, 1.5d, BACKOFF_MAX_DELAY_MS);
    }

    public static /* synthetic */ void a(AbstractStream abstractStream) {
        Stream.State state = abstractStream.state;
        Assert.hardAssert(state == Stream.State.Backoff, "State should still be backoff but was %s", state);
        abstractStream.state = Stream.State.Initial;
        abstractStream.start();
        Assert.hardAssert(abstractStream.isStarted(), "Stream should have started", new Object[0]);
    }

    public static /* synthetic */ void b(AbstractStream abstractStream) {
        if (abstractStream.isOpen()) {
            abstractStream.state = Stream.State.Healthy;
        }
    }

    private void cancelHealthCheck() {
        AsyncQueue.DelayedTask delayedTask = this.healthCheck;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.healthCheck = null;
        }
    }

    private void cancelIdleCheck() {
        AsyncQueue.DelayedTask delayedTask = this.idleTimer;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.idleTimer = null;
        }
    }

    private void close(Stream.State state, l0 l0Var) {
        Assert.hardAssert(isStarted(), "Only started streams should be closed.", new Object[0]);
        Stream.State state2 = Stream.State.Error;
        Assert.hardAssert(state == state2 || l0Var.o(), "Can't provide an error when not in an error state.", new Object[0]);
        this.workerQueue.verifyIsCurrentThread();
        if (Datastore.isMissingSslCiphers(l0Var)) {
            Util.crashMainThread(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", l0Var.l()));
        }
        cancelIdleCheck();
        cancelHealthCheck();
        this.backoff.cancel();
        this.closeCount++;
        l0.b bVarM = l0Var.m();
        if (bVarM == l0.b.OK) {
            this.backoff.reset();
        } else if (bVarM == l0.b.RESOURCE_EXHAUSTED) {
            Logger.debug(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.backoff.resetToMax();
        } else if (bVarM == l0.b.UNAUTHENTICATED && this.state != Stream.State.Healthy) {
            this.firestoreChannel.invalidateToken();
        } else if (bVarM == l0.b.UNAVAILABLE && ((l0Var.l() instanceof UnknownHostException) || (l0Var.l() instanceof ConnectException))) {
            this.backoff.setTemporaryMaxDelay(BACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS);
        }
        if (state != state2) {
            Logger.debug(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            tearDown();
        }
        if (this.call != null) {
            if (l0Var.o()) {
                Logger.debug(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.call.halfClose();
            }
            this.call = null;
        }
        this.state = state;
        this.listener.onClose(l0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIdleCloseTimer() {
        if (isOpen()) {
            close(Stream.State.Initial, l0.f1215e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpen() {
        this.state = Stream.State.Open;
        this.listener.onOpen();
        if (this.healthCheck == null) {
            this.healthCheck = this.workerQueue.enqueueAfterDelay(this.healthTimerId, HEALTHY_TIMEOUT_MS, new Runnable() { // from class: com.google.firebase.firestore.remote.b
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.b(this.f10662a);
                }
            });
        }
    }

    private void performBackoff() {
        Assert.hardAssert(this.state == Stream.State.Error, "Should only perform backoff in an error state", new Object[0]);
        this.state = Stream.State.Backoff;
        this.backoff.backoffAndRun(new Runnable() { // from class: com.google.firebase.firestore.remote.a
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStream.a(this.f10661a);
            }
        });
    }

    public void handleServerClose(l0 l0Var) {
        Assert.hardAssert(isStarted(), "Can't handle server close on non-started stream!", new Object[0]);
        close(Stream.State.Error, l0Var);
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void inhibitBackoff() {
        Assert.hardAssert(!isStarted(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.workerQueue.verifyIsCurrentThread();
        this.state = Stream.State.Initial;
        this.backoff.reset();
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isOpen() {
        this.workerQueue.verifyIsCurrentThread();
        Stream.State state = this.state;
        return state == Stream.State.Open || state == Stream.State.Healthy;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isStarted() {
        this.workerQueue.verifyIsCurrentThread();
        Stream.State state = this.state;
        return state == Stream.State.Starting || state == Stream.State.Backoff || isOpen();
    }

    public void markIdle() {
        if (isOpen() && this.idleTimer == null) {
            this.idleTimer = this.workerQueue.enqueueAfterDelay(this.idleTimerId, IDLE_TIMEOUT_MS, this.idleTimeoutRunnable);
        }
    }

    public abstract void onFirst(RespT respt);

    public abstract void onNext(RespT respt);

    @Override // com.google.firebase.firestore.remote.Stream
    public void start() {
        this.workerQueue.verifyIsCurrentThread();
        Assert.hardAssert(this.call == null, "Last call still set", new Object[0]);
        Assert.hardAssert(this.idleTimer == null, "Idle timer still set", new Object[0]);
        Stream.State state = this.state;
        if (state == Stream.State.Error) {
            performBackoff();
            return;
        }
        Assert.hardAssert(state == Stream.State.Initial, "Already started", new Object[0]);
        this.call = this.firestoreChannel.runBidiStreamingRpc(this.methodDescriptor, new StreamObserver(new CloseGuardedRunner(this.closeCount)));
        this.state = Stream.State.Starting;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void stop() {
        if (isStarted()) {
            close(Stream.State.Initial, l0.f1215e);
        }
    }

    public void tearDown() {
    }

    public void writeRequest(ReqT reqt) {
        this.workerQueue.verifyIsCurrentThread();
        Logger.debug(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        cancelIdleCheck();
        this.call.sendMessage(reqt);
    }
}
