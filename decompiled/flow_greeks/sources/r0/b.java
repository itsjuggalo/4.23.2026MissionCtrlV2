package r0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Spannable {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f19207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f19208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f19211e;

        /* JADX INFO: renamed from: r0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0333a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextPaint f19212a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f19214c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f19215d = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f19213b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0333a(TextPaint textPaint) {
                this.f19212a = textPaint;
            }

            public a a() {
                return new a(this.f19212a, this.f19213b, this.f19214c, this.f19215d);
            }

            public C0333a b(int i10) {
                this.f19214c = i10;
                return this;
            }

            public C0333a c(int i10) {
                this.f19215d = i10;
                return this;
            }

            public C0333a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f19213b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f19211e = r0.a.a(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f19211e = null;
            }
            this.f19207a = textPaint;
            this.f19208b = textDirectionHeuristic;
            this.f19209c = i10;
            this.f19210d = i11;
        }

        public boolean a(a aVar) {
            if (this.f19209c == aVar.b() && this.f19210d == aVar.c() && this.f19207a.getTextSize() == aVar.e().getTextSize() && this.f19207a.getTextScaleX() == aVar.e().getTextScaleX() && this.f19207a.getTextSkewX() == aVar.e().getTextSkewX() && this.f19207a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f19207a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f19207a.getFlags() == aVar.e().getFlags() && this.f19207a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f19207a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f19207a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f19209c;
        }

        public int c() {
            return this.f19210d;
        }

        public TextDirectionHeuristic d() {
            return this.f19208b;
        }

        public TextPaint e() {
            return this.f19207a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f19208b == aVar.d();
        }

        public int hashCode() {
            return s0.b.b(Float.valueOf(this.f19207a.getTextSize()), Float.valueOf(this.f19207a.getTextScaleX()), Float.valueOf(this.f19207a.getTextSkewX()), Float.valueOf(this.f19207a.getLetterSpacing()), Integer.valueOf(this.f19207a.getFlags()), this.f19207a.getTextLocales(), this.f19207a.getTypeface(), Boolean.valueOf(this.f19207a.isElegantTextHeight()), this.f19208b, Integer.valueOf(this.f19209c), Integer.valueOf(this.f19210d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f19207a.getTextSize());
            sb2.append(", textScaleX=" + this.f19207a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f19207a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f19207a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f19207a.isElegantTextHeight());
            sb2.append(", textLocale=" + this.f19207a.getTextLocales());
            sb2.append(", typeface=" + this.f19207a.getTypeface());
            if (i10 >= 26) {
                sb2.append(", variationSettings=" + this.f19207a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f19208b);
            sb2.append(", breakStrategy=" + this.f19209c);
            sb2.append(", hyphenationFrequency=" + this.f19210d);
            sb2.append("}");
            return sb2.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f19207a = params.getTextPaint();
            this.f19208b = params.getTextDirection();
            this.f19209c = params.getBreakStrategy();
            this.f19210d = params.getHyphenationFrequency();
            this.f19211e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
