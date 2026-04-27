package S1;

import android.app.Activity;
import androidx.fragment.app.AbstractActivityC1143u;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: renamed from: S1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0874f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7424a;

    public C0874f(Activity activity) {
        AbstractC1294n.k(activity, "Activity must not be null");
        this.f7424a = activity;
    }

    public final Activity a() {
        return (Activity) this.f7424a;
    }

    public final AbstractActivityC1143u b() {
        return (AbstractActivityC1143u) this.f7424a;
    }

    public final boolean c() {
        return this.f7424a instanceof Activity;
    }

    public final boolean d() {
        return this.f7424a instanceof AbstractActivityC1143u;
    }
}
