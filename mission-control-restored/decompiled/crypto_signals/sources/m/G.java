package m;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class G extends F {
    @Override // m.F, m.H
    public void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override // m.H
    public boolean b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
