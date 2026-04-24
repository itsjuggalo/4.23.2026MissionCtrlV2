package t1;

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
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.cloudmessaging.zzf;
import e3.v;
import io.flutter.plugin.platform.p;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class l implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f9900c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f9902f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9898a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Messenger f9899b = new Messenger(new zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: t1.j
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i);
            }
            l lVar = this.f9894a;
            synchronized (lVar) {
                try {
                    m mVar = (m) lVar.e.get(i);
                    if (mVar == null) {
                        Log.w("MessengerIpcClient", "Received response for unknown request: " + i);
                        return true;
                    }
                    lVar.e.remove(i);
                    lVar.c();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        mVar.b(new v("Not supported by GmsCore", null));
                        return true;
                    }
                    switch (mVar.e) {
                        case 0:
                            if (data.getBoolean("ack", false)) {
                                mVar.c(null);
                                return true;
                            }
                            mVar.b(new v("Invalid response to one way request", null));
                            return true;
                        default:
                            Bundle bundle = data.getBundle("data");
                            if (bundle == null) {
                                bundle = Bundle.EMPTY;
                            }
                            mVar.c(bundle);
                            return true;
                    }
                } finally {
                }
            }
        }
    }));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f9901d = new ArrayDeque();
    public final SparseArray e = new SparseArray();

    public final synchronized void a(String str) {
        b(str, null);
    }

    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i = this.f9898a;
            if (i == 0) {
                throw new IllegalStateException();
            }
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                this.f9898a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f9898a = 4;
            A1.b.b().c((Context) this.f9902f.f9908b, this);
            v vVar = new v(str, securityException);
            Iterator it = this.f9901d.iterator();
            while (it.hasNext()) {
                ((m) it.next()).b(vVar);
            }
            this.f9901d.clear();
            for (int i6 = 0; i6 < this.e.size(); i6++) {
                ((m) this.e.valueAt(i6)).b(vVar);
            }
            this.e.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f9898a == 2 && this.f9901d.isEmpty() && this.e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f9898a = 3;
                A1.b.b().c((Context) this.f9902f.f9908b, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(m mVar) {
        int i = this.f9898a;
        if (i != 0) {
            if (i == 1) {
                this.f9901d.add(mVar);
                return true;
            }
            if (i != 2) {
                return false;
            }
            this.f9901d.add(mVar);
            ((ScheduledExecutorService) this.f9902f.f9909c).execute(new i(this, 0));
            return true;
        }
        this.f9901d.add(mVar);
        if (this.f9898a != 0) {
            throw new IllegalStateException();
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f9898a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (A1.b.b().a((Context) this.f9902f.f9908b, intent, this, 1)) {
                ((ScheduledExecutorService) this.f9902f.f9909c).schedule(new i(this, 1), 30L, TimeUnit.SECONDS);
            } else {
                a("Unable to bind to service");
            }
        } catch (SecurityException e) {
            b("Unable to bind to service", e);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        ((ScheduledExecutorService) this.f9902f.f9909c).execute(new A.a(29, this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        ((ScheduledExecutorService) this.f9902f.f9909c).execute(new i(this, 2));
    }
}
