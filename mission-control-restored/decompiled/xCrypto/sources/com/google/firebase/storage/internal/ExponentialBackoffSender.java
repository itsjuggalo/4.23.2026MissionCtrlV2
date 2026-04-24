package com.google.firebase.storage.internal;

import G1.d;
import G1.g;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class ExponentialBackoffSender {
    private static final int MAXIMUM_WAIT_TIME_MILLI = 30000;
    private static final int NETWORK_STATUS_POLL_INTERVAL = 1000;
    public static final int RND_MAX = 250;
    private static final String TAG = "ExponenentialBackoff";
    private final InteropAppCheckTokenProvider appCheckProvider;
    private final InternalAuthProvider authProvider;
    private volatile boolean canceled;
    private final Context context;
    private long retryTime;
    private static final Random random = new Random();
    static Sleeper sleeper = new SleeperImpl();
    static d clock = g.c();

    public ExponentialBackoffSender(Context context, InternalAuthProvider internalAuthProvider, InteropAppCheckTokenProvider interopAppCheckTokenProvider, long j4) {
        this.context = context;
        this.authProvider = internalAuthProvider;
        this.appCheckProvider = interopAppCheckTokenProvider;
        this.retryTime = j4;
    }

    public void cancel() {
        this.canceled = true;
    }

    public boolean isRetryableError(int i4) {
        return (i4 >= 500 && i4 < 600) || i4 == -2 || i4 == 429 || i4 == 408;
    }

    public void reset() {
        this.canceled = false;
    }

    public void sendWithExponentialBackoff(NetworkRequest networkRequest) {
        sendWithExponentialBackoff(networkRequest, true);
    }

    public void sendWithExponentialBackoff(NetworkRequest networkRequest, boolean z4) {
        AbstractC0940s.k(networkRequest);
        long jA = clock.a() + this.retryTime;
        if (z4) {
            networkRequest.performRequest(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider), this.context);
        } else {
            networkRequest.performRequestStart(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider));
        }
        int i4 = NETWORK_STATUS_POLL_INTERVAL;
        while (clock.a() + ((long) i4) <= jA && !networkRequest.isResultSuccess() && isRetryableError(networkRequest.getResultCode())) {
            try {
                sleeper.sleep(random.nextInt(RND_MAX) + i4);
                if (i4 < MAXIMUM_WAIT_TIME_MILLI) {
                    if (networkRequest.getResultCode() != -2) {
                        i4 *= 2;
                        Log.w(TAG, "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w(TAG, "network unavailable, sleeping.");
                        i4 = NETWORK_STATUS_POLL_INTERVAL;
                    }
                }
                if (this.canceled) {
                    return;
                }
                networkRequest.reset();
                if (z4) {
                    networkRequest.performRequest(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider), this.context);
                } else {
                    networkRequest.performRequestStart(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider));
                }
            } catch (InterruptedException unused) {
                Log.w(TAG, "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
