package h0;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import b.a;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10884d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f10887g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f10889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f10883c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f10885e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f10886f = new Object();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public static List a(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f10893d;

        public c(String str, int i10, String str2, Notification notification) {
            this.f10890a = str;
            this.f10891b = i10;
            this.f10892c = str2;
            this.f10893d = notification;
        }

        @Override // h0.m.f
        public void a(b.a aVar) {
            aVar.E(this.f10890a, this.f10891b, this.f10892c, this.f10893d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f10890a + ", id:" + this.f10891b + ", tag:" + this.f10892c + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f10894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f10895b;

        public d(ComponentName componentName, IBinder iBinder) {
            this.f10894a = componentName;
            this.f10895b = iBinder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f10896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f10897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f10898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f10899d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f10900e = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f10901a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b.a f10903c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f10902b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque f10904d = new ArrayDeque();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f10905e = 0;

            public a(ComponentName componentName) {
                this.f10901a = componentName;
            }
        }

        public e(Context context) {
            this.f10896a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f10897b = handlerThread;
            handlerThread.start();
            this.f10898c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f10902b) {
                return true;
            }
            boolean zBindService = this.f10896a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f10901a), this, 33);
            aVar.f10902b = zBindService;
            if (zBindService) {
                aVar.f10905e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f10901a);
                this.f10896a.unbindService(this);
            }
            return aVar.f10902b;
        }

        public final void b(a aVar) {
            if (aVar.f10902b) {
                this.f10896a.unbindService(this);
                aVar.f10902b = false;
            }
            aVar.f10903c = null;
        }

        public final void c(f fVar) {
            j();
            for (a aVar : this.f10899d.values()) {
                aVar.f10904d.add(fVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f10899d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f10899d.get(componentName);
            if (aVar != null) {
                aVar.f10903c = a.AbstractBinderC0045a.H(iBinder);
                aVar.f10905e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f10899d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f10901a + ", " + aVar.f10904d.size() + " queued tasks");
            }
            if (aVar.f10904d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f10903c == null) {
                i(aVar);
                return;
            }
            while (true) {
                f fVar = (f) aVar.f10904d.peek();
                if (fVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + fVar);
                    }
                    fVar.a(aVar.f10903c);
                    aVar.f10904d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f10901a);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f10901a, e10);
                }
            }
            if (aVar.f10904d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(f fVar) {
            this.f10898c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((f) message.obj);
                return true;
            }
            if (i10 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f10894a, dVar.f10895b);
                return true;
            }
            if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f10898c.hasMessages(3, aVar.f10901a)) {
                return;
            }
            int i10 = aVar.f10905e;
            int i11 = i10 + 1;
            aVar.f10905e = i11;
            if (i11 <= 6) {
                int i12 = (1 << i10) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
                }
                this.f10898c.sendMessageDelayed(this.f10898c.obtainMessage(3, aVar.f10901a), i12);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f10904d.size() + " tasks to " + aVar.f10901a + " after " + aVar.f10905e + " retries");
            aVar.f10904d.clear();
        }

        public final void j() {
            Set setF = m.f(this.f10896a);
            if (setF.equals(this.f10900e)) {
                return;
            }
            this.f10900e = setF;
            List<ResolveInfo> listQueryIntentServices = this.f10896a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setF.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f10899d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f10899d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f10899d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    b((a) entry.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f10898c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f10898c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
        void a(b.a aVar);
    }

    public m(Context context) {
        this.f10888a = context;
        this.f10889b = (NotificationManager) context.getSystemService("notification");
    }

    public static m e(Context context) {
        return new m(context);
    }

    public static Set f(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f10883c) {
            if (string != null) {
                try {
                    if (!string.equals(f10884d)) {
                        String[] strArrSplit = string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f10885e = hashSet;
                        f10884d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f10885e;
        }
        return set;
    }

    public static boolean k(Notification notification) {
        Bundle bundleA = i.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f10889b);
    }

    public void b(int i10) {
        c(null, i10);
    }

    public void c(String str, int i10) {
        this.f10889b.cancel(str, i10);
    }

    public void d() {
        this.f10889b.cancelAll();
    }

    public List g() {
        return Build.VERSION.SDK_INT >= 26 ? b.a(this.f10889b) : Collections.EMPTY_LIST;
    }

    public void h(int i10, Notification notification) {
        i(null, i10, notification);
    }

    public void i(String str, int i10, Notification notification) {
        if (!k(notification)) {
            this.f10889b.notify(str, i10, notification);
        } else {
            j(new c(this.f10888a.getPackageName(), i10, str, notification));
            this.f10889b.cancel(str, i10);
        }
    }

    public final void j(f fVar) {
        synchronized (f10886f) {
            try {
                if (f10887g == null) {
                    f10887g = new e(this.f10888a.getApplicationContext());
                }
                f10887g.h(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
