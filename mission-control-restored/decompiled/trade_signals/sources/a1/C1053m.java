package a1;

import java.util.Queue;
import q1.AbstractC2629l;
import q1.C2625h;

/* JADX INFO: renamed from: a1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1053m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2625h f9859a;

    /* JADX INFO: renamed from: a1.m$a */
    public class a extends C2625h {
        public a(long j8) {
            super(j8);
        }

        @Override // q1.C2625h
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b bVar, Object obj) {
            bVar.c();
        }
    }

    /* JADX INFO: renamed from: a1.m$b */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Queue f9861d = AbstractC2629l.f(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f9864c;

        public static b a(Object obj, int i8, int i9) {
            b bVar;
            Queue queue = f9861d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.b(obj, i8, i9);
            return bVar;
        }

        public final void b(Object obj, int i8, int i9) {
            this.f9864c = obj;
            this.f9863b = i8;
            this.f9862a = i9;
        }

        public void c() {
            Queue queue = f9861d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9863b == bVar.f9863b && this.f9862a == bVar.f9862a && this.f9864c.equals(bVar.f9864c);
        }

        public int hashCode() {
            return (((this.f9862a * 31) + this.f9863b) * 31) + this.f9864c.hashCode();
        }
    }

    public C1053m(long j8) {
        this.f9859a = new a(j8);
    }

    public Object a(Object obj, int i8, int i9) {
        b bVarA = b.a(obj, i8, i9);
        Object objG = this.f9859a.g(bVarA);
        bVarA.c();
        return objG;
    }

    public void b(Object obj, int i8, int i9, Object obj2) {
        this.f9859a.k(b.a(obj, i8, i9), obj2);
    }
}
