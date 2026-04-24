package E;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f356c;

    public a(int i, k kVar, int i6) {
        this.f354a = i;
        this.f355b = kVar;
        this.f356c = i6;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f354a);
        this.f355b.f363a.performAction(this.f356c, bundle);
    }
}
