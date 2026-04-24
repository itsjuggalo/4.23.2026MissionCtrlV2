package y2;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25611n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f25612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f25613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25614c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25616e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f25623l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25615d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Layout.Alignment f25617f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25618g = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f25619h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f25620i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25621j = f25611n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25622k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextUtils.TruncateAt f25624m = null;

    public static class a extends Exception {
    }

    public g(CharSequence charSequence, TextPaint textPaint, int i7) {
        this.f25612a = charSequence;
        this.f25613b = textPaint;
        this.f25614c = i7;
        this.f25616e = charSequence.length();
    }

    public static g b(CharSequence charSequence, TextPaint textPaint, int i7) {
        return new g(charSequence, textPaint, i7);
    }

    public StaticLayout a() {
        if (this.f25612a == null) {
            this.f25612a = "";
        }
        int iMax = Math.max(0, this.f25614c);
        CharSequence charSequenceEllipsize = this.f25612a;
        if (this.f25618g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f25613b, iMax, this.f25624m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f25616e);
        this.f25616e = iMin;
        if (this.f25623l && this.f25618g == 1) {
            this.f25617f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f25615d, iMin, this.f25613b, iMax);
        builderObtain.setAlignment(this.f25617f);
        builderObtain.setIncludePad(this.f25622k);
        builderObtain.setTextDirection(this.f25623l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f25624m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f25618g);
        float f7 = this.f25619h;
        if (f7 != 0.0f || this.f25620i != 1.0f) {
            builderObtain.setLineSpacing(f7, this.f25620i);
        }
        if (this.f25618g > 1) {
            builderObtain.setHyphenationFrequency(this.f25621j);
        }
        return builderObtain.build();
    }

    public g c(Layout.Alignment alignment) {
        this.f25617f = alignment;
        return this;
    }

    public g d(TextUtils.TruncateAt truncateAt) {
        this.f25624m = truncateAt;
        return this;
    }

    public g e(int i7) {
        this.f25621j = i7;
        return this;
    }

    public g f(boolean z7) {
        this.f25622k = z7;
        return this;
    }

    public g g(boolean z7) {
        this.f25623l = z7;
        return this;
    }

    public g h(float f7, float f8) {
        this.f25619h = f7;
        this.f25620i = f8;
        return this;
    }

    public g i(int i7) {
        this.f25618g = i7;
        return this;
    }

    public g j(h hVar) {
        return this;
    }
}
