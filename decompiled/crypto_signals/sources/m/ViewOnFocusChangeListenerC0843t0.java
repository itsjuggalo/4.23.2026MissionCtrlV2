package m;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: m.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC0843t0 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f8435a;

    public ViewOnFocusChangeListenerC0843t0(SearchView searchView) {
        this.f8435a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z6) {
        SearchView searchView = this.f8435a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.f4306O;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z6);
        }
    }
}
