package W;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;
import m.AbstractC0829m;

/* JADX INFO: loaded from: classes.dex */
public final class h extends U.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3320a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f3321b;

    public h(SwitchCompat switchCompat) {
        this.f3321b = new WeakReference(switchCompat);
    }

    @Override // U.g
    public void a() {
        switch (this.f3320a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.f3321b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    @Override // U.g
    public final void b() {
        switch (this.f3320a) {
            case 0:
                i.a((EditText) this.f3321b.get(), 1);
                break;
            default:
                SwitchCompat switchCompat = (SwitchCompat) this.f3321b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    public h(AbstractC0829m abstractC0829m) {
        this.f3321b = new WeakReference(abstractC0829m);
    }
}
