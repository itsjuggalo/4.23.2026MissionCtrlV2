package m;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8334b;

    public /* synthetic */ Z(Object obj, int i) {
        this.f8333a = i;
        this.f8334b = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j4) {
        C0826k0 c0826k0;
        switch (this.f8333a) {
            case 0:
                if (i != -1 && (c0826k0 = ((AbstractC0816f0) this.f8334b).f8349c) != null) {
                    c0826k0.setListSelectionHidden(false);
                    break;
                }
                break;
            default:
                ((SearchView) this.f8334b).m(i);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.f8333a;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
