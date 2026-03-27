package p0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q0.AbstractC1718a;

/* JADX INFO: renamed from: p0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1685a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile C1685a f13967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f13968e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13971c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f13970b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f13969a = new HashMap();

    public C1685a(Context context) {
        this.f13971c = context.getApplicationContext();
    }

    public static C1685a d(Context context) {
        if (f13967d == null) {
            synchronized (f13968e) {
                try {
                    if (f13967d == null) {
                        f13967d = new C1685a(context);
                    }
                } finally {
                }
            }
        }
        return f13967d;
    }

    public void a() {
        try {
            try {
                AbstractC1718a.c("Startup");
                b(this.f13971c.getPackageManager().getProviderInfo(new ComponentName(this.f13971c.getPackageName(), InitializationProvider.class.getName()), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS).metaData);
            } catch (PackageManager.NameNotFoundException e4) {
                throw new d(e4);
            }
        } finally {
            AbstractC1718a.f();
        }
    }

    public void b(Bundle bundle) {
        String string = this.f13971c.getString(c.f13972a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f13970b.add(cls);
                        }
                    }
                }
                Iterator it = this.f13970b.iterator();
                while (it.hasNext()) {
                    c((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e4) {
                throw new d(e4);
            }
        }
    }

    public final Object c(Class cls, Set set) {
        Object objA;
        if (AbstractC1718a.h()) {
            try {
                AbstractC1718a.c(cls.getSimpleName());
            } catch (Throwable th) {
                AbstractC1718a.f();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f13969a.containsKey(cls)) {
            objA = this.f13969a.get(cls);
        } else {
            set.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class> listDependencies = bVar.dependencies();
                if (!listDependencies.isEmpty()) {
                    for (Class cls2 : listDependencies) {
                        if (!this.f13969a.containsKey(cls2)) {
                            c(cls2, set);
                        }
                    }
                }
                objA = bVar.a(this.f13971c);
                set.remove(cls);
                this.f13969a.put(cls, objA);
            } catch (Throwable th2) {
                throw new d(th2);
            }
        }
        AbstractC1718a.f();
        return objA;
    }

    public boolean e(Class cls) {
        return this.f13970b.contains(cls);
    }
}
