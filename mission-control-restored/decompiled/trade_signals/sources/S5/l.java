package S5;

import I6.AbstractC0613d0;
import I6.S;
import R5.h0;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O5.i f7668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.c f7669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f7672e;

    public l(O5.i builtIns, q6.c fqName, Map allValueArguments, boolean z7) {
        AbstractC2304t.f(builtIns, "builtIns");
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(allValueArguments, "allValueArguments");
        this.f7668a = builtIns;
        this.f7669b = fqName;
        this.f7670c = allValueArguments;
        this.f7671d = z7;
        this.f7672e = AbstractC2484l.b(EnumC2486n.f21975b, new k(this));
    }

    public static final AbstractC0613d0 c(l lVar) {
        return lVar.f7668a.p(lVar.e()).t();
    }

    @Override // S5.c
    public Map a() {
        return this.f7670c;
    }

    @Override // S5.c
    public q6.c e() {
        return this.f7669b;
    }

    @Override // S5.c
    public S getType() {
        Object value = this.f7672e.getValue();
        AbstractC2304t.e(value, "getValue(...)");
        return (S) value;
    }

    @Override // S5.c
    public h0 j() {
        h0 NO_SOURCE = h0.f7249a;
        AbstractC2304t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    public /* synthetic */ l(O5.i iVar, q6.c cVar, Map map, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this(iVar, cVar, map, (i8 & 8) != 0 ? false : z7);
    }
}
