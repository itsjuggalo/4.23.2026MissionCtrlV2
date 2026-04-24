package com.revenuecat.purchases.common;

import W2.E;
import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import m3.AbstractC1608c;
import o3.AbstractC1681l;
import o3.C1679j;
import org.json.JSONException;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public class Dispatcher {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final double INTEGRATION_TEST_DELAY_PERCENTAGE = 0.01d;
    private final ExecutorService executorService;
    private final Handler mainHandler;
    private final boolean runningIntegrationTests;

    public static abstract class AsyncCall implements Runnable {
        public abstract HTTPResult call();

        public void onCompletion(HTTPResult result) {
            r.f(result, "result");
        }

        public void onError(PurchasesError error) {
            r.f(error, "error");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                onCompletion(call());
            } catch (SignatureVerificationException e4) {
                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e4);
                LogUtilsKt.errorLog(purchasesError);
                onError(purchasesError);
            } catch (IOException e5) {
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e5);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            } catch (SecurityException e6) {
                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e6);
                LogUtilsKt.errorLog(purchasesError3);
                onError(purchasesError3);
            } catch (JSONException e7) {
                PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(e7);
                LogUtilsKt.errorLog(purchasesError4);
                onError(purchasesError4);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public Dispatcher(ExecutorService executorService, Handler handler, boolean z4) {
        r.f(executorService, "executorService");
        this.executorService = executorService;
        this.mainHandler = handler;
        this.runningIntegrationTests = z4;
    }

    public static /* synthetic */ void enqueue$default(Dispatcher dispatcher, Runnable runnable, Delay delay, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }
        if ((i4 & 2) != 0) {
            delay = Delay.NONE;
        }
        dispatcher.enqueue(runnable, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$3$lambda$2(Runnable command, Dispatcher this$0) {
        r.f(command, "$command");
        r.f(this$0, "this$0");
        try {
            command.run();
        } catch (Throwable th) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception running command: " + th, null);
            Handler handler = this$0.mainHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.revenuecat.purchases.common.b
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        Dispatcher.enqueue$lambda$3$lambda$2$lambda$1(th);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$3$lambda$2$lambda$1(Throwable e4) throws Throwable {
        r.f(e4, "$e");
        throw e4;
    }

    public void close() {
        synchronized (this.executorService) {
            this.executorService.shutdownNow();
        }
    }

    public void enqueue(final Runnable command, Delay delay) {
        r.f(command, "command");
        r.f(delay, "delay");
        synchronized (this.executorService) {
            try {
                if (!this.executorService.isShutdown()) {
                    Runnable runnable = new Runnable() { // from class: com.revenuecat.purchases.common.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            Dispatcher.enqueue$lambda$3$lambda$2(command, this);
                        }
                    };
                    if (delay == Delay.NONE || !(this.executorService instanceof ScheduledExecutorService)) {
                        this.executorService.submit(runnable);
                    } else {
                        long j4 = AbstractC1681l.j(new C1679j(C1779a.s(delay.m94getMinDelayUwyO8pc()), C1779a.s(delay.m93getMaxDelayUwyO8pc())), AbstractC1608c.f13542a);
                        if (this.runningIntegrationTests) {
                            j4 = (long) (j4 * 0.01d);
                        }
                        ((ScheduledExecutorService) this.executorService).schedule(runnable, j4, TimeUnit.MILLISECONDS);
                    }
                }
                E e4 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isClosed() {
        boolean zIsShutdown;
        synchronized (this.executorService) {
            zIsShutdown = this.executorService.isShutdown();
        }
        return zIsShutdown;
    }

    public /* synthetic */ Dispatcher(ExecutorService executorService, Handler handler, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        this(executorService, (i4 & 2) != 0 ? new Handler(Looper.getMainLooper()) : handler, (i4 & 4) != 0 ? false : z4);
    }
}
