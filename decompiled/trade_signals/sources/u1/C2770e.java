package u1;

import android.os.Build;
import u1.AbstractC2768c;

/* JADX INFO: renamed from: u1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2770e implements AbstractC2768c.b {
    @Override // u1.AbstractC2768c.b
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // u1.AbstractC2768c.b
    public void b(String str) {
        System.loadLibrary(str);
    }

    @Override // u1.AbstractC2768c.b
    public String c(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // u1.AbstractC2768c.b
    public String[] d() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // u1.AbstractC2768c.b
    public void e(String str) {
        System.load(str);
    }
}
