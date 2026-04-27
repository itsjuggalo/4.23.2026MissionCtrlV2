package m;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: m.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0849w0 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f8438a;

    public C0849w0(SearchView searchView) {
        this.f8438a = searchView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j4) {
        this.f8438a.l(i);
    }
}
