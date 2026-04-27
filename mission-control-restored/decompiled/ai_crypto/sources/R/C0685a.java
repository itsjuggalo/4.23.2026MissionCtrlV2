package R;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: renamed from: R.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0685a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f4567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4568c;

    public C0685a(int i7, x xVar, int i8) {
        this.f4566a = i7;
        this.f4567b = xVar;
        this.f4568c = i8;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4566a);
        this.f4567b.a0(this.f4568c, bundle);
    }
}
