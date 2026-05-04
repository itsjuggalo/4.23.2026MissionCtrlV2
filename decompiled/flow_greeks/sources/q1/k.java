package q1;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18777a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f18778b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof r0.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends b {
        @Override // q1.k.b
        public boolean a(CharSequence charSequence) {
            return l.a(charSequence) || (charSequence instanceof r0.b);
        }
    }

    public k(Spannable spannable) {
        this.f18778b = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f18778b;
        if (!this.f18777a && c().a(spannable)) {
            this.f18778b = new SpannableString(spannable);
        }
        this.f18777a = true;
    }

    public Spannable b() {
        return this.f18778b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f18778b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f18778b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f18778b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f18778b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f18778b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f18778b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i10, int i11, Class cls) {
        return this.f18778b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f18778b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f18778b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f18778b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f18778b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f18778b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f18778b.toString();
    }

    public k(CharSequence charSequence) {
        this.f18778b = new SpannableString(charSequence);
    }
}
