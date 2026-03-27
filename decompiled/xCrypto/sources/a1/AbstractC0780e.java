package a1;

import a1.v;
import android.content.Context;
import c1.C0873a;
import g1.C1258d;
import g1.C1261g;
import g1.C1263i;
import i1.C1300g;
import i1.C1301h;
import i1.C1302i;
import i1.C1303j;
import i1.InterfaceC1297d;
import i1.N;
import i1.X;
import k1.C1569c;
import k1.C1570d;

/* JADX INFO: renamed from: a1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0780e {

    /* JADX INFO: renamed from: a1.e$b */
    public static final class b implements v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6077a;

        public b() {
        }

        @Override // a1.v.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f6077a = (Context) c1.d.b(context);
            return this;
        }

        @Override // a1.v.a
        public v build() {
            c1.d.a(this.f6077a, Context.class);
            return new c(this.f6077a);
        }
    }

    /* JADX INFO: renamed from: a1.e$c */
    public static final class c extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f6078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V2.a f6079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V2.a f6080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public V2.a f6081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public V2.a f6082e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public V2.a f6083f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public V2.a f6084g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public V2.a f6085h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public V2.a f6086i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public V2.a f6087j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public V2.a f6088k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public V2.a f6089l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public V2.a f6090m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public V2.a f6091n;

        @Override // a1.v
        public InterfaceC1297d e() {
            return (InterfaceC1297d) this.f6085h.get();
        }

        @Override // a1.v
        public u f() {
            return (u) this.f6091n.get();
        }

        public final void g(Context context) {
            this.f6079b = C0873a.a(k.a());
            c1.b bVarA = c1.c.a(context);
            this.f6080c = bVarA;
            b1.j jVarA = b1.j.a(bVarA, C1569c.a(), C1570d.a());
            this.f6081d = jVarA;
            this.f6082e = C0873a.a(b1.l.a(this.f6080c, jVarA));
            this.f6083f = X.a(this.f6080c, C1300g.a(), C1302i.a());
            this.f6084g = C0873a.a(C1301h.a(this.f6080c));
            this.f6085h = C0873a.a(N.a(C1569c.a(), C1570d.a(), C1303j.a(), this.f6083f, this.f6084g));
            C1261g c1261gB = C1261g.b(C1569c.a());
            this.f6086i = c1261gB;
            C1263i c1263iA = C1263i.a(this.f6080c, this.f6085h, c1261gB, C1570d.a());
            this.f6087j = c1263iA;
            V2.a aVar = this.f6079b;
            V2.a aVar2 = this.f6082e;
            V2.a aVar3 = this.f6085h;
            this.f6088k = C1258d.a(aVar, aVar2, c1263iA, aVar3, aVar3);
            V2.a aVar4 = this.f6080c;
            V2.a aVar5 = this.f6082e;
            V2.a aVar6 = this.f6085h;
            this.f6089l = h1.s.a(aVar4, aVar5, aVar6, this.f6087j, this.f6079b, aVar6, C1569c.a(), C1570d.a(), this.f6085h);
            V2.a aVar7 = this.f6079b;
            V2.a aVar8 = this.f6085h;
            this.f6090m = h1.w.a(aVar7, aVar8, this.f6087j, aVar8);
            this.f6091n = C0873a.a(w.a(C1569c.a(), C1570d.a(), this.f6088k, this.f6089l, this.f6090m));
        }

        public c(Context context) {
            this.f6078a = this;
            g(context);
        }
    }

    public static v.a a() {
        return new b();
    }
}
