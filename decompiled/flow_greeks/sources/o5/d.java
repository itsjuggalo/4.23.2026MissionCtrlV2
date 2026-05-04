package o5;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f17520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.AbstractC0094a f17521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f17522c;

    static {
        a.g gVar = new a.g();
        f17520a = gVar;
        b bVar = new b();
        f17521b = bVar;
        f17522c = new com.google.android.gms.common.api.a("ClientTelemetry.API", bVar, gVar);
    }

    public d(Context context, z zVar) {
        super(context, f17522c, zVar, f.a.f5486c);
    }

    @Override // com.google.android.gms.common.internal.y
    public final Task c(final w wVar) {
        v.a aVarA = v.a();
        aVarA.d(zad.zaa);
        aVarA.c(false);
        aVarA.b(new q() { // from class: o5.c
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                a.g gVar = d.f17520a;
                ((a) ((e) obj).getService()).H(wVar);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(aVarA.a());
    }
}
