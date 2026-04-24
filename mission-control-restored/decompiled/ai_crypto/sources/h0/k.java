package h0;

import O.m;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public class k implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14712a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f14713b;

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
            return charSequence instanceof m;
        }
    }

    public static class c extends b {
        @Override // h0.k.b
        public boolean a(CharSequence charSequence) {
            return l.a(charSequence) || (charSequence instanceof m);
        }
    }

    public k(Spannable spannable) {
        this.f14713b = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f14713b;
        if (!this.f14712a && c().a(spannable)) {
            this.f14713b = new SpannableString(spannable);
        }
        this.f14712a = true;
    }

    public Spannable b() {
        return this.f14713b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i7) {
        return this.f14713b.charAt(i7);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f14713b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f14713b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f14713b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f14713b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f14713b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i7, int i8, Class cls) {
        return this.f14713b.getSpans(i7, i8, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f14713b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i7, int i8, Class cls) {
        return this.f14713b.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f14713b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        a();
        this.f14713b.setSpan(obj, i7, i8, i9);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i7, int i8) {
        return this.f14713b.subSequence(i7, i8);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f14713b.toString();
    }

    public k(CharSequence charSequence) {
        this.f14713b = new SpannableString(charSequence);
    }
}
