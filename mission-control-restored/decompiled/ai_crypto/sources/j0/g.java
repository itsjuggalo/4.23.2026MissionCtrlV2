package j0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import com.google.android.gms.common.api.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f17358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.e f17360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17361d = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17362e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17363f = true;

    public static class a extends c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f17364a;

        public a(EditText editText) {
            this.f17364a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            super.b();
            g.b((EditText) this.f17364a.get(), 1);
        }
    }

    public g(EditText editText, boolean z7) {
        this.f17358a = editText;
        this.f17359b = z7;
    }

    public static void b(EditText editText, int i7) {
        if (i7 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final c.e a() {
        if (this.f17360c == null) {
            this.f17360c = new a(this.f17358a);
        }
        return this.f17360c;
    }

    public void c(boolean z7) {
        if (this.f17363f != z7) {
            if (this.f17360c != null) {
                androidx.emoji2.text.c.b().t(this.f17360c);
            }
            this.f17363f = z7;
            if (z7) {
                b(this.f17358a, androidx.emoji2.text.c.b().d());
            }
        }
    }

    public final boolean d() {
        return (this.f17363f && (this.f17359b || androidx.emoji2.text.c.h())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        if (this.f17358a.isInEditMode() || d() || i8 > i9 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            if (iD == 1) {
                androidx.emoji2.text.c.b().r((Spannable) charSequence, i7, i7 + i9, this.f17361d, this.f17362e);
                return;
            } else if (iD != 3) {
                return;
            }
        }
        androidx.emoji2.text.c.b().s(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
    }
}
