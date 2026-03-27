package I;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f772c;

    public a(int i4, t tVar, int i5) {
        this.f770a = i4;
        this.f771b = tVar;
        this.f772c = i5;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f770a);
        this.f771b.T(this.f772c, bundle);
    }
}
