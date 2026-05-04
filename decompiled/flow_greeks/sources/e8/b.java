package e8;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r8.i f8465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f8466b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Iterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f8467a;

        /* JADX INFO: renamed from: e8.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0156a implements Iterator {
            public C0156a() {
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b next() {
                r8.m mVar = (r8.m) a.this.f8467a.next();
                return new b(b.this.f8466b.W(mVar.c().b()), r8.i.c(mVar.d()));
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return a.this.f8467a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove called on immutable collection");
            }
        }

        public a(Iterator it) {
            this.f8467a = it;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0156a();
        }
    }

    public b(e eVar, r8.i iVar) {
        this.f8465a = iVar;
        this.f8466b = eVar;
    }

    public boolean b() {
        return !this.f8465a.g().isEmpty();
    }

    public Iterable c() {
        return new a(this.f8465a.iterator());
    }

    public long d() {
        return this.f8465a.g().j();
    }

    public String e() {
        return this.f8466b.X();
    }

    public Object f() {
        Object value = this.f8465a.g().n().getValue();
        return value instanceof Long ? Double.valueOf(((Long) value).longValue()) : value;
    }

    public e g() {
        return this.f8466b;
    }

    public Object h() {
        return this.f8465a.g().getValue();
    }

    public Object i(boolean z10) {
        return this.f8465a.g().N(z10);
    }

    public String toString() {
        return "DataSnapshot { key = " + this.f8466b.X() + ", value = " + this.f8465a.g().N(true) + " }";
    }
}
