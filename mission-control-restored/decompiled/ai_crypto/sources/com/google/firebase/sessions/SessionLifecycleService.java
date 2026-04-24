package com.google.firebase.sessions;

import a6.C0929a;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.sessions.j;
import java.util.ArrayList;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SessionLifecycleService extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12260d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f12261a = new HandlerThread("FirebaseSessions_HandlerThread");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f12262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f12263c;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f12265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f12266c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            r.f(looper, "looper");
            this.f12266c = new ArrayList();
        }

        public final void a() {
            Log.d("SessionLifecycleService", "Broadcasting new session");
            i.f12308a.a().a(j.f12310f.a().c());
            for (Messenger it : new ArrayList(this.f12266c)) {
                r.e(it, "it");
                f(it);
            }
        }

        public final void b(Message message) {
            Log.d("SessionLifecycleService", "Activity backgrounding at " + message.getWhen());
            this.f12265b = message.getWhen();
        }

        public final void c(Message message) {
            this.f12266c.add(message.replyTo);
            Messenger messenger = message.replyTo;
            r.e(messenger, "msg.replyTo");
            f(messenger);
            Log.d("SessionLifecycleService", "Client " + message.replyTo + " bound at " + message.getWhen() + ". Clients: " + this.f12266c.size());
        }

        public final void d(Message message) {
            Log.d("SessionLifecycleService", "Activity foregrounding at " + message.getWhen() + com.amazon.a.a.o.c.a.b.f10001a);
            if (!this.f12264a) {
                Log.d("SessionLifecycleService", "Cold start detected.");
                this.f12264a = true;
                g();
            } else if (e(message.getWhen())) {
                Log.d("SessionLifecycleService", "Session too long in background. Creating new session.");
                g();
            }
            this.f12265b = message.getWhen();
        }

        public final boolean e(long j7) {
            return j7 - this.f12265b > C0929a.r(d4.i.f13385c.a().b());
        }

        public final void f(Messenger messenger) {
            try {
                if (this.f12264a) {
                    h(messenger, j.f12310f.a().c().b());
                } else {
                    String strA = h.f12306a.a().a();
                    Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session.");
                    if (strA != null) {
                        h(messenger, strA);
                    }
                }
            } catch (IllegalStateException e7) {
                Log.w("SessionLifecycleService", "Failed to send session to client.", e7);
            }
        }

        public final void g() {
            try {
                j.a aVar = j.f12310f;
                aVar.a().a();
                Log.d("SessionLifecycleService", "Generated new session.");
                a();
                h.f12306a.a().b(aVar.a().c().b());
            } catch (IllegalStateException e7) {
                Log.w("SessionLifecycleService", "Failed to generate new session.", e7);
            }
        }

        public final void h(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("SessionUpdateExtra", str);
                Message messageObtain = Message.obtain(null, 3, 0, 0);
                messageObtain.setData(bundle);
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
                Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger);
                this.f12266c.remove(messenger);
            } catch (Exception e7) {
                Log.w("SessionLifecycleService", "Unable to push new session to " + messenger + com.amazon.a.a.o.c.a.b.f10001a, e7);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            r.f(msg, "msg");
            if (this.f12265b > msg.getWhen()) {
                Log.d("SessionLifecycleService", "Ignoring old message from " + msg.getWhen() + " which is older than " + this.f12265b + com.amazon.a.a.o.c.a.b.f10001a);
                return;
            }
            int i7 = msg.what;
            if (i7 == 1) {
                d(msg);
                return;
            }
            if (i7 == 2) {
                b(msg);
                return;
            }
            if (i7 == 4) {
                c(msg);
                return;
            }
            Log.w("SessionLifecycleService", "Received unexpected event from the SessionLifecycleClient: " + msg);
            super.handleMessage(msg);
        }
    }

    public final Messenger a(Intent intent) {
        return Build.VERSION.SDK_INT >= 33 ? (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class) : (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger messengerA = a(intent);
        if (messengerA != null) {
            Message messageObtain = Message.obtain(null, 4, 0, 0);
            messageObtain.replyTo = messengerA;
            b bVar = this.f12262b;
            if (bVar != null) {
                bVar.sendMessage(messageObtain);
            }
        }
        Messenger messenger = this.f12263c;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f12261a.start();
        Looper looper = this.f12261a.getLooper();
        r.e(looper, "handlerThread.looper");
        this.f12262b = new b(looper);
        this.f12263c = new Messenger(this.f12262b);
        Log.d("SessionLifecycleService", "Service created on process " + Process.myPid());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f12261a.quit();
    }
}
