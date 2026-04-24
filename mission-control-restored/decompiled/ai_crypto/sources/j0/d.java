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
    public final TextView f17347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e f17348b;

    public static class a extends c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f17349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reference f17350b;

        public a(TextView textView, d dVar) {
            this.f17349a = new WeakReference(textView);
            this.f17350b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            CharSequence text;
            CharSequence charSequenceO;
            super.b();
            TextView textView = (TextView) this.f17349a.get();
            if (c(textView, (InputFilter) this.f17350b.get()) && textView.isAttachedToWindow() && text != (charSequenceO = androidx.emoji2.text.c.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceO);
                int selectionEnd = Selection.getSelectionEnd(charSequenceO);
                textView.setText(charSequenceO);
                if (charSequenceO instanceof Spannable) {
                    d.b((Spannable) charSequenceO, selectionStart, selectionEnd);
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
        this.f17347a = textView;
    }

    public static void b(Spannable spannable, int i7, int i8) {
        if (i7 >= 0 && i8 >= 0) {
            Selection.setSelection(spannable, i7, i8);
        } else if (i7 >= 0) {
            Selection.setSelection(spannable, i7);
        } else if (i8 >= 0) {
            Selection.setSelection(spannable, i8);
        }
    }

    public final c.e a() {
        if (this.f17348b == null) {
            this.f17348b = new a(this.f17347a, this);
        }
        return this.f17348b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        if (this.f17347a.isInEditMode()) {
            return charSequence;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            if (iD == 1) {
                if ((i10 == 0 && i9 == 0 && spanned.length() == 0 && charSequence == this.f17347a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i7 != 0 || i8 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i7, i8);
                }
                return androidx.emoji2.text.c.b().p(charSequence, 0, charSequence.length());
            }
            if (iD != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.c.b().s(a());
        return charSequence;
    }
}
