package q8;

import android.util.Log;
import java.util.List;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    public a(d.a aVar, List list) {
        super(aVar, list);
    }

    @Override // q8.b
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // q8.b
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // q8.b
    public void f(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // q8.b
    public void h(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // q8.b
    public String c(d.a aVar, String str, String str2, long j10) {
        return str2;
    }
}
