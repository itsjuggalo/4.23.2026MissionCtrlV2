package b3;

import android.util.Log;
import b3.n;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import t3.InterfaceC2656a;
import z3.InterfaceC2891c;
import z3.InterfaceC2892d;

/* JADX INFO: loaded from: classes.dex */
public class n implements InterfaceC0987d, InterfaceC2656a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final N3.b f8545i = new N3.b() { // from class: b3.j
        @Override // N3.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f8547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f8549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f8550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f8551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f8552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC0992i f8553h;

    public static b m(Executor executor) {
        return new b(executor);
    }

    public static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // b3.InterfaceC0987d
    public N3.a b(C0982E c0982e) {
        N3.b bVarH = h(c0982e);
        return bVarH == null ? C0980C.e() : bVarH instanceof C0980C ? (C0980C) bVarH : C0980C.i(bVarH);
    }

    @Override // b3.InterfaceC0987d
    public synchronized N3.b g(C0982E c0982e) {
        x xVar = (x) this.f8548c.get(c0982e);
        if (xVar != null) {
            return xVar;
        }
        return f8545i;
    }

    @Override // b3.InterfaceC0987d
    public synchronized N3.b h(C0982E c0982e) {
        AbstractC0981D.c(c0982e, "Null interface requested.");
        return (N3.b) this.f8547b.get(c0982e);
    }

    public final void n(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f8549d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((N3.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f8553h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (v e7) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e7);
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = ((C0986c) it2.next()).j().toArray();
                int length = array.length;
                int i7 = 0;
                while (true) {
                    if (i7 < length) {
                        Object obj = array[i7];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f8550e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f8550e.add(obj.toString());
                        }
                        i7++;
                    }
                }
            }
            if (this.f8546a.isEmpty()) {
                p.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f8546a.keySet());
                arrayList2.addAll(list);
                p.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                final C0986c c0986c = (C0986c) it3.next();
                this.f8546a.put(c0986c, new w(new N3.b() { // from class: b3.k
                    @Override // N3.b
                    public final Object get() {
                        return this.f8539a.r(c0986c);
                    }
                }));
            }
            arrayList.addAll(w(list));
            arrayList.addAll(x());
            v();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        u();
    }

    public final void o(Map map, boolean z7) {
        for (Map.Entry entry : map.entrySet()) {
            C0986c c0986c = (C0986c) entry.getKey();
            N3.b bVar = (N3.b) entry.getValue();
            if (c0986c.n() || (c0986c.o() && z7)) {
                bVar.get();
            }
        }
        this.f8551f.f();
    }

    public void p(boolean z7) {
        HashMap map;
        if (com.amazon.a.a.l.d.a(this.f8552g, null, Boolean.valueOf(z7))) {
            synchronized (this) {
                map = new HashMap(this.f8546a);
            }
            o(map, z7);
        }
    }

    public final /* synthetic */ Object r(C0986c c0986c) {
        return c0986c.h().a(new C0983F(c0986c, this));
    }

    public final void u() {
        Boolean bool = (Boolean) this.f8552g.get();
        if (bool != null) {
            o(this.f8546a, bool.booleanValue());
        }
    }

    public final void v() {
        for (C0986c c0986c : this.f8546a.keySet()) {
            for (q qVar : c0986c.g()) {
                if (qVar.g() && !this.f8548c.containsKey(qVar.c())) {
                    this.f8548c.put(qVar.c(), x.b(Collections.emptySet()));
                } else if (this.f8547b.containsKey(qVar.c())) {
                    continue;
                } else {
                    if (qVar.f()) {
                        throw new y(String.format("Unsatisfied dependency for component %s: %s", c0986c, qVar.c()));
                    }
                    if (!qVar.g()) {
                        this.f8547b.put(qVar.c(), C0980C.e());
                    }
                }
            }
        }
    }

    public final List w(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0986c c0986c = (C0986c) it.next();
            if (c0986c.p()) {
                final N3.b bVar = (N3.b) this.f8546a.get(c0986c);
                for (C0982E c0982e : c0986c.j()) {
                    if (this.f8547b.containsKey(c0982e)) {
                        final C0980C c0980c = (C0980C) ((N3.b) this.f8547b.get(c0982e));
                        arrayList.add(new Runnable() { // from class: b3.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0980c.j(bVar);
                            }
                        });
                    } else {
                        this.f8547b.put(c0982e, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List x() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f8546a.entrySet()) {
            C0986c c0986c = (C0986c) entry.getKey();
            if (!c0986c.p()) {
                N3.b bVar = (N3.b) entry.getValue();
                for (C0982E c0982e : c0986c.j()) {
                    if (!map.containsKey(c0982e)) {
                        map.put(c0982e, new HashSet());
                    }
                    ((Set) map.get(c0982e)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f8548c.containsKey(entry2.getKey())) {
                final x xVar = (x) this.f8548c.get(entry2.getKey());
                for (final N3.b bVar2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: b3.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            xVar.a(bVar2);
                        }
                    });
                }
            } else {
                this.f8548c.put((C0982E) entry2.getKey(), x.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public n(Executor executor, Iterable iterable, Collection collection, InterfaceC0992i interfaceC0992i) {
        this.f8546a = new HashMap();
        this.f8547b = new HashMap();
        this.f8548c = new HashMap();
        this.f8550e = new HashSet();
        this.f8552g = new AtomicReference();
        u uVar = new u(executor);
        this.f8551f = uVar;
        this.f8553h = interfaceC0992i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C0986c.s(uVar, u.class, InterfaceC2892d.class, InterfaceC2891c.class));
        arrayList.add(C0986c.s(this, InterfaceC2656a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C0986c c0986c = (C0986c) it.next();
            if (c0986c != null) {
                arrayList.add(c0986c);
            }
        }
        this.f8549d = q(iterable);
        n(arrayList);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f8554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f8555b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f8556c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public InterfaceC0992i f8557d = InterfaceC0992i.f8538a;

        public b(Executor executor) {
            this.f8554a = executor;
        }

        public b b(C0986c c0986c) {
            this.f8556c.add(c0986c);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f8555b.add(new N3.b() { // from class: b3.o
                @Override // N3.b
                public final Object get() {
                    return n.b.f(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.f8555b.addAll(collection);
            return this;
        }

        public n e() {
            return new n(this.f8554a, this.f8555b, this.f8556c, this.f8557d);
        }

        public b g(InterfaceC0992i interfaceC0992i) {
            this.f8557d = interfaceC0992i;
            return this;
        }

        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
