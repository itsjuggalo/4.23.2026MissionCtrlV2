package B1;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.C0944w;
import com.google.android.gms.common.internal.C0947z;
import com.google.android.gms.common.internal.InterfaceC0946y;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.google.android.gms.common.api.e implements InterfaceC0946y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.AbstractC0145a f111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f112c;

    static {
        a.g gVar = new a.g();
        f110a = gVar;
        c cVar = new c();
        f111b = cVar;
        f112c = new com.google.android.gms.common.api.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, C0947z c0947z) {
        super(context, f112c, c0947z, e.a.f9668c);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0946y
    public final Task a(final C0944w c0944w) {
        AbstractC0920y.a aVarA = AbstractC0920y.a();
        aVarA.d(zaf.zaa);
        aVarA.c(false);
        aVarA.b(new InterfaceC0915t() { // from class: B1.b
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                a.g gVar = d.f110a;
                ((a) ((e) obj).getService()).b(c0944w);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(aVarA.a());
    }
}
