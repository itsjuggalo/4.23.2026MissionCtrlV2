package R1;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.common.internal.C1211w;
import com.google.android.gms.common.internal.C1214z;
import com.google.android.gms.common.internal.InterfaceC1213y;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.google.android.gms.common.api.e implements InterfaceC1213y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f4675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.AbstractC0178a f4676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f4677c;

    static {
        a.g gVar = new a.g();
        f4675a = gVar;
        c cVar = new c();
        f4676b = cVar;
        f4677c = new com.google.android.gms.common.api.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, C1214z c1214z) {
        super(context, f4677c, c1214z, e.a.f10853c);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1213y
    public final Task a(final C1211w c1211w) {
        AbstractC1186x.a aVarA = AbstractC1186x.a();
        aVarA.d(zaf.zaa);
        aVarA.c(false);
        aVarA.b(new InterfaceC1181s() { // from class: R1.b
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                a.g gVar = d.f4675a;
                ((a) ((e) obj).getService()).b(c1211w);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(aVarA.a());
    }
}
