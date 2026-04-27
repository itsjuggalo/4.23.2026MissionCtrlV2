package O1;

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
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class x implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f4106c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ D f4109f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4104a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Messenger f4105b = new Messenger(new zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: O1.u
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i7 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i7);
            }
            x xVar = this.f4101a;
            synchronized (xVar) {
                try {
                    A a7 = (A) xVar.f4108e.get(i7);
                    if (a7 == null) {
                        Log.w("MessengerIpcClient", "Received response for unknown request: " + i7);
                        return true;
                    }
                    xVar.f4108e.remove(i7);
                    xVar.f();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        a7.c(new B(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    a7.a(data);
                    return true;
                } finally {
                }
            }
        }
    }));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f4107d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray f4108e = new SparseArray();

    public /* synthetic */ x(D d7, w wVar) {
        this.f4109f = d7;
    }

    public final synchronized void a(int i7, String str) {
        b(i7, str, null);
    }

    public final synchronized void b(int i7, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i8 = this.f4104a;
            if (i8 == 0) {
                throw new IllegalStateException();
            }
            if (i8 != 1 && i8 != 2) {
                if (i8 != 3) {
                    return;
                }
                this.f4104a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f4104a = 4;
            V1.b.b().c(this.f4109f.f4053a, this);
            B b7 = new B(i7, str, th);
            Iterator it = this.f4107d.iterator();
            while (it.hasNext()) {
                ((A) it.next()).c(b7);
            }
            this.f4107d.clear();
            for (int i9 = 0; i9 < this.f4108e.size(); i9++) {
                ((A) this.f4108e.valueAt(i9)).c(b7);
            }
            this.f4108e.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c() {
        this.f4109f.f4054b.execute(new Runnable() { // from class: O1.r
            @Override // java.lang.Runnable
            public final void run() {
                final A a7;
                while (true) {
                    final x xVar = this.f4098a;
                    synchronized (xVar) {
                        try {
                            if (xVar.f4104a != 2) {
                                return;
                            }
                            if (xVar.f4107d.isEmpty()) {
                                xVar.f();
                                return;
                            } else {
                                a7 = (A) xVar.f4107d.poll();
                                xVar.f4108e.put(a7.f4048a, a7);
                                xVar.f4109f.f4054b.schedule(new Runnable() { // from class: O1.v
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        xVar.e(a7.f4048a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(a7)));
                    }
                    D d7 = xVar.f4109f;
                    Messenger messenger = xVar.f4105b;
                    int i7 = a7.f4050c;
                    Context context = d7.f4053a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i7;
                    messageObtain.arg1 = a7.f4048a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", a7.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", a7.f4051d);
                    messageObtain.setData(bundle);
                    try {
                        xVar.f4106c.a(messageObtain);
                    } catch (RemoteException e7) {
                        xVar.a(2, e7.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void d() {
        if (this.f4104a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void e(int i7) {
        A a7 = (A) this.f4108e.get(i7);
        if (a7 != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i7);
            this.f4108e.remove(i7);
            a7.c(new B(3, "Timed out waiting for response", null));
            f();
        }
    }

    public final synchronized void f() {
        try {
            if (this.f4104a == 2 && this.f4107d.isEmpty() && this.f4108e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f4104a = 3;
                V1.b.b().c(this.f4109f.f4053a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean g(A a7) {
        int i7 = this.f4104a;
        if (i7 != 0) {
            if (i7 == 1) {
                this.f4107d.add(a7);
                return true;
            }
            if (i7 != 2) {
                return false;
            }
            this.f4107d.add(a7);
            c();
            return true;
        }
        this.f4107d.add(a7);
        AbstractC1207s.n(this.f4104a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f4104a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (V1.b.b().a(this.f4109f.f4053a, intent, this, 1)) {
                this.f4109f.f4054b.schedule(new Runnable() { // from class: O1.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f4099a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e7) {
            b(0, "Unable to bind to service", e7);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f4109f.f4054b.execute(new Runnable() { // from class: O1.q
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.f4096a;
                IBinder iBinder2 = iBinder;
                synchronized (xVar) {
                    if (iBinder2 == null) {
                        xVar.a(0, "Null service connection");
                        return;
                    }
                    try {
                        xVar.f4106c = new y(iBinder2);
                        xVar.f4104a = 2;
                        xVar.c();
                    } catch (RemoteException e7) {
                        xVar.a(0, e7.getMessage());
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
        this.f4109f.f4054b.execute(new Runnable() { // from class: O1.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f4100a.a(2, "Service disconnected");
            }
        });
    }
}
