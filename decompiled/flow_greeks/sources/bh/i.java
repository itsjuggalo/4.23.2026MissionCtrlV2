package bh;

import java.util.Iterator;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f3395b;

        public a(e eVar) {
            this.f3395b = eVar;
            this.f3394a = eVar.l();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e next() {
            e eVar = this.f3395b;
            int iL = eVar.l();
            int i10 = this.f3394a;
            this.f3394a = i10 - 1;
            return eVar.o(iL - i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3394a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f3397b;

        public b(e eVar) {
            this.f3397b = eVar;
            this.f3396a = eVar.l();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            e eVar = this.f3397b;
            int iL = eVar.l();
            int i10 = this.f3396a;
            this.f3396a = i10 - 1;
            return eVar.m(iL - i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3396a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements Iterable, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f3398a;

        public c(e eVar) {
            this.f3398a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.f3398a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements Iterable, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f3399a;

        public d(e eVar) {
            this.f3399a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.f3399a);
        }
    }

    public static final Iterable a(e eVar) {
        t.f(eVar, "<this>");
        return new c(eVar);
    }

    public static final Iterable b(e eVar) {
        t.f(eVar, "<this>");
        return new d(eVar);
    }
}
