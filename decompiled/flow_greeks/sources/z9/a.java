package z9;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f25609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f25610b;

    public a(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f25609a = viewGroup;
        this.f25610b = onClickListener;
    }

    public Boolean a(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        View.OnClickListener onClickListener = this.f25610b;
        if (onClickListener == null) {
            return Boolean.FALSE;
        }
        onClickListener.onClick(this.f25609a);
        return Boolean.TRUE;
    }
}
