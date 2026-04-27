package r3;

import X2.AbstractC0755b;
import X2.AbstractC0757d;
import X2.AbstractC0769p;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import o3.C1676g;
import r3.C1762i;
import r3.InterfaceC1761h;

/* JADX INFO: renamed from: r3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1762i implements InterfaceC1761h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matcher f14588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f14589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1760g f14590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f14591d;

    /* JADX INFO: renamed from: r3.i$a */
    public static final class a extends AbstractC0757d {
        public a() {
        }

        @Override // X2.AbstractC0755b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return l((String) obj);
            }
            return false;
        }

        @Override // X2.AbstractC0755b
        public int i() {
            return C1762i.this.d().groupCount() + 1;
        }

        @Override // X2.AbstractC0757d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return n((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean l(String str) {
            return super.contains(str);
        }

        @Override // X2.AbstractC0757d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return o((String) obj);
            }
            return -1;
        }

        @Override // X2.AbstractC0757d, java.util.List
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public String get(int i4) {
            String strGroup = C1762i.this.d().group(i4);
            return strGroup == null ? "" : strGroup;
        }

        public /* bridge */ int n(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int o(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* JADX INFO: renamed from: r3.i$b */
    public static final class b extends AbstractC0755b implements InterfaceC1760g {
        public b() {
        }

        public static final C1759f o(b bVar, int i4) {
            return bVar.n(i4);
        }

        @Override // X2.AbstractC0755b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof C1759f) {
                return m((C1759f) obj);
            }
            return false;
        }

        @Override // X2.AbstractC0755b
        public int i() {
            return C1762i.this.d().groupCount() + 1;
        }

        @Override // X2.AbstractC0755b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return q3.l.i(X2.x.B(AbstractC0769p.h(this)), new i3.k() { // from class: r3.j
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return C1762i.b.o(this.f14594a, ((Integer) obj).intValue());
                }
            }).iterator();
        }

        public /* bridge */ boolean m(C1759f c1759f) {
            return super.contains(c1759f);
        }

        public C1759f n(int i4) {
            C1676g c1676gD = l.d(C1762i.this.d(), i4);
            if (c1676gD.f().intValue() < 0) {
                return null;
            }
            String strGroup = C1762i.this.d().group(i4);
            kotlin.jvm.internal.r.e(strGroup, "group(...)");
            return new C1759f(strGroup, c1676gD);
        }
    }

    public C1762i(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.r.f(matcher, "matcher");
        kotlin.jvm.internal.r.f(input, "input");
        this.f14588a = matcher;
        this.f14589b = input;
        this.f14590c = new b();
    }

    @Override // r3.InterfaceC1761h
    public InterfaceC1761h.b a() {
        return InterfaceC1761h.a.a(this);
    }

    @Override // r3.InterfaceC1761h
    public List b() {
        if (this.f14591d == null) {
            this.f14591d = new a();
        }
        List list = this.f14591d;
        kotlin.jvm.internal.r.c(list);
        return list;
    }

    public final MatchResult d() {
        return this.f14588a;
    }
}
