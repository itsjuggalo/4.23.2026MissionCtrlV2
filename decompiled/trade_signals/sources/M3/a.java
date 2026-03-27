package M3;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f5345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f5346b;

    public a(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f5345a = viewGroup;
        this.f5346b = onClickListener;
    }

    public Boolean a(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        View.OnClickListener onClickListener = this.f5346b;
        if (onClickListener == null) {
            return Boolean.FALSE;
        }
        onClickListener.onClick(this.f5345a);
        return Boolean.TRUE;
    }
}
