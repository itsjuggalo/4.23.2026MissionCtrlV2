package p2;

import com.google.android.gms.common.api.Status;
import java.util.Locale;
import q2.AbstractC2630a;

/* JADX INFO: renamed from: p2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2544a extends R1.b {
    public C2544a(int i8) {
        super(new Status(i8, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i8), AbstractC2630a.a(i8))));
        if (i8 == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }
}
