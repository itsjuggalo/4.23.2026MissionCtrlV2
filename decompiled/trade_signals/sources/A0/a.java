package A0;

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

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f7e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f10c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f9b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8a = new HashMap();

    public a(Context context) {
        this.f10c = context.getApplicationContext();
    }

    public static a e(Context context) {
        if (f6d == null) {
            synchronized (f7e) {
                try {
                    if (f6d == null) {
                        f6d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f6d;
    }

    public void a() {
        try {
            try {
                B0.a.c("Startup");
                b(this.f10c.getPackageManager().getProviderInfo(new ComponentName(this.f10c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e8) {
                throw new d(e8);
            }
        } finally {
            B0.a.f();
        }
    }

    public void b(Bundle bundle) {
        String string = this.f10c.getString(c.f11a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f9b.add(cls);
                        }
                    }
                }
                Iterator it = this.f9b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e8) {
                throw new d(e8);
            }
        }
    }

    public Object c(Class cls) {
        Object objD;
        synchronized (f7e) {
            try {
                objD = this.f8a.get(cls);
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
        Object objB;
        if (B0.a.h()) {
            try {
                B0.a.c(cls.getSimpleName());
            } catch (Throwable th) {
                B0.a.f();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f8a.containsKey(cls)) {
            objB = this.f8a.get(cls);
        } else {
            set.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f8a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objB = bVar.b(this.f10c);
                set.remove(cls);
                this.f8a.put(cls, objB);
            } catch (Throwable th2) {
                throw new d(th2);
            }
        }
        B0.a.f();
        return objB;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f9b.contains(cls);
    }
}
