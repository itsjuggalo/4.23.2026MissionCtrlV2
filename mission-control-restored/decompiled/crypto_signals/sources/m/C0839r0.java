package m;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: m.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0839r0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f8429a;

    public C0839r0(SearchView searchView) {
        this.f8429a = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i7) {
        SearchView searchView = this.f8429a;
        Editable text = searchView.f4324t.getText();
        searchView.f4316c0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        searchView.t(!zIsEmpty);
        int i8 = 8;
        if (searchView.f4315b0 && !searchView.f4308R && zIsEmpty) {
            searchView.y.setVisibility(8);
            i8 = 0;
        }
        searchView.f4293A.setVisibility(i8);
        searchView.p();
        searchView.s();
        charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i7) {
    }
}
