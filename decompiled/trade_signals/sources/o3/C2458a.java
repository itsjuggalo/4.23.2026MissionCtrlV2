package o3;

import android.util.Log;
import java.util.List;
import o3.InterfaceC2461d;

/* JADX INFO: renamed from: o3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2458a extends AbstractC2459b {
    public C2458a(InterfaceC2461d.a aVar, List list) {
        super(aVar, list);
    }

    @Override // o3.AbstractC2459b
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // o3.AbstractC2459b
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // o3.AbstractC2459b
    public void f(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // o3.AbstractC2459b
    public void h(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // o3.AbstractC2459b
    public String c(InterfaceC2461d.a aVar, String str, String str2, long j8) {
        return str2;
    }
}
