package p6;

import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f22086b;

        public a(e eVar) {
            this.f22086b = eVar;
            this.f22085a = eVar.f();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e next() {
            e eVar = this.f22086b;
            int iF = eVar.f();
            int i7 = this.f22085a;
            this.f22085a = i7 - 1;
            return eVar.i(iF - i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22085a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f22088b;

        public b(e eVar) {
            this.f22088b = eVar;
            this.f22087a = eVar.f();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            e eVar = this.f22088b;
            int iF = eVar.f();
            int i7 = this.f22087a;
            this.f22087a = i7 - 1;
            return eVar.g(iF - i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22087a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class c implements Iterable, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f22089a;

        public c(e eVar) {
            this.f22089a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.f22089a);
        }
    }

    public static final class d implements Iterable, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f22090a;

        public d(e eVar) {
            this.f22090a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.f22090a);
        }
    }

    public static final Iterable a(e eVar) {
        r.f(eVar, "<this>");
        return new c(eVar);
    }

    public static final Iterable b(e eVar) {
        r.f(eVar, "<this>");
        return new d(eVar);
    }
}
