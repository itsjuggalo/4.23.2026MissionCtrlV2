package W;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import m.AbstractC0829m;

/* JADX INFO: loaded from: classes.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0829m f3322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f3323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3324c = true;

    public i(AbstractC0829m abstractC0829m) {
        this.f3322a = abstractC0829m;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            U.j jVarA = U.j.a();
            if (editableText == null) {
                length = 0;
            } else {
                jVarA.getClass();
                length = editableText.length();
            }
            jVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i7) {
        AbstractC0829m abstractC0829m = this.f3322a;
        if (abstractC0829m.isInEditMode() || !this.f3324c || U.j.f3060j == null || i6 > i7 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = U.j.a().b();
        if (iB != 0) {
            if (iB == 1) {
                U.j.a().e((Spannable) charSequence, i, i7 + i);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        U.j jVarA = U.j.a();
        if (this.f3323b == null) {
            this.f3323b = new h(abstractC0829m);
        }
        jVarA.f(this.f3323b);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i7) {
    }
}
