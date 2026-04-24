package e;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import f.AbstractC1238a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m3.AbstractC1608c;
import w.AbstractC1898b;

/* JADX INFO: renamed from: e.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1222d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11440a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f11441b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f11442c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f11443d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map f11444e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f11445f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f11446g = new Bundle();

    /* JADX INFO: renamed from: e.d$a */
    public class a implements InterfaceC0848k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1220b f11448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1238a f11449c;

        public a(String str, InterfaceC1220b interfaceC1220b, AbstractC1238a abstractC1238a) {
            this.f11447a = str;
            this.f11448b = interfaceC1220b;
            this.f11449c = abstractC1238a;
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            if (!AbstractC0846i.a.ON_START.equals(aVar)) {
                if (AbstractC0846i.a.ON_STOP.equals(aVar)) {
                    AbstractC1222d.this.f11444e.remove(this.f11447a);
                    return;
                } else {
                    if (AbstractC0846i.a.ON_DESTROY.equals(aVar)) {
                        AbstractC1222d.this.l(this.f11447a);
                        return;
                    }
                    return;
                }
            }
            AbstractC1222d.this.f11444e.put(this.f11447a, new C0187d(this.f11448b, this.f11449c));
            if (AbstractC1222d.this.f11445f.containsKey(this.f11447a)) {
                Object obj = AbstractC1222d.this.f11445f.get(this.f11447a);
                AbstractC1222d.this.f11445f.remove(this.f11447a);
                this.f11448b.a(obj);
            }
            C1219a c1219a = (C1219a) AbstractC1222d.this.f11446g.getParcelable(this.f11447a);
            if (c1219a != null) {
                AbstractC1222d.this.f11446g.remove(this.f11447a);
                this.f11448b.a(this.f11449c.c(c1219a.b(), c1219a.a()));
            }
        }
    }

    /* JADX INFO: renamed from: e.d$b */
    public class b extends AbstractC1221c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1238a f11452b;

        public b(String str, AbstractC1238a abstractC1238a) {
            this.f11451a = str;
            this.f11452b = abstractC1238a;
        }

        @Override // e.AbstractC1221c
        public void b(Object obj, AbstractC1898b abstractC1898b) throws Exception {
            Integer num = (Integer) AbstractC1222d.this.f11441b.get(this.f11451a);
            if (num != null) {
                AbstractC1222d.this.f11443d.add(this.f11451a);
                try {
                    AbstractC1222d.this.f(num.intValue(), this.f11452b, obj, abstractC1898b);
                    return;
                } catch (Exception e4) {
                    AbstractC1222d.this.f11443d.remove(this.f11451a);
                    throw e4;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f11452b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // e.AbstractC1221c
        public void c() {
            AbstractC1222d.this.l(this.f11451a);
        }
    }

    /* JADX INFO: renamed from: e.d$c */
    public class c extends AbstractC1221c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1238a f11455b;

        public c(String str, AbstractC1238a abstractC1238a) {
            this.f11454a = str;
            this.f11455b = abstractC1238a;
        }

        @Override // e.AbstractC1221c
        public void b(Object obj, AbstractC1898b abstractC1898b) throws Exception {
            Integer num = (Integer) AbstractC1222d.this.f11441b.get(this.f11454a);
            if (num != null) {
                AbstractC1222d.this.f11443d.add(this.f11454a);
                try {
                    AbstractC1222d.this.f(num.intValue(), this.f11455b, obj, abstractC1898b);
                    return;
                } catch (Exception e4) {
                    AbstractC1222d.this.f11443d.remove(this.f11454a);
                    throw e4;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f11455b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // e.AbstractC1221c
        public void c() {
            AbstractC1222d.this.l(this.f11454a);
        }
    }

    /* JADX INFO: renamed from: e.d$d, reason: collision with other inner class name */
    public static class C0187d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1220b f11457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1238a f11458b;

        public C0187d(InterfaceC1220b interfaceC1220b, AbstractC1238a abstractC1238a) {
            this.f11457a = interfaceC1220b;
            this.f11458b = abstractC1238a;
        }
    }

    /* JADX INFO: renamed from: e.d$e */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0846i f11459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f11460b = new ArrayList();

        public e(AbstractC0846i abstractC0846i) {
            this.f11459a = abstractC0846i;
        }

        public void a(InterfaceC0848k interfaceC0848k) {
            this.f11459a.a(interfaceC0848k);
            this.f11460b.add(interfaceC0848k);
        }

        public void b() {
            Iterator it = this.f11460b.iterator();
            while (it.hasNext()) {
                this.f11459a.c((InterfaceC0848k) it.next());
            }
            this.f11460b.clear();
        }
    }

    public final void a(int i4, String str) {
        this.f11440a.put(Integer.valueOf(i4), str);
        this.f11441b.put(str, Integer.valueOf(i4));
    }

    public final boolean b(int i4, int i5, Intent intent) {
        String str = (String) this.f11440a.get(Integer.valueOf(i4));
        if (str == null) {
            return false;
        }
        d(str, i5, intent, (C0187d) this.f11444e.get(str));
        return true;
    }

    public final boolean c(int i4, Object obj) {
        InterfaceC1220b interfaceC1220b;
        String str = (String) this.f11440a.get(Integer.valueOf(i4));
        if (str == null) {
            return false;
        }
        C0187d c0187d = (C0187d) this.f11444e.get(str);
        if (c0187d == null || (interfaceC1220b = c0187d.f11457a) == null) {
            this.f11446g.remove(str);
            this.f11445f.put(str, obj);
            return true;
        }
        if (!this.f11443d.remove(str)) {
            return true;
        }
        interfaceC1220b.a(obj);
        return true;
    }

    public final void d(String str, int i4, Intent intent, C0187d c0187d) {
        if (c0187d == null || c0187d.f11457a == null || !this.f11443d.contains(str)) {
            this.f11445f.remove(str);
            this.f11446g.putParcelable(str, new C1219a(i4, intent));
        } else {
            c0187d.f11457a.a(c0187d.f11458b.c(i4, intent));
            this.f11443d.remove(str);
        }
    }

    public final int e() {
        int iD = AbstractC1608c.f13542a.d(2147418112);
        while (true) {
            int i4 = iD + 65536;
            if (!this.f11440a.containsKey(Integer.valueOf(i4))) {
                return i4;
            }
            iD = AbstractC1608c.f13542a.d(2147418112);
        }
    }

    public abstract void f(int i4, AbstractC1238a abstractC1238a, Object obj, AbstractC1898b abstractC1898b);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f11443d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f11446g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
            String str = stringArrayList.get(i4);
            if (this.f11441b.containsKey(str)) {
                Integer num = (Integer) this.f11441b.remove(str);
                if (!this.f11446g.containsKey(str)) {
                    this.f11440a.remove(num);
                }
            }
            a(integerArrayList.get(i4).intValue(), stringArrayList.get(i4));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f11441b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f11441b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f11443d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f11446g.clone());
    }

    public final AbstractC1221c i(String str, InterfaceC0850m interfaceC0850m, AbstractC1238a abstractC1238a, InterfaceC1220b interfaceC1220b) {
        AbstractC0846i lifecycle = interfaceC0850m.getLifecycle();
        if (lifecycle.b().c(AbstractC0846i.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + interfaceC0850m + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        e eVar = (e) this.f11442c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, interfaceC1220b, abstractC1238a));
        this.f11442c.put(str, eVar);
        return new b(str, abstractC1238a);
    }

    public final AbstractC1221c j(String str, AbstractC1238a abstractC1238a, InterfaceC1220b interfaceC1220b) {
        k(str);
        this.f11444e.put(str, new C0187d(interfaceC1220b, abstractC1238a));
        if (this.f11445f.containsKey(str)) {
            Object obj = this.f11445f.get(str);
            this.f11445f.remove(str);
            interfaceC1220b.a(obj);
        }
        C1219a c1219a = (C1219a) this.f11446g.getParcelable(str);
        if (c1219a != null) {
            this.f11446g.remove(str);
            interfaceC1220b.a(abstractC1238a.c(c1219a.b(), c1219a.a()));
        }
        return new c(str, abstractC1238a);
    }

    public final void k(String str) {
        if (((Integer) this.f11441b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer num;
        if (!this.f11443d.contains(str) && (num = (Integer) this.f11441b.remove(str)) != null) {
            this.f11440a.remove(num);
        }
        this.f11444e.remove(str);
        if (this.f11445f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f11445f.get(str));
            this.f11445f.remove(str);
        }
        if (this.f11446g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f11446g.getParcelable(str));
            this.f11446g.remove(str);
        }
        e eVar = (e) this.f11442c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f11442c.remove(str);
        }
    }
}
