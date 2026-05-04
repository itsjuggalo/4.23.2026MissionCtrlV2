package l5;

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
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f15488c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d0 f15491f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15486a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Messenger f15487b = new Messenger(new zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: l5.u
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i10);
            }
            x xVar = this.f15483a;
            synchronized (xVar) {
                try {
                    a0 a0Var = (a0) xVar.f15490e.get(i10);
                    if (a0Var == null) {
                        Log.w("MessengerIpcClient", "Received response for unknown request: " + i10);
                        return true;
                    }
                    xVar.f15490e.remove(i10);
                    xVar.f();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        a0Var.c(new b0(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    a0Var.a(data);
                    return true;
                } finally {
                }
            }
        }
    }));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f15489d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray f15490e = new SparseArray();

    public /* synthetic */ x(d0 d0Var, w wVar) {
        this.f15491f = d0Var;
    }

    public final synchronized void a(int i10, String str) {
        b(i10, str, null);
    }

    public final synchronized void b(int i10, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i11 = this.f15486a;
            if (i11 == 0) {
                throw new IllegalStateException();
            }
            if (i11 != 1 && i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.f15486a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f15486a = 4;
            s5.a.b().c(this.f15491f.f15449a, this);
            b0 b0Var = new b0(i10, str, th);
            Iterator it = this.f15489d.iterator();
            while (it.hasNext()) {
                ((a0) it.next()).c(b0Var);
            }
            this.f15489d.clear();
            for (int i12 = 0; i12 < this.f15490e.size(); i12++) {
                ((a0) this.f15490e.valueAt(i12)).c(b0Var);
            }
            this.f15490e.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c() {
        this.f15491f.f15450b.execute(new Runnable() { // from class: l5.r
            @Override // java.lang.Runnable
            public final void run() {
                final a0 a0Var;
                while (true) {
                    final x xVar = this.f15480a;
                    synchronized (xVar) {
                        try {
                            if (xVar.f15486a != 2) {
                                return;
                            }
                            if (xVar.f15489d.isEmpty()) {
                                xVar.f();
                                return;
                            } else {
                                a0Var = (a0) xVar.f15489d.poll();
                                xVar.f15490e.put(a0Var.f15431a, a0Var);
                                xVar.f15491f.f15450b.schedule(new Runnable() { // from class: l5.v
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        xVar.e(a0Var.f15431a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } finally {
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(a0Var)));
                    }
                    d0 d0Var = xVar.f15491f;
                    Messenger messenger = xVar.f15487b;
                    int i10 = a0Var.f15433c;
                    Context context = d0Var.f15449a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i10;
                    messageObtain.arg1 = a0Var.f15431a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", a0Var.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", a0Var.f15434d);
                    messageObtain.setData(bundle);
                    try {
                        xVar.f15488c.a(messageObtain);
                    } catch (RemoteException e10) {
                        xVar.a(2, e10.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void d() {
        if (this.f15486a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void e(int i10) {
        a0 a0Var = (a0) this.f15490e.get(i10);
        if (a0Var != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i10);
            this.f15490e.remove(i10);
            a0Var.c(new b0(3, "Timed out waiting for response", null));
            f();
        }
    }

    public final synchronized void f() {
        try {
            if (this.f15486a == 2 && this.f15489d.isEmpty() && this.f15490e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f15486a = 3;
                s5.a.b().c(this.f15491f.f15449a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean g(a0 a0Var) {
        int i10 = this.f15486a;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f15489d.add(a0Var);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            this.f15489d.add(a0Var);
            c();
            return true;
        }
        this.f15489d.add(a0Var);
        com.google.android.gms.common.internal.s.n(this.f15486a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f15486a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (s5.a.b().a(this.f15491f.f15449a, intent, this, 1)) {
                this.f15491f.f15450b.schedule(new Runnable() { // from class: l5.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15481a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e10) {
            b(0, "Unable to bind to service", e10);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f15491f.f15450b.execute(new Runnable() { // from class: l5.q
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.f15478a;
                IBinder iBinder2 = iBinder;
                synchronized (xVar) {
                    if (iBinder2 == null) {
                        xVar.a(0, "Null service connection");
                        return;
                    }
                    try {
                        xVar.f15488c = new y(iBinder2);
                        xVar.f15486a = 2;
                        xVar.c();
                    } catch (RemoteException e10) {
                        xVar.a(0, e10.getMessage());
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
        this.f15491f.f15450b.execute(new Runnable() { // from class: l5.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f15482a.a(2, "Service disconnected");
            }
        });
    }
}
