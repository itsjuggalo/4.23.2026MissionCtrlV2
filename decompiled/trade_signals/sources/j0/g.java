package j0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f19936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.f f19938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19939d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19940e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19941f = true;

    public static class a extends c.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f19942a;

        public a(EditText editText) {
            this.f19942a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            super.b();
            g.b((EditText) this.f19942a.get(), 1);
        }
    }

    public g(EditText editText, boolean z7) {
        this.f19936a = editText;
        this.f19937b = z7;
    }

    public static void b(EditText editText, int i8) {
        if (i8 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final c.f a() {
        if (this.f19938c == null) {
            this.f19938c = new a(this.f19936a);
        }
        return this.f19938c;
    }

    public void c(boolean z7) {
        if (this.f19941f != z7) {
            if (this.f19938c != null) {
                androidx.emoji2.text.c.c().u(this.f19938c);
            }
            this.f19941f = z7;
            if (z7) {
                b(this.f19936a, androidx.emoji2.text.c.c().e());
            }
        }
    }

    public final boolean d() {
        return (this.f19941f && (this.f19937b || androidx.emoji2.text.c.i())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        if (this.f19936a.isInEditMode() || d() || i9 > i10 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = androidx.emoji2.text.c.c().e();
        if (iE != 0) {
            if (iE == 1) {
                androidx.emoji2.text.c.c().s((Spannable) charSequence, i8, i8 + i10, this.f19939d, this.f19940e);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        androidx.emoji2.text.c.c().t(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }
}
