package E3;

import G3.p;
import com.google.protobuf.AbstractC1240i;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1628a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1629b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1630c = new b();

    public class a extends E3.b {
        public a() {
        }

        @Override // E3.b
        public void a(AbstractC1240i abstractC1240i) {
            d.this.f1628a.h(abstractC1240i);
        }

        @Override // E3.b
        public void b(double d7) {
            d.this.f1628a.j(d7);
        }

        @Override // E3.b
        public void c() {
            d.this.f1628a.n();
        }

        @Override // E3.b
        public void d(long j7) {
            d.this.f1628a.r(j7);
        }

        @Override // E3.b
        public void e(String str) {
            d.this.f1628a.v(str);
        }
    }

    public class b extends E3.b {
        public b() {
        }

        @Override // E3.b
        public void a(AbstractC1240i abstractC1240i) {
            d.this.f1628a.i(abstractC1240i);
        }

        @Override // E3.b
        public void b(double d7) {
            d.this.f1628a.k(d7);
        }

        @Override // E3.b
        public void c() {
            d.this.f1628a.o();
        }

        @Override // E3.b
        public void d(long j7) {
            d.this.f1628a.s(j7);
        }

        @Override // E3.b
        public void e(String str) {
            d.this.f1628a.w(str);
        }
    }

    public E3.b b(p.c.a aVar) {
        return aVar.equals(p.c.a.DESCENDING) ? this.f1630c : this.f1629b;
    }

    public byte[] c() {
        return this.f1628a.a();
    }

    public void d(byte[] bArr) {
        this.f1628a.c(bArr);
    }
}
