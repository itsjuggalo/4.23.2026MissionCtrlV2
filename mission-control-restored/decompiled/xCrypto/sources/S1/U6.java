package S1;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class U6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f4259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ W6 f4260d;

    public U6(W6 w6, String str, String str2, Bundle bundle) {
        this.f4257a = str;
        this.f4258b = str2;
        this.f4259c = bundle;
        Objects.requireNonNull(w6);
        this.f4260d = w6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b7 b7Var = this.f4260d.f4276a;
        l7 l7VarN0 = b7Var.N0();
        long jCurrentTimeMillis = b7Var.f().currentTimeMillis();
        String str = this.f4257a;
        b7Var.i((J) AbstractC0940s.k(l7VarN0.R(str, this.f4258b, this.f4259c, "auto", jCurrentTimeMillis, false, true)), str);
    }
}
