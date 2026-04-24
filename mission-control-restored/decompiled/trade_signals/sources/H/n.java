package H;

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
import b.InterfaceC1166a;
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
public final class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f3511d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f3514g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f3516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3510c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f3512e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3513f = new Object();

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
        public final String f3517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f3520d;

        public c(String str, int i8, String str2, Notification notification) {
            this.f3517a = str;
            this.f3518b = i8;
            this.f3519c = str2;
            this.f3520d = notification;
        }

        @Override // H.n.f
        public void a(InterfaceC1166a interfaceC1166a) {
            interfaceC1166a.y(this.f3517a, this.f3518b, this.f3519c, this.f3520d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f3517a + ", id:" + this.f3518b + ", tag:" + this.f3519c + "]";
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f3521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f3522b;

        public d(ComponentName componentName, IBinder iBinder) {
            this.f3521a = componentName;
            this.f3522b = iBinder;
        }
    }

    public static class e implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f3524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f3525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f3526d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f3527e = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f3528a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public InterfaceC1166a f3530c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3529b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque f3531d = new ArrayDeque();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f3532e = 0;

            public a(ComponentName componentName) {
                this.f3528a = componentName;
            }
        }

        public e(Context context) {
            this.f3523a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f3524b = handlerThread;
            handlerThread.start();
            this.f3525c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f3529b) {
                return true;
            }
            boolean zBindService = this.f3523a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f3528a), this, 33);
            aVar.f3529b = zBindService;
            if (zBindService) {
                aVar.f3532e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f3528a);
                this.f3523a.unbindService(this);
            }
            return aVar.f3529b;
        }

        public final void b(a aVar) {
            if (aVar.f3529b) {
                this.f3523a.unbindService(this);
                aVar.f3529b = false;
            }
            aVar.f3530c = null;
        }

        public final void c(f fVar) {
            j();
            for (a aVar : this.f3526d.values()) {
                aVar.f3531d.add(fVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f3526d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f3526d.get(componentName);
            if (aVar != null) {
                aVar.f3530c = InterfaceC1166a.AbstractBinderC0204a.D(iBinder);
                aVar.f3532e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f3526d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f3528a + ", " + aVar.f3531d.size() + " queued tasks");
            }
            if (aVar.f3531d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f3530c == null) {
                i(aVar);
                return;
            }
            while (true) {
                f fVar = (f) aVar.f3531d.peek();
                if (fVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + fVar);
                    }
                    fVar.a(aVar.f3530c);
                    aVar.f3531d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f3528a);
                    }
                } catch (RemoteException e8) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f3528a, e8);
                }
            }
            if (aVar.f3531d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(f fVar) {
            this.f3525c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i8 = message.what;
            if (i8 == 0) {
                c((f) message.obj);
                return true;
            }
            if (i8 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f3521a, dVar.f3522b);
                return true;
            }
            if (i8 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i8 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f3525c.hasMessages(3, aVar.f3528a)) {
                return;
            }
            int i8 = aVar.f3532e;
            int i9 = i8 + 1;
            aVar.f3532e = i9;
            if (i9 <= 6) {
                int i10 = (1 << i8) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i10 + " ms");
                }
                this.f3525c.sendMessageDelayed(this.f3525c.obtainMessage(3, aVar.f3528a), i10);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f3531d.size() + " tasks to " + aVar.f3528a + " after " + aVar.f3532e + " retries");
            aVar.f3531d.clear();
        }

        public final void j() {
            Set setF = n.f(this.f3523a);
            if (setF.equals(this.f3527e)) {
                return;
            }
            this.f3527e = setF;
            List<ResolveInfo> listQueryIntentServices = this.f3523a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                if (!this.f3526d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f3526d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f3526d.entrySet().iterator();
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
            this.f3525c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f3525c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface f {
        void a(InterfaceC1166a interfaceC1166a);
    }

    public n(Context context) {
        this.f3515a = context;
        this.f3516b = (NotificationManager) context.getSystemService("notification");
    }

    public static n e(Context context) {
        return new n(context);
    }

    public static Set f(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f3510c) {
            if (string != null) {
                try {
                    if (!string.equals(f3511d)) {
                        String[] strArrSplit = string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f3512e = hashSet;
                        f3511d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f3512e;
        }
        return set;
    }

    public static boolean k(Notification notification) {
        Bundle bundleA = i.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f3516b);
    }

    public void b(int i8) {
        c(null, i8);
    }

    public void c(String str, int i8) {
        this.f3516b.cancel(str, i8);
    }

    public void d() {
        this.f3516b.cancelAll();
    }

    public List g() {
        return Build.VERSION.SDK_INT >= 26 ? b.k(this.f3516b) : Collections.emptyList();
    }

    public void h(int i8, Notification notification) {
        i(null, i8, notification);
    }

    public void i(String str, int i8, Notification notification) {
        if (!k(notification)) {
            this.f3516b.notify(str, i8, notification);
        } else {
            j(new c(this.f3515a.getPackageName(), i8, str, notification));
            this.f3516b.cancel(str, i8);
        }
    }

    public final void j(f fVar) {
        synchronized (f3513f) {
            try {
                if (f3514g == null) {
                    f3514g = new e(this.f3515a.getApplicationContext());
                }
                f3514g.h(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
