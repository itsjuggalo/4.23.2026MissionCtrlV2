package m3;

import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c4.h f15797a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c4.h {
        public a(long j10) {
            super(j10);
        }

        @Override // c4.h
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b bVar, Object obj) {
            bVar.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Queue f15799d = c4.l.f(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15802c;

        public static b a(Object obj, int i10, int i11) {
            b bVar;
            Queue queue = f15799d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.b(obj, i10, i11);
            return bVar;
        }

        public final void b(Object obj, int i10, int i11) {
            this.f15802c = obj;
            this.f15801b = i10;
            this.f15800a = i11;
        }

        public void c() {
            Queue queue = f15799d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f15801b == bVar.f15801b && this.f15800a == bVar.f15800a && this.f15802c.equals(bVar.f15802c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f15800a * 31) + this.f15801b) * 31) + this.f15802c.hashCode();
        }
    }

    public m(long j10) {
        this.f15797a = new a(j10);
    }

    public Object a(Object obj, int i10, int i11) {
        b bVarA = b.a(obj, i10, i11);
        Object objG = this.f15797a.g(bVarA);
        bVarA.c();
        return objG;
    }

    public void b(Object obj, int i10, int i11, Object obj2) {
        this.f15797a.k(b.a(obj, i10, i11), obj2);
    }
}
