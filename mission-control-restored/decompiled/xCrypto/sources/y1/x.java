package y1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.firebase.messaging.Constants;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class x implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f15906c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ D f15909f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15904a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Messenger f15905b = new Messenger(new zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: y1.u
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i4 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i4);
            }
            x xVar = this.f15901a;
            synchronized (xVar) {
                try {
                    AbstractC1937A abstractC1937A = (AbstractC1937A) xVar.f15908e.get(i4);
                    if (abstractC1937A == null) {
                        Log.w("MessengerIpcClient", "Received response for unknown request: " + i4);
                        return true;
                    }
                    xVar.f15908e.remove(i4);
                    xVar.f();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        abstractC1937A.c(new B(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    abstractC1937A.a(data);
                    return true;
                } finally {
                }
            }
        }
    }));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f15907d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray f15908e = new SparseArray();

    public /* synthetic */ x(D d4, w wVar) {
        this.f15909f = d4;
    }

    public final synchronized void a(int i4, String str) {
        b(i4, str, null);
    }

    public final synchronized void b(int i4, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i5 = this.f15904a;
            if (i5 == 0) {
                throw new IllegalStateException();
            }
            if (i5 != 1 && i5 != 2) {
                if (i5 != 3) {
                    return;
                }
                this.f15904a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f15904a = 4;
            F1.b.b().c(this.f15909f.f15855a, this);
            B b4 = new B(i4, str, th);
            Iterator it = this.f15907d.iterator();
            while (it.hasNext()) {
                ((AbstractC1937A) it.next()).c(b4);
            }
            this.f15907d.clear();
            for (int i6 = 0; i6 < this.f15908e.size(); i6++) {
                ((AbstractC1937A) this.f15908e.valueAt(i6)).c(b4);
            }
            this.f15908e.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c() {
        this.f15909f.f15856b.execute(new Runnable() { // from class: y1.r
            @Override // java.lang.Runnable
            public final void run() {
                final AbstractC1937A abstractC1937A;
                while (true) {
                    final x xVar = this.f15898a;
                    synchronized (xVar) {
                        try {
                            if (xVar.f15904a != 2) {
                                return;
                            }
                            if (xVar.f15907d.isEmpty()) {
                                xVar.f();
                                return;
                            } else {
                                abstractC1937A = (AbstractC1937A) xVar.f15907d.poll();
                                xVar.f15908e.put(abstractC1937A.f15850a, abstractC1937A);
                                xVar.f15909f.f15856b.schedule(new Runnable() { // from class: y1.v
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        xVar.e(abstractC1937A.f15850a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } finally {
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(abstractC1937A)));
                    }
                    D d4 = xVar.f15909f;
                    Messenger messenger = xVar.f15905b;
                    int i4 = abstractC1937A.f15852c;
                    Context context = d4.f15855a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i4;
                    messageObtain.arg1 = abstractC1937A.f15850a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", abstractC1937A.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, abstractC1937A.f15853d);
                    messageObtain.setData(bundle);
                    try {
                        xVar.f15906c.a(messageObtain);
                    } catch (RemoteException e4) {
                        xVar.a(2, e4.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void d() {
        if (this.f15904a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void e(int i4) {
        AbstractC1937A abstractC1937A = (AbstractC1937A) this.f15908e.get(i4);
        if (abstractC1937A != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i4);
            this.f15908e.remove(i4);
            abstractC1937A.c(new B(3, "Timed out waiting for response", null));
            f();
        }
    }

    public final synchronized void f() {
        try {
            if (this.f15904a == 2 && this.f15907d.isEmpty() && this.f15908e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f15904a = 3;
                F1.b.b().c(this.f15909f.f15855a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean g(AbstractC1937A abstractC1937A) {
        int i4 = this.f15904a;
        if (i4 != 0) {
            if (i4 == 1) {
                this.f15907d.add(abstractC1937A);
                return true;
            }
            if (i4 != 2) {
                return false;
            }
            this.f15907d.add(abstractC1937A);
            c();
            return true;
        }
        this.f15907d.add(abstractC1937A);
        AbstractC0940s.n(this.f15904a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f15904a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (F1.b.b().a(this.f15909f.f15855a, intent, this, 1)) {
                this.f15909f.f15856b.schedule(new Runnable() { // from class: y1.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15899a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e4) {
            b(0, "Unable to bind to service", e4);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f15909f.f15856b.execute(new Runnable() { // from class: y1.q
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.f15896a;
                IBinder iBinder2 = iBinder;
                synchronized (xVar) {
                    if (iBinder2 == null) {
                        xVar.a(0, "Null service connection");
                        return;
                    }
                    try {
                        xVar.f15906c = new y(iBinder2);
                        xVar.f15904a = 2;
                        xVar.c();
                    } catch (RemoteException e4) {
                        xVar.a(0, e4.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f15909f.f15856b.execute(new Runnable() { // from class: y1.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f15900a.a(2, "Service disconnected");
            }
        });
    }
}
