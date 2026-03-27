package U;

import N1.A;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3099a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f3100b;

    public v(Spannable spannable) {
        this.f3100b = spannable;
    }

    public final void a() {
        Spannable spannable = this.f3100b;
        if (!this.f3099a) {
            if ((Build.VERSION.SDK_INT < 28 ? new A(15) : new u(15)).i(spannable)) {
                this.f3100b = new SpannableString(spannable);
            }
        }
        this.f3099a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f3100b.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f3100b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f3100b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f3100b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f3100b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f3100b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i6, Class cls) {
        return this.f3100b.getSpans(i, i6, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3100b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i6, Class cls) {
        return this.f3100b.nextSpanTransition(i, i6, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f3100b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i6, int i7) {
        a();
        this.f3100b.setSpan(obj, i, i6, i7);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i6) {
        return this.f3100b.subSequence(i, i6);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f3100b.toString();
    }

    public v(CharSequence charSequence) {
        this.f3100b = new SpannableString(charSequence);
    }
}
