package m;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: m.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0847v0 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f8437a;

    public C0847v0(SearchView searchView) {
        this.f8437a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f8437a.o();
        return true;
    }
}
