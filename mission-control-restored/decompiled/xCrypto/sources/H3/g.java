package H3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f758b;

        public a(e eVar) {
            this.f758b = eVar;
            this.f757a = eVar.f();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e next() {
            e eVar = this.f758b;
            int iF = eVar.f();
            int i4 = this.f757a;
            this.f757a = i4 - 1;
            return eVar.i(iF - i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f757a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f760b;

        public b(e eVar) {
            this.f760b = eVar;
            this.f759a = eVar.f();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            e eVar = this.f760b;
            int iF = eVar.f();
            int i4 = this.f759a;
            this.f759a = i4 - 1;
            return eVar.g(iF - i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f759a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class c implements Iterable, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f761a;

        public c(e eVar) {
            this.f761a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.f761a);
        }
    }

    public static final class d implements Iterable, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f762a;

        public d(e eVar) {
            this.f762a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.f762a);
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
