package S1;

import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class S6 extends A {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b7 f4240e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S6(b7 b7Var, V3 v32) {
        super(v32);
        Objects.requireNonNull(b7Var);
        this.f4240e = b7Var;
    }

    @Override // S1.A
    public final void a() {
        b7 b7Var = this.f4240e;
        b7Var.b().h();
        String str = (String) b7Var.x0().pollFirst();
        if (str != null) {
            b7Var.y0(b7Var.f().a());
            b7Var.a().w().b("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            b7.V(b7Var.e(), intent);
        }
        b7Var.u0();
    }
}
