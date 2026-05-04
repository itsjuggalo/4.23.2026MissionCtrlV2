package w0;

import android.widget.ListView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ListView f23610s;

    public d(ListView listView) {
        super(listView);
        this.f23610s = listView;
    }

    @Override // w0.a
    public boolean a(int i10) {
        return false;
    }

    @Override // w0.a
    public boolean b(int i10) {
        ListView listView = this.f23610s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i11 = firstVisiblePosition + childCount;
        if (i10 > 0) {
            if (i11 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i10 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // w0.a
    public void j(int i10, int i11) {
        this.f23610s.scrollListBy(i11);
    }
}
