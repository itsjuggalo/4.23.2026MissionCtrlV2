package L;

import android.database.DataSetObserver;
import m.AbstractC0816f0;
import m.D0;

/* JADX INFO: loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1021b;

    public /* synthetic */ b(Object obj, int i) {
        this.f1020a = i;
        this.f1021b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f1020a) {
            case 0:
                D0 d02 = (D0) this.f1021b;
                d02.f1022a = true;
                d02.notifyDataSetChanged();
                break;
            default:
                AbstractC0816f0 abstractC0816f0 = (AbstractC0816f0) this.f1021b;
                if (abstractC0816f0.f8366z.isShowing()) {
                    abstractC0816f0.b();
                }
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f1020a) {
            case 0:
                D0 d02 = (D0) this.f1021b;
                d02.f1022a = false;
                d02.notifyDataSetInvalidated();
                break;
            default:
                ((AbstractC0816f0) this.f1021b).dismiss();
                break;
        }
    }
}
