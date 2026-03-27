package M1;

import N1.C0484u;
import android.app.Activity;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.C0896b;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.internal.fido.zzo;
import com.google.android.gms.internal.fido.zzp;
import com.google.android.gms.internal.fido.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f1602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f1603b;

    static {
        a.g gVar = new a.g();
        f1602a = gVar;
        f1603b = new com.google.android.gms.common.api.a("Fido.FIDO2_API", new zzo(), gVar);
    }

    public a(Activity activity) {
        super(activity, f1603b, a.d.f9667K, new C0896b());
    }

    public Task d(final C0484u c0484u) {
        return doRead(AbstractC0920y.a().b(new InterfaceC0915t() { // from class: M1.b
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                a aVar = this.f1604a;
                C0484u c0484u2 = c0484u;
                ((zzs) ((zzp) obj).getService()).zzc(new c(aVar, (TaskCompletionSource) obj2), c0484u2);
            }
        }).e(5407).a());
    }
}
