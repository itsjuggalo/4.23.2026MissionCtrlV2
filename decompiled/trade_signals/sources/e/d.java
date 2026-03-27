package e;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.InterfaceC1159k;
import androidx.lifecycle.InterfaceC1161m;
import f.AbstractC1725a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f17091a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f17092b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f17093c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f17094d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map f17095e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f17096f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f17097g = new Bundle();

    public class a implements InterfaceC1159k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1657b f17099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1725a f17100c;

        public a(String str, InterfaceC1657b interfaceC1657b, AbstractC1725a abstractC1725a) {
            this.f17098a = str;
            this.f17099b = interfaceC1657b;
            this.f17100c = abstractC1725a;
        }

        @Override // androidx.lifecycle.InterfaceC1159k
        public void b(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
            if (!AbstractC1157i.a.ON_START.equals(aVar)) {
                if (AbstractC1157i.a.ON_STOP.equals(aVar)) {
                    d.this.f17095e.remove(this.f17098a);
                    return;
                } else {
                    if (AbstractC1157i.a.ON_DESTROY.equals(aVar)) {
                        d.this.l(this.f17098a);
                        return;
                    }
                    return;
                }
            }
            d.this.f17095e.put(this.f17098a, new C0289d(this.f17099b, this.f17100c));
            if (d.this.f17096f.containsKey(this.f17098a)) {
                Object obj = d.this.f17096f.get(this.f17098a);
                d.this.f17096f.remove(this.f17098a);
                this.f17099b.a(obj);
            }
            C1656a c1656a = (C1656a) d.this.f17097g.getParcelable(this.f17098a);
            if (c1656a != null) {
                d.this.f17097g.remove(this.f17098a);
                this.f17099b.a(this.f17100c.c(c1656a.b(), c1656a.a()));
            }
        }
    }

    public class b extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1725a f17103b;

        public b(String str, AbstractC1725a abstractC1725a) {
            this.f17102a = str;
            this.f17103b = abstractC1725a;
        }

        @Override // e.c
        public void b(Object obj, H.b bVar) throws Exception {
            Integer num = (Integer) d.this.f17092b.get(this.f17102a);
            if (num != null) {
                d.this.f17094d.add(this.f17102a);
                try {
                    d.this.f(num.intValue(), this.f17103b, obj, bVar);
                    return;
                } catch (Exception e8) {
                    d.this.f17094d.remove(this.f17102a);
                    throw e8;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f17103b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // e.c
        public void c() {
            d.this.l(this.f17102a);
        }
    }

    public class c extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1725a f17106b;

        public c(String str, AbstractC1725a abstractC1725a) {
            this.f17105a = str;
            this.f17106b = abstractC1725a;
        }

        @Override // e.c
        public void b(Object obj, H.b bVar) throws Exception {
            Integer num = (Integer) d.this.f17092b.get(this.f17105a);
            if (num != null) {
                d.this.f17094d.add(this.f17105a);
                try {
                    d.this.f(num.intValue(), this.f17106b, obj, bVar);
                    return;
                } catch (Exception e8) {
                    d.this.f17094d.remove(this.f17105a);
                    throw e8;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f17106b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // e.c
        public void c() {
            d.this.l(this.f17105a);
        }
    }

    /* JADX INFO: renamed from: e.d$d, reason: collision with other inner class name */
    public static class C0289d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1657b f17108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1725a f17109b;

        public C0289d(InterfaceC1657b interfaceC1657b, AbstractC1725a abstractC1725a) {
            this.f17108a = interfaceC1657b;
            this.f17109b = abstractC1725a;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1157i f17110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f17111b = new ArrayList();

        public e(AbstractC1157i abstractC1157i) {
            this.f17110a = abstractC1157i;
        }

        public void a(InterfaceC1159k interfaceC1159k) {
            this.f17110a.a(interfaceC1159k);
            this.f17111b.add(interfaceC1159k);
        }

        public void b() {
            Iterator it = this.f17111b.iterator();
            while (it.hasNext()) {
                this.f17110a.c((InterfaceC1159k) it.next());
            }
            this.f17111b.clear();
        }
    }

    public final void a(int i8, String str) {
        this.f17091a.put(Integer.valueOf(i8), str);
        this.f17092b.put(str, Integer.valueOf(i8));
    }

    public final boolean b(int i8, int i9, Intent intent) {
        String str = (String) this.f17091a.get(Integer.valueOf(i8));
        if (str == null) {
            return false;
        }
        d(str, i9, intent, (C0289d) this.f17095e.get(str));
        return true;
    }

    public final boolean c(int i8, Object obj) {
        InterfaceC1657b interfaceC1657b;
        String str = (String) this.f17091a.get(Integer.valueOf(i8));
        if (str == null) {
            return false;
        }
        C0289d c0289d = (C0289d) this.f17095e.get(str);
        if (c0289d == null || (interfaceC1657b = c0289d.f17108a) == null) {
            this.f17097g.remove(str);
            this.f17096f.put(str, obj);
            return true;
        }
        if (!this.f17094d.remove(str)) {
            return true;
        }
        interfaceC1657b.a(obj);
        return true;
    }

    public final void d(String str, int i8, Intent intent, C0289d c0289d) {
        if (c0289d == null || c0289d.f17108a == null || !this.f17094d.contains(str)) {
            this.f17096f.remove(str);
            this.f17097g.putParcelable(str, new C1656a(i8, intent));
        } else {
            c0289d.f17108a.a(c0289d.f17109b.c(i8, intent));
            this.f17094d.remove(str);
        }
    }

    public final int e() {
        int iD = F5.c.f1916a.d(2147418112);
        while (true) {
            int i8 = iD + 65536;
            if (!this.f17091a.containsKey(Integer.valueOf(i8))) {
                return i8;
            }
            iD = F5.c.f1916a.d(2147418112);
        }
    }

    public abstract void f(int i8, AbstractC1725a abstractC1725a, Object obj, H.b bVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f17094d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f17097g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i8 = 0; i8 < stringArrayList.size(); i8++) {
            String str = stringArrayList.get(i8);
            if (this.f17092b.containsKey(str)) {
                Integer num = (Integer) this.f17092b.remove(str);
                if (!this.f17097g.containsKey(str)) {
                    this.f17091a.remove(num);
                }
            }
            a(integerArrayList.get(i8).intValue(), stringArrayList.get(i8));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f17092b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f17092b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f17094d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f17097g.clone());
    }

    public final e.c i(String str, InterfaceC1161m interfaceC1161m, AbstractC1725a abstractC1725a, InterfaceC1657b interfaceC1657b) {
        AbstractC1157i lifecycle = interfaceC1161m.getLifecycle();
        if (lifecycle.b().b(AbstractC1157i.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + interfaceC1161m + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        e eVar = (e) this.f17093c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, interfaceC1657b, abstractC1725a));
        this.f17093c.put(str, eVar);
        return new b(str, abstractC1725a);
    }

    public final e.c j(String str, AbstractC1725a abstractC1725a, InterfaceC1657b interfaceC1657b) {
        k(str);
        this.f17095e.put(str, new C0289d(interfaceC1657b, abstractC1725a));
        if (this.f17096f.containsKey(str)) {
            Object obj = this.f17096f.get(str);
            this.f17096f.remove(str);
            interfaceC1657b.a(obj);
        }
        C1656a c1656a = (C1656a) this.f17097g.getParcelable(str);
        if (c1656a != null) {
            this.f17097g.remove(str);
            interfaceC1657b.a(abstractC1725a.c(c1656a.b(), c1656a.a()));
        }
        return new c(str, abstractC1725a);
    }

    public final void k(String str) {
        if (((Integer) this.f17092b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer num;
        if (!this.f17094d.contains(str) && (num = (Integer) this.f17092b.remove(str)) != null) {
            this.f17091a.remove(num);
        }
        this.f17095e.remove(str);
        if (this.f17096f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f17096f.get(str));
            this.f17096f.remove(str);
        }
        if (this.f17097g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f17097g.getParcelable(str));
            this.f17097g.remove(str);
        }
        e eVar = (e) this.f17093c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f17093c.remove(str);
        }
    }
}
