package Y3;

import android.os.Bundle;
import androidx.lifecycle.C0353j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o.C0879b;
import o.C0880c;
import o.C0883f;
import q0.C0919a;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3661d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f3662f;

    public static HashMap c(byte[] bArr) {
        HashMap map = new HashMap();
        map.put("enabled", Boolean.TRUE);
        map.put("data", bArr);
        return map;
    }

    public Bundle a(String str) {
        if (!this.f3659b) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = (Bundle) this.e;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.e;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.e;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.e = null;
        return bundle2;
    }

    public q0.d b() {
        String str;
        q0.d dVar;
        Iterator it = ((C0883f) this.f3661d).iterator();
        do {
            C0879b c0879b = (C0879b) it;
            if (!c0879b.hasNext()) {
                return null;
            }
            Map.Entry components = (Map.Entry) c0879b.next();
            kotlin.jvm.internal.j.d(components, "components");
            str = (String) components.getKey();
            dVar = (q0.d) components.getValue();
        } while (!kotlin.jvm.internal.j.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return dVar;
    }

    public void d(String str, q0.d provider) {
        Object obj;
        kotlin.jvm.internal.j.e(provider, "provider");
        C0883f c0883f = (C0883f) this.f3661d;
        C0880c c0880cA = c0883f.a(str);
        if (c0880cA != null) {
            obj = c0880cA.f8616b;
        } else {
            C0880c c0880c = new C0880c(str, provider);
            c0883f.f8625d++;
            C0880c c0880c2 = c0883f.f8623b;
            if (c0880c2 == null) {
                c0883f.f8622a = c0880c;
                c0883f.f8623b = c0880c;
            } else {
                c0880c2.f8617c = c0880c;
                c0880c.f8618d = c0880c2;
                c0883f.f8623b = c0880c;
            }
            obj = null;
        }
        if (((q0.d) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e() {
        if (!this.f3660c) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        C0919a c0919a = (C0919a) this.f3662f;
        if (c0919a == null) {
            c0919a = new C0919a(this);
        }
        this.f3662f = c0919a;
        try {
            C0353j.class.getDeclaredConstructor(new Class[0]);
            C0919a c0919a2 = (C0919a) this.f3662f;
            if (c0919a2 != null) {
                c0919a2.f9143a.add(C0353j.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + C0353j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
