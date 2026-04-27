package O;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class m implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f3985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f3986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f3989e;

        /* JADX INFO: renamed from: O.m$a$a, reason: collision with other inner class name */
        public static class C0061a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextPaint f3990a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f3992c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f3993d = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f3991b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0061a(TextPaint textPaint) {
                this.f3990a = textPaint;
            }

            public a a() {
                return new a(this.f3990a, this.f3991b, this.f3992c, this.f3993d);
            }

            public C0061a b(int i7) {
                this.f3992c = i7;
                return this;
            }

            public C0061a c(int i7) {
                this.f3993d = i7;
                return this;
            }

            public C0061a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f3991b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i7, int i8) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3989e = l.a(textPaint).setBreakStrategy(i7).setHyphenationFrequency(i8).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f3989e = null;
            }
            this.f3985a = textPaint;
            this.f3986b = textDirectionHeuristic;
            this.f3987c = i7;
            this.f3988d = i8;
        }

        public boolean a(a aVar) {
            if (this.f3987c == aVar.b() && this.f3988d == aVar.c() && this.f3985a.getTextSize() == aVar.e().getTextSize() && this.f3985a.getTextScaleX() == aVar.e().getTextScaleX() && this.f3985a.getTextSkewX() == aVar.e().getTextSkewX() && this.f3985a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f3985a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f3985a.getFlags() == aVar.e().getFlags() && this.f3985a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f3985a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f3985a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f3987c;
        }

        public int c() {
            return this.f3988d;
        }

        public TextDirectionHeuristic d() {
            return this.f3986b;
        }

        public TextPaint e() {
            return this.f3985a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f3986b == aVar.d();
        }

        public int hashCode() {
            return P.b.b(Float.valueOf(this.f3985a.getTextSize()), Float.valueOf(this.f3985a.getTextScaleX()), Float.valueOf(this.f3985a.getTextSkewX()), Float.valueOf(this.f3985a.getLetterSpacing()), Integer.valueOf(this.f3985a.getFlags()), this.f3985a.getTextLocales(), this.f3985a.getTypeface(), Boolean.valueOf(this.f3985a.isElegantTextHeight()), this.f3986b, Integer.valueOf(this.f3987c), Integer.valueOf(this.f3988d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f3985a.getTextSize());
            sb.append(", textScaleX=" + this.f3985a.getTextScaleX());
            sb.append(", textSkewX=" + this.f3985a.getTextSkewX());
            int i7 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f3985a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f3985a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f3985a.getTextLocales());
            sb.append(", typeface=" + this.f3985a.getTypeface());
            if (i7 >= 26) {
                sb.append(", variationSettings=" + this.f3985a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f3986b);
            sb.append(", breakStrategy=" + this.f3987c);
            sb.append(", hyphenationFrequency=" + this.f3988d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f3985a = params.getTextPaint();
            this.f3986b = params.getTextDirection();
            this.f3987c = params.getBreakStrategy();
            this.f3988d = params.getHyphenationFrequency();
            this.f3989e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
