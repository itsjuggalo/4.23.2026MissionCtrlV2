package U1;

import R1.a;
import R1.e;
import S1.AbstractC0882n;
import S1.InterfaceC0880l;
import android.content.Context;
import com.google.android.gms.common.internal.C1300u;
import com.google.android.gms.common.internal.InterfaceC1299t;
import com.google.android.gms.common.internal.r;
import l2.AbstractC2328l;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public final class d extends R1.e implements InterfaceC1299t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a.g f8088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a.AbstractC0099a f8089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final R1.a f8090m;

    static {
        a.g gVar = new a.g();
        f8088k = gVar;
        c cVar = new c();
        f8089l = cVar;
        f8090m = new R1.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, C1300u c1300u) {
        super(context, f8090m, c1300u, e.a.f7106c);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1299t
    public final AbstractC2328l a(final r rVar) {
        AbstractC0882n.a aVarA = AbstractC0882n.a();
        aVarA.d(c2.d.f13342a);
        aVarA.c(false);
        aVarA.b(new InterfaceC0880l() { // from class: U1.b
            @Override // S1.InterfaceC0880l
            public final void a(Object obj, Object obj2) {
                a.g gVar = d.f8088k;
                ((a) ((e) obj).getService()).G(rVar);
                ((C2329m) obj2).c(null);
            }
        });
        return c(aVarA.a());
    }
}
