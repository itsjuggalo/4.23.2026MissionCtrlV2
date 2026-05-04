package e;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8269a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f8270b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8271c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f8272d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map f8273e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f8274f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f8275g = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.b f8277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f.a f8278c;

        public a(String str, e.b bVar, f.a aVar) {
            this.f8276a = str;
            this.f8277b = bVar;
            this.f8278c = aVar;
        }

        @Override // androidx.lifecycle.k
        public void b(m mVar, i.a aVar) {
            if (!i.a.ON_START.equals(aVar)) {
                if (i.a.ON_STOP.equals(aVar)) {
                    d.this.f8273e.remove(this.f8276a);
                    return;
                } else {
                    if (i.a.ON_DESTROY.equals(aVar)) {
                        d.this.l(this.f8276a);
                        return;
                    }
                    return;
                }
            }
            d.this.f8273e.put(this.f8276a, new C0151d(this.f8277b, this.f8278c));
            if (d.this.f8274f.containsKey(this.f8276a)) {
                Object obj = d.this.f8274f.get(this.f8276a);
                d.this.f8274f.remove(this.f8276a);
                this.f8277b.a(obj);
            }
            e.a aVar2 = (e.a) d.this.f8275g.getParcelable(this.f8276a);
            if (aVar2 != null) {
                d.this.f8275g.remove(this.f8276a);
                this.f8277b.a(this.f8278c.c(aVar2.b(), aVar2.a()));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.a f8281b;

        public b(String str, f.a aVar) {
            this.f8280a = str;
            this.f8281b = aVar;
        }

        @Override // e.c
        public void b(Object obj, h0.b bVar) throws Exception {
            Integer num = (Integer) d.this.f8270b.get(this.f8280a);
            if (num != null) {
                d.this.f8272d.add(this.f8280a);
                try {
                    d.this.f(num.intValue(), this.f8281b, obj, bVar);
                    return;
                } catch (Exception e10) {
                    d.this.f8272d.remove(this.f8280a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f8281b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // e.c
        public void c() {
            d.this.l(this.f8280a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.a f8284b;

        public c(String str, f.a aVar) {
            this.f8283a = str;
            this.f8284b = aVar;
        }

        @Override // e.c
        public void b(Object obj, h0.b bVar) throws Exception {
            Integer num = (Integer) d.this.f8270b.get(this.f8283a);
            if (num != null) {
                d.this.f8272d.add(this.f8283a);
                try {
                    d.this.f(num.intValue(), this.f8284b, obj, bVar);
                    return;
                } catch (Exception e10) {
                    d.this.f8272d.remove(this.f8283a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f8284b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // e.c
        public void c() {
            d.this.l(this.f8283a);
        }
    }

    /* JADX INFO: renamed from: e.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0151d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e.b f8286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f.a f8287b;

        public C0151d(e.b bVar, f.a aVar) {
            this.f8286a = bVar;
            this.f8287b = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f8288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f8289b = new ArrayList();

        public e(i iVar) {
            this.f8288a = iVar;
        }

        public void a(k kVar) {
            this.f8288a.a(kVar);
            this.f8289b.add(kVar);
        }

        public void b() {
            Iterator it = this.f8289b.iterator();
            while (it.hasNext()) {
                this.f8288a.c((k) it.next());
            }
            this.f8289b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f8269a.put(Integer.valueOf(i10), str);
        this.f8270b.put(str, Integer.valueOf(i10));
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = (String) this.f8269a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, (C0151d) this.f8273e.get(str));
        return true;
    }

    public final boolean c(int i10, Object obj) {
        e.b bVar;
        String str = (String) this.f8269a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        C0151d c0151d = (C0151d) this.f8273e.get(str);
        if (c0151d == null || (bVar = c0151d.f8286a) == null) {
            this.f8275g.remove(str);
            this.f8274f.put(str, obj);
            return true;
        }
        if (!this.f8272d.remove(str)) {
            return true;
        }
        bVar.a(obj);
        return true;
    }

    public final void d(String str, int i10, Intent intent, C0151d c0151d) {
        if (c0151d == null || c0151d.f8286a == null || !this.f8272d.contains(str)) {
            this.f8274f.remove(str);
            this.f8275g.putParcelable(str, new e.a(i10, intent));
        } else {
            c0151d.f8286a.a(c0151d.f8287b.c(i10, intent));
            this.f8272d.remove(str);
        }
    }

    public final int e() {
        int iD = td.c.f21894a.d(2147418112);
        while (true) {
            int i10 = iD + 65536;
            if (!this.f8269a.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            iD = td.c.f21894a.d(2147418112);
        }
    }

    public abstract void f(int i10, f.a aVar, Object obj, h0.b bVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f8272d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f8275g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f8270b.containsKey(str)) {
                Integer num = (Integer) this.f8270b.remove(str);
                if (!this.f8275g.containsKey(str)) {
                    this.f8269a.remove(num);
                }
            }
            a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f8270b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f8270b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f8272d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f8275g.clone());
    }

    public final e.c i(String str, m mVar, f.a aVar, e.b bVar) {
        i lifecycle = mVar.getLifecycle();
        if (lifecycle.b().b(i.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + mVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        e eVar = (e) this.f8271c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, bVar, aVar));
        this.f8271c.put(str, eVar);
        return new b(str, aVar);
    }

    public final e.c j(String str, f.a aVar, e.b bVar) {
        k(str);
        this.f8273e.put(str, new C0151d(bVar, aVar));
        if (this.f8274f.containsKey(str)) {
            Object obj = this.f8274f.get(str);
            this.f8274f.remove(str);
            bVar.a(obj);
        }
        e.a aVar2 = (e.a) this.f8275g.getParcelable(str);
        if (aVar2 != null) {
            this.f8275g.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new c(str, aVar);
    }

    public final void k(String str) {
        if (((Integer) this.f8270b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer num;
        if (!this.f8272d.contains(str) && (num = (Integer) this.f8270b.remove(str)) != null) {
            this.f8269a.remove(num);
        }
        this.f8273e.remove(str);
        if (this.f8274f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f8274f.get(str));
            this.f8274f.remove(str);
        }
        if (this.f8275g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f8275g.getParcelable(str));
            this.f8275g.remove(str);
        }
        e eVar = (e) this.f8271c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f8271c.remove(str);
        }
    }
}
