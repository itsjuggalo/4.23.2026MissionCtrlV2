package io.flutter.plugins.firebase.messaging;

import L4.k;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import h5.C1728e;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class FlutterFirebaseMessagingBackgroundService extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List f16821i = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static C1728e f16822j;

    public static void k(Context context, Intent intent, boolean z7) {
        a.d(context, FlutterFirebaseMessagingBackgroundService.class, 2020, intent, z7);
    }

    public static /* synthetic */ void l(Intent intent, CountDownLatch countDownLatch) {
        f16822j.d(intent, countDownLatch);
    }

    public static void m() {
        Log.i("FLTFireMsgService", "FlutterFirebaseMessagingBackgroundService started!");
        List list = f16821i;
        synchronized (list) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    f16822j.d((Intent) it.next(), null);
                }
                f16821i.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void n(long j7) {
        C1728e.m(j7);
    }

    public static void o(long j7) {
        C1728e.n(j7);
    }

    public static void p(long j7, k kVar) {
        if (f16822j != null) {
            Log.w("FLTFireMsgService", "Attempted to start a duplicate background isolate. Returning...");
            return;
        }
        C1728e c1728e = new C1728e();
        f16822j = c1728e;
        c1728e.p(j7, kVar);
    }

    @Override // io.flutter.plugins.firebase.messaging.a
    public void g(final Intent intent) {
        if (!f16822j.h()) {
            Log.w("FLTFireMsgService", "A background message could not be handled in Dart as no onBackgroundMessage handler has been registered.");
            return;
        }
        List list = f16821i;
        synchronized (list) {
            try {
                if (f16822j.i()) {
                    Log.i("FLTFireMsgService", "Service has not yet started, messages will be queued.");
                    list.add(intent);
                    return;
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(getMainLooper()).post(new Runnable() { // from class: h5.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlutterFirebaseMessagingBackgroundService.l(intent, countDownLatch);
                    }
                });
                try {
                    countDownLatch.await();
                } catch (InterruptedException e7) {
                    Log.i("FLTFireMsgService", "Exception waiting to execute Dart callback", e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.flutter.plugins.firebase.messaging.a
    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    @Override // io.flutter.plugins.firebase.messaging.a, android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // io.flutter.plugins.firebase.messaging.a, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (f16822j == null) {
            f16822j = new C1728e();
        }
        f16822j.o();
    }

    @Override // io.flutter.plugins.firebase.messaging.a, android.app.Service
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // io.flutter.plugins.firebase.messaging.a, android.app.Service
    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i7, int i8) {
        return super.onStartCommand(intent, i7, i8);
    }
}
