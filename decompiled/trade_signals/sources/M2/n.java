package M2;

import M2.n;
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
import u3.InterfaceC2772a;

/* JADX INFO: loaded from: classes.dex */
public class n implements InterfaceC0701d, InterfaceC2772a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final S3.b f5312i = new S3.b() { // from class: M2.j
        @Override // S3.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f5315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f5317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f5318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f5319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f5320h;

    public n(Executor executor, Iterable iterable, Collection collection, i iVar) {
        this.f5313a = new HashMap();
        this.f5314b = new HashMap();
        this.f5315c = new HashMap();
        this.f5317e = new HashSet();
        this.f5319g = new AtomicReference();
        u uVar = new u(executor);
        this.f5318f = uVar;
        this.f5320h = iVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C0700c.s(uVar, u.class, A3.d.class, A3.c.class));
        arrayList.add(C0700c.s(this, InterfaceC2772a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C0700c c0700c = (C0700c) it.next();
            if (c0700c != null) {
                arrayList.add(c0700c);
            }
        }
        this.f5316d = p(iterable);
        m(arrayList);
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

    @Override // M2.InterfaceC0701d
    public S3.a a(E e8) {
        S3.b bVarF = f(e8);
        return bVarF == null ? C.e() : bVarF instanceof C ? (C) bVarF : C.i(bVarF);
    }

    @Override // M2.InterfaceC0701d
    public synchronized S3.b e(E e8) {
        x xVar = (x) this.f5315c.get(e8);
        if (xVar != null) {
            return xVar;
        }
        return f5312i;
    }

    @Override // M2.InterfaceC0701d
    public synchronized S3.b f(E e8) {
        D.c(e8, "Null interface requested.");
        return (S3.b) this.f5314b.get(e8);
    }

    public final void m(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f5316d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((S3.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f5320h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (v e8) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e8);
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = ((C0700c) it2.next()).j().toArray();
                int length = array.length;
                int i8 = 0;
                while (true) {
                    if (i8 < length) {
                        Object obj = array[i8];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f5317e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f5317e.add(obj.toString());
                        }
                        i8++;
                    }
                }
            }
            if (this.f5313a.isEmpty()) {
                p.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f5313a.keySet());
                arrayList2.addAll(list);
                p.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                final C0700c c0700c = (C0700c) it3.next();
                this.f5313a.put(c0700c, new w(new S3.b() { // from class: M2.k
                    @Override // S3.b
                    public final Object get() {
                        return this.f5306a.q(c0700c);
                    }
                }));
            }
            arrayList.addAll(v(list));
            arrayList.addAll(w());
            u();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        t();
    }

    public final void n(Map map, boolean z7) {
        for (Map.Entry entry : map.entrySet()) {
            C0700c c0700c = (C0700c) entry.getKey();
            S3.b bVar = (S3.b) entry.getValue();
            if (c0700c.n() || (c0700c.o() && z7)) {
                bVar.get();
            }
        }
        this.f5318f.f();
    }

    public void o(boolean z7) {
        HashMap map;
        if (com.amazon.a.a.l.d.a(this.f5319g, null, Boolean.valueOf(z7))) {
            synchronized (this) {
                map = new HashMap(this.f5313a);
            }
            n(map, z7);
        }
    }

    public final /* synthetic */ Object q(C0700c c0700c) {
        return c0700c.h().create(new F(c0700c, this));
    }

    public final void t() {
        Boolean bool = (Boolean) this.f5319g.get();
        if (bool != null) {
            n(this.f5313a, bool.booleanValue());
        }
    }

    public final void u() {
        Map map;
        E eC;
        S3.b bVarE;
        for (C0700c c0700c : this.f5313a.keySet()) {
            for (q qVar : c0700c.g()) {
                if (qVar.g() && !this.f5315c.containsKey(qVar.c())) {
                    map = this.f5315c;
                    eC = qVar.c();
                    bVarE = x.b(Collections.emptySet());
                } else if (this.f5314b.containsKey(qVar.c())) {
                    continue;
                } else {
                    if (qVar.f()) {
                        throw new y(String.format("Unsatisfied dependency for component %s: %s", c0700c, qVar.c()));
                    }
                    if (!qVar.g()) {
                        map = this.f5314b;
                        eC = qVar.c();
                        bVarE = C.e();
                    }
                }
                map.put(eC, bVarE);
            }
        }
    }

    public final List v(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0700c c0700c = (C0700c) it.next();
            if (c0700c.p()) {
                final S3.b bVar = (S3.b) this.f5313a.get(c0700c);
                for (E e8 : c0700c.j()) {
                    if (this.f5314b.containsKey(e8)) {
                        final C c8 = (C) ((S3.b) this.f5314b.get(e8));
                        arrayList.add(new Runnable() { // from class: M2.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                c8.j(bVar);
                            }
                        });
                    } else {
                        this.f5314b.put(e8, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List w() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f5313a.entrySet()) {
            C0700c c0700c = (C0700c) entry.getKey();
            if (!c0700c.p()) {
                S3.b bVar = (S3.b) entry.getValue();
                for (E e8 : c0700c.j()) {
                    if (!map.containsKey(e8)) {
                        map.put(e8, new HashSet());
                    }
                    ((Set) map.get(e8)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f5315c.containsKey(entry2.getKey())) {
                final x xVar = (x) this.f5315c.get(entry2.getKey());
                for (final S3.b bVar2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: M2.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            xVar.a(bVar2);
                        }
                    });
                }
            } else {
                this.f5315c.put((E) entry2.getKey(), x.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f5321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f5322b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f5323c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f5324d = i.f5305a;

        public b(Executor executor) {
            this.f5321a = executor;
        }

        public b b(C0700c c0700c) {
            this.f5323c.add(c0700c);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f5322b.add(new S3.b() { // from class: M2.o
                @Override // S3.b
                public final Object get() {
                    return n.b.f(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.f5322b.addAll(collection);
            return this;
        }

        public n e() {
            return new n(this.f5321a, this.f5322b, this.f5323c, this.f5324d);
        }

        public b g(i iVar) {
            this.f5324d = iVar;
            return this;
        }

        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
