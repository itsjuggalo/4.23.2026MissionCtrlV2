package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.messaging.n0;
import java.util.concurrent.ExecutorService;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import l2.InterfaceC2322f;
import w0.ExecutorC2893k;

/* JADX INFO: renamed from: com.google.firebase.messaging.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractServiceC1438i extends Service {
    static final long MESSAGE_TIMEOUT_S = 20;
    private static final String TAG = "EnhancedIntentService";
    private Binder binder;
    private int lastStartId;
    final ExecutorService executor = AbstractC1444o.d();
    private final Object lock = new Object();
    private int runningTasks = 0;

    /* JADX INFO: renamed from: com.google.firebase.messaging.i$a */
    public class a implements n0.a {
        public a() {
        }

        @Override // com.google.firebase.messaging.n0.a
        public AbstractC2328l a(Intent intent) {
            return AbstractServiceC1438i.this.f(intent);
        }
    }

    public final void c(Intent intent) {
        if (intent != null) {
            l0.c(intent);
        }
        synchronized (this.lock) {
            try {
                int i8 = this.runningTasks - 1;
                this.runningTasks = i8;
                if (i8 == 0) {
                    stopSelfResultHook(this.lastStartId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void d(Intent intent, AbstractC2328l abstractC2328l) {
        c(intent);
    }

    public final /* synthetic */ void e(Intent intent, C2329m c2329m) {
        try {
            handleIntent(intent);
        } finally {
            c2329m.c(null);
        }
    }

    public final AbstractC2328l f(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return AbstractC2331o.e(null);
        }
        final C2329m c2329m = new C2329m();
        this.executor.execute(new Runnable() { // from class: com.google.firebase.messaging.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f15735a.e(intent, c2329m);
            }
        });
        return c2329m.a();
    }

    public abstract Intent getStartCommandIntent(Intent intent);

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Service received bind request");
            }
            if (this.binder == null) {
                this.binder = new n0(new a());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.binder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i8, int i9) {
        synchronized (this.lock) {
            this.lastStartId = i9;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            c(intent);
            return 2;
        }
        AbstractC2328l abstractC2328lF = f(startCommandIntent);
        if (abstractC2328lF.n()) {
            c(intent);
            return 2;
        }
        abstractC2328lF.b(new ExecutorC2893k(), new InterfaceC2322f() { // from class: com.google.firebase.messaging.g
            @Override // l2.InterfaceC2322f
            public final void a(AbstractC2328l abstractC2328l) {
                this.f15729a.d(intent, abstractC2328l);
            }
        });
        return 3;
    }

    public boolean stopSelfResultHook(int i8) {
        return stopSelfResult(i8);
    }
}
