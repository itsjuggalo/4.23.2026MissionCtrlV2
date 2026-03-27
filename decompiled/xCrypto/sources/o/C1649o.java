package o;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: renamed from: o.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1649o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f13859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextClassifier f13860b;

    public C1649o(TextView textView) {
        this.f13859a = (TextView) G.e.b(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f13860b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManagerA = AbstractC1646l.a(this.f13859a.getContext().getSystemService(AbstractC1645k.a()));
        return textClassificationManagerA != null ? textClassificationManagerA.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f13860b = textClassifier;
    }
}
