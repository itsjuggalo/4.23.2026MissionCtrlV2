package h9;

import com.google.protobuf.i;
import j9.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f11246a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11247b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f11248c = new b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends h9.b {
        public a() {
        }

        @Override // h9.b
        public void a(i iVar) {
            d.this.f11246a.h(iVar);
        }

        @Override // h9.b
        public void b(double d10) {
            d.this.f11246a.j(d10);
        }

        @Override // h9.b
        public void c() {
            d.this.f11246a.n();
        }

        @Override // h9.b
        public void d(long j10) {
            d.this.f11246a.r(j10);
        }

        @Override // h9.b
        public void e(String str) {
            d.this.f11246a.v(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends h9.b {
        public b() {
        }

        @Override // h9.b
        public void a(i iVar) {
            d.this.f11246a.i(iVar);
        }

        @Override // h9.b
        public void b(double d10) {
            d.this.f11246a.k(d10);
        }

        @Override // h9.b
        public void c() {
            d.this.f11246a.o();
        }

        @Override // h9.b
        public void d(long j10) {
            d.this.f11246a.s(j10);
        }

        @Override // h9.b
        public void e(String str) {
            d.this.f11246a.w(str);
        }
    }

    public h9.b b(p.c.a aVar) {
        return aVar.equals(p.c.a.DESCENDING) ? this.f11248c : this.f11247b;
    }

    public byte[] c() {
        return this.f11246a.a();
    }

    public void d(byte[] bArr) {
        this.f11246a.c(bArr);
    }
}
