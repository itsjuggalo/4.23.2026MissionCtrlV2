package w;

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
import b.InterfaceC0855a;
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
    public static String f15499d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f15502g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f15504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f15498c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f15500e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f15501f = new Object();

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
        public final String f15505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f15507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f15508d;

        public c(String str, int i4, String str2, Notification notification) {
            this.f15505a = str;
            this.f15506b = i4;
            this.f15507c = str2;
            this.f15508d = notification;
        }

        @Override // w.p.f
        public void a(InterfaceC0855a interfaceC0855a) {
            interfaceC0855a.V(this.f15505a, this.f15506b, this.f15507c, this.f15508d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f15505a + ", id:" + this.f15506b + ", tag:" + this.f15507c + "]";
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f15509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f15510b;

        public d(ComponentName componentName, IBinder iBinder) {
            this.f15509a = componentName;
            this.f15510b = iBinder;
        }
    }

    public static class e implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f15511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f15512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f15513c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f15514d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f15515e = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f15516a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public InterfaceC0855a f15518c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f15517b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque f15519d = new ArrayDeque();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f15520e = 0;

            public a(ComponentName componentName) {
                this.f15516a = componentName;
            }
        }

        public e(Context context) {
            this.f15511a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f15512b = handlerThread;
            handlerThread.start();
            this.f15513c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f15517b) {
                return true;
            }
            boolean zBindService = this.f15511a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f15516a), this, 33);
            aVar.f15517b = zBindService;
            if (zBindService) {
                aVar.f15520e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f15516a);
                this.f15511a.unbindService(this);
            }
            return aVar.f15517b;
        }

        public final void b(a aVar) {
            if (aVar.f15517b) {
                this.f15511a.unbindService(this);
                aVar.f15517b = false;
            }
            aVar.f15518c = null;
        }

        public final void c(f fVar) {
            j();
            for (a aVar : this.f15514d.values()) {
                aVar.f15519d.add(fVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f15514d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f15514d.get(componentName);
            if (aVar != null) {
                aVar.f15518c = InterfaceC0855a.AbstractBinderC0121a.b(iBinder);
                aVar.f15520e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f15514d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f15516a + ", " + aVar.f15519d.size() + " queued tasks");
            }
            if (aVar.f15519d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f15518c == null) {
                i(aVar);
                return;
            }
            while (true) {
                f fVar = (f) aVar.f15519d.peek();
                if (fVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + fVar);
                    }
                    fVar.a(aVar.f15518c);
                    aVar.f15519d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f15516a);
                    }
                } catch (RemoteException e4) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f15516a, e4);
                }
            }
            if (aVar.f15519d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(f fVar) {
            this.f15513c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 0) {
                c((f) message.obj);
                return true;
            }
            if (i4 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f15509a, dVar.f15510b);
                return true;
            }
            if (i4 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i4 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f15513c.hasMessages(3, aVar.f15516a)) {
                return;
            }
            int i4 = aVar.f15520e;
            int i5 = i4 + 1;
            aVar.f15520e = i5;
            if (i5 <= 6) {
                int i6 = (1 << i4) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i6 + " ms");
                }
                this.f15513c.sendMessageDelayed(this.f15513c.obtainMessage(3, aVar.f15516a), i6);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f15519d.size() + " tasks to " + aVar.f15516a + " after " + aVar.f15520e + " retries");
            aVar.f15519d.clear();
        }

        public final void j() {
            Set setF = p.f(this.f15511a);
            if (setF.equals(this.f15515e)) {
                return;
            }
            this.f15515e = setF;
            List<ResolveInfo> listQueryIntentServices = this.f15511a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                if (!this.f15514d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f15514d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f15514d.entrySet().iterator();
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
            this.f15513c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f15513c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface f {
        void a(InterfaceC0855a interfaceC0855a);
    }

    public p(Context context) {
        this.f15503a = context;
        this.f15504b = (NotificationManager) context.getSystemService("notification");
    }

    public static p e(Context context) {
        return new p(context);
    }

    public static Set f(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f15498c) {
            if (string != null) {
                try {
                    if (!string.equals(f15499d)) {
                        String[] strArrSplit = string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f15500e = hashSet;
                        f15499d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f15500e;
        }
        return set;
    }

    public static boolean k(Notification notification) {
        Bundle bundleA = k.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f15504b);
    }

    public void b(int i4) {
        c(null, i4);
    }

    public void c(String str, int i4) {
        this.f15504b.cancel(str, i4);
    }

    public void d() {
        this.f15504b.cancelAll();
    }

    public List g() {
        return Build.VERSION.SDK_INT >= 26 ? b.k(this.f15504b) : Collections.EMPTY_LIST;
    }

    public void h(int i4, Notification notification) {
        i(null, i4, notification);
    }

    public void i(String str, int i4, Notification notification) {
        if (!k(notification)) {
            this.f15504b.notify(str, i4, notification);
        } else {
            j(new c(this.f15503a.getPackageName(), i4, str, notification));
            this.f15504b.cancel(str, i4);
        }
    }

    public final void j(f fVar) {
        synchronized (f15501f) {
            try {
                if (f15502g == null) {
                    f15502g = new e(this.f15503a.getApplicationContext());
                }
                f15502g.h(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
