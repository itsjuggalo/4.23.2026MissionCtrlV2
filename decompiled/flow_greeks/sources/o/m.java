package o;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f17295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextClassifier f17296b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public m(TextView textView) {
        this.f17295a = (TextView) s0.f.d(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f17296b;
        return textClassifier == null ? a.a(this.f17295a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f17296b = textClassifier;
    }
}
