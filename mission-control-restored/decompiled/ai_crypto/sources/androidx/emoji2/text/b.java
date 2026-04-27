package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.c;

/* JADX INFO: loaded from: classes.dex */
public class b implements c.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f7645b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f7646a;

    public b() {
        TextPaint textPaint = new TextPaint();
        this.f7646a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal threadLocal = f7645b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.c.d
    public boolean a(CharSequence charSequence, int i7, int i8, int i9) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i7 < i8) {
            sbB.append(charSequence.charAt(i7));
            i7++;
        }
        return I.c.a(this.f7646a, sbB.toString());
    }
}
