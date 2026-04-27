package c3;

import java.util.Iterator;
import p3.C2555i;
import p3.C2559m;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2555i f13346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f13347b;

    public class a implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f13348a;

        /* JADX INFO: renamed from: c3.b$a$a, reason: collision with other inner class name */
        public class C0229a implements Iterator {
            public C0229a() {
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b next() {
                C2559m c2559m = (C2559m) a.this.f13348a.next();
                return new b(b.this.f13347b.W(c2559m.c().b()), C2555i.d(c2559m.d()));
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return a.this.f13348a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove called on immutable collection");
            }
        }

        public a(Iterator it) {
            this.f13348a = it;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0229a();
        }
    }

    public b(e eVar, C2555i c2555i) {
        this.f13346a = c2555i;
        this.f13347b = eVar;
    }

    public boolean b() {
        return !this.f13346a.n().isEmpty();
    }

    public Iterable c() {
        return new a(this.f13346a.iterator());
    }

    public long d() {
        return this.f13346a.n().j();
    }

    public String e() {
        return this.f13347b.X();
    }

    public Object f() {
        Object value = this.f13346a.n().o().getValue();
        return value instanceof Long ? Double.valueOf(((Long) value).longValue()) : value;
    }

    public e g() {
        return this.f13347b;
    }

    public Object h() {
        return this.f13346a.n().getValue();
    }

    public Object i(boolean z7) {
        return this.f13346a.n().D(z7);
    }

    public String toString() {
        return "DataSnapshot { key = " + this.f13347b.X() + ", value = " + this.f13346a.n().D(true) + " }";
    }
}
