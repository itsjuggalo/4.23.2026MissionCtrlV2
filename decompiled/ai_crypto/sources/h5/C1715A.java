package h5;

import android.app.Activity;
import java.util.ArrayList;

/* JADX INFO: renamed from: h5.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1715A implements V4.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f14910d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14909c = 240;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14911e = false;

    /* JADX INFO: renamed from: h5.A$a */
    public interface a {
        void a(int i7);
    }

    public void a(Activity activity, a aVar, InterfaceC1725b interfaceC1725b) {
        if (this.f14911e) {
            interfaceC1725b.a("A request for permissions is already running, please wait for it to finish before doing another request.");
            return;
        }
        if (activity == null) {
            interfaceC1725b.a("Unable to detect current Android Activity.");
            return;
        }
        this.f14910d = aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.POST_NOTIFICATIONS");
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (this.f14911e) {
            return;
        }
        F.a.a(activity, strArr, 240);
        this.f14911e = true;
    }

    @Override // V4.n
    public boolean onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        a aVar;
        int i8 = 0;
        if (!this.f14911e || i7 != 240 || (aVar = this.f14910d) == null) {
            return false;
        }
        this.f14911e = false;
        if (iArr.length > 0 && iArr[0] == 0) {
            i8 = 1;
        }
        aVar.a(i8);
        return true;
    }
}
