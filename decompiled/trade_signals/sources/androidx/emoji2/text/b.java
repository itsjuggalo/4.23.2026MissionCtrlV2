package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.c;

/* JADX INFO: loaded from: classes.dex */
public class b implements c.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f11457b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f11458a;

    public b() {
        TextPaint textPaint = new TextPaint();
        this.f11458a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal threadLocal = f11457b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.c.e
    public boolean a(CharSequence charSequence, int i8, int i9, int i10) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i8 < i9) {
            sbB.append(charSequence.charAt(i8));
            i8++;
        }
        return L.c.a(this.f11458a, sbB.toString());
    }
}
