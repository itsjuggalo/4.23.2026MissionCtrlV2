package t;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import b.AbstractBinderC0370b;
import b.C0369a;
import b.InterfaceC0371c;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class V implements Handler.Callback, ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f9792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f9793c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashSet f9794d = new HashSet();

    public V(Context context) {
        this.f9791a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f9792b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(U u6) {
        boolean z6;
        ArrayDeque arrayDeque;
        boolean zIsLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = u6.f9787a;
        if (zIsLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + u6.f9790d.size() + " queued tasks");
        }
        if (u6.f9790d.isEmpty()) {
            return;
        }
        if (u6.f9788b) {
            z6 = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.f9791a;
            boolean zBindService = context.bindService(component, this, 33);
            u6.f9788b = zBindService;
            if (zBindService) {
                u6.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z6 = u6.f9788b;
        }
        if (!z6 || u6.f9789c == null) {
            b(u6);
            return;
        }
        while (true) {
            arrayDeque = u6.f9790d;
            S s6 = (S) arrayDeque.peek();
            if (s6 == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Sending task " + s6);
                }
                s6.a(u6.f9789c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Remote service has died: " + componentName);
                }
            } catch (RemoteException e) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        b(u6);
    }

    public final void b(U u6) {
        Handler handler = this.f9792b;
        ComponentName componentName = u6.f9787a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i = u6.e;
        int i6 = i + 1;
        u6.e = i6;
        if (i6 <= 6) {
            int i7 = (1 << i) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i7 + " ms");
            }
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i7);
            return;
        }
        StringBuilder sb = new StringBuilder("Giving up on delivering ");
        ArrayDeque arrayDeque = u6.f9790d;
        sb.append(arrayDeque.size());
        sb.append(" tasks to ");
        sb.append(componentName);
        sb.append(" after ");
        sb.append(u6.e);
        sb.append(" retries");
        Log.w("NotifManCompat", sb.toString());
        arrayDeque.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i = message.what;
        InterfaceC0371c interfaceC0371c = null;
        if (i == 0) {
            S s6 = (S) message.obj;
            String string = Settings.Secure.getString(this.f9791a.getContentResolver(), "enabled_notification_listeners");
            synchronized (W.f9795c) {
                if (string != null) {
                    try {
                        if (!string.equals(W.f9796d)) {
                            String[] strArrSplit = string.split(":", -1);
                            HashSet hashSet2 = new HashSet(strArrSplit.length);
                            for (String str : strArrSplit) {
                                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                                if (componentNameUnflattenFromString != null) {
                                    hashSet2.add(componentNameUnflattenFromString.getPackageName());
                                }
                            }
                            W.e = hashSet2;
                            W.f9796d = string;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                hashSet = W.e;
            }
            if (!hashSet.equals(this.f9794d)) {
                this.f9794d = hashSet;
                List<ResolveInfo> listQueryIntentServices = this.f9791a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet3 = new HashSet();
                for (ResolveInfo resolveInfo : listQueryIntentServices) {
                    if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet3.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet3) {
                    if (!this.f9793c.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f9793c.put(componentName2, new U(componentName2));
                    }
                }
                Iterator it = this.f9793c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!hashSet3.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        U u6 = (U) entry.getValue();
                        if (u6.f9788b) {
                            this.f9791a.unbindService(this);
                            u6.f9788b = false;
                        }
                        u6.f9789c = null;
                        it.remove();
                    }
                }
            }
            for (U u7 : this.f9793c.values()) {
                u7.f9790d.add(s6);
                a(u7);
            }
        } else if (i == 1) {
            T t6 = (T) message.obj;
            ComponentName componentName3 = t6.f9785a;
            IBinder iBinder = t6.f9786b;
            U u8 = (U) this.f9793c.get(componentName3);
            if (u8 != null) {
                int i6 = AbstractBinderC0370b.f4807a;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0371c.f4808g);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0371c)) {
                        C0369a c0369a = new C0369a();
                        c0369a.f4806a = iBinder;
                        interfaceC0371c = c0369a;
                    } else {
                        interfaceC0371c = (InterfaceC0371c) iInterfaceQueryLocalInterface;
                    }
                }
                u8.f9789c = interfaceC0371c;
                u8.e = 0;
                a(u8);
                return true;
            }
        } else if (i == 2) {
            U u9 = (U) this.f9793c.get((ComponentName) message.obj);
            if (u9 != null) {
                if (u9.f9788b) {
                    this.f9791a.unbindService(this);
                    u9.f9788b = false;
                }
                u9.f9789c = null;
                return true;
            }
        } else {
            if (i != 3) {
                return false;
            }
            U u10 = (U) this.f9793c.get((ComponentName) message.obj);
            if (u10 != null) {
                a(u10);
                return true;
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f9792b.obtainMessage(1, new T(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f9792b.obtainMessage(2, componentName).sendToTarget();
    }
}
