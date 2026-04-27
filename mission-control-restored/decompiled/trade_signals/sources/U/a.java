package U;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f8006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8007c;

    public a(int i8, t tVar, int i9) {
        this.f8005a = i8;
        this.f8006b = tVar;
        this.f8007c = i9;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f8005a);
        this.f8006b.T(this.f8007c, bundle);
    }
}
