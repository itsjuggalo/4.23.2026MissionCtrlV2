package U5;

import B6.k;
import R5.InterfaceC0858o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: U5.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0966x extends AbstractC0956m implements R5.V {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f8414h = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C0966x.class, "fragments", "getFragments()Ljava/util/List;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C0966x.class, "empty", "getEmpty()Z", 0))};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F f8415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.c f8416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.i f8417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final H6.i f8418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final B6.k f8419g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0966x(F module, q6.c fqName, H6.n storageManager) {
        super(S5.h.f7663J.b(), fqName.g());
        AbstractC2304t.f(module, "module");
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(storageManager, "storageManager");
        this.f8415c = module;
        this.f8416d = fqName;
        this.f8417e = storageManager.e(new C0963u(this));
        this.f8418f = storageManager.e(new C0964v(this));
        this.f8419g = new B6.i(storageManager, new C0965w(this));
    }

    public static final boolean M0(C0966x c0966x) {
        return R5.T.b(c0966x.x0().N0(), c0966x.e());
    }

    public static final List N0(C0966x c0966x) {
        return R5.T.c(c0966x.x0().N0(), c0966x.e());
    }

    public static final B6.k R0(C0966x c0966x) {
        if (c0966x.isEmpty()) {
            return k.b.f219b;
        }
        List listJ = c0966x.J();
        ArrayList arrayList = new ArrayList(p5.r.s(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(((R5.N) it.next()).r());
        }
        List listS0 = p5.z.s0(arrayList, new P(c0966x.x0(), c0966x.e()));
        return B6.b.f172d.a("package view scope for " + c0966x.e() + " in " + c0966x.x0().getName(), listS0);
    }

    @Override // R5.V
    public List J() {
        return (List) H6.m.a(this.f8417e, this, f8414h[0]);
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o visitor, Object obj) {
        AbstractC2304t.f(visitor, "visitor");
        return visitor.b(this, obj);
    }

    @Override // R5.InterfaceC0856m
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public R5.V b() {
        if (e().c()) {
            return null;
        }
        return x0().u0(e().d());
    }

    public final boolean P0() {
        return ((Boolean) H6.m.a(this.f8418f, this, f8414h[1])).booleanValue();
    }

    @Override // R5.V
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public F x0() {
        return this.f8415c;
    }

    @Override // R5.V
    public q6.c e() {
        return this.f8416d;
    }

    public boolean equals(Object obj) {
        R5.V v8 = obj instanceof R5.V ? (R5.V) obj : null;
        return v8 != null && AbstractC2304t.b(e(), v8.e()) && AbstractC2304t.b(x0(), v8.x0());
    }

    public int hashCode() {
        return (x0().hashCode() * 31) + e().hashCode();
    }

    @Override // R5.V
    public boolean isEmpty() {
        return P0();
    }

    @Override // R5.V
    public B6.k r() {
        return this.f8419g;
    }
}
