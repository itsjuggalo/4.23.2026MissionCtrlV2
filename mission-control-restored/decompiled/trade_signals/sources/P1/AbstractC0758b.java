package P1;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import d2.AbstractC1623e;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.InterfaceC2322f;

/* JADX INFO: renamed from: P1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0758b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference f6299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SoftReference f6300b;

    public Executor a() {
        ExecutorService executorServiceUnconfigurableExecutorService;
        synchronized (AbstractC0758b.class) {
            try {
                SoftReference softReference = f6299a;
                executorServiceUnconfigurableExecutorService = softReference != null ? (ExecutorService) softReference.get() : null;
                if (executorServiceUnconfigurableExecutorService == null) {
                    AbstractC1623e.a();
                    executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new X1.a("firebase-iid-executor")));
                    f6299a = new SoftReference(executorServiceUnconfigurableExecutorService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorServiceUnconfigurableExecutorService;
    }

    public abstract int b(Context context, C0757a c0757a);

    public abstract void c(Context context, Bundle bundle);

    public final /* synthetic */ void d(Intent intent, final Context context, boolean z7, BroadcastReceiver.PendingResult pendingResult) {
        Executor executorUnconfigurableExecutorService;
        int iE;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                iE = e(context, intent2);
            } else if (intent.getExtras() == null) {
                iE = 500;
            } else {
                final C0757a c0757a = new C0757a(intent);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                synchronized (AbstractC0758b.class) {
                    try {
                        SoftReference softReference = f6300b;
                        executorUnconfigurableExecutorService = softReference != null ? (Executor) softReference.get() : null;
                        if (executorUnconfigurableExecutorService == null) {
                            AbstractC1623e.a();
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new X1.a("pscm-ack-executor"));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            executorUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                            f6300b = new SoftReference(executorUnconfigurableExecutorService);
                        }
                    } finally {
                    }
                }
                executorUnconfigurableExecutorService.execute(new Runnable() { // from class: P1.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2328l abstractC2328lC;
                        C0757a c0757a2 = c0757a;
                        if (TextUtils.isEmpty(c0757a2.d())) {
                            abstractC2328lC = AbstractC2331o.e(null);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString("google.message_id", c0757a2.d());
                            Integer numE = c0757a2.e();
                            if (numE != null) {
                                bundle.putInt("google.product_id", numE.intValue());
                            }
                            Context context2 = context;
                            bundle.putBoolean("supports_message_handled", true);
                            abstractC2328lC = D.b(context2).c(2, bundle);
                        }
                        final CountDownLatch countDownLatch2 = countDownLatch;
                        abstractC2328lC.b(new Executor() { // from class: P1.m
                            @Override // java.util.concurrent.Executor
                            public final void execute(Runnable runnable) {
                                runnable.run();
                            }
                        }, new InterfaceC2322f() { // from class: P1.n
                            @Override // l2.InterfaceC2322f
                            public final void a(AbstractC2328l abstractC2328l) {
                                countDownLatch2.countDown();
                            }
                        });
                    }
                });
                int iB = b(context, c0757a);
                try {
                    if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                        Log.w("CloudMessagingReceiver", "Message ack timed out");
                    }
                } catch (InterruptedException e8) {
                    Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e8.toString()));
                }
                iE = iB;
            }
            if (z7 && pendingResult != null) {
                pendingResult.setResultCode(iE);
            }
            if (pendingResult != null) {
                pendingResult.finish();
            }
        } catch (Throwable th) {
            if (pendingResult != null) {
                pendingResult.finish();
            }
            throw th;
        }
    }

    public final int e(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if (Objects.equals(intent.getAction(), "com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        a().execute(new Runnable() { // from class: P1.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f6325a.d(intent, context, zIsOrderedBroadcast, pendingResultGoAsync);
            }
        });
    }
}
