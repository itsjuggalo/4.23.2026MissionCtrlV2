package W;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f3313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f3314b;

    public d(TextView textView) {
        this.f3313a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i6, Spanned spanned, int i7, int i8) {
        TextView textView = this.f3313a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = U.j.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i8 == 0 && i7 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i6 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i6);
                }
                return U.j.a().e(charSequence, 0, charSequence.length());
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        U.j jVarA = U.j.a();
        if (this.f3314b == null) {
            this.f3314b = new c(textView, this);
        }
        jVarA.f(this.f3314b);
        return charSequence;
    }
}
