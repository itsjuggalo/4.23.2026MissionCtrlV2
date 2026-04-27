package F1;

import android.content.Context;
import android.view.KeyCharacterMap;

/* JADX INFO: loaded from: classes.dex */
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f508a;

    @Override // F1.c
    public int a(Context context, String str) {
        return this.f508a;
    }

    public Character b(int i) {
        char c6 = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i6 = i & com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
            int i7 = this.f508a;
            if (i7 != 0) {
                this.f508a = KeyCharacterMap.getDeadChar(i7, i6);
            } else {
                this.f508a = i6;
            }
        } else {
            int i8 = this.f508a;
            if (i8 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i8, i);
                if (deadChar > 0) {
                    c6 = (char) deadChar;
                }
                this.f508a = 0;
            }
        }
        return Character.valueOf(c6);
    }

    @Override // F1.c
    public int c(Context context, String str, boolean z6) {
        return 0;
    }

    public l() {
        this.f508a = 0;
    }

    public l(int i, int i6) {
        D1.b.w("Generator ID %d contains more than %d reserved bits", (i & 1) == i, Integer.valueOf(i), 1);
        D1.b.w("Cannot supply target ID from different generator ID", (i6 & 1) == i, new Object[0]);
        this.f508a = i6;
    }
}
