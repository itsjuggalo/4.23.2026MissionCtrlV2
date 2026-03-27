package Z1;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import c3.C0395a;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C0400c;
import com.google.android.gms.common.internal.I;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k2.C0755a;
import k2.C0758d;
import k2.C0765k;
import p0.C0899k;
import q.C0910b;
import q.C0918j;
import z.AbstractC1454l;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f3960k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0910b f3961l = new C0910b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f3964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0758d f3965d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0765k f3967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final X2.b f3968h;
    public final AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f3966f = new AtomicBoolean();
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f3969j = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    public h(m mVar, Context context, String str) {
        ?? arrayList;
        int i = 2;
        int i6 = 0;
        this.f3962a = context;
        I.d(str);
        this.f3963b = str;
        this.f3964c = mVar;
        a aVar = FirebaseInitProvider.f5513a;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new Y2.b((String) it.next(), 1));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        l2.j jVar = l2.j.f8096a;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        arrayList3.add(new Y2.b(new FirebaseCommonRegistrar(), i));
        arrayList3.add(new Y2.b(new ExecutorsRegistrar(), i));
        arrayList4.add(C0755a.c(context, Context.class, new Class[0]));
        arrayList4.add(C0755a.c(this, h.class, new Class[0]));
        arrayList4.add(C0755a.c(mVar, m.class, new Class[0]));
        C0899k c0899k = new C0899k();
        if (AbstractC1454l.a(context) && FirebaseInitProvider.f5514b.get()) {
            arrayList4.add(C0755a.c(aVar, a.class, new Class[0]));
        }
        C0758d c0758d = new C0758d(arrayList3, arrayList4, c0899k);
        this.f3965d = c0758d;
        Trace.endSection();
        this.f3967g = new C0765k(new d(i6, this, context));
        this.f3968h = c0758d.f(V2.e.class);
        e eVar = new e(this);
        a();
        if (this.e.get()) {
            ComponentCallbacks2C0400c.e.f5142a.get();
        }
        this.i.add(eVar);
        Trace.endSection();
    }

    public static ArrayList d() {
        ArrayList arrayList = new ArrayList();
        synchronized (f3960k) {
            try {
                for (h hVar : (C0918j) f3961l.values()) {
                    hVar.a();
                    arrayList.add(hVar.f3963b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static h e() {
        h hVar;
        synchronized (f3960k) {
            try {
                hVar = (h) f3961l.getOrDefault("[DEFAULT]", null);
                if (hVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + B1.c.b() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((V2.e) hVar.f3968h.get()).b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public static h f(String str) {
        h hVar;
        String str2;
        synchronized (f3960k) {
            try {
                hVar = (h) f3961l.getOrDefault(str.trim(), null);
                if (hVar == null) {
                    ArrayList arrayListD = d();
                    if (arrayListD.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", arrayListD);
                    }
                    throw new IllegalStateException("FirebaseApp with name " + str + " doesn't exist. " + str2);
                }
                ((V2.e) hVar.f3968h.get()).b();
            } finally {
            }
        }
        return hVar;
    }

    public static h i(m mVar, Context context, String str) {
        h hVar;
        AtomicReference atomicReference = f.f3957a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = f.f3957a;
            if (atomicReference2.get() == null) {
                f fVar = new f();
                while (true) {
                    if (atomicReference2.compareAndSet(null, fVar)) {
                        ComponentCallbacks2C0400c.b(application);
                        ComponentCallbacks2C0400c.e.a(fVar);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        String strTrim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f3960k) {
            C0910b c0910b = f3961l;
            I.i("FirebaseApp name " + strTrim + " already exists!", !c0910b.containsKey(strTrim));
            I.h(context, "Application context cannot be null.");
            hVar = new h(mVar, context, strTrim);
            c0910b.put(strTrim, hVar);
        }
        hVar.h();
        return hVar;
    }

    public static h j(Context context) {
        synchronized (f3960k) {
            try {
                if (f3961l.containsKey("[DEFAULT]")) {
                    return e();
                }
                m mVarA = m.a(context);
                if (mVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return i(mVarA, context, "[DEFAULT]");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        I.i("FirebaseApp was deleted", !this.f3966f.get());
    }

    public final void b() {
        if (this.f3966f.compareAndSet(false, true)) {
            synchronized (f3960k) {
                f3961l.remove(this.f3963b);
            }
            Iterator it = this.f3969j.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a();
            }
        }
    }

    public final Object c(Class cls) {
        a();
        return this.f3965d.b(cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        hVar.a();
        return this.f3963b.equals(hVar.f3963b);
    }

    public final String g() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f3963b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.f3964c.f3975b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void h() {
        HashMap map;
        if (!AbstractC1454l.a(this.f3962a)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f3963b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f3962a;
            AtomicReference atomicReference = g.f3958b;
            if (atomicReference.get() == null) {
                g gVar = new g(context);
                while (!atomicReference.compareAndSet(null, gVar)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(gVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f3963b);
        Log.i("FirebaseApp", sb2.toString());
        C0758d c0758d = this.f3965d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f3963b);
        AtomicReference atomicReference2 = c0758d.f7843f;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (c0758d) {
                    map = new HashMap(c0758d.f7839a);
                }
                c0758d.i(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((V2.e) this.f3968h.get()).b();
    }

    public final int hashCode() {
        return this.f3963b.hashCode();
    }

    public final boolean k() {
        boolean z6;
        a();
        C0395a c0395a = (C0395a) this.f3967g.get();
        synchronized (c0395a) {
            z6 = c0395a.f4912d;
        }
        return z6;
    }

    public final void l(boolean z6) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            h hVar = ((e) it.next()).f3956a;
            if (z6) {
                hVar.getClass();
            } else {
                ((V2.e) hVar.f3968h.get()).b();
            }
        }
    }

    public final void m(Boolean bool) {
        a();
        C0395a c0395a = (C0395a) this.f3967g.get();
        synchronized (c0395a) {
            try {
                if (bool == null) {
                    c0395a.f4910b.edit().remove("firebase_data_collection_default_enabled").apply();
                    c0395a.b(c0395a.a());
                } else {
                    boolean zEquals = Boolean.TRUE.equals(bool);
                    c0395a.f4910b.edit().putBoolean("firebase_data_collection_default_enabled", zEquals).apply();
                    c0395a.b(zEquals);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Y3.d dVar = new Y3.d((Object) this);
        dVar.h(this.f3963b, "name");
        dVar.h(this.f3964c, "options");
        return dVar.toString();
    }
}
