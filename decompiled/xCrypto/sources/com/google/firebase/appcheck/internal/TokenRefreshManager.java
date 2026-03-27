package com.google.firebase.appcheck.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.internal.util.Clock;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class TokenRefreshManager {
    private static final long FIVE_MINUTES_IN_MILLIS = 300000;
    private static final long REFRESH_BUFFER_ABSOLUTE_MILLIS = 60000;
    private static final double REFRESH_BUFFER_FRACTION = 0.5d;
    private static final long UNSET_REFRESH_TIME = -1;
    private final Clock clock;
    private volatile int currentListenerCount;
    private volatile boolean isAutoRefreshEnabled;
    private volatile boolean isBackgrounded;
    private volatile long nextRefreshTimeMillis;
    private final DefaultTokenRefresher tokenRefresher;

    public TokenRefreshManager(Context context, DefaultFirebaseAppCheck defaultFirebaseAppCheck, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this((Context) AbstractC0940s.k(context), new DefaultTokenRefresher((DefaultFirebaseAppCheck) AbstractC0940s.k(defaultFirebaseAppCheck), executor, scheduledExecutorService), new Clock.DefaultClock());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldScheduleRefresh() {
        return this.isAutoRefreshEnabled && !this.isBackgrounded && this.currentListenerCount > 0 && this.nextRefreshTimeMillis != -1;
    }

    public void maybeScheduleTokenRefresh(AppCheckToken appCheckToken) {
        DefaultAppCheckToken defaultAppCheckTokenConstructFromRawToken = appCheckToken instanceof DefaultAppCheckToken ? (DefaultAppCheckToken) appCheckToken : DefaultAppCheckToken.constructFromRawToken(appCheckToken.getToken());
        this.nextRefreshTimeMillis = defaultAppCheckTokenConstructFromRawToken.getReceivedAtTimestamp() + ((long) (defaultAppCheckTokenConstructFromRawToken.getExpiresInMillis() * REFRESH_BUFFER_FRACTION)) + FIVE_MINUTES_IN_MILLIS;
        if (this.nextRefreshTimeMillis > defaultAppCheckTokenConstructFromRawToken.getExpireTimeMillis()) {
            this.nextRefreshTimeMillis = defaultAppCheckTokenConstructFromRawToken.getExpireTimeMillis() - 60000;
        }
        if (shouldScheduleRefresh()) {
            this.tokenRefresher.scheduleRefresh(this.nextRefreshTimeMillis - this.clock.currentTimeMillis());
        }
    }

    public void onListenerCountChanged(int i4) {
        if (this.currentListenerCount == 0 && i4 > 0) {
            this.currentListenerCount = i4;
            if (shouldScheduleRefresh()) {
                this.tokenRefresher.scheduleRefresh(this.nextRefreshTimeMillis - this.clock.currentTimeMillis());
            }
        } else if (this.currentListenerCount > 0 && i4 == 0) {
            this.tokenRefresher.cancel();
        }
        this.currentListenerCount = i4;
    }

    public void setIsAutoRefreshEnabled(boolean z4) {
        this.isAutoRefreshEnabled = z4;
    }

    public TokenRefreshManager(Context context, final DefaultTokenRefresher defaultTokenRefresher, final Clock clock) {
        this.tokenRefresher = defaultTokenRefresher;
        this.clock = clock;
        this.nextRefreshTimeMillis = -1L;
        ComponentCallbacks2C0900d.c((Application) context.getApplicationContext());
        ComponentCallbacks2C0900d.b().a(new ComponentCallbacks2C0900d.a() { // from class: com.google.firebase.appcheck.internal.TokenRefreshManager.1
            @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d.a
            public void onBackgroundStateChanged(boolean z4) {
                TokenRefreshManager.this.isBackgrounded = z4;
                if (z4) {
                    defaultTokenRefresher.cancel();
                } else if (TokenRefreshManager.this.shouldScheduleRefresh()) {
                    defaultTokenRefresher.scheduleRefresh(TokenRefreshManager.this.nextRefreshTimeMillis - clock.currentTimeMillis());
                }
            }
        });
    }
}
