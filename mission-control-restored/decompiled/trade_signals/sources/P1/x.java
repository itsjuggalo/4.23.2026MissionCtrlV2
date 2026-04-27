package P1;

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
import com.google.android.gms.common.internal.AbstractC1294n;
import d2.HandlerC1624f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class x implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f6340c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ D f6343f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6338a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Messenger f6339b = new Messenger(new HandlerC1624f(Looper.getMainLooper(), new Handler.Callback() { // from class: P1.u
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i8 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i8);
            }
            x xVar = this.f6335a;
            synchronized (xVar) {
                try {
                    A a8 = (A) xVar.f6342e.get(i8);
                    if (a8 == null) {
                        Log.w("MessengerIpcClient", "Received response for unknown request: " + i8);
                        return true;
                    }
                    xVar.f6342e.remove(i8);
                    xVar.f();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        a8.c(new B(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    a8.a(data);
                    return true;
                } finally {
                }
            }
        }
    }));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f6341d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray f6342e = new SparseArray();

    public /* synthetic */ x(D d8, w wVar) {
        this.f6343f = d8;
    }

    public final synchronized void a(int i8, String str) {
        b(i8, str, null);
    }

    public final synchronized void b(int i8, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i9 = this.f6338a;
            if (i9 == 0) {
                throw new IllegalStateException();
            }
            if (i9 != 1 && i9 != 2) {
                if (i9 != 3) {
                    return;
                }
                this.f6338a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f6338a = 4;
            V1.a.b().c(this.f6343f.f6287a, this);
            B b8 = new B(i8, str, th);
            Iterator it = this.f6341d.iterator();
            while (it.hasNext()) {
                ((A) it.next()).c(b8);
            }
            this.f6341d.clear();
            for (int i10 = 0; i10 < this.f6342e.size(); i10++) {
                ((A) this.f6342e.valueAt(i10)).c(b8);
            }
            this.f6342e.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c() {
        this.f6343f.f6288b.execute(new Runnable() { // from class: P1.r
            @Override // java.lang.Runnable
            public final void run() {
                final A a8;
                while (true) {
                    final x xVar = this.f6332a;
                    synchronized (xVar) {
                        try {
                            if (xVar.f6338a != 2) {
                                return;
                            }
                            if (xVar.f6341d.isEmpty()) {
                                xVar.f();
                                return;
                            } else {
                                a8 = (A) xVar.f6341d.poll();
                                xVar.f6342e.put(a8.f6282a, a8);
                                xVar.f6343f.f6288b.schedule(new Runnable() { // from class: P1.v
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        xVar.e(a8.f6282a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(a8)));
                    }
                    D d8 = xVar.f6343f;
                    Messenger messenger = xVar.f6339b;
                    int i8 = a8.f6284c;
                    Context context = d8.f6287a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i8;
                    messageObtain.arg1 = a8.f6282a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", a8.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", a8.f6285d);
                    messageObtain.setData(bundle);
                    try {
                        xVar.f6340c.a(messageObtain);
                    } catch (RemoteException e8) {
                        xVar.a(2, e8.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void d() {
        if (this.f6338a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void e(int i8) {
        A a8 = (A) this.f6342e.get(i8);
        if (a8 != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i8);
            this.f6342e.remove(i8);
            a8.c(new B(3, "Timed out waiting for response", null));
            f();
        }
    }

    public final synchronized void f() {
        try {
            if (this.f6338a == 2 && this.f6341d.isEmpty() && this.f6342e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f6338a = 3;
                V1.a.b().c(this.f6343f.f6287a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean g(A a8) {
        int i8 = this.f6338a;
        if (i8 != 0) {
            if (i8 == 1) {
                this.f6341d.add(a8);
                return true;
            }
            if (i8 != 2) {
                return false;
            }
            this.f6341d.add(a8);
            c();
            return true;
        }
        this.f6341d.add(a8);
        AbstractC1294n.m(this.f6338a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f6338a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (V1.a.b().a(this.f6343f.f6287a, intent, this, 1)) {
                this.f6343f.f6288b.schedule(new Runnable() { // from class: P1.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6333a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e8) {
            b(0, "Unable to bind to service", e8);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f6343f.f6288b.execute(new Runnable() { // from class: P1.q
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.f6330a;
                IBinder iBinder2 = iBinder;
                synchronized (xVar) {
                    if (iBinder2 == null) {
                        xVar.a(0, "Null service connection");
                        return;
                    }
                    try {
                        xVar.f6340c = new y(iBinder2);
                        xVar.f6338a = 2;
                        xVar.c();
                    } catch (RemoteException e8) {
                        xVar.a(0, e8.getMessage());
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
        this.f6343f.f6288b.execute(new Runnable() { // from class: P1.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f6334a.a(2, "Service disconnected");
            }
        });
    }
}
