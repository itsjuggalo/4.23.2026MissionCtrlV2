package l2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f15305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15306e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f15309c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f15308b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f15307a = new HashMap();

    public a(Context context) {
        this.f15309c = context.getApplicationContext();
    }

    public static a e(Context context) {
        if (f15305d == null) {
            synchronized (f15306e) {
                try {
                    if (f15305d == null) {
                        f15305d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f15305d;
    }

    public void a() {
        try {
            try {
                m2.a.c("Startup");
                b(this.f15309c.getPackageManager().getProviderInfo(new ComponentName(this.f15309c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new d(e10);
            }
        } finally {
            m2.a.f();
        }
    }

    public void b(Bundle bundle) {
        String string = this.f15309c.getString(c.f15310a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f15308b.add(cls);
                        }
                    }
                }
                Iterator it = this.f15308b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new d(e10);
            }
        }
    }

    public Object c(Class cls) {
        Object objD;
        synchronized (f15306e) {
            try {
                objD = this.f15307a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public final Object d(Class cls, Set set) {
        Object objCreate;
        if (m2.a.h()) {
            try {
                m2.a.c(cls.getSimpleName());
            } catch (Throwable th) {
                m2.a.f();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f15307a.containsKey(cls)) {
            objCreate = this.f15307a.get(cls);
        } else {
            set.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f15307a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objCreate = bVar.create(this.f15309c);
                set.remove(cls);
                this.f15307a.put(cls, objCreate);
            } catch (Throwable th2) {
                throw new d(th2);
            }
        }
        m2.a.f();
        return objCreate;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f15308b.contains(cls);
    }
}
