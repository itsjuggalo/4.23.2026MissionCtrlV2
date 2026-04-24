package m;

import android.graphics.Typeface;
import android.widget.TextView;

/* JADX INFO: renamed from: m.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0842t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f8432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f8433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8434c;

    public RunnableC0842t(TextView textView, Typeface typeface, int i) {
        this.f8432a = textView;
        this.f8433b = typeface;
        this.f8434c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8432a.setTypeface(this.f8433b, this.f8434c);
    }
}
