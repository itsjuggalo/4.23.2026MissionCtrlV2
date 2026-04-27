package j0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f19925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.f f19926b;

    public static class a extends c.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f19927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reference f19928b;

        public a(TextView textView, d dVar) {
            this.f19927a = new WeakReference(textView);
            this.f19928b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            CharSequence text;
            CharSequence charSequenceP;
            super.b();
            TextView textView = (TextView) this.f19927a.get();
            if (c(textView, (InputFilter) this.f19928b.get()) && textView.isAttachedToWindow() && text != (charSequenceP = androidx.emoji2.text.c.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceP);
                int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                textView.setText(charSequenceP);
                if (charSequenceP instanceof Spannable) {
                    d.b((Spannable) charSequenceP, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(TextView textView) {
        this.f19925a = textView;
    }

    public static void b(Spannable spannable, int i8, int i9) {
        if (i8 >= 0 && i9 >= 0) {
            Selection.setSelection(spannable, i8, i9);
        } else if (i8 >= 0) {
            Selection.setSelection(spannable, i8);
        } else if (i9 >= 0) {
            Selection.setSelection(spannable, i9);
        }
    }

    public final c.f a() {
        if (this.f19926b == null) {
            this.f19926b = new a(this.f19925a, this);
        }
        return this.f19926b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i8, int i9, Spanned spanned, int i10, int i11) {
        if (this.f19925a.isInEditMode()) {
            return charSequence;
        }
        int iE = androidx.emoji2.text.c.c().e();
        if (iE != 0) {
            if (iE == 1) {
                if ((i11 == 0 && i10 == 0 && spanned.length() == 0 && charSequence == this.f19925a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i8 != 0 || i9 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i8, i9);
                }
                return androidx.emoji2.text.c.c().q(charSequence, 0, charSequence.length());
            }
            if (iE != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.c.c().t(a());
        return charSequence;
    }
}
