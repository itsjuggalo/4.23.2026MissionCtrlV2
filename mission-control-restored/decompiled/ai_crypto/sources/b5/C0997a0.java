package b5;

import b5.AbstractC1001c0;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: renamed from: b5.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0997a0 implements AbstractC1001c0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f8645a = new HashMap();

    public static /* synthetic */ void n(AbstractC1001c0.F f7, Task task) {
        if (!task.isSuccessful()) {
            f7.b(AbstractC1046w.e(task.getException()));
            return;
        }
        Z2.Z z7 = (Z2.Z) task.getResult();
        f8645a.put(z7.i(), z7);
        f7.a(new AbstractC1001c0.z.a().b(Long.valueOf(z7.g())).c(Long.valueOf(z7.b())).f(z7.i()).e(z7.a()).d(Long.valueOf(z7.f())).a());
    }

    @Override // b5.AbstractC1001c0.j
    public void b(String str, String str2, AbstractC1001c0.F f7) {
        Z2.W wB = Z2.X.b((Z2.Z) f8645a.get(str), str2);
        String string = UUID.randomUUID().toString();
        Y.f8636d.put(string, wB);
        f7.a(string);
    }

    @Override // b5.AbstractC1001c0.j
    public void j(String str, final AbstractC1001c0.F f7) {
        Z2.X.a((Z2.L) Y.f8634b.get(str)).addOnCompleteListener(new OnCompleteListener() { // from class: b5.Z
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                C0997a0.n(f7, task);
            }
        });
    }

    @Override // b5.AbstractC1001c0.j
    public void k(String str, String str2, AbstractC1001c0.F f7) {
        Z2.W wC = Z2.X.c(str, str2);
        String string = UUID.randomUUID().toString();
        Y.f8636d.put(string, wC);
        f7.a(string);
    }
}
