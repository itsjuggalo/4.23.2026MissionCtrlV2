package p;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f21399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextClassifier f21400b;

    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public r(TextView textView) {
        this.f21399a = (TextView) P.f.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f21400b;
        return textClassifier == null ? a.a(this.f21399a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f21400b = textClassifier;
    }
}
