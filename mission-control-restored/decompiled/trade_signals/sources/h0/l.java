package h0;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public class l implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18332a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f18333b;

    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            return false;
        }
    }

    public static class c extends b {
        @Override // h0.l.b
        public boolean a(CharSequence charSequence) {
            return m.a(charSequence);
        }
    }

    public l(Spannable spannable) {
        this.f18333b = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f18333b;
        if (!this.f18332a && c().a(spannable)) {
            this.f18333b = new SpannableString(spannable);
        }
        this.f18332a = true;
    }

    public Spannable b() {
        return this.f18333b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i8) {
        return this.f18333b.charAt(i8);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f18333b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f18333b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f18333b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f18333b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f18333b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i8, int i9, Class cls) {
        return this.f18333b.getSpans(i8, i9, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f18333b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i8, int i9, Class cls) {
        return this.f18333b.nextSpanTransition(i8, i9, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f18333b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i8, int i9, int i10) {
        a();
        this.f18333b.setSpan(obj, i8, i9, i10);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i8, int i9) {
        return this.f18333b.subSequence(i8, i9);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f18333b.toString();
    }

    public l(CharSequence charSequence) {
        this.f18333b = new SpannableString(charSequence);
    }
}
