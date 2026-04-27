package m7;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f21524b;

        public a(e eVar) {
            this.f21524b = eVar;
            this.f21523a = eVar.e();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e next() {
            e eVar = this.f21524b;
            int iE = eVar.e();
            int i8 = this.f21523a;
            this.f21523a = i8 - 1;
            return eVar.h(iE - i8);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21523a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f21526b;

        public b(e eVar) {
            this.f21526b = eVar;
            this.f21525a = eVar.e();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            e eVar = this.f21526b;
            int iE = eVar.e();
            int i8 = this.f21525a;
            this.f21525a = i8 - 1;
            return eVar.f(iE - i8);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21525a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class c implements Iterable, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f21527a;

        public c(e eVar) {
            this.f21527a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.f21527a);
        }
    }

    public static final class d implements Iterable, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f21528a;

        public d(e eVar) {
            this.f21528a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.f21528a);
        }
    }

    public static final Iterable a(e eVar) {
        AbstractC2304t.f(eVar, "<this>");
        return new c(eVar);
    }

    public static final Iterable b(e eVar) {
        AbstractC2304t.f(eVar, "<this>");
        return new d(eVar);
    }
}
