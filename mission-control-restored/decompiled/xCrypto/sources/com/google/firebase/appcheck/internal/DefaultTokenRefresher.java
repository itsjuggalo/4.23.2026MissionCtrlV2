package com.google.firebase.appcheck.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTokenRefresher {
    static final long INITIAL_DELAY_SECONDS = 30;
    static final long MAX_DELAY_SECONDS = 960;
    private static final long UNSET_DELAY = -1;
    private volatile long delayAfterFailureSeconds = -1;
    private final DefaultFirebaseAppCheck firebaseAppCheck;
    private final Executor liteExecutor;
    private volatile ScheduledFuture<?> refreshFuture;
    private final ScheduledExecutorService scheduledExecutorService;

    public DefaultTokenRefresher(DefaultFirebaseAppCheck defaultFirebaseAppCheck, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseAppCheck = (DefaultFirebaseAppCheck) AbstractC0940s.k(defaultFirebaseAppCheck);
        this.liteExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    private long getNextRefreshMillis() {
        return this.delayAfterFailureSeconds == -1 ? INITIAL_DELAY_SECONDS : this.delayAfterFailureSeconds * 2 < MAX_DELAY_SECONDS ? this.delayAfterFailureSeconds * 2 : MAX_DELAY_SECONDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefresh() {
        this.firebaseAppCheck.fetchTokenFromProvider().addOnFailureListener(this.liteExecutor, new OnFailureListener() { // from class: com.google.firebase.appcheck.internal.h
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f10217a.scheduleRefreshAfterFailure();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRefreshAfterFailure() {
        cancel();
        this.delayAfterFailureSeconds = getNextRefreshMillis();
        this.refreshFuture = this.scheduledExecutorService.schedule(new i(this), this.delayAfterFailureSeconds, TimeUnit.SECONDS);
    }

    public void cancel() {
        if (this.refreshFuture == null || this.refreshFuture.isDone()) {
            return;
        }
        this.refreshFuture.cancel(false);
    }

    public void scheduleRefresh(long j4) {
        cancel();
        this.delayAfterFailureSeconds = -1L;
        this.refreshFuture = this.scheduledExecutorService.schedule(new i(this), Math.max(0L, j4), TimeUnit.MILLISECONDS);
    }
}
