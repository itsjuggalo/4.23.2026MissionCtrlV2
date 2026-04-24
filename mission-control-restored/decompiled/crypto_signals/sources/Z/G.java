package Z;

import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3708a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3709b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.i f3710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f3711d;

    public G(P p3) {
        this.f3711d = p3;
    }

    public final void a() {
        boolean zK = P.K(3);
        P p3 = this.f3711d;
        if (zK) {
            Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + p3);
        }
        C0259a c0259a = p3.f3742h;
        if (c0259a != null) {
            c0259a.f3812q = false;
            c0259a.d(false);
            p3.A(true);
            p3.E();
            Iterator it = p3.f3746m.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
        p3.f3742h = null;
    }
}
