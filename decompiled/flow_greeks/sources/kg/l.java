package kg;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kg.k;
import kg.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matcher f14913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f14914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f14915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f14916d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends dd.d {
        public a() {
        }

        @Override // dd.b
        public int c() {
            return l.this.d().groupCount() + 1;
        }

        @Override // dd.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(String str) {
            return super.contains(str);
        }

        @Override // dd.d, java.util.List
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public String get(int i10) {
            String strGroup = l.this.d().group(i10);
            return strGroup == null ? "" : strGroup;
        }

        @Override // dd.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return p((String) obj);
            }
            return -1;
        }

        @Override // dd.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return q((String) obj);
            }
            return -1;
        }

        public /* bridge */ int p(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int q(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends dd.b implements j {
        public b() {
        }

        public static final i q(b bVar, int i10) {
            return bVar.p(i10);
        }

        @Override // dd.b
        public int c() {
            return l.this.d().groupCount() + 1;
        }

        @Override // dd.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof i) {
                return g((i) obj);
            }
            return false;
        }

        public /* bridge */ boolean g(i iVar) {
            return super.contains(iVar);
        }

        @Override // dd.b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return jg.t.E(dd.a0.Q(dd.r.l(this)), new pd.k() { // from class: kg.m
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return l.b.q(this.f14919a, ((Integer) obj).intValue());
                }
            }).iterator();
        }

        public i p(int i10) {
            vd.g gVarD = o.d(l.this.d(), i10);
            if (gVarD.a().intValue() < 0) {
                return null;
            }
            String strGroup = l.this.d().group(i10);
            kotlin.jvm.internal.t.e(strGroup, "group(...)");
            return new i(strGroup, gVarD);
        }
    }

    public l(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.t.f(matcher, "matcher");
        kotlin.jvm.internal.t.f(input, "input");
        this.f14913a = matcher;
        this.f14914b = input;
        this.f14915c = new b();
    }

    @Override // kg.k
    public k.b a() {
        return k.a.a(this);
    }

    @Override // kg.k
    public List b() {
        if (this.f14916d == null) {
            this.f14916d = new a();
        }
        List list = this.f14916d;
        kotlin.jvm.internal.t.c(list);
        return list;
    }

    public final MatchResult d() {
        return this.f14913a;
    }
}
