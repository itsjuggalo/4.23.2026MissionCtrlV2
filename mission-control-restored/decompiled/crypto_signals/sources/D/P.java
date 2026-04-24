package D;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class P extends O {
    public P(V v2, WindowInsets windowInsets) {
        super(v2, windowInsets);
    }

    @Override // D.U
    public V a() {
        return V.c(this.f212c.consumeDisplayCutout(), null);
    }

    @Override // D.U
    public C0004d e() {
        DisplayCutout displayCutout = this.f212c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0004d(displayCutout);
    }

    @Override // D.N, D.U
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P)) {
            return false;
        }
        P p3 = (P) obj;
        return Objects.equals(this.f212c, p3.f212c) && Objects.equals(this.e, p3.e);
    }

    @Override // D.U
    public int hashCode() {
        return this.f212c.hashCode();
    }
}
