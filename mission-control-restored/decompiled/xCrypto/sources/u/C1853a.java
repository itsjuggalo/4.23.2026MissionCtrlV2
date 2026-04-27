package u;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: u.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1853a extends C1859g implements Map {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AbstractC1858f f15043h;

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    public class C0244a extends AbstractC1858f {
        public C0244a() {
        }

        @Override // u.AbstractC1858f
        public void a() {
            C1853a.this.clear();
        }

        @Override // u.AbstractC1858f
        public Object b(int i4, int i5) {
            return C1853a.this.f15084b[(i4 << 1) + i5];
        }

        @Override // u.AbstractC1858f
        public Map c() {
            return C1853a.this;
        }

        @Override // u.AbstractC1858f
        public int d() {
            return C1853a.this.f15085c;
        }

        @Override // u.AbstractC1858f
        public int e(Object obj) {
            return C1853a.this.g(obj);
        }

        @Override // u.AbstractC1858f
        public int f(Object obj) {
            return C1853a.this.i(obj);
        }

        @Override // u.AbstractC1858f
        public void g(Object obj, Object obj2) {
            C1853a.this.put(obj, obj2);
        }

        @Override // u.AbstractC1858f
        public void h(int i4) {
            C1853a.this.l(i4);
        }

        @Override // u.AbstractC1858f
        public Object i(int i4, Object obj) {
            return C1853a.this.m(i4, obj);
        }
    }

    public C1853a() {
    }

    @Override // java.util.Map
    public Set entrySet() {
        return o().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return o().m();
    }

    public final AbstractC1858f o() {
        if (this.f15043h == null) {
            this.f15043h = new C0244a();
        }
        return this.f15043h;
    }

    public boolean p(Collection collection) {
        return AbstractC1858f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        d(this.f15085c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return o().n();
    }

    public C1853a(int i4) {
        super(i4);
    }

    public C1853a(C1859g c1859g) {
        super(c1859g);
    }
}
