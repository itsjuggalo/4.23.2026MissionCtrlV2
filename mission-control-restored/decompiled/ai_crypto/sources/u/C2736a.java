package u;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: u.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2736a extends g implements Map {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AbstractC2741f f24342h;

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    public class C0374a extends AbstractC2741f {
        public C0374a() {
        }

        @Override // u.AbstractC2741f
        public void a() {
            C2736a.this.clear();
        }

        @Override // u.AbstractC2741f
        public Object b(int i7, int i8) {
            return C2736a.this.f24383b[(i7 << 1) + i8];
        }

        @Override // u.AbstractC2741f
        public Map c() {
            return C2736a.this;
        }

        @Override // u.AbstractC2741f
        public int d() {
            return C2736a.this.f24384c;
        }

        @Override // u.AbstractC2741f
        public int e(Object obj) {
            return C2736a.this.g(obj);
        }

        @Override // u.AbstractC2741f
        public int f(Object obj) {
            return C2736a.this.i(obj);
        }

        @Override // u.AbstractC2741f
        public void g(Object obj, Object obj2) {
            C2736a.this.put(obj, obj2);
        }

        @Override // u.AbstractC2741f
        public void h(int i7) {
            C2736a.this.l(i7);
        }

        @Override // u.AbstractC2741f
        public Object i(int i7, Object obj) {
            return C2736a.this.m(i7, obj);
        }
    }

    public C2736a() {
    }

    @Override // java.util.Map
    public Set entrySet() {
        return o().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return o().m();
    }

    public final AbstractC2741f o() {
        if (this.f24342h == null) {
            this.f24342h = new C0374a();
        }
        return this.f24342h;
    }

    public boolean p(Collection collection) {
        return AbstractC2741f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        d(this.f24384c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return o().n();
    }

    public C2736a(int i7) {
        super(i7);
    }

    public C2736a(g gVar) {
        super(gVar);
    }
}
