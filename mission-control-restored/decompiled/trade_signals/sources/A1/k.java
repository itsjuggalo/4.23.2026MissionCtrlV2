package A1;

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
    public final a f33a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f34b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f35c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f36a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f37b = null;

        public a(Context context) {
            this.f36a = context;
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
                    for (String str2 : ((String) obj).split(com.amazon.a.a.o.b.f.f14100a, -1)) {
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
            String str2;
            String str3;
            String str4 = (String) c().get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str4).asSubclass(d.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e8) {
                e = e8;
                str2 = String.format("Class %s is not found.", str4);
                Log.w("BackendRegistry", str2, e);
                return null;
            } catch (IllegalAccessException e9) {
                e = e9;
                str3 = String.format("Could not instantiate %s.", str4);
                Log.w("BackendRegistry", str3, e);
                return null;
            } catch (InstantiationException e10) {
                e = e10;
                str3 = String.format("Could not instantiate %s.", str4);
                Log.w("BackendRegistry", str3, e);
                return null;
            } catch (NoSuchMethodException e11) {
                e = e11;
                str2 = String.format("Could not instantiate %s", str4);
                Log.w("BackendRegistry", str2, e);
                return null;
            } catch (InvocationTargetException e12) {
                e = e12;
                str2 = String.format("Could not instantiate %s", str4);
                Log.w("BackendRegistry", str2, e);
                return null;
            }
        }

        public final Map c() {
            if (this.f37b == null) {
                this.f37b = a(this.f36a);
            }
            return this.f37b;
        }
    }

    public k(a aVar, i iVar) {
        this.f35c = new HashMap();
        this.f33a = aVar;
        this.f34b = iVar;
    }

    @Override // A1.e
    public synchronized m a(String str) {
        if (this.f35c.containsKey(str)) {
            return (m) this.f35c.get(str);
        }
        d dVarB = this.f33a.b(str);
        if (dVarB == null) {
            return null;
        }
        m mVarCreate = dVarB.create(this.f34b.a(str));
        this.f35c.put(str, mVarCreate);
        return mVarCreate;
    }

    public k(Context context, i iVar) {
        this(new a(context), iVar);
    }
}
