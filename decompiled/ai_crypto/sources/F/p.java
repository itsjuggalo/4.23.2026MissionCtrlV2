package F;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
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
import b.InterfaceC0974a;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f1826d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f1829g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f1831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1825c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f1827e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f1828f = new Object();

    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    public static class b {
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        public static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        public static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        public static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        public static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        public static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        public static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        public static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        public static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        public static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    public static class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f1835d;

        public c(String str, int i7, String str2, Notification notification) {
            this.f1832a = str;
            this.f1833b = i7;
            this.f1834c = str2;
            this.f1835d = notification;
        }

        @Override // F.p.f
        public void a(InterfaceC0974a interfaceC0974a) {
            interfaceC0974a.X(this.f1832a, this.f1833b, this.f1834c, this.f1835d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f1832a + ", id:" + this.f1833b + ", tag:" + this.f1834c + "]";
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f1836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f1837b;

        public d(ComponentName componentName, IBinder iBinder) {
            this.f1836a = componentName;
            this.f1837b = iBinder;
        }
    }

    public static class e implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f1839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f1840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f1841d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f1842e = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f1843a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public InterfaceC0974a f1845c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f1844b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque f1846d = new ArrayDeque();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f1847e = 0;

            public a(ComponentName componentName) {
                this.f1843a = componentName;
            }
        }

        public e(Context context) {
            this.f1838a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1839b = handlerThread;
            handlerThread.start();
            this.f1840c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f1844b) {
                return true;
            }
            boolean zBindService = this.f1838a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f1843a), this, 33);
            aVar.f1844b = zBindService;
            if (zBindService) {
                aVar.f1847e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f1843a);
                this.f1838a.unbindService(this);
            }
            return aVar.f1844b;
        }

        public final void b(a aVar) {
            if (aVar.f1844b) {
                this.f1838a.unbindService(this);
                aVar.f1844b = false;
            }
            aVar.f1845c = null;
        }

        public final void c(f fVar) {
            j();
            for (a aVar : this.f1841d.values()) {
                aVar.f1846d.add(fVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f1841d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f1841d.get(componentName);
            if (aVar != null) {
                aVar.f1845c = InterfaceC0974a.AbstractBinderC0143a.b(iBinder);
                aVar.f1847e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f1841d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f1843a + ", " + aVar.f1846d.size() + " queued tasks");
            }
            if (aVar.f1846d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f1845c == null) {
                i(aVar);
                return;
            }
            while (true) {
                f fVar = (f) aVar.f1846d.peek();
                if (fVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + fVar);
                    }
                    fVar.a(aVar.f1845c);
                    aVar.f1846d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f1843a);
                    }
                } catch (RemoteException e7) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f1843a, e7);
                }
            }
            if (aVar.f1846d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(f fVar) {
            this.f1840c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                c((f) message.obj);
                return true;
            }
            if (i7 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f1836a, dVar.f1837b);
                return true;
            }
            if (i7 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i7 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f1840c.hasMessages(3, aVar.f1843a)) {
                return;
            }
            int i7 = aVar.f1847e;
            int i8 = i7 + 1;
            aVar.f1847e = i8;
            if (i8 <= 6) {
                int i9 = (1 << i7) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i9 + " ms");
                }
                this.f1840c.sendMessageDelayed(this.f1840c.obtainMessage(3, aVar.f1843a), i9);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f1846d.size() + " tasks to " + aVar.f1843a + " after " + aVar.f1847e + " retries");
            aVar.f1846d.clear();
        }

        public final void j() {
            Set setF = p.f(this.f1838a);
            if (setF.equals(this.f1842e)) {
                return;
            }
            this.f1842e = setF;
            List<ResolveInfo> listQueryIntentServices = this.f1838a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                if (!this.f1841d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f1841d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f1841d.entrySet().iterator();
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
            this.f1840c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1840c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface f {
        void a(InterfaceC0974a interfaceC0974a);
    }

    public p(Context context) {
        this.f1830a = context;
        this.f1831b = (NotificationManager) context.getSystemService("notification");
    }

    public static p e(Context context) {
        return new p(context);
    }

    public static Set f(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1825c) {
            if (string != null) {
                try {
                    if (!string.equals(f1826d)) {
                        String[] strArrSplit = string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f1827e = hashSet;
                        f1826d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f1827e;
        }
        return set;
    }

    public static boolean k(Notification notification) {
        Bundle bundleA = k.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f1831b);
    }

    public void b(int i7) {
        c(null, i7);
    }

    public void c(String str, int i7) {
        this.f1831b.cancel(str, i7);
    }

    public void d() {
        this.f1831b.cancelAll();
    }

    public List g() {
        return Build.VERSION.SDK_INT >= 26 ? b.k(this.f1831b) : Collections.emptyList();
    }

    public void h(int i7, Notification notification) {
        i(null, i7, notification);
    }

    public void i(String str, int i7, Notification notification) {
        if (!k(notification)) {
            this.f1831b.notify(str, i7, notification);
        } else {
            j(new c(this.f1830a.getPackageName(), i7, str, notification));
            this.f1831b.cancel(str, i7);
        }
    }

    public final void j(f fVar) {
        synchronized (f1828f) {
            try {
                if (f1829g == null) {
                    f1829g = new e(this.f1830a.getApplicationContext());
                }
                f1829g.h(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
