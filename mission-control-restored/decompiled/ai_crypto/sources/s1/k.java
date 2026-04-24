package s1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f22988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f22989c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f22990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f22991b = null;

        public a(Context context) {
            this.f22990a = context;
        }

        public static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        public final Map a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(com.amazon.a.a.o.b.f.f9989a, -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        public d b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str2).asSubclass(d.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e7) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e7);
                return null;
            } catch (IllegalAccessException e8) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e8);
                return null;
            } catch (InstantiationException e9) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e9);
                return null;
            } catch (NoSuchMethodException e10) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e10);
                return null;
            } catch (InvocationTargetException e11) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e11);
                return null;
            }
        }

        public final Map c() {
            if (this.f22991b == null) {
                this.f22991b = a(this.f22990a);
            }
            return this.f22991b;
        }
    }

    public k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    @Override // s1.e
    public synchronized m a(String str) {
        if (this.f22989c.containsKey(str)) {
            return (m) this.f22989c.get(str);
        }
        d dVarB = this.f22987a.b(str);
        if (dVarB == null) {
            return null;
        }
        m mVarCreate = dVarB.create(this.f22988b.a(str));
        this.f22989c.put(str, mVarCreate);
        return mVarCreate;
    }

    public k(a aVar, i iVar) {
        this.f22989c = new HashMap();
        this.f22987a = aVar;
        this.f22988b = iVar;
    }
}
