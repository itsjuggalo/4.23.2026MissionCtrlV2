package g4;

import android.os.Build;
import g4.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements c.b {
    @Override // g4.c.b
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // g4.c.b
    public void b(String str) {
        System.loadLibrary(str);
    }

    @Override // g4.c.b
    public String c(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // g4.c.b
    public String[] d() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // g4.c.b
    public void e(String str) {
        System.load(str);
    }
}
