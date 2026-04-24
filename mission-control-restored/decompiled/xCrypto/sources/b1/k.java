package b1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k implements InterfaceC0861e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f8260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8261c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f8263b = null;

        public a(Context context) {
            this.f8262a = context;
        }

        public static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
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
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(com.amazon.a.a.o.b.f.f8804a, -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        public InterfaceC0860d b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (InterfaceC0860d) Class.forName(str2).asSubclass(InterfaceC0860d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e4) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e4);
                return null;
            } catch (IllegalAccessException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e5);
                return null;
            } catch (InstantiationException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e6);
                return null;
            } catch (NoSuchMethodException e7) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e7);
                return null;
            } catch (InvocationTargetException e8) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e8);
                return null;
            }
        }

        public final Map c() {
            if (this.f8263b == null) {
                this.f8263b = a(this.f8262a);
            }
            return this.f8263b;
        }
    }

    public k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    @Override // b1.InterfaceC0861e
    public synchronized m a(String str) {
        if (this.f8261c.containsKey(str)) {
            return (m) this.f8261c.get(str);
        }
        InterfaceC0860d interfaceC0860dB = this.f8259a.b(str);
        if (interfaceC0860dB == null) {
            return null;
        }
        m mVarCreate = interfaceC0860dB.create(this.f8260b.a(str));
        this.f8261c.put(str, mVarCreate);
        return mVarCreate;
    }

    public k(a aVar, i iVar) {
        this.f8261c = new HashMap();
        this.f8259a = aVar;
        this.f8260b = iVar;
    }
}
