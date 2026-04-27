package o;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: renamed from: o.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2444m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f21850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextClassifier f21851b;

    /* JADX INFO: renamed from: o.m$a */
    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public C2444m(TextView textView) {
        this.f21850a = (TextView) S.g.d(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f21851b;
        return textClassifier == null ? a.a(this.f21850a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f21851b = textClassifier;
    }
}
