package o7;

import android.util.Log;
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
import o7.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements d, w8.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final fa.b f17568i = new fa.b() { // from class: o7.j
        @Override // fa.b
        public final Object get() {
            return Collections.EMPTY_SET;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f17569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f17570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f17571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f17572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f17573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f17574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f17575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f17576h;

    public static /* synthetic */ Object i(n nVar, c cVar) {
        nVar.getClass();
        return cVar.h().create(new f0(cVar, nVar));
    }

    public static b l(Executor executor) {
        return new b(executor);
    }

    public static List p(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // o7.d
    public fa.a a(e0 e0Var) {
        fa.b bVarD = d(e0Var);
        return bVarD == null ? c0.e() : bVarD instanceof c0 ? (c0) bVarD : c0.f(bVarD);
    }

    @Override // o7.d
    public synchronized fa.b d(e0 e0Var) {
        d0.c(e0Var, "Null interface requested.");
        return (fa.b) this.f17570b.get(e0Var);
    }

    @Override // o7.d
    public synchronized fa.b g(e0 e0Var) {
        x xVar = (x) this.f17571c.get(e0Var);
        if (xVar != null) {
            return xVar;
        }
        return f17568i;
    }

    public final void m(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f17572d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((fa.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f17576h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (v e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = ((c) it2.next()).j().toArray();
                int length = array.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        Object obj = array[i10];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f17573e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f17573e.add(obj.toString());
                        }
                        i10++;
                    }
                }
            }
            if (this.f17569a.isEmpty()) {
                p.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f17569a.keySet());
                arrayList2.addAll(list);
                p.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                final c cVar = (c) it3.next();
                this.f17569a.put(cVar, new w(new fa.b() { // from class: o7.k
                    @Override // fa.b
                    public final Object get() {
                        return n.i(this.f17562a, cVar);
                    }
                }));
            }
            arrayList.addAll(s(list));
            arrayList.addAll(t());
            r();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        q();
    }

    public final void n(Map map, boolean z10) {
        for (Map.Entry entry : map.entrySet()) {
            c cVar = (c) entry.getKey();
            fa.b bVar = (fa.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z10)) {
                bVar.get();
            }
        }
        this.f17574f.f();
    }

    public void o(boolean z10) {
        HashMap map;
        if (com.amazon.a.a.l.d.a(this.f17575g, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f17569a);
            }
            n(map, z10);
        }
    }

    public final void q() {
        Boolean bool = (Boolean) this.f17575g.get();
        if (bool != null) {
            n(this.f17569a, bool.booleanValue());
        }
    }

    public final void r() {
        for (c cVar : this.f17569a.keySet()) {
            for (q qVar : cVar.g()) {
                if (qVar.g() && !this.f17571c.containsKey(qVar.c())) {
                    this.f17571c.put(qVar.c(), x.b(Collections.EMPTY_SET));
                } else if (this.f17570b.containsKey(qVar.c())) {
                    continue;
                } else {
                    if (qVar.f()) {
                        throw new y(String.format("Unsatisfied dependency for component %s: %s", cVar, qVar.c()));
                    }
                    if (!qVar.g()) {
                        this.f17570b.put(qVar.c(), c0.e());
                    }
                }
            }
        }
    }

    public final List s(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.p()) {
                final fa.b bVar = (fa.b) this.f17569a.get(cVar);
                for (e0 e0Var : cVar.j()) {
                    if (this.f17570b.containsKey(e0Var)) {
                        final c0 c0Var = (c0) ((fa.b) this.f17570b.get(e0Var));
                        arrayList.add(new Runnable() { // from class: o7.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0Var.g(bVar);
                            }
                        });
                    } else {
                        this.f17570b.put(e0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List t() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f17569a.entrySet()) {
            c cVar = (c) entry.getKey();
            if (!cVar.p()) {
                fa.b bVar = (fa.b) entry.getValue();
                for (e0 e0Var : cVar.j()) {
                    if (!map.containsKey(e0Var)) {
                        map.put(e0Var, new HashSet());
                    }
                    ((Set) map.get(e0Var)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f17571c.containsKey(entry2.getKey())) {
                final x xVar = (x) this.f17571c.get(entry2.getKey());
                for (final fa.b bVar2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: o7.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            xVar.a(bVar2);
                        }
                    });
                }
            } else {
                this.f17571c.put((e0) entry2.getKey(), x.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public n(Executor executor, Iterable iterable, Collection collection, i iVar) {
        this.f17569a = new HashMap();
        this.f17570b = new HashMap();
        this.f17571c = new HashMap();
        this.f17573e = new HashSet();
        this.f17575g = new AtomicReference();
        u uVar = new u(executor);
        this.f17574f = uVar;
        this.f17576h = iVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.q(uVar, u.class, c9.d.class, c9.c.class));
        arrayList.add(c.q(this, w8.a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f17572d = p(iterable);
        m(arrayList);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f17577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f17578b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f17579c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f17580d = i.f17561a;

        public b(Executor executor) {
            this.f17577a = executor;
        }

        public b b(c cVar) {
            this.f17579c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f17578b.add(new fa.b() { // from class: o7.o
                @Override // fa.b
                public final Object get() {
                    return n.b.a(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.f17578b.addAll(collection);
            return this;
        }

        public n e() {
            return new n(this.f17577a, this.f17578b, this.f17579c, this.f17580d);
        }

        public b f(i iVar) {
            this.f17580d = iVar;
            return this;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
