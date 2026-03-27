package m;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {
    public abstract void a(StaticLayout.Builder builder, TextView textView);

    public boolean b(TextView textView) {
        return ((Boolean) I.e("getHorizontallyScrolling", textView, Boolean.FALSE)).booleanValue();
    }
}
