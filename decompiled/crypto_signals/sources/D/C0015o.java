package D;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: renamed from: D.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0015o extends AbstractC0017q {
    public final /* synthetic */ int e;

    public C0015o(int i, Class cls, int i6, int i7, int i8) {
        this.e = i8;
        this.f251a = i;
        this.f254d = cls;
        this.f253c = i6;
        this.f252b = i7;
    }

    @Override // D.AbstractC0017q
    public final Object b(View view) {
        switch (this.e) {
            case 0:
                return AbstractC0023x.b(view);
            default:
                return z.b(view);
        }
    }

    @Override // D.AbstractC0017q
    public final void c(View view, CharSequence charSequence) {
        switch (this.e) {
            case 0:
                AbstractC0023x.h(view, charSequence);
                break;
            default:
                z.e(view, charSequence);
                break;
        }
    }

    @Override // D.AbstractC0017q
    public final boolean e(Object obj, CharSequence charSequence) {
        switch (this.e) {
        }
        return !TextUtils.equals((CharSequence) obj, charSequence);
    }
}
