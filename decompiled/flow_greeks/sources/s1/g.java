package s1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import com.google.android.gms.common.api.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f19950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.f f19952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19953d = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19954e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19955f = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends c.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f19956a;

        public a(EditText editText) {
            this.f19956a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            super.b();
            g.b((EditText) this.f19956a.get(), 1);
        }
    }

    public g(EditText editText, boolean z10) {
        this.f19950a = editText;
        this.f19951b = z10;
    }

    public static void b(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final c.f a() {
        if (this.f19952c == null) {
            this.f19952c = new a(this.f19950a);
        }
        return this.f19952c;
    }

    public void c(boolean z10) {
        if (this.f19955f != z10) {
            if (this.f19952c != null) {
                androidx.emoji2.text.c.c().u(this.f19952c);
            }
            this.f19955f = z10;
            if (z10) {
                b(this.f19950a, androidx.emoji2.text.c.c().e());
            }
        }
    }

    public final boolean d() {
        if (this.f19955f) {
            return (this.f19951b || androidx.emoji2.text.c.i()) ? false : true;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f19950a.isInEditMode() || d() || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = androidx.emoji2.text.c.c().e();
        if (iE != 0) {
            if (iE == 1) {
                androidx.emoji2.text.c.c().s((Spannable) charSequence, i10, i10 + i12, this.f19953d, this.f19954e);
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
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
